/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Bram Esendam
 */
public class Paneel extends JPanel implements KeyListener
{

    private GunShip gunShip;
    private PowerUp powerUpSpeed, powerUpHealth, powerUpDamage;
    private BossGunShip bossShip;
    private int asteroidSpawnTime, repaintTime = 22, bossStage = 1;
    private hitRegistration hitReg = new hitRegistration();
    private Levelinfo levelinfo = new Levelinfo();
    private boolean shot = false, wIsadded = false, dIsadded = false, bossFight = false,
            sIsadded = false, aIsadded = false, spaceIsadded = false, gameOver = false;

    //ArrayLists
    private ArrayList<String> keys;
    private ArrayList<Asteroid> asteroids;
    private ArrayList<EnemyGunShip> enemyGunShips;

    //Sounds && music
    private final Sound levelMusic = new Sound("audio/music/level1music.wav");
    private final Sound explosion = new Sound("audio/explosion.wav");
    private final Sound gameOverMusic = new Sound("audio/music/gameOver.wav");
    private final Sound hurtSound = new Sound("audio/hurt_sound.wav");
    private final Sound hitRock = new Sound("audio/hit_rock.wav");
    private final Sound boostSound = new Sound("audio/boost.wav");
    private final Sound bossStage1Music = new Sound("audio/music/bossStage1.wav");
    private final Sound bossStage2Music = new Sound("audio/music/bossStage2.wav");
    private final Sound bossStage3Music = new Sound("audio/music/bossStage3.wav");
    private final Sound bossFinalStageMusic = new Sound("audio/music/bossFinalStage.wav");
    private final Sound bossDefeated = new Sound("audio/music/bossDefeated.wav");

    //Timers
    private Timer paintTimer, bulletLimiter, enemyGunShipTimer;

    //images
    private final Image backGroundImg = ImageIO.read(new File("Textures/Background.png"));
    private final Image youLoseImg = ImageIO.read(new File("Textures/GameOver.png"));

    public Paneel() throws IOException
    {
        levelMusic.playBackgroundMusic();
        gunShip = new GunShip(1150, 360);
        powerUpSpeed = new PowerUp(300, 300, "speed");    
        bossShip = new BossGunShip();
        asteroids = new ArrayList<Asteroid>();
        keys = new ArrayList<String>();
        enemyGunShips = new ArrayList<EnemyGunShip>();
        asteroidSpawnTime = 3500;
        hitReg.start();

        //Timers && Threads
        paintTimer = new Timer(repaintTime, new paintTimerHandler());
        paintTimer.start();
        enemyGunShipTimer = new Timer(9333, new enemyGunShipTimerHandler());
        enemyGunShipTimer.start();
        bulletLimiter = new Timer(211, new bulletLimitHandler());
        bulletLimiter.start();
        new moveHandler().start();
        new levelHandler().start();
        new asteroidHandler().start();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(backGroundImg, 0, 0, null);
        levelinfo.draw(g);
        try
        {
            if (gunShip.hp <= 0)
            {
                g.drawImage(youLoseImg, 730, 350, null);
                g.setColor(Color.red);
                g.drawString("Press F1 to respawn!", 875, 525);
                if (!gameOver)
                {
                    levelMusic.stopMusic();
                    bossStage1Music.stopMusic();
                    bossStage2Music.stopMusic();
                    bossStage3Music.stopMusic();
                    bossFinalStageMusic.stopMusic();
                    bossDefeated.stopMusic();
                    gameOverMusic.playBackgroundMusic();
                    gameOver = true;
                    levelinfo.totalTries++;
                    levelinfo.asteroidDeathCount = 0;
                    enemyGunShips.forEach((EnemyGunShip enemyGunShip) ->
                    {
                        enemyGunShip.stopShootTimers();
                    });
                }
            } else
            {
                gunShip.draw(g);
                powerUpSpeed.draw(g);
            }
            enemyGunShips.forEach((EnemyGunShip enemyGunShip) ->
            {
                if (enemyGunShip.hp > 0 && enemyGunShip.isAlive())
                {
                    enemyGunShip.draw(g);
                    enemyGunShip.Ydestination = gunShip.getY();
                    enemyGunShip.Xdestination = gunShip.getX();
                } else
                {
                    enemyGunShip.stopShootTimers();
                    enemyGunShip.stop();
                    enemyGunShips.remove(enemyGunShip);
                }

            });
            asteroids.forEach((Asteroid asteroid) ->
            {
                if (asteroid.isAlive())
                {
                    asteroid.draw(g);
                }
            });
            if (bossFight)
            {
                if (!bossShip.isAlive())
                {
                    bossShip.start();
                }
                bossShip.draw(g);
            }
        } catch (ConcurrentModificationException e)
        {
        }
    }

    @Override
    public void keyTyped(KeyEvent e
    )
    {
    }

    @Override
    public void keyPressed(KeyEvent e
    )
    {
        if (e.getKeyCode() == KeyEvent.VK_D && !dIsadded)
        {
            keys.add("d");
            dIsadded = true;

        } else if (e.getKeyCode() == KeyEvent.VK_A && !aIsadded)
        {
            keys.add("a");
            aIsadded = true;

        } else if (e.getKeyCode() == KeyEvent.VK_W && !wIsadded)
        {
            keys.add("w");
            wIsadded = true;
        } else if (e.getKeyCode() == KeyEvent.VK_S && !sIsadded)
        {
            keys.add("s");
            sIsadded = true;

        } else if (e.getKeyCode() == KeyEvent.VK_SPACE && !spaceIsadded && gunShip.hp > 0)
        {
            keys.add("space");
            spaceIsadded = true;
        } else if (e.getKeyCode() == KeyEvent.VK_T)
        {
            hurtSound.play();
            gunShip.hp -= 20;
        } else if (e.getKeyCode() == KeyEvent.VK_F1)
        {
            restartGame();
        } else if (e.getKeyCode() == KeyEvent.VK_F5)
        {
            levelinfo.asteroidDeathCount = 75;
            bossStage = 1;
        } else if (e.getKeyCode() == KeyEvent.VK_F6)
        {
            levelinfo.asteroidDeathCount = 75;
            bossShip.hp = (bossShip.totalHp / 4) * 3;
            bossStage = 2;
        } else if (e.getKeyCode() == KeyEvent.VK_F7)
        {
            levelinfo.asteroidDeathCount = 75;
            bossShip.hp = (bossShip.totalHp / 4) * 2;
            bossStage = 3;
        } else if (e.getKeyCode() == KeyEvent.VK_F8)
        {
            levelinfo.asteroidDeathCount = 75;
            bossShip.hp = (bossShip.totalHp / 4) * 1;
            bossStage = 4;
        }
    }

    @Override
    public void keyReleased(KeyEvent e
    )
    {
        try
        {
            keys.forEach((key) ->
            {
                String keyChar = "" + e.getKeyChar();
                System.out.println(e.getKeyCode());
                if (key.equals(keyChar) && key.equals("w"))
                {
                    System.out.println("Remove W");
                    keys.remove("w");
                    wIsadded = false;
                } else if (key.equals(keyChar) && key.equals("s"))
                {
                    System.out.println("Remove S");
                    keys.remove("s");
                    sIsadded = false;
                } else if (key.equals(keyChar) && key.equals("d"))
                {
                    System.out.println("Remove D");
                    keys.remove("d");
                    dIsadded = false;
                } else if (key.equals(keyChar) && key.equals("a"))
                {
                    System.out.println("Remove A");
                    keys.remove("a");
                    aIsadded = false;
                } else if (e.getKeyCode() == 32 && key.equals("space"))
                {
                    System.out.println("Remove space");
                    keys.remove("space");
                    spaceIsadded = false;
                }

            });
        } catch (ConcurrentModificationException ex)
        {
        }
    }

    public void restartGame()
    {
        System.out.println("Game has been reset!");
        asteroids.forEach((asteroid) ->
        {
            asteroid.stop();
        });
        enemyGunShips.forEach((enemyGunShip) ->
        {
            enemyGunShip.bullets.forEach((bullet) ->
            {
                bullet.stop();
            });
            enemyGunShip.bullets.clear();
            enemyGunShip.stopShootTimers();
            enemyGunShip.stop();
        });
        enemyGunShips.clear();
        asteroids.clear();
        gunShip.hp = 100;
        gunShip.x = 1150;
        gunShip.y = 360;
        gunShip.speed = 3;

        gameOverMusic.stopMusic();
        levelMusic.playBackgroundMusic();
        gameOver = false;
    }

    public void trySleep(int ms)
    {
        try
        {
            Thread.sleep(ms);
        } catch (InterruptedException e)
        {
            System.out.println(e);
        }
    }

    private class hitRegistration extends Thread
    {

        @Override
        public void run()
        {
            while (true)
            {
                registrateHits();
                trySleep(repaintTime);
            }
        }

        public void registrateHits()
        {
            try
            {
                //looping trough all the Astroids on the screen
                asteroids.forEach((Asteroid asteroid) ->
                {
                    //checking if the gunship is getting hit by a asteroid
                    if (gunShip.hp > 0 && gunShip.getX() < asteroid.getX() + 5 && gunShip.getX() > asteroid.getX()
                            && gunShip.getY() < asteroid.getY() + 50 && gunShip.getY() > asteroid.getY())
                    {
                        gunShip.hp -= 10;
                        hurtSound.play();
                    }
                    //checking if the bullets are hitting a asteroid
                    gunShip.bullets.forEach((bullet) ->
                    {
                        if (!bullet.dead && bullet.isAlive())
                        {
                            if (bullet.getX() < asteroid.getX() + 15 && bullet.getX() > asteroid.getX()
                                    && bullet.getY() < asteroid.getY() + 50 && bullet.getY() > asteroid.getY())
                            {
                                bullet.dead();//setting dead to true
                                bullet.stop();//stoping bullet thread
                                asteroid.hp -= 11;
                                hitRock.play();
                            }
                            enemyGunShips.forEach((EnemyGunShip enemyGunShip) ->
                            {
                                if (bullet.getX() < enemyGunShip.getX() + 15 && bullet.getX() > enemyGunShip.getX()
                                        && bullet.getY() < enemyGunShip.getY() + 50 && bullet.getY() > enemyGunShip.getY() - 15)
                                {
                                    bullet.dead();//setting dead to true
                                    bullet.stop();//stoping bullet thread
                                    enemyGunShip.hp -= 13;
                                }
                            });
                        } else
                        {
                            gunShip.bullets.remove(bullet);
                        }
                    });
                    //removing a asteroid if hp is below 0
                    if (asteroid.hp < 0)
                    {
                        levelinfo.asteroidDeathCount++;
                        asteroid.stop();
                        explosion.play();
                    }
                    if (!asteroid.isAlive())
                    {
                        asteroids.remove(asteroid);
                    }
                });
                //checking if the gunship is getting hit by a power up
                if (gunShip.hp > 0 && gunShip.getX() < powerUpSpeed.getX() + 30 && gunShip.getX() > powerUpSpeed.getX()
                        && gunShip.getY() < powerUpSpeed.getY() + 18 && gunShip.getY() > powerUpSpeed.getY())
                {
                    gunShip.speed += 1;
                    powerUpSpeed.x = -1000;
                    powerUpSpeed.y = -1000;
                    boostSound.play();
                }
                //looping trough all the enemyGunShips on the screen
                enemyGunShips.forEach((EnemyGunShip enemyGunShip) ->
                {
                    //checking if the ennemy's bullets are hitting your gunship
                    enemyGunShip.bullets.forEach((EnemyBullet bullet) ->
                    {
                        if (!bullet.dead && bullet.isAlive())
                        {
                            if (bullet.getX() < gunShip.getX() + 15 && bullet.getX() > gunShip.getX()
                                    && bullet.getY() < gunShip.getY() + 50 && bullet.getY() > gunShip.getY())
                            {
                                bullet.dead();//setting dead to true
                                bullet.stop();//stoping bullet thread
                                gunShip.hp -= bullet.damage;
                                if (gunShip.hp > 0)
                                {
                                    hurtSound.play();
                                }
                            }
                        } else
                        {
                            gunShip.bullets.remove(bullet);
                        }
                    });
                });
            } catch (ConcurrentModificationException ex)
            {
            }
        }
    }

    private class levelHandler extends Thread
    {

        @Override
        public void run()
        {
            while (true)
            {
                if (levelinfo.asteroidDeathCount < 25)
                {
                    asteroidSpawnTime = 2500;
                    levelinfo.level = 1;
                } else if (levelinfo.asteroidDeathCount >= 25 && levelinfo.asteroidDeathCount < 50)
                {
                    asteroidSpawnTime = 2000;
                    levelinfo.level = 2;
                } else if (levelinfo.asteroidDeathCount >= 50 && levelinfo.asteroidDeathCount < 75)
                {
                    asteroidSpawnTime = 1000;
                    levelinfo.level = 3;
                } else if (levelinfo.asteroidDeathCount >= 75)
                {
                    bossFight = true;
                    levelMusic.stopMusic();
                    if (bossStage == 1 && !bossStage1Music.isPlaying())
                    {
                        System.out.println("stage 1");
                        bossStage1Music.playBackgroundMusic();
                    } else if (bossStage == 2 && !bossStage2Music.isPlaying() && bossShip.hp <= (bossShip.totalHp / 4) * 3)
                    {
                        bossStage1Music.stopMusic();
                        System.out.println("stage 2");
                        bossStage2Music.playBackgroundMusic();
                    } else if (bossStage == 3 && !bossStage3Music.isPlaying() && bossShip.hp <= (bossShip.totalHp / 4) * 2)
                    {
                        bossStage2Music.stopMusic();
                        System.out.println("stage 3");
                        bossStage3Music.playBackgroundMusic();
                    } else if (bossStage == 4 && !bossFinalStageMusic.isPlaying() && bossShip.hp <= (bossShip.totalHp / 4) * 1)
                    {
                        bossStage3Music.stopMusic();
                        System.out.println("stage 4");
                        bossFinalStageMusic.playBackgroundMusic();
                    }
                    levelinfo.level = 4;
                } else if (levelinfo.isBossDead)
                {
                    bossFight = false;
                    asteroidSpawnTime = 800;
                    levelinfo.level = 5;
                }
                trySleep(150);
            }
        }
    }

    private class moveHandler extends Thread
    {

        @Override
        public void run()
        {
            while (true)
            {
                move();
                trySleep(repaintTime);
            }
        }

        public void move()
        {
            try
            {
                keys.forEach((key) ->
                {
                    if (key.equals("w"))
                    {
                        gunShip.moveUp();
                    } else if (key.equals("s"))
                    {
                        gunShip.moveDown();

                    } else if (key.equals("d"))
                    {
                        gunShip.moveRight();

                    } else if (key.equals("a"))
                    {
                        gunShip.moveLeft();

                    } else if (key.equals("space"))
                    {
                        if (!shot)
                        {
                            gunShip.shoot();
                            shot = true;
                        }
                    }
                });
            } catch (ConcurrentModificationException ex)
            {

            }
        }
    }

    class asteroidHandler extends Thread
    {

        @Override
        public void run()
        {
            trySleep(4000);
            while (true)
            {
                if (!bossFight)
                {
                    addAsteroid();
                }
                trySleep(asteroidSpawnTime);
            }
        }

        public void addAsteroid()
        {
            Asteroid asteroid = null;
            try
            {
                asteroid = new Asteroid();
            } catch (IOException ex)
            {
            }
            asteroid.start();
            asteroids.add(asteroid);
            System.out.println("asteroid added");
        }
    }

    class paintTimerHandler implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            repaint();
        }
    }

    class bulletLimitHandler implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (shot)
            {
                shot = false;
            }
        }
    }

    class enemyGunShipTimerHandler implements ActionListener
    {

        private Random rand = new Random();

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (!bossFight && !gameOver)
            {
                try
                {
                    EnemyGunShip enemyGunShip = new EnemyGunShip(rand.nextInt(780) + 100, levelinfo.level);
                    enemyGunShip.start();
                    enemyGunShips.add(enemyGunShip);
                    System.out.println("Number of enemy's: " + enemyGunShips.size());
                } catch (IOException ex)
                {
                }
            }

        }
    }
}

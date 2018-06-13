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
    private PowerUpSpeed powerUpSpeed;
    private int asteroidSpawnTime, repaintTime = 22;
    private hitRegistration hitReg = new hitRegistration();
    private boolean shot = false, wIsadded = false, dIsadded = false,
            sIsadded = false, aIsadded = false, spaceIsadded = false, gameOver = false;

    //ArrayLists
    private ArrayList<String> keys;
    private ArrayList<Asteroid> asteroids;

    //Sounds && music
    private final Sound levelMusic = new Sound("audio/music/level1music.wav");
    private final Sound explosion = new Sound("audio/explosion.wav");
    private final Sound gameOverMusic = new Sound("audio/music/gameOver.wav");

    //Timers
    private Timer paintTimer, asteroidTimer, bulletLimiter, moveTimer;

    //images
    private final Image backGroundImg = ImageIO.read(new File("Textures/Background.png"));
    private final Image youLoseImg = ImageIO.read(new File("Textures/GameOver.png"));

    public Paneel() throws IOException
    {
        //levelMusic.playBackgroundMusic();
        levelMusic.start();
        levelMusic.playBackgroundMusic();

        gunShip = new GunShip(1150, 360);
        powerUpSpeed = new PowerUpSpeed(300, 300);
        asteroids = new ArrayList<Asteroid>();
        keys = new ArrayList<String>();
        asteroidSpawnTime = 3500;
        hitReg.start();

        //Timers
        paintTimer = new Timer(repaintTime, new paintTimerHandler());
        paintTimer.start();
        asteroidTimer = new Timer(asteroidSpawnTime, new asteroidTimerHandler());
        asteroidTimer.start();
        bulletLimiter = new Timer(100, new bulletLimitHandler());
        bulletLimiter.start();
        new moveHandler().start();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(backGroundImg, 0, 0, null);
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
                    if (!gameOverMusic.isAlive())
                    {
                        gameOverMusic.start();
                    }
                    gameOverMusic.playBackgroundMusic();
                    gameOver = true;
                }
            } else
            {
                gunShip.draw(g);
                powerUpSpeed.draw(g);
            }
            asteroids.forEach((Asteroid asteroid) ->
            {
                if (asteroid.isAlive())
                {
                    asteroid.draw(g);
                }
            });
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
        System.out.println("pres");
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

        } else if (e.getKeyCode() == KeyEvent.VK_SPACE && !spaceIsadded)
        {
            keys.add("space");
            spaceIsadded = true;
        } else if (e.getKeyCode() == KeyEvent.VK_T)
        {
            gunShip.hp -= 20;
        } else if (e.getKeyCode() == KeyEvent.VK_F1)
        {
            restartGame();
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        try
        {
            keys.forEach((key) ->
            {
                if (key.equals("w"))
                {
                    System.out.println("Remove W");
                    keys.remove("w");
                    wIsadded = false;
                } else if (key.equals("s"))
                {
                    System.out.println("Remove S");
                    keys.remove("s");
                    sIsadded = false;
                } else if (key.equals("d"))
                {
                    System.out.println("Remove D");
                    keys.remove("d");
                    dIsadded = false;
                } else if (key.equals("a"))
                {
                    System.out.println("Remove A");
                    keys.remove("a");
                    aIsadded = false;
                } else if (key.equals("space"))
                {
                    System.out.println("Remove space");
                    keys.remove("space");
                    spaceIsadded = false;
                }

            });
            System.out.println("x: " + gunShip.x);
            System.out.println("y: " + gunShip.y);
        } catch (ConcurrentModificationException ex)
        {

        }
    }

    public void updateTimers()
    {
        asteroidTimer.stop();
        asteroidTimer = new Timer(asteroidSpawnTime, new asteroidTimerHandler());
        asteroidTimer.start();
    }

    public void restartGame()
    {
        System.out.println("Game has been reset!");
        asteroids.forEach((asteroid) ->
        {
            asteroid.stop();
        });
        asteroids.clear();
        gunShip.hp = 100;
        gunShip.x = 1150;
        gunShip.y = 360;
        gunShip.speed = 3;
        
        gameOverMusic.stopMusic();
        levelMusic.playBackgroundMusic();
        gameOver = false;
    }

    private class hitRegistration extends Thread
    {

        @Override
        public void run()
        {
            while (true)
            {
                try
                {
                    registrateHits();
                    Thread.sleep(repaintTime);
                } catch (InterruptedException e)
                {
                }
            }
        }

        public void registrateHits()
        {
            try
            {
                asteroids.forEach((Asteroid asteroid) ->
                {
                    //checking if the gunship is getting hit by a asteroid
                    if (gunShip.hp > 0 && gunShip.getX() < asteroid.getX() + 5 && gunShip.getX() > asteroid.getX())
                    {
                        if (gunShip.getY() < asteroid.getY() + 50 && gunShip.getY() > asteroid.getY())
                        {
                            gunShip.hp -= 10;
                            Sound hurtSound = new Sound("audio/hurt_sound.wav");
                            hurtSound.play();
                        }
                    }

                    //checking if the bullets are hitting a asteroid
                    gunShip.bullets.forEach((bullet) ->
                    {
                        if (!bullet.dead && bullet.isAlive())
                        {
                            if (bullet.getX() < asteroid.getX() + 15 && bullet.getX() > asteroid.getX())
                            {
                                if (bullet.getY() < asteroid.getY() + 50 && bullet.getY() > asteroid.getY())
                                {
                                    System.out.println("Bullet thread stopped");
                                    bullet.dead();
                                    bullet.stop();
                                    asteroid.hp -= 10;
                                    Sound hitRock = new Sound("audio/hit_rock.wav");
                                    hitRock.play();
                                }
                            }
                        }
                    });

                    //removing a asteroid if hp is below 0
                    if (asteroid.hp < 0)
                    {
                        System.out.println(asteroid.hp);
                        System.out.println("Asteroid destroyed");
                        asteroid.stop();
                        asteroids.remove(asteroid);
                        explosion.play();
                    }
                });
                //checking if the gunship is getting hit by a power up
                if (gunShip.hp > 0 && gunShip.getX() < powerUpSpeed.getX() + 30 && gunShip.getX() > powerUpSpeed.getX())
                {
                    if (gunShip.getY() < powerUpSpeed.getY() + 18 && gunShip.getY() > powerUpSpeed.getY())
                    {
                        gunShip.speed += 1;
                        powerUpSpeed.x = -1000;
                        powerUpSpeed.y = -1000;
                    }
                }
            } 
            catch (ConcurrentModificationException ex)
            {

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
                try
                {
                    Thread.sleep(27);
                } catch (InterruptedException e)
                {
                }
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
                System.out.println("Bullet limit reset!");
                shot = false;
            }
        }
    }

    class asteroidTimerHandler implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (!gameOver)
            {
                Asteroid asteroid = null;
                try
                {
                    asteroid = new Asteroid();
                } catch (IOException ex)
                {
                    Logger.getLogger(Paneel.class.getName()).log(Level.SEVERE, null, ex);
                }
                asteroid.start();
                asteroids.add(asteroid);
                System.out.println("asteroid added");
            }
        }
    }
}

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

    public ArrayList<Asteroid> asteroids;
    public JButton btnReset, btnStart;
    public GunShip gunShip;
    public Timer timer, asteroidTimer, bulletLimiter, moveTimer;
    public Image backGroundImg = ImageIO.read(new File("Textures/Background.png"));
    public boolean shot = false, wIsadded = false, dIsadded = false,
            sIsadded = false, aIsadded = false, spaceIsadded = false;
    private ArrayList<String> keys;

    public Paneel() throws IOException
    {
        Sound level1Music = new Sound();
        level1Music.setFile("audio/music/level1music.wav");
        level1Music.playBackgroundMusic();
        gunShip = new GunShip(640, 360);
        timer = new Timer(22, new paintTimerHandler());
        asteroidTimer = new Timer(5000, new asteroidTimerHandler());
        bulletLimiter = new Timer(100, new bulletLimitHandler());
        moveTimer = new Timer(35, new moveHandler());
        asteroids = new ArrayList<Asteroid>();
        keys = new ArrayList<String>();
        moveTimer.start();
        asteroidTimer.start();
        bulletLimiter.start();
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(backGroundImg, 0, 0, null);
        gunShip.draw(g);
        try
        {
            asteroids.forEach((Asteroid asteroid) ->
            {
                if (gunShip.getX() < asteroid.getX() + 5 && gunShip.getX() > asteroid.getX())
                {
                    if (gunShip.getY() < asteroid.getY() + 50 && gunShip.getY() > asteroid.getY())
                    {
                        gunShip.hp -= 10;
                    }
                }
                gunShip.bullets.forEach((bullet) ->
                {
                    if (bullet.getX() < asteroid.getX() + 15 && bullet.getX() > asteroid.getX())
                    {
                        if (bullet.getY() < asteroid.getY() + 50 && bullet.getY() > asteroid.getY())
                        {
                            if (!bullet.dead && bullet.isAlive())
                            {
                                System.out.println("Bullet thread stopped");
                                bullet.dead();
                                bullet.stop();
                                asteroid.hp -= 10;
                            }
                        }
                    }
                });
                if (asteroid.hp < 0)
                {
                    Sound explosion = new Sound();
                    explosion.setFile("audio/explosion.wav");
                    System.out.println(asteroid.hp);
                    System.out.println("Asteroid destroyed");
                    asteroid.stop();
                    asteroids.remove(asteroid);
                    explosion.play();
                } else
                {
                    asteroid.draw(g);
                }

            });
        } catch (ConcurrentModificationException e)
        {

        }
    }

    @Override

    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        System.out.println("pres");
        if (e.getKeyCode() == KeyEvent.VK_D && !dIsadded)
        {
            keys.add("d");
            dIsadded = true;

        }
        if (e.getKeyCode() == KeyEvent.VK_A && !aIsadded)
        {
            keys.add("a");
            aIsadded = true;

        }
        if (e.getKeyCode() == KeyEvent.VK_W && !wIsadded)
        {
            keys.add("w");
            wIsadded = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_S && !sIsadded)
        {
            keys.add("s");
            sIsadded = true;

        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE && !spaceIsadded)
        {
            keys.add("space");
            spaceIsadded = true;
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
                }
                if (key.equals("s"))
                {
                    System.out.println("Remove S");
                    keys.remove("s");
                    sIsadded = false;
                }
                if (key.equals("d"))
                {
                    System.out.println("Remove D");
                    keys.remove("d");
                    dIsadded = false;
                }
                if (key.equals("a"))
                {
                    System.out.println("Remove A");
                    keys.remove("a");
                    aIsadded = false;
                }
                if (key.equals("space"))
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

    private class moveHandler implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent action)
        {
            keys.forEach((key) ->
            {
                if (key.equals("w"))
                {
                    gunShip.moveUp();
                }
                if (key.equals("s"))
                {
                    gunShip.moveDown();

                }
                if (key.equals("d"))
                {
                    gunShip.moveRight();

                }
                if (key.equals("a"))
                {
                    gunShip.moveLeft();

                }
                if (key.equals("space"))
                {
                    if (!shot)
                    {
                        gunShip.shoot();
                        shot = true;
                        Sound spaceGun = new Sound();
                        spaceGun.setFile("audio/space_gun.wav");
                        spaceGun.play();
                    }
                }
            });
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

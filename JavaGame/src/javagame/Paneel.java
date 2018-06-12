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
    public Timer timer, asteroidTimer, bulletLimiter;
    public Image backGroundImg = ImageIO.read(new File("Textures/Background.png"));
    public boolean shot = false;

    public Paneel() throws IOException
    {

        gunShip = new GunShip(640, 360);
        timer = new Timer(22, new paintTimerHandler());
        asteroidTimer = new Timer(1000, new asteroidTimerHandler());
        bulletLimiter = new Timer(100, new bulletLimitHandler());
        asteroids = new ArrayList<Asteroid>();
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
        System.out.println("tpyped");
        if (e.getKeyCode() == KeyEvent.VK_D)
        {
            for (int i = 0; i < 10; i++)
            {
                System.out.println("ja is goed");
                gunShip.moveRight();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_A)
        {
            for (int i = 0; i < 4; i++)
            {
                gunShip.moveLeft();
            }

        }
        if (e.getKeyCode() == KeyEvent.VK_W)
        {
            for (int i = 0; i < 4; i++)
            {
                gunShip.moveUp();
            }

        }
        if (e.getKeyCode() == KeyEvent.VK_S)
        {
            for (int i = 0; i < 4; i++)
            {
                gunShip.moveDown();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        System.out.println("pres");
        if (e.getKeyCode() == KeyEvent.VK_D)
        {
            gunShip.moveRight();
        }
        if (e.getKeyCode() == KeyEvent.VK_A)
        {
            gunShip.moveLeft();
        }
        if (e.getKeyCode() == KeyEvent.VK_W)
        {
            gunShip.moveUp();
        }
        if (e.getKeyCode() == KeyEvent.VK_S)
        {
            gunShip.moveDown();
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
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
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        System.out.println("x: " + gunShip.x);
        System.out.println("y: " + gunShip.y);
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

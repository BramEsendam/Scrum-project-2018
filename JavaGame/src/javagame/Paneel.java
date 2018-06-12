/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
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
    public Timer timer, asteroidTimer;

    public Paneel()
    {
        gunShip = new GunShip(640, 360);
        timer = new Timer(22, new paintTimerHandler());
        asteroidTimer = new Timer(1000, new asteroidTimerHandler());

        asteroids = new ArrayList<Asteroid>();
        asteroidTimer.start();
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        setBackground(Color.gray);
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
                                System.out.println("hit!");
                                bullet.dead();
                                bullet.stop();
                                asteroid.hp -= 10;
                            }
                        }
                    }
                });
                if (asteroid.hp < 0)
                {
                    System.out.println(asteroid.hp);
                    System.out.println("Asteroid destroyed");
                    asteroid.stop();
                    asteroids.remove(asteroid);
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
            gunShip.shoot();
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

    class asteroidTimerHandler implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            Asteroid asteroid = new Asteroid();
            asteroid.start();
            asteroid.hp = 100;
            asteroids.add(asteroid);
            System.out.println("hp: " + asteroid.hp);
            System.out.println("asteroid added");
        }

    }
}

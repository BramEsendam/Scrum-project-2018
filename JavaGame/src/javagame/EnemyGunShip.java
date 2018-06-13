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
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.Timer;

/**
 *
 * @author brame
 */
public class EnemyGunShip extends Thread
{

    public ArrayList<EnemyBullet> bullets;
    public int x, y, hp = 50, speed = 3, Ydestination = 360, Xdestination = 1150;
    private Image gunShipImg;
    public Timer shootTimer = new Timer(1500, new shootHandler());

    public EnemyGunShip(int Y) throws IOException
    {
        this.gunShipImg = ImageIO.read(new File("Textures/EnemySpaceShip1.png"));
        shootTimer.start();
        bullets = new ArrayList<EnemyBullet>();
        x = -50;
        y = Y;
    }

    public void draw(Graphics g)
    {
        g.drawImage(gunShipImg, x, y, null);
        if (hp != 50)
        {
            g.setColor(Color.black);
            g.drawRect(x + 5, y + 60, 50, 4);
            g.setColor(Color.green);
            g.fillRect(x + 6, y + 61, hp, 3);
        }
        bullets.forEach((bullet) ->
        {
            if (this.x > 2000)
            {
                bullet.stop();
                bullets.remove(bullet);
            } else if(bullet.isAlive())
            {
                bullet.draw(g);
            }
        });
    }

    @Override
    public void run()
    {
        while (true)
        {
            if (x < 200)
            {
                x += 1;
            }
            try
            {
                Thread.sleep(20);
            } catch (InterruptedException e)
            {
            }
        }
    }

    public void shoot()
    {
        EnemyBullet bullet = new EnemyBullet(this.x, this.y, Ydestination, Xdestination, Color.red);
        bullet.start();
        bullets.add(bullet);
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    private class shootHandler implements ActionListener
    {

        public shootHandler()
        {
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            shoot();
        }
    }
}

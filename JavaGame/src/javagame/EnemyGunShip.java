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
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.Timer;

/**
 *
 * @author brame
 */
public class EnemyGunShip extends Thread
{

    public ArrayList<EnemyBullet> bullets;
    public int x, y, height, width, yFirstGun, yNextGun, damage, bulletSize, hp = 50, level, Ydestination = 360, Xdestination = 1150;
    private Image gunShipImg;
    public Timer Level1ShootTimer = new Timer(1500, new shootHandler()), Level2ShootTimer = new Timer(1200, new shootHandler()), Level3ShootTimer = new Timer(950, new shootHandler());
    private boolean dubbelLaser, swapGun = true, isDead;
    Random rand = new Random();

    public EnemyGunShip(int Y, int level) throws IOException
    {
        String fileName = "Textures/";
        this.level = level;
        if (this.level != 1 && this.level != 2 && this.level != 3)
        {
            this.level = (rand.nextInt(3) + 1);
        }
        if (this.level == 1)
        {
            width = 55;
            height = 34;
            bulletSize = 5;
            dubbelLaser = true;
            damage = 10;
            yFirstGun = 2;
            yNextGun = 32;
            Level1ShootTimer.start();
            fileName += "EnemySpaceShip1.png";
        } else if (this.level == 2)
        {
            width = 87;
            height = 50;
            bulletSize = 6;
            damage = 15;
            Level2ShootTimer.start();
            fileName += "EnemySpaceShip2.png";
        } else if (this.level == 3)
        {
            width = 90;
            height = 61;
            bulletSize = 8;
            damage = 20;
            dubbelLaser = true;
            yFirstGun = 10;
            yNextGun = 50;
            Level3ShootTimer.start();
            fileName += "EnemySpaceShip3.png";
        }
        this.gunShipImg = ImageIO.read(new File(fileName));
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
            g.drawRect(x + 5, y + height, 50, 4);
            g.setColor(Color.green);
            g.fillRect(x + 6, y + height + 1, hp, 3);
        }
        bullets.forEach((bullet) ->
        {
            if (this.x > 2000)
            {
                bullet.stop();
                bullets.remove(bullet);
            } else if (bullet.isAlive())
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
        EnemyBullet bullet;
        if (dubbelLaser)
        {
            if (swapGun)
            {
                bullet = new EnemyBullet(this.x + 35, this.y + yFirstGun, Ydestination, Xdestination, bulletSize, damage, Color.red);
                swapGun = false;
            } else
            {
                bullet = new EnemyBullet(this.x + 35, this.y + yNextGun, Ydestination, Xdestination, bulletSize, damage, Color.red);
                swapGun = true;
            }

        } else
        {
            bullet = new EnemyBullet(this.x + 80, this.y + 25, Ydestination, Xdestination, bulletSize, damage, Color.red);
        }
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

    void stopShootTimers()
    {
        Level1ShootTimer.stop();
        Level2ShootTimer.stop();
        Level3ShootTimer.stop();
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

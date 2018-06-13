/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagame;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author brame
 */
public class EnemyBullet extends Thread
{

    public int x, Xdestination, Ydestination, margin = 0;
    public double Ypath, y;
    public boolean dead = false;
    private Color color;

    public EnemyBullet(int X, int Y, int Ydestination, int Xdestination, Color color)
    {
        this.x = X;
        this.y = Y;
        if (y > this.Ydestination)
        {
            margin = 15;
        }
        this.Xdestination = Xdestination;
        this.Ydestination = (int) (Ydestination + margin);

        this.color = color;

        Ypath = (this.Ydestination - this.y) / (this.Xdestination - this.x);

        System.out.println("Xdestination: " + this.Xdestination);
        System.out.println("Ydestination: " + this.Ydestination);
        System.out.println("Ypath: " + Ypath);
        Sound spaceGun = new Sound("audio/space_gun.wav");
        spaceGun.play();
    }

    @Override
    public void run()
    {
        while (true)
        {
            if (x > 2000)
            {
                this.stop();
            }
            x += 2;
            y += Ypath + (Ypath);
            try
            {
                Thread.sleep(7);
            } catch (InterruptedException e)
            {
            }
        }
    }

    public void draw(Graphics g)
    {
        if (!dead)
        {
            g.setColor(color);
            g.fillOval(x - 2, (int) Math.round(this.y), 5, 3);
        }

    }

    public void dead()
    {
        this.dead = true;
    }

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return (int) Math.round(this.y);
    }
}

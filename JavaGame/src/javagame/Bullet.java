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
 * @author Bram Esendam
 */
public class Bullet extends Thread
{

    public int x, y;
    public boolean dead = false;

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }

    public Bullet(int X, int Y)
    {
        this.x = X;
        this.y = Y + 8;
    }

    @Override
    public void run()
    {
        while (true)
        {
            if (x < 0)
            {
                this.stop();
            }
            x -= 6;
            try
            {
                Thread.sleep(10);
            } catch (InterruptedException e)
            {
            }
        }
    }

    public void draw(Graphics g)
    {
        if (!dead)
        {
            g.setColor(Color.RED);
            g.fillOval(x - 10, y, 5, 3);
        }

    }

    public void dead()
    {
        this.dead = true;
    }

}

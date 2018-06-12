/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagame;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author Bram Esendam
 */
public class Asteroid extends Thread
{

    public int x, y, hp;

    Asteroid()
    {
        Random rand = new Random();
        this.hp = 100;
        this.x = -100;
        this.y = rand.nextInt(700) + 100;
    }

    @Override
    public void run()
    {
        while (true)
        {
            if (x > 1500)
            {
                this.stop();
            }
            this.x++;
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
        g.setColor(Color.DARK_GRAY);
        g.fillOval(x, y, 50, 50);
        if (hp != 100)
        {
            g.drawRect(x, y + 53, 50, 4);
            g.setColor(Color.green);
            g.fillRect(x + 1, y + 54, hp / 2, 2);
        }
    }
}


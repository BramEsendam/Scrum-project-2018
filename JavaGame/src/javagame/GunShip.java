/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagame;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author Bram Esendam
 */
public class GunShip
{

    public ArrayList<Bullet> bullets;
    public int x, y,  hp = 100, speed = 3;
    public Image gunShipImg;
    private Sound drive;

    public GunShip(int X, int Y) throws IOException
    {
        this.gunShipImg = ImageIO.read(new File("Textures/SpaceShip.png"));
        
        bullets = new ArrayList<Bullet>();
        x = X;
        y = Y;
    }

    public void draw(Graphics g)
    {
        g.drawImage(gunShipImg, x, y, null);

        bullets.forEach((bullet) ->
        {
            if (this.x < -200)
            {
                bullet.dead();
                bullets.remove(bullet);
            } else
            {
                bullet.draw(g);
            }

        });
    }

    public void moveDown()
    {
        this.y += speed;
    }

    public void moveUp()
    {
        this.y -= speed;
    }

    public void moveRight()
    {
        this.x += speed;
    }

    public void moveLeft()
    {
        this.x -= speed;
    }
    
    public void powerUp()
    {
        this.speed = this.speed + 1;
    }
    
    public void shoot()
    {
        Bullet bullet = new Bullet(this.x, this.y);
        bullet.start();
        bullets.add(bullet);
    }

}

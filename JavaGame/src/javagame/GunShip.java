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
    public int x, y,  hp = 100;
    public Image gunShipImg;
    private Sound drive;

    public GunShip(int X, int Y) throws IOException
    {
        this.gunShipImg = ImageIO.read(new File("Textures/SpaceShip.png"));
        this.drive = new Sound();
        this.drive.setFile("audio/drive2.wav");
        
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
        this.y += 3;
        this.drive.play();
    }

    public void moveUp()
    {
        this.y -= 3;
        this.drive.play();
    }

    public void moveRight()
    {
        this.x += 3;
        this.drive.play();
    }

    public void moveLeft()
    {
        this.x -= 3;
        this.drive.play();
    }

    public void shoot()
    {
        Bullet bullet = new Bullet(this.x, this.y);
        bullet.start();
        bullets.add(bullet);
    }

}

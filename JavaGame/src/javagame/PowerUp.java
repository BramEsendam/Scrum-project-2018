package javagame;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PowerUp
{

    public int x, y, speed, health, damage, random;
    private Image powerUpImg;
    private String kindPower;

    public PowerUp(int x, int y, String kindPower) throws IOException
    {
        this.x = x;
        this.y = y;
        this.kindPower = kindPower;
        this.speed = 1;
        this.health = 30;
        this.damage = 10; 
        this.random = (int)(Math.random() * 100 + 1);
        
        if (null != this.kindPower)
        switch (this.kindPower)
        {
            case "speed":
                this.powerUpImg = ImageIO.read(new File("Textures/battery.png"));
                break;
            case "health":
                this.powerUpImg = ImageIO.read(new File("Textures/healthpack.png"));
                break;
            case "damage":
                this.powerUpImg = ImageIO.read(new File("Textures/ammoBox.png"));
                break;
            default:
                break;
        }
    }

    public int speedBoost()
    {
        return speed;
    }
    
    public int healthPack()
    {
        return health;
    }
    
    public int extraDamage()
    {
        return damage;
    }
    
    public void draw(Graphics g)
    {
        g.drawImage(powerUpImg, x, y, null);
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }
}

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
    public boolean pickUp = false;

    public PowerUp(int x, int y) throws IOException
    {
        this.x = x + 400;
        this.y = y;
        this.speed = 1;
        this.health = 30;
        this.damage = 1; 
        this.random = (int)(Math.random() * 100 + 1);
        
        if (random >= 0 && random <= 50)
        {
            this.kindPower = "health";
        }
        else if (random >= 50 && random <= 85)
        {
            this.kindPower = "damage";
        }
        else if (random >= 85 && random <= 100)
        {
            this.kindPower = "speed";
        }
        
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
        if (this.kindPower == "speed")
        {
           return speed; 
        }
        else 
        {
            return 0;
        }
    }
    
    public int healthPack()
    {
       
        if (this.kindPower == "health")
        {
            return health;
        }
        else 
        {
            return 0;
        }
    }
    
    public int damagePack()
    {
        
        if (this.kindPower == "damage")
        {
           return damage;
        }
        else 
        {
            return 0;
        }
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

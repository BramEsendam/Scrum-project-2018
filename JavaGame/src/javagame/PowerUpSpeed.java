package javagame;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class PowerUpSpeed {
    public int x, y;
    private Image powerUpImg;
    
    public PowerUpSpeed(int x, int y) throws IOException
    {
        this.powerUpImg = ImageIO.read(new File("Textures/battery.png"));
        this.x = x;
        this.y = y;
    }
    
    public void draw(Graphics g) {
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

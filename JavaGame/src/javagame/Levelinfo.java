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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Bram Esendam
 */
public class Levelinfo
{

    //images
    private Image level1Text, level2Text, level3Text, bossFightText;
    public int level = 1, x = 710, y = 10, deathCount = 0, asteroidDeathCount = 0;
    
    public Levelinfo()
    {
        try
        {
            this.level1Text = ImageIO.read(new File("Textures/level-1.png"));
            this.level2Text = ImageIO.read(new File("Textures/level-2.png"));
            this.level3Text = ImageIO.read(new File("Textures/level-3.png"));
            this.bossFightText = ImageIO.read(new File("Textures/Boss-Fight.png"));

        } catch (IOException ex)
        {
            Logger.getLogger(Levelinfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void draw(Graphics g)
    {
        if (level == 1)
        {
            g.drawImage(level1Text, x, y, null);

        } else if (level == 2)
        {
            g.drawImage(level2Text, x, y, null);

        } else if (level == 3)
        {
            g.drawImage(level3Text, x, y, null);

        } else if (level == 4)
        {
            g.drawImage(bossFightText, x, y, null);

        } else if (level == 5)
        {
            //g.drawImage(gunShipImg, x, y, null);

        }
    }
}

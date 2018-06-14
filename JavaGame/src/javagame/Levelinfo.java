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
    private Image level1Text, level2Text, level3Text, bossFightText, endlessModeText;
    private Image number1, number2, number3, number4, number5, number6, number7, number8, number9;
    public int level = 1, x = 710, y = 10, totalTries = 0, asteroidDeathCount = 0;
    public boolean isBossDead = false;

    public Levelinfo()
    {
        try
        {
            this.level1Text = ImageIO.read(new File("Textures/level-1.png"));
            this.level2Text = ImageIO.read(new File("Textures/level-2.png"));
            this.level3Text = ImageIO.read(new File("Textures/level-3.png"));
            this.bossFightText = ImageIO.read(new File("Textures/Boss-Fight.png"));
            this.endlessModeText = ImageIO.read(new File("Textures/Endless-mode.png"));
            this.number1 = ImageIO.read(new File("Textures/1.png"));
            this.number2 = ImageIO.read(new File("Textures/2.png"));
            this.number3 = ImageIO.read(new File("Textures/3.png"));
            this.number4 = ImageIO.read(new File("Textures/4.png"));
            this.number5 = ImageIO.read(new File("Textures/5.png"));
            this.number6 = ImageIO.read(new File("Textures/6.png"));
            this.number7 = ImageIO.read(new File("Textures/7.png"));
            this.number8 = ImageIO.read(new File("Textures/8.png"));
            this.number9 = ImageIO.read(new File("Textures/9.png"));

        } catch (IOException ex)
        {
            Logger.getLogger(Levelinfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void draw(Graphics g)
    {
        drawLevelInfo(g);
        drawScore(g);
    }

    public void drawScore(Graphics g)
    {
        
    }

    public void drawLevelInfo(Graphics g)
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
            g.drawImage(bossFightText, x - 150, y, null);

        } else if (level == 5)
        {
            g.drawImage(endlessModeText, x - 150, y, null);
        }
    }

    public Image getLevel1Text()
    {
        return level1Text;
    }

    public Image getLevel2Text()
    {
        return level2Text;
    }

    public Image getLevel3Text()
    {
        return level3Text;
    }

    public Image getBossFightText()
    {
        return bossFightText;
    }

    public int getLevel()
    {
        return level;
    }

    public int getTotalTries()
    {
        return totalTries;
    }

    public int getAsteroidDeathCount()
    {
        return asteroidDeathCount;
    }

    public boolean isIsBossDead()
    {
        return isBossDead;
    }
}

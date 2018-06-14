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
    private ArrayList<Image> numbers;
    public int level = 1, x = 710, y = 10, totalTries = 0, asteroidDeathCount = 000;
    public boolean isBossDead = false;

    public Levelinfo()
    {
        try
        {
            numbers = new ArrayList<Image>();
            this.level1Text = ImageIO.read(new File("Textures/level-1.png"));
            this.level2Text = ImageIO.read(new File("Textures/level-2.png"));
            this.level3Text = ImageIO.read(new File("Textures/level-3.png"));
            this.bossFightText = ImageIO.read(new File("Textures/Boss-Fight.png"));
            this.endlessModeText = ImageIO.read(new File("Textures/Endless-mode.png"));
            for (int i = 0; i <= 9; i++)
            {
                numbers.add(ImageIO.read(new File("Textures/" + i + ".png")));
                System.out.println(i);
            }
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
        boolean secondDigitIsSet = false, thirdDigitIsSet = false, fourthDigitIsSet = false;
        int firstDigit = Integer.parseInt(Integer.toString(asteroidDeathCount).substring(0, 1));
        int secondDigit = 0;
        int thirdDigit = 0;
        int fourthDigit = 0;

        try
        {
            secondDigit = Integer.parseInt(Integer.toString(asteroidDeathCount).substring(1, 2));
            secondDigitIsSet = true;
        } catch (StringIndexOutOfBoundsException e)
        {

        }
        try
        {
            thirdDigit = Integer.parseInt(Integer.toString(asteroidDeathCount).substring(2, 3));
            thirdDigitIsSet = true;
        } catch (StringIndexOutOfBoundsException e)
        {

        }
        try
        {
            fourthDigit = Integer.parseInt(Integer.toString(asteroidDeathCount).substring(3, 4));
            fourthDigitIsSet = true;
        } catch (StringIndexOutOfBoundsException e)
        {
        }
        if (secondDigitIsSet)
        {
            if (fourthDigitIsSet)
            {
                g.drawImage(numbers.get(fourthDigit), 1850, 13, null);
                g.drawImage(numbers.get(thirdDigit), 1800, 13, null);
                g.drawImage(numbers.get(secondDigit), 1750, 13, null);
                g.drawImage(numbers.get(firstDigit), 1700, 13, null);
            } else if (thirdDigitIsSet)
            {
                g.drawImage(numbers.get(thirdDigit), 1850, 13, null);
                g.drawImage(numbers.get(secondDigit), 1800, 13, null);
                g.drawImage(numbers.get(firstDigit), 1750, 13, null);
            } else
            {
                g.drawImage(numbers.get(secondDigit), 1850, 13, null);
                g.drawImage(numbers.get(firstDigit), 1800, 13, null);
            }
        } else
        {
            g.drawImage(numbers.get(firstDigit), 1850, 13, null);
        }
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

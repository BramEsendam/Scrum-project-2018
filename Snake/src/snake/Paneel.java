/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Bram Esendam
 */
public class Paneel extends JPanel implements KeyListener
{

    private final Image bgImg = ImageIO.read(new File("src/Textures/Background.png"));
    private Timer repaintTimer = new Timer(27, new paintTimerHandler());

    public Paneel() throws IOException
    {
        repaintTimer.start();
    }

    @Override
    public void paintComponent(Graphics g)
    {
       g.drawImage(bgImg, 0, 0, null);
    }

    @Override
    public void keyTyped(KeyEvent ke
    )
    {

    }

    @Override
    public void keyPressed(KeyEvent ke
    )
    {

    }

    @Override
    public void keyReleased(KeyEvent ke
    )
    {

    }

    private class paintTimerHandler implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            repaint();
        }
    }

}

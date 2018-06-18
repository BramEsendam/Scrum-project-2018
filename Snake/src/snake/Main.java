/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.event.KeyListener;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Bram Esendam
 */
public class Main extends JFrame
{

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException
    {
        Main frame = new Main();
        frame.setSize(1280, 720);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("SNAAAAAAAAAAKEEEEE");
        JPanel paneel = new Paneel();
        frame.addKeyListener((KeyListener) paneel);
        frame.setContentPane(paneel);
        frame.setVisible(true);
    }

}

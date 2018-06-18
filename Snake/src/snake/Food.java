/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Jacco
 */
public class Food
{
    private int x,y;
    private final Color kleur;
    
    public Food(int x, int y)
    {
        this.kleur = Color.RED;
        this.x = x;
        this.y = y;
    }
    
    public void draw(Graphics g)
    {
        g.setColor(kleur);
        g.fillRect(x, y, 50, 50);
    }
}

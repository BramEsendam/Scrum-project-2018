/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Packages;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.swing.plaf.basic.BasicSplitPaneUI;

/**
 *
 * @author chant
 */
public class GameBoard
{
    public static final int ROWS = 4;
    public static final int COLS = 4;
    
    private final int startingTiles = 2;
    private Tile[][] board;
    private boolean dead;
    private boolean won;
    private BufferedImage gameBoard;
    private BufferedImage finalBoard;
    private int x;
    private int y;
    
    private static int SPACING = 10;
    public static int BOARD_WIDTH = (COLS + 1) * SPACING + COLS * Tile.WIDTH;
    public static int BOARD_HEIGHT = (ROWS + 1) * SPACING + ROWS * Tile.HEIGHT;
    
    private boolean hasStarted;

    public GameBoard(int x, int y)
    {
        this.x = x;
        this.y = y;
        board = new Tile[ROWS][COLS];
        gameBoard = new  BufferedImage(BOARD_WIDTH, BOARD_HEIGHT, BufferedImage.TYPE_INT_RGB);
        finalBoard = new  BufferedImage(BOARD_WIDTH, BOARD_HEIGHT, BufferedImage.TYPE_INT_RGB);
        
        createBoardImage();
    }
 

    private void createBoardImage()
    {
        Graphics2D g = (Graphics2D) gameBoard.getGraphics();
        g.setColor(Color.darkGray);
        g.fillRect(0, 0, BOARD_WIDTH, BOARD_HEIGHT);
        g.setColor(Color.lightGray);
        
        for (int row = 0; row < ROWS; row++)
        {
            for (int col = 0; col < COLS; col++)
            {
                int x = SPACING + SPACING * col + Tile.WIDTH * col;
                int y = SPACING + SPACING * row+ Tile.HEIGHT * row;
                g.fillRoundRect(x, y, Tile.WIDTH, Tile.HEIGHT, Tile.ARC_WIDTH, Tile.ARC_HEIGHT);
            }
        }
    }
    
    public void render(Graphics2D g)
    {
        Graphics2D g2d = (Graphics2D)finalBoard.getGraphics();
        g2d.drawImage(gameBoard, 0, 0, null);
        
        // draw tiles
        
        g.drawImage(finalBoard, x, y, null);
        g2d.dispose();
    }
    
    public void update()
    {
        checkKeys();
    }
    
    private void moveTiles (Direction dir)
    {
        boolean canMove = false;
        int horizontalDirection = 0;
        int verticalDirection = 0;
        
        if (dir == Direction.LEFT)
        {
            horizontalDirection = -1;
            for (int row = 0; row < ROWS; row++)
            {
                for (int col = 0; col < COLS; col++)
                {
                    if (canMove)
                    {
                        canMove = move(row, col, horizontalDirection, verticalDirection, dir);
                    } else move(row, col, horizontalDirection, verticalDirection, dir);
                }
            }
        }
        if (dir == Direction.RIGHT)
        {
            horizontalDirection = 1;
            for (int row = 0; row < ROWS; row++)
            {
                for (int col = COLS - 1; col >= 0; col --)
                {
                    if (canMove)
                    {
                        canMove = move(row, col, horizontalDirection, verticalDirection, dir);
                    } else move(row, col, horizontalDirection, verticalDirection, dir);
                }
            }
        }
        if (dir == Direction.UP)
        {
            verticalDirection = -1;
            for (int row = 0; row < ROWS; row++)
            {
                for (int col = 0; col < COLS; col++)
                {
                    if (canMove)
                    {
                        canMove = move(row, col, horizontalDirection, verticalDirection, dir);
                    } else move(row, col, horizontalDirection, verticalDirection, dir);
                }
            }
        }
        if (dir == Direction.DOWN)
        {
            verticalDirection = 1;
            for (int row = ROWS - 1; row >= 0; row--)
            {
                for (int col = 0; col < COLS; col++)
                {
                    if (canMove)
                    {
                        canMove = move(row, col, horizontalDirection, verticalDirection, dir);
                    } else move(row, col, horizontalDirection, verticalDirection, dir);
                }
            }
        }
    }
    
    private void checkKeys()
    {
        if (Keyboard.typed(KeyEvent.VK_LEFT))
        {
            moveTiles(Direction.LEFT);
            if (hasStarted) hasStarted = true;
        }
        if (Keyboard.typed(KeyEvent.VK_RIGHT))
        {
            moveTiles(Direction.RIGHT);
            if (hasStarted) hasStarted = true;
        }
        if (Keyboard.typed(KeyEvent.VK_UP))
        {
            moveTiles(Direction.UP);
            if (hasStarted) hasStarted = true;
        }
        if (Keyboard.typed(KeyEvent.VK_DOWN))
        {
            moveTiles(Direction.DOWN);
            if (hasStarted) hasStarted = true;
        }
    }
   
}

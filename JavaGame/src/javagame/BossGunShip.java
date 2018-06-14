/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author brame
 */
public class BossGunShip extends Thread
{

    public ArrayList<EnemyBullet> bullets;
    public int x = -300, y = 355, height, width, damage, bulletSize, hp, totalHp = 5000, Ydestination = 360, Xdestination = 1150;
    public Image gunShipImg, icon;
    public boolean stopedMoving, swapLaser = false, hitSide = false;
    public Timer stage1ShootTimer = new Timer(1500, new shootHandler("normal")), stage2ShootTimer = new Timer(1100, new shootHandler("normal")),
            stage3ShootTimer = new Timer(850, new shootHandler("normal")), stage4ShootTimer = new Timer(750, new shootHandler("normal")),
            specialAttackStage2Timer = new Timer(2500, new shootHandler("specialAttackStage2")), specialAttackStage1Timer = new Timer(800, new shootHandler("specialAttackStage1")),
            specialAttackStage3Timer = new Timer(3500, new shootHandler("specialAttackStage3"));
    private Random rand = new Random();

    public BossGunShip() throws IOException
    {
        this.gunShipImg = ImageIO.read(new File("Textures/boss.png"));
        this.hp = totalHp;
        bullets = new ArrayList<EnemyBullet>();
    }

    public void draw(Graphics g)
    {
        g.drawImage(gunShipImg, x, y, null);
        if (hp != 50)
        {
            g.setColor(Color.white);
            g.drawRect(655, 100, 503, 22);
            g.setColor(Color.red);
            g.fillRect(657, 102, hp / 10, 19);
        }
        bullets.forEach((bullet) ->
        {
            if (this.x > 2000)
            {
                bullet.stop();
                bullets.remove(bullet);
            } else if (bullet.isAlive())
            {
                bullet.draw(g);
            }
        });
    }

    @Override
    public void run()
    {
        while (true)
        {
            if (x < 100)
            {
                x += 3;
            } else
            {
                if (y < 150)
                {
                    hitSide = true;
                } else if (y > 600)
                {
                    hitSide = false;
                }
                if (hitSide)
                {
                    y += rand.nextInt(3);
                } else if (!hitSide)
                {
                    y -= rand.nextInt(3);
                }
                stopedMoving = true;
            }
            try
            {
                Thread.sleep(20);
            } catch (InterruptedException e)
            {
            }
        }
    }

    public void shoot(String attackType)
    {
        EnemyBullet bullet = null;
        if (attackType == "normal")
        {
            bulletSize = 12;
            if (swapLaser)
            {
                swapLaser = false;
                bullet = new EnemyBullet(this.x + 150, this.y + 20, Ydestination, Xdestination, bulletSize, damage, Color.green);
                bullet.start();
                bullets.add(bullet);
            } else
            {
                swapLaser = true;
                bullet = new EnemyBullet(this.x + 150, this.y + 336, Ydestination, Xdestination, bulletSize, damage, Color.green);
                bullet.start();
                bullets.add(bullet);
            }
        } else if (attackType == "specialAttackStage1")
        {
            bullet = new EnemyBullet(this.x + 365, this.y + 178, this.y + 178, 2000, bulletSize, damage, Color.red);
            bullet.start();
            bullets.add(bullet);
        } else if (attackType == "specialAttackStage2")
        {
            bullet = new EnemyBullet(this.x + 200, this.y + 128, Ydestination, Xdestination, bulletSize, damage, Color.yellow);
            bullet.start();
            bullets.add(bullet);
            bullet = new EnemyBullet(this.x + 200, this.y + 228, Ydestination, Xdestination, bulletSize, damage, Color.yellow);
            bullet.start();
            bullets.add(bullet);
        } else if (attackType == "specialAttackStage3")
        {
            bullet = new EnemyBullet(this.x + 150, this.y + 20, this.y - 500, 1500, bulletSize, damage, Color.ORANGE);
            bullet.start();
            bullets.add(bullet);
            bullet = new EnemyBullet(this.x + 150, this.y + 20, this.y - 250, 1500, bulletSize, damage, Color.ORANGE);
            bullet.start();
            bullets.add(bullet);
            bullet = new EnemyBullet(this.x + 150, this.y + 336, this.y + 250, 1500, bulletSize, damage, Color.ORANGE);
            bullet.start();
            bullets.add(bullet);
            bullet = new EnemyBullet(this.x + 150, this.y + 336, this.y + 500, 1500, bulletSize, damage, Color.ORANGE);
            bullet.start();
            bullets.add(bullet);
        }
    }

    void stopShootTimers()
    {
        stage1ShootTimer.stop();
        stage2ShootTimer.stop();
        stage3ShootTimer.stop();
        stage4ShootTimer.stop();
        specialAttackStage1Timer.stop();
        specialAttackStage2Timer.stop();
        specialAttackStage3Timer.stop();

    }

    private class shootHandler implements ActionListener
    {

        private String attackType;

        public shootHandler(String attackType)
        {
            this.attackType = attackType;
        }

        @Override

        public void actionPerformed(ActionEvent e)
        {
            if (stopedMoving)
            {
                shoot(this.attackType);
            }
        }
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void stage1()
    {
        stage1ShootTimer.start();
        specialAttackStage1Timer.start();
    }

    public void stage2()
    {
        stage1ShootTimer.stop();
        stage2ShootTimer.start();
        specialAttackStage2Timer.start();
    }

    public void stage3()
    {
        stage2ShootTimer.stop();
        stage3ShootTimer.start();
        specialAttackStage3Timer.start();

    }

    public void stage4()
    {
        stage3ShootTimer.stop();
        stage4ShootTimer.start();
    }
}

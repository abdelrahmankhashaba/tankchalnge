/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tankchalnge;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/** 
 *
 * @author tarah
 */
public class movingballs extends JPanel implements Runnable{

   public ArrayList<ball>Balls=new ArrayList<ball>(5);
   public tank1 BlueTank=new tank1("TankBlueS.jpg");
   public tank1 BlueTank1=new tank1("TankBlueS.jpg");

    public movingballs()
    {
        setSize(600,600);
        BlueTank.pos.x=200;
        BlueTank.pos.y=340; 
        
        BlueTank1.pos.x=40;
        BlueTank1.pos.y=340;
        
        
        this.addKeyListener(new keylist());
        
    }
    private class keylist implements KeyListener
    {

        @Override
        public void keyTyped(KeyEvent e) {
           
        }

        @Override
        public void keyPressed(KeyEvent e) {
           
            if (e.getKeyCode()==KeyEvent.VK_RIGHT)
            {
                
                BlueTank.mover();
                
            }
            if (e.getKeyCode()==KeyEvent.VK_LEFT)
            {
                
                BlueTank.movel();
            }
            if (e.getKeyCode()==KeyEvent.VK_SPACE)
            {
                
                BlueTank.fireBullet();
            }
            if (e.getKeyCode()==KeyEvent.VK_D)
            {
                
                BlueTank1.mover();
                
            }
            if (e.getKeyCode()==KeyEvent.VK_A)
            {
                
                BlueTank1.movel();
            }
            if (e.getKeyCode()==KeyEvent.VK_ALT)
            {
                
                BlueTank1.fireBullet();
            }
        }
        

        @Override
        public void keyReleased(KeyEvent e) {
           
        }
    }
    public void  paintComponent(Graphics g)
    {
        g.clearRect(0, 0, 600, 600);
        
        try
        {
        BufferedImage bluetank = ImageIO.read(new File(BlueTank.ImagePath));
        BufferedImage bluerocket = ImageIO.read(new File(BlueTank.Rocket.imgPath));
        g.drawImage(bluetank, BlueTank.pos.x, BlueTank.pos.y,null);
        g.drawImage(bluerocket, BlueTank.Rocket.pos.x, BlueTank.Rocket.pos.y,null);
        
        BufferedImage blueTank1 = ImageIO.read(new File(BlueTank1.ImagePath));
        BufferedImage Bluerocket = ImageIO.read(new File(BlueTank1.Rocket.imgPath));
        g.drawImage(blueTank1, BlueTank1.pos.x, BlueTank1.pos.y,null);
        g.drawImage(Bluerocket, BlueTank1.Rocket.pos.x, BlueTank1.Rocket.pos.y,null);
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        
        
        for (ball OneBall: Balls)
        
        {
            g.setColor(OneBall.CurrentColor);
            g.fillOval(OneBall.x,OneBall.y, 50, 50);
            if (BlueTank.Rocket.pos.distance(OneBall.x, OneBall.y)<=50)
            {
                int result;
                Balls.remove(OneBall);
                Tankchalnge.NumberofBalls--;
                BlueTank.score++;
                if( Tankchalnge.NumberofBalls==0)
                {
                    result=JOptionPane.showConfirmDialog(null, "Tank 1 Wins The Score:"+" "+ BlueTank.score , "Game Over", JOptionPane.DEFAULT_OPTION);
                    if(result == JOptionPane.OK_OPTION){
                        exit(0);
                    }
                }
               // System.out.println("Hit Occurs" + OneBall.CurrentColor.toString());
                break;
                
            }
             if (BlueTank1.Rocket.pos.distance(OneBall.x, OneBall.y)<=50)
            {
                int result1;
                Balls.remove(OneBall);
                Tankchalnge.NumberofBalls--;
                BlueTank1.score--;
                if( Tankchalnge.NumberofBalls==0)
                {
                   result1=JOptionPane.showConfirmDialog(null, "Game Over "+" "+ BlueTank1.score  , "Game Over", JOptionPane.DEFAULT_OPTION); 
                    if(result1== JOptionPane.OK_OPTION){
                        exit(0);
                    }
                }

               // System.out.println("Hit Occurs" + OneBall.CurrentColor.toString());
                break;
                
            }
            
        }
        
    }
    @Override
    public void run() {
    try
    {
    while(true)
    {
        for (ball OneBall: Balls)
        {
            OneBall.move(this.getWidth());
        }    
        
        Thread.sleep(50);
        repaint();
    }
    }
    catch (InterruptedException e)
    {}
    }
    
}


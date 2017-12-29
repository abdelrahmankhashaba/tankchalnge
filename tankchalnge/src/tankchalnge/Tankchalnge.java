/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tankchalnge;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author tarah
 */
public class Tankchalnge {

   public static int NumberofBalls=9;
    public static void main(String[] args) {
       
       
        JFrame Ch4=new JFrame();
        Ch4.setSize(600, 600);
        Ch4.setTitle("Tank Game");
        Ch4.setResizable(false);
        Ch4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        movingballs mb=new movingballs();
       
        mb.Balls.add(new ball());
        mb.Balls.add(new ball(100,100,20,Color.red));
        mb.Balls.add(new ball(160,160,15,Color.red));
        mb.Balls.add(new ball(180,180,10,Color.red));
        mb.Balls.add(new ball(200,200,20,Color.red));
        mb.Balls.add(new ball(220,220,18,Color.red));
        mb.Balls.add(new ball(240,240,15,Color.red));
        mb.Balls.add(new ball(260,260,12,Color.red));
        mb.Balls.add(new ball(80,80,18,Color.red));
        mb.Balls.add(new ball(60,60,11,Color.red));


        Ch4.add(mb,BorderLayout.CENTER);
        mb.setFocusable(true);
        Thread t1=new Thread(mb);
        t1.start();
        Ch4.setVisible(true);
        
       
        
         
       
        
      
       
        
        
        
    }
    
}

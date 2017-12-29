/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tankchalnge;
import java.awt.Point;
/**
 *
 * @author tarah
 */


public class tank2 {
    public Point pos1=new Point();
    public bullets Rocket1=new bullets();
    public String ImagePath1;
    public int speed;
    public int score;
 public tank2 (String ImagePath)
    {
        speed=5;
        score=0;
        this.ImagePath1=ImagePath;
        Rocket1.imgPath="C:\\Users\\tarah\\Documents\\NetBeansProjects\\tankchalnge";
       // pos1.x=X;
       // pos1.y=Y;
    }

   
  void mover() {
        this.pos1.x+=speed;

    }
    void movel() {
         this.pos1.x-=speed;

    }
     public void fireBullet(){
        Rocket1.pos.x=this.pos1.x+60;
        Rocket1.pos.y=this.pos1.y;
        Thread t2=new Thread (Rocket1);
        t2.start();
     }
}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


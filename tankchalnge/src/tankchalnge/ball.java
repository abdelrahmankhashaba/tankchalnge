/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tankchalnge;
import java.awt.Color;
/**
 *
 * @author tarah
 */
public class ball {
     public int x,y;
    public int speedx;
    public Color CurrentColor;
    public ball(int x,int y,int speedx,Color color)
    {
        this.x=x;
        this.y=y;
        this.speedx=speedx;
        this.CurrentColor=color;
    }
    public ball()
    {
        x=0;
        y=0;
        speedx=10;
        CurrentColor=Color.GREEN;
    }
    public  void move(int width)
    {
        x+=speedx;
        if (x+50>width)
        {
            speedx= -speedx;
        }
        if (x<0)
        {
            speedx= -speedx;
        }
    }
    
}

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Missile 
{
int x,y,cy,cx;
Image im;
int height;
int width;
String namei;
int direction;
    public Missile(int xg, int yg,String s)
    {
    namei = s;
    ImageIcon i = new ImageIcon(getClass().getResource(namei));
    height = i.getIconHeight();
    width = i.getIconWidth();
    im = i.getImage();
    x = xg - width/2;// should be given in constructor?
    y = yg - height;
    cy = -20;
    }
     
    public Missile(int xg, int yg,String s,int iii,int bx,int by)
    {
    namei = s;
    ImageIcon i = new ImageIcon(getClass().getResource(namei));
    height = i.getIconHeight();
    width = i.getIconWidth();
    im = i.getImage();
    x = bx;
    y = by;
//     x = xg - width/2;
//     y = yg - height;
    direction = iii;
    if (iii == 12){
    cy = -20;
    }
    else if (iii == 3){
    cx = 20;
    }
    else if (iii == 6){
    cy = 20;
    }
    else if (iii == 9){
    cx = -20;
    }
    else if (iii == 0){
    cy = 20;
    }
    }
    
    public void accelerate(){
    y = y + cy;
    x = x + cx;
}
    public int getX(){
    return x;    
    }
    public int getY(){
    return y;    
    }
    public int getHeight(){
    return height;    
    }
    public int getWidth(){
    return width;    
    }
    public Image getImage(){
    return im;
    }
    public int getDirection(){
    return direction;
    }
}

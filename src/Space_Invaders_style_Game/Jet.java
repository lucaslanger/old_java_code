import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Jet implements KeyListener
{
int x,cx,y,cy;
Image im;
ArrayList<Missile> mmm;
int height;
int width;
String jname;
boolean toofarx;
boolean toofary;
int shootspeed = 250;
int shoottime = 250;

boolean airstrikecall = false;

    public Jet(String s)
    {
    jname = s;
    ImageIcon i = new ImageIcon(getClass().getResource(jname));
    height = i.getIconHeight();
    width = i.getIconWidth();
    im = i.getImage();
    x = 400;
    y = 500;
    mmm = new ArrayList<Missile>();
    }
    
    public void move(){
if (this.getX() > 0 && this.getX() < 1000 - 145){
x = x + cx;
}
else if (this.getX() == 0 && cx > 0){
x = x + cx;
}
else if (this.getX() == 1000 - 145 && cx < 0){
x = x + cx;
}
if (this.getY() > 0 && this.getY() < 1000 - 250){
y = y + cy;
}
else if (this.getY() == 0 && cy > 0){
y = y + cy;
}
else if (this.getY() == 1000 - 250 && cy < 0){
y = y + cy;
}
   
}
    public void rangecheck(){
    if (this.getX() > 500){
    toofarx = true;
    }
    else{
    toofarx = false;
    }
    if (this.getY() > 500){
    toofary = true;
    }
    else{
    toofary = false;
    }
    
    }

    public int getX(){
    return x;    
    }
    public int getY(){
    return y;    
    }
    public Image getImage(){
    return im;
    }
    public ArrayList<Missile> getMissiles(){
    return mmm;
    }
    public void launchmissile(){
    Missile m = new Missile(x + width/2,y,"missile.gif");
    mmm.add(m);
    }
    public int getHeight(){
    return height;    
    }
    public int getWidth(){
    return width;    
    }
    public void keyPressed(KeyEvent e){
    
    int key = e.getKeyCode();
     if (key == KeyEvent.VK_LEFT){
     cx = -5;
     }
     if (key == KeyEvent.VK_RIGHT){
     cx = 5;   
    }
    if (key == KeyEvent.VK_UP){
    cy = -5;
    }
    if (key == KeyEvent.VK_DOWN){
    cy = 5;
    }
    if (key == KeyEvent.VK_SPACE){
    if (shootspeed == shoottime){  
        shootspeed = 0;    
    launchmissile();
}
    }
}

     public void keyReleased(KeyEvent e){
     int key = e.getKeyCode();
     if (key == KeyEvent.VK_LEFT){
     cx = 0;
     }
     if (key == KeyEvent.VK_RIGHT){
     cx = 0;   
    }
    if (key == KeyEvent.VK_UP){
    cy = 0;
    }
    if (key == KeyEvent.VK_DOWN){
    cy = 0;
    }
    if (key == KeyEvent.VK_ALT){
    airstrikecall = true;
    }
        
}

    public void keyTyped(KeyEvent e){    
     }

    public void setXLocation(int x1){
    x = x1;
    cx = 0;
    cy = 0;
    }
    public void setYLocation(int y1){
    y = y1;
    }
    public void shootinterval(){
        if (shootspeed != shoottime){
    shootspeed = shootspeed + 5;
    }
    
    }
    public void setShootTime(int s){
    shoottime = s;
    shootspeed = s;
    }

public void normalize(){
shoottime = 250;
}
public void changeX(int c){
x = x + c;
}
public void changeY(int t){
y = y + t;
}
public boolean checkAirStrike(){
boolean b = airstrikecall;
airstrikecall = false;
return b;
}
}


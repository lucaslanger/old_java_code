import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class Enemy
{
ImageIcon en;
Image im;
String enname;
Random r;
int framewidth;
int xlocation;
int ylocation  = 0;
int imageheight;
int imagewidth;
int fwidth;

int deadtime;

boolean alive = true;

boolean movedown = false;
boolean lefttoright = false;
boolean righttoleft = false;
boolean zigzag = false;
int zigzagx;
int movementspeed = 5;

    public Enemy(String ens, int f, int movements)
    {
    movementspeed = movements;
    enname = ens;
    fwidth = f;
    framewidth = fwidth - imagewidth;
    en = new ImageIcon(getClass().getResource(enname + ".gif"));
    imageheight = en.getIconHeight();
    imagewidth = en.getIconWidth();
    im = en.getImage();  
    r = new Random();
   
    if (enname.equals("enemy1")){
    movedown = true;
    }
    else if (enname.equals("enemy2")){
    righttoleft = true;
    }
    else if(enname.equals("enemy3")){
    movedown = true;
    }
    else if(enname.equals("enemy4")){
    lefttoright = true;
    xlocation = framewidth;
    }
    else if(enname.equals("enemy5")){
    zigzag = true;
    }
    else if (enname.equals("boss2")){
    movedown = true;
    }
    this.placeEnemy(); 
    }
    
    public void placeEnemy(){
    if(movedown){    
    xlocation = r.nextInt(framewidth - imagewidth);    
}
else if(righttoleft){
xlocation = framewidth - imagewidth;
ylocation = r.nextInt(1000 - imageheight - 223);
}
else if (lefttoright){
    xlocation = 0;
    ylocation = r.nextInt(1000 - imageheight - 223);
}
else if (zigzag){
    xlocation = r.nextInt(1000 - imagewidth - 200);
}
    }
    public void move(){   
    if(alive){    
        if(movedown){
    ylocation = ylocation + movementspeed;
}
    else if(lefttoright){
    xlocation = xlocation + movementspeed;
}
else if(righttoleft){
    xlocation = xlocation - movementspeed;
}
else if(zigzag){
    ylocation = ylocation + movementspeed;
    if (zigzagx < 200){ 
    xlocation = xlocation + 10;
    zigzagx = zigzagx + 10;
}
else if (zigzagx == 400){
zigzagx = 0;
}
else{
xlocation = xlocation - 10;
zigzagx = zigzagx + 10;
}
}
    }
    }
    public int getXLocation(){
    return xlocation;
    }
    public int getYLocation(){
    return ylocation;
    }
    public Image getImage(){
    return im;
    }
    public int getHeight(){
    return imageheight;
    }
    public int getWidth(){
    return imagewidth;
    }
    public void addDeadTime(){
    deadtime += 5;
    }
    public int getDeadTime(){
    return deadtime;    
}
    public void setImage(String imgname){
    ImageIcon ii = new ImageIcon(getClass().getResource(imgname));
    im = ii.getImage();
    }
    public void setStationary(){
    alive = false;
    }
    public boolean checkDead(){
    return alive;
    }  

}

import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class Boost
{
int whichboost;
ImageIcon imic;
Image im;
int x;
int y;
Random r;
int swidth;
int sheight;
int timeinplay;
int height;
int width;

    public Boost(int boosttype,int screenwidth,int screenheight)
    {
    swidth = screenwidth;
    sheight = screenheight;
    r = new Random();
    whichboost = boosttype;   
    timeinplay = 2000;
    if (whichboost == 0){
    imic = new ImageIcon(getClass().getResource("movementboost.jpg"));
    width = imic.getIconWidth();
    height = imic.getIconHeight();
    im = imic.getImage();
    width = imic.getIconWidth();
    }  
    else if (whichboost == 1){
    imic = new ImageIcon(getClass().getResource("attackspeedboost.jpg"));
    width = imic.getIconWidth();
    height = imic.getIconHeight();
    im = imic.getImage();
    }   
    else if (whichboost == 2){
    imic = new ImageIcon(getClass().getResource("defenseboost.jpg"));
    width = imic.getIconWidth();
    height = imic.getIconHeight();
    im = imic.getImage();
    }  
    setLocation();
    }
    public void setLocation(){
    x = r.nextInt(1000-width);
    y = r.nextInt(1000-height);
    }
    public void decreaseTimeVisible(){
    timeinplay = timeinplay - 5;
    }
    public int getTime(){
    return timeinplay;
    }
    public int getBoostType(){
    return whichboost;
    }
    public Image getImage(){
    return im;
    }
    public int getX(){
    return x;
    }
    public int getY(){
    return y;
    }
    public int getWidth(){
    return width;
    }
    public int getHeight(){
    return height;
    }
}

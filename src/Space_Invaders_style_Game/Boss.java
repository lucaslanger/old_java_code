import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.util.ArrayList;

public class Boss 
{
Image img;
ImageIcon imic;
int y;
int x; 
Random r;
int direction;
int durationmoved;
int height;
int width;
ArrayList<Missile> slimeballs;
int slime;
int level;
int movementspeed = 5;
public Boss(int bosslevel){
level = bosslevel;
if (bosslevel == 0){
imic = new ImageIcon(getClass().getResource("boss.gif"));
height = imic.getIconHeight();
width = imic.getIconWidth();
img = imic.getImage();
y = 100;
x = 490;
r = new Random();
durationmoved = 400;
slimeballs = new ArrayList<Missile>();
}

if (bosslevel == 1){
imic = new ImageIcon(getClass().getResource("boss2.gif"));
height = imic.getIconHeight();
width = imic.getIconWidth();
img = imic.getImage();
y = 100;
x = 490;
r = new Random();
durationmoved = 400;
slimeballs = new ArrayList<Missile>();
}

if (bosslevel == 3){
imic = new ImageIcon(getClass().getResource("boss4.gif"));
height = imic.getIconHeight();
width = imic.getIconWidth();
img = imic.getImage();
y = 100;
x = 490;
r = new Random();
durationmoved = 400;
slimeballs = new ArrayList<Missile>();
}

if (bosslevel == 4){
imic = new ImageIcon(getClass().getResource("boss5.gif"));
height = imic.getIconHeight();
width = imic.getIconWidth();
img = imic.getImage();
y = 100;
x = 490;
r = new Random();
durationmoved = 400;
slimeballs = new ArrayList<Missile>();
movementspeed = 10;
}

}
public void fire(){
if (level == 0){
slimeballs.add(new Missile(0,0,"slimeball.gif",12,this.getX()+ width/2,this.getY() + 64));
slimeballs.add(new Missile(0,0,"slimeball.gif",3,this.getX()+ width,this.getY()+ height/2));
slimeballs.add(new Missile(0,0,"slimeball.gif",6,this.getX()+ width/2,this.getY() + height));
slimeballs.add(new Missile(0,0,"slimeball.gif",9,this.getX() - 53,this.getY() + height/2));
}
if (level == 4){
slimeballs.add(new Missile(0,0,"acid-breath.gif",0,this.getX() + width/2,this.getY() + height));
}
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
public void move(){
if (level == 1){
y = y - 20;
}

if (level!= 3){
if (durationmoved != 400){
durationmoved += 5;
if (direction == 0){
if (this.getY() > 0){
y = y - movementspeed;
}
else if (this.getY() == 0){
durationmoved = 400;
}
}
else if(direction == 1){
if (this.getX() <1000 - width){
x = x + movementspeed;
}

else if (this.getX() ==1000 - width){
durationmoved = 400;    
}
if (this.getY() > 0){
y = y - movementspeed;
}
else if (this.getY() == 0){
durationmoved = 400;
}
}
else if(direction == 2){
if (this.getX() <1000 - width){
 x = x + movementspeed;
}
 else if (this.getX() ==1000 - width){
durationmoved = 400;   
}
}
else if(direction == 3 ){
if (this.getY() < 440){
y = y + movementspeed;
}
else if (this.getY() == 440){
durationmoved = 400;
}
if (this.getX() <1000 - width){
 x = x + movementspeed;
 }
 else if (this.getX() ==1000 - width){
durationmoved = 400;   
}
}
else if (direction == 4 ){
if (this.getY() < 440){
y = y + movementspeed;

}
else if (this.getY() == 440){
durationmoved = 400;
}
}
else if (direction == 5){
if (this.getY() < 440){
y = y + movementspeed;

}
else if (this.getY() == 440){
durationmoved = 400;
}
if (this.getX() > 0){
x = x - movementspeed;
;
}
else if (this.getX() == 0){
durationmoved = 400;
}
}
else if (direction == 6){
if (this.getX() > 0){
x = x - movementspeed;
}
else if (this.getX() == 0){
durationmoved = 400;
}
}
else if (direction == 7 ){
if (this.getX() > 0){
x = x - movementspeed;
}
else if (this.getX() == 0){
durationmoved = 400;
}
if (this.getY() > 0){
y = y - movementspeed;
}
else if (this.getY() == 0){
durationmoved = 400;
}
}

}
else{
direction = r.nextInt(7);
durationmoved = 0;
}
}
else if (level == 3){
if (durationmoved != 400){
durationmoved += 5;
if (direction == 0){
if (this.getY() > 0){
y = y - movementspeed;
}
else if (this.getY() == 0){
durationmoved = 400;
}
}
else if(direction == 1){
if (this.getX() <1000 - width){
x = x + movementspeed;
}

else if (this.getX() ==1000 - width){
durationmoved = 400;    
}
if (this.getY() > 0){
y = y - movementspeed;
}
else if (this.getY() == 0){
durationmoved = 400;
}
}
else if(direction == 2){
if (this.getX() <1000 - width){
 x = x + movementspeed;
}
 else if (this.getX() ==1000 - width){
durationmoved = 400;   
}
}
else if(direction == 3 ){
if (this.getY() < 670){
y = y + movementspeed;
}
else if (this.getY() == 670){
durationmoved = 400;
}
if (this.getX() <1000 - width){
 x = x + movementspeed;
 }
 else if (this.getX() ==1000 - width){
durationmoved = 400;   
}
}
else if (direction == 4 ){
if (this.getY() < 670){
y = y + movementspeed;

}
else if (this.getY() == 670){
durationmoved = 400;
}
}
else if (direction == 5){
if (this.getY() < 670){
y = y + movementspeed;

}
else if (this.getY() == 670){
durationmoved = 400;
}
if (this.getX() > 0){
x = x - movementspeed;
;
}
else if (this.getX() == 0){
durationmoved = 400;
}
}
else if (direction == 6){
if (this.getX() > 0){
x = x - movementspeed;
}
else if (this.getX() == 0){
durationmoved = 400;
}
}
else if (direction == 7 ){
if (this.getX() > 0){
x = x - movementspeed;
}
else if (this.getX() == 0){
durationmoved = 400;
}
if (this.getY() > 0){
y = y - movementspeed;
}
else if (this.getY() == 0){
durationmoved = 400;
}
}

}
else{
direction = r.nextInt(7);
durationmoved = 0;
}
}
}
public Image getImage(){
return img;
}
public void movemissiles(){
for (int c=0;c<slimeballs.size();c++){
slimeballs.get(c).accelerate();
}
}
public ArrayList<Missile> getSlimeballs(){
return slimeballs;
}
public int getLevel(){
return level;
}
}


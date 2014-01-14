import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PaintPanel extends JPanel implements MouseListener
{
public int x,y;
boolean circle = false;
boolean rectangle = false;
boolean clear = false;
boolean poly = false;
boolean draw = false;
Color c;
int[] xcoord;
int[] ycoord;

int[]xtemp;
int[]ytemp;
int d =0;

public PaintPanel(){
addMouseListener(this);
c = (Color.GREEN);
setVisible(true);
xtemp = new int[100];
ytemp = new int[100];
}

public void mouseClicked(MouseEvent e){
if (poly){
xtemp[d] = e.getX();
ytemp[d] = e.getY();
d++;
}
else{
x = e.getX();
y = e.getY();
repaint();
}
}
public void mouseEntered(MouseEvent e){}
public void mouseExited(MouseEvent e){}
public void mousePressed(MouseEvent e){}
public void mouseReleased(MouseEvent e){}

public void paintComponent(Graphics g){
if(circle == true){
g.setColor(c);
g.fillOval(x-10, y-10, 20, 20);
}
if(rectangle == true){
g.setColor(c);
g.fillRect(x-10, y-10, 20, 20);
}
if (clear == true){
g.setColor(Color.WHITE);
g.fillRect(0,0,x,y);
clear = false;
}
if (draw == true){
xcoord = new int[d];
ycoord = new int[d];
for (int f = 0;f<d;f++){
xcoord[f] = xtemp[f];
ycoord[f] = ytemp[f];
}
g.fillPolygon(xcoord,ycoord,d);
d = 0;
}
}
public void colorselect(){
c = JColorChooser.showDialog(null,"Decide on a Color for Drawing Shapes",c);
}

public void circleistrue(){
circle = true;
rectangle = false;
}
public void rectangleistrue(){
rectangle = true;
circle = false;
}
public void clearcolors(){
y = this.getHeight();
x = this.getWidth();
rectangle = false;
circle = false;
clear = true;
repaint();
}
public void coordpolygon(){
poly = true;
rectangle = false;
circle = false;
clear = false;
}
public void drawpolygon(){
draw = true;
poly = false;
rectangle = false;
circle = false;
clear = false;
repaint();
}
}

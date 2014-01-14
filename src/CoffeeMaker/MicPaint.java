import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class MicPaint extends JFrame implements ActionListener
{
JButton circle;
JButton rectangle;
JButton choosecolor;
JButton clear;
JButton polygon;
JButton draw;

PaintPanel p;

JPanel options;

public MicPaint(){
setSize(500,500);
setLayout(new BorderLayout());
p = new PaintPanel();

circle = new JButton("Draw Circles");
rectangle = new JButton("Draw Rectangles");
choosecolor = new JButton("Choose a Color");
clear = new JButton("Clear Shapes");
polygon = new JButton("Polygon Mode");
draw = new JButton("Draw it!");

circle.addActionListener(this);
rectangle.addActionListener(this);
choosecolor.addActionListener(this);
clear.addActionListener(this);
polygon.addActionListener(this);
draw.addActionListener(this);

options = new JPanel();
options.add(circle);
options.add(rectangle);
options.add(choosecolor);
options.add(clear);
options.add(polygon);
options.add(draw);
add(options,"North");
add(p);

setSize(501,501);
setVisible(true);
}
public void actionPerformed(ActionEvent e){
if (e.getActionCommand() == "Draw Circles" ){
p.circleistrue();
}
if (e.getActionCommand() == "Draw Rectangles" ){
p.rectangleistrue();
}
if(e.getActionCommand() == "Choose a Color"){
p.colorselect();
}
if (e.getActionCommand() == "Clear Shapes"){
p.clearcolors();
}
if(e.getActionCommand() == "Polygon Mode"){
p.coordpolygon();
}
if (e.getActionCommand() == "Draw it!"){
p.drawpolygon();
}
} 

public static void main (String []args){
MicPaint mp = new MicPaint();
}
}

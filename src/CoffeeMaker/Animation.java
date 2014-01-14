import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Animation extends JPanel implements ActionListener{

private Timer animator;

ImageIcon[] animation1; 
ImageIcon[] animation2; 
ImageIcon[] animation3; 
ImageIcon[] animation4; 

private ImageIcon image1;
private ImageIcon image2;
private ImageIcon image3;
private ImageIcon image4;
private ImageIcon image5;
private ImageIcon image6;
private ImageIcon image7;
private ImageIcon image7b;
private ImageIcon image4b;

int c = 0;
boolean goahead = false;
boolean goahead2 = false;
boolean goahead3 = false;
boolean goahead4 = false;

boolean taken = true;

public Animation(){

animation1 = new ImageIcon[4];
animation2 = new ImageIcon[7];
animation3 = new ImageIcon[5];
animation4 = new ImageIcon[9];

image1 = new ImageIcon(getClass().getResource("coffeemaker.jpg"));
image2 = new ImageIcon(getClass().getResource("coffeemaker2.jpg"));
image3 = new ImageIcon(getClass().getResource("coffeemaker3.jpg"));
image4 = new ImageIcon(getClass().getResource("coffeemaker4.jpg"));
image5 = new ImageIcon(getClass().getResource("coffeemaker5.jpg"));
image6 = new ImageIcon(getClass().getResource("coffeemaker6.jpg"));
image7 = new ImageIcon(getClass().getResource("coffeemaker7.jpg"));
image7b = new ImageIcon(getClass().getResource("coffeemaker7 with sugar.jpg"));
image4b = new ImageIcon(getClass().getResource("coffeemaker4 with sugar.jpg")); 
   
animation1[0] = image1;
animation1[1] = image2;
animation1[2] = image3;
animation1[3] = image4;

animation2[0] = image1;
animation2[1] = image2;
animation2[2] = image3;
animation2[3] = image4;
animation2[4] = image5;
animation2[5] = image6;
animation2[6] = image7;

animation3[0] = image1;
animation3[1] = image2;
animation3[2] = image3;
animation3[3] = image4;
animation3[4] = image4b;

animation4[0] = image1;
animation4[1] = image2;
animation4[2] = image3;
animation4[3] = image4;
animation4[4] = image5;
animation4[5] = image6;
animation4[6] = image7;
animation4[7] = image7b;
animation4[8] = image4b;

animator = new Timer(5,this);
animator.start();

}

public void paintComponent(Graphics g){
super.paintComponent(g);
if(goahead == true){
if(c == 4){
goahead = false;
c=3;
}
else{
animation1[c].paintIcon(this,g,0,0);
c++;
}
}
else if(goahead2 == true){
if(c == 7){
goahead2 = false;
c=6;
}
else{
animation2[c].paintIcon(this,g,0,0);
c++;
}
}
else if(goahead3 == true){
if(c == 5){
goahead3 = false;
c=8;
}
else{
animation3[c].paintIcon(this,g,0,0);
c++;
}
}
else if(goahead4 == true){
if(c == 8){
goahead4 = false;
c=7;
}
else{
animation4[c].paintIcon(this,g,0,0);
c++;
}
}
else{
animation4[c].paintIcon(this,g,0,0);
}
}
public void doAnimation(int a){
if (a == 1){
goahead = true;
}
if (a == 2){
goahead2 = true;
}
if (a == 3){
goahead3 = true;
}
if (a == 4){
goahead4 = true;
}
}
public void actionPerformed(ActionEvent e) {
repaint();
}
public void coffeetaken(){
c=0;
}
}

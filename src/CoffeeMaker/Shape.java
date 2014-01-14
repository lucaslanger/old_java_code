import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Shape extends JFrame implements ActionListener{
    int x, y, shapeChoice;
    String colorSelected;
    JButton circle,square,refresh,colorChoice;
    JPanel bot, right, center;
    Color c;
    boolean refreshCheck=false;
   
//     String[] colors = {"Red", "Blue", "Orange", "Yellow", "Green", "Black", "Gray"};
//     colorSelected = (String) JOptionPane.showInputDialog(null, "Please Select a Colour", "Colour Selection", JOptionPane.INFORMATION_MESSAGE, null, colors, colors[0]);
//            
    DrawArea draw = new DrawArea();
   
   
    public Shape (){
        super("Drawer by KEVIN LIN");
        bot = new JPanel();
        center = new JPanel();
        circle = new JButton("Circle");
        circle.addActionListener(this);
        square = new JButton("Square");
        square.addActionListener(this);
        refresh = new JButton("Refresh");
        refresh.addActionListener(this);
        colorChoice = new JButton("Color");
        colorChoice.addActionListener(this);
       
        circle.setEnabled(false);
        square.setEnabled(false);
        bot.add(colorChoice);
        bot.add(circle);
        bot.add(square);
        bot.add(refresh);
       
        add("North", bot);
        add("Center", draw);
        setSize(700,500);
        setLocation(250, 50);
        setVisible(true);
    }
    public class DrawArea extends JPanel {
        public DrawArea() {
            x=0;y=0;
                addMouseListener(
                new MouseAdapter() {
                    public void mouseReleased( MouseEvent e ) {
                        x=e.getX();
                        y=e.getY();
                        repaint();
                    }
                }
            );
        }
        public void paint( Graphics g ) {
                if(shapeChoice ==1){
                    g.setColor(c);
                    g.fillOval(x-10, y-10, 20, 20);
                }
                if(shapeChoice == 2) {
                    g.setColor(c);
                    g.fillRect(x-10,y-10, 20, 20);
                }
                if(refreshCheck == true){
                    g.clearRect(0,0, 700,500);
                    refreshCheck = false;
                }
        }
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == circle) {
            shapeChoice = 1;
        }
        if(e.getSource() == square) {
            shapeChoice = 2;
        }
        if(e.getSource() == colorChoice) {
            String[] colors = {"Red", "Blue", "Orange", "Yellow", "Green", "Black", "Gray"};
            colorSelected = (String) JOptionPane.showInputDialog(null, "Please Select a Colour", "Colour Selection", JOptionPane.INFORMATION_MESSAGE, null, colors, colors[0]);//ffdgdfgdfgdfgdfg
            if(colorSelected == "Red") {
                c= Color.RED;
            }
            if(colorSelected == "Blue") {
                c=Color.BLUE;
            }
            if(colorSelected == "Orange") {
                c=Color.ORANGE;
            }
            if(colorSelected == "Yellow") {
                c=Color.YELLOW;
            }
            if(colorSelected == "Green") {
                c=Color.GREEN;
            }
            if(colorSelected == "Black") {
                c=Color.BLACK;
            }
            if(colorSelected == "Gray") {
                c=Color.GRAY;
            }
            circle.setEnabled(true);
            square.setEnabled(true);
        }
        if(e.getSource() == refresh) {
            refreshCheck = true;
            repaint();
        }
    }
    public static void main (String [] args){
        Shape shp = new Shape();
    }
}
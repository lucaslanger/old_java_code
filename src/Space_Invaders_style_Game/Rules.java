import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener // This class is just a picture with a button to return to original screen
{

JButton returne;
JPanel p;
JLabel l;
ImageIcon i;

    public Rules(){
   returne = new JButton("Return to Main Menu");
    p = new JPanel();
    l = new JLabel();
    i = new ImageIcon(getClass().getResource("instructions.jpg")); // pic of rules created on paint
    l.setIcon(i);
    p.add(returne);

    add(p,"North");
    add(l);
    setSize(1500,1000);
    returne.addActionListener(this);
    setVisible(true);
    }

    public void actionPerformed(ActionEvent e){ // returns to mainframe when done reading...
    if (e.getSource() == returne){
        dispose();
    }
    }
}

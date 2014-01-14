// This is Lucas Langers game!
// Welcome to the code behind "The Search For The Loch Ness Monster"



import java.awt.*; /// neccesary tools for Intro Frame
import java.awt.event.*; 
import javax.swing.*;

public class Menu extends JFrame implements ActionListener // ActionListener for response on buttons
{

JButton startgame; // Three options...
JButton rules;
JButton quitgame;

JPanel menu;
JPanel sg;
JPanel r;
JPanel qg;

JLabel initialimage;

ImageIcon setting;

    public Menu(){
        setLayout(new BorderLayout());// Standard layout
        sg = new JPanel();
        r = new JPanel();
        qg = new JPanel();
        menu = new JPanel();
        
        setting = new ImageIcon(getClass().getResource("setting.jpg"));
        initialimage = new JLabel();
        initialimage.setIcon(setting);
        
        startgame = new JButton("START THE DAMN GAME!");
        rules = new JButton("FIND OUT HOW TO PLAY...");
        quitgame = new JButton("EXIT");  
        
        sg.add(startgame);
        r.add(rules);
        qg.add(quitgame);
        startgame.addActionListener(this);
        rules.addActionListener(this);
        quitgame.addActionListener(this);
        
        menu.add(sg);
        menu.add(r);
        menu.add(qg);
        
        add(initialimage); // Image goes on top
        add(menu,"South");
        
        setSize(1500,1000);
        setVisible(true);
}

public void actionPerformed(ActionEvent e){
if (e.getSource() == startgame){ // Things to do if the user clicks on one of the buttons...
Test t = new Test("jet0.gif");
dispose();
}
else if (e.getSource() == rules){
Rules rul = new Rules();
}
else if (e.getSource() == quitgame){
System.exit(0);
}

}
}

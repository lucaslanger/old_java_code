import javax.swing.*;
import java.awt.*;
//The important use of this class is the fact that it is a JFrame. I found that the game was alot less flickery if the paint method was in a JPanel

public class Test extends JFrame { // This class was mainly used to test out my code after I made changes.
Background b; 

Timer t;
public Test (String jname){

JFrame test = new JFrame();
b = new Background(jname,1500,1000);
test.add(b);
   test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   test.setSize(1500,1000);
  test.setVisible(true);

}

       public static void main(String[] args){
                new Test("jet0.gif");               
            }   
          
}


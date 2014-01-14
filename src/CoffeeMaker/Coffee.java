
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.Thread;

public class Coffee extends JFrame implements ActionListener{
    JPanel disref;
    JPanel display;
    JButton returncoins;
    JButton credit;
    
    JPanel coinslot;
    JButton cname;
    JButton twodollars;
    JButton onedollar;
    JButton quarter;
    JButton dime;
    JButton nickel;

    JPanel menu;
    JButton options;
    JButton bcoffee;
    JButton wcoffee;
    JButton wwithsugar;
    JButton bwithsugar;
   
    JPanel texta;
    JPanel tasize;
    TextField ta;
    JButton takecoffee;
    JPanel takec;
    
    JButton rsugar,rmilk,rcups,rcoffee;
    JPanel refill;
    
    int sugar = 5;
    int milk = 5;
    int cups = 10;
    int coffee = 5;

    double amount = 0;

    Animation a;
    boolean boa = false;
    boolean boamilk = false;
    boolean boasugar = false;
    boolean boamilksugar = false;
    
    public Coffee(){
        super("Welcome to Lucas's Coffemaking Machine");
        setLayout(new BorderLayout());
        
        a = new Animation(); 
        a.setBackground(Color.BLACK);
        
        coinslot = new JPanel();
        
        disref = new JPanel(new BorderLayout());
        refill = new JPanel();

        rsugar = new JButton("Refill Sugar");
        rmilk = new JButton("Refill Milk");
        rcups = new JButton("Refill Cups");
        rcoffee = new JButton("Refill Coffee");

        cname = new JButton("Insert Coins:");
        cname.setEnabled(false);
        
        twodollars = new JButton("$2.00");
        onedollar = new JButton("$1.00");
        quarter = new JButton("$0.25");
        dime = new JButton("$0.10");
        nickel = new JButton("$0.05");
        
        options = new JButton("Options:");
        bcoffee = new JButton("Black Coffee - $1.00");
        wcoffee = new JButton("White Coffee - $1.25");
        bwithsugar = new JButton("Black Coffee with sugar  - $1.25");
        wwithsugar = new JButton("White Coffee with sugar - $1.50");    
       
        options.setEnabled(false);
        bcoffee.setEnabled(false);
        wcoffee.setEnabled(false);
        wwithsugar.setEnabled(false);
        bwithsugar.setEnabled(false);
        
        returncoins = new JButton("Return Coins");
        credit = new JButton("$" + amount);
        
        coinslot.setLayout(new BoxLayout(coinslot,BoxLayout.Y_AXIS));
       
        display = new JPanel();
        
        menu = new JPanel();
        menu.setLayout(new BoxLayout(menu,BoxLayout.Y_AXIS));
     
        takec = new JPanel();
        tasize = new JPanel();
        texta = new JPanel(new BorderLayout());
        ta = new TextField(35);
        ta.setFont(new Font("sanserif", Font.BOLD,18));
        takecoffee = new JButton("Take your coffee before it gets cold!");
        takecoffee.setEnabled(false);
        takec.add(takecoffee);
        tasize.add(ta);
        tasize.setBackground(Color.BLACK);
        takec.setBackground(Color.BLACK);
                
        coinslot.add(cname);
        coinslot.add(twodollars);
        coinslot.add(onedollar);
        coinslot.add(quarter);
        coinslot.add(dime);
        coinslot.add(nickel);
        coinslot.setBackground(Color.BLACK);
        
        display.add(credit);
        display.add(returncoins);
        display.setBackground(Color.BLACK);
        
        texta.add(takec,"North");
        texta.add(tasize,"South");
        
        menu.add(options);
        menu.add(bcoffee);
        menu.add(wcoffee);
        menu.add(bwithsugar);
        menu.add(wwithsugar);
        menu.setBackground(Color.BLACK);
                
        refill.add(rmilk);
        refill.add(rcoffee);
        refill.add(rsugar);
        refill.add(rcups);
        refill.setBackground(Color.BLACK);
        
        disref.add(refill,"South");
        disref.add(display,"North");
      
        add(menu,"East");
        add(coinslot,"West");
        add(disref,"North");
        add(texta,"South");
        add(a,"Center");
        
        twodollars.addActionListener(this);
        onedollar.addActionListener(this);
        quarter.addActionListener(this);
        dime.addActionListener(this);
        nickel.addActionListener(this);
    
        takecoffee.addActionListener(this);
        
        returncoins.addActionListener(this);
        
        bcoffee.addActionListener(this);
        wcoffee.addActionListener(this);
        wwithsugar.addActionListener(this);
        bwithsugar.addActionListener(this);
        
        rcoffee.addActionListener(this);
        rmilk.addActionListener(this);
        rsugar.addActionListener(this);
        rcups.addActionListener(this);
        
        setSize(1000,1000);
        setVisible(true);
    }
    
   public void CheckButtons(){
       if(boa == true){
       a.doAnimation(1);
       boa = false;
       }
       else if(boamilk == true){
       a.doAnimation(2);
       boamilk = false;
       }
       else if(boasugar == true){
       a.doAnimation(3);
       boasugar = false;
       }
       else if(boamilksugar == true){
       a.doAnimation(4);
       boamilksugar = false;
       }
       if (amount >= 1.50){
       bcoffee.setEnabled(true);
       wcoffee.setEnabled(true);
       wwithsugar.setEnabled(true);
       bwithsugar.setEnabled(true);   
       }
       else if (amount >= 1.25){
       bcoffee.setEnabled(true);
       wcoffee.setEnabled(true);
       bwithsugar.setEnabled(true);   
       }
       else if (amount >= 1.00){
       bcoffee.setEnabled(true); 
       }
       else {
       bcoffee.setEnabled(false);
       wcoffee.setEnabled(false);
       wwithsugar.setEnabled(false);
       bwithsugar.setEnabled(false);
        }
       if (milk <= 0){
       wcoffee.setEnabled(false);
       wwithsugar.setEnabled(false);
       ta.setText("The machine has run out of milk; please refill");
       }
       else if (coffee <= 0){
       bcoffee.setEnabled(false);
       wcoffee.setEnabled(false);
       wwithsugar.setEnabled(false);
       bwithsugar.setEnabled(false);
       ta.setText("The machine has run out of coffee; please refill");
       }
       else if (sugar <= 0){
       wwithsugar.setEnabled(false);
       bwithsugar.setEnabled(false);
       ta.setText("The machine has run out of sugar; please refill");
       }
       else if (cups <= 0){
       bcoffee.setEnabled(false);
       wcoffee.setEnabled(false);
       wwithsugar.setEnabled(false);
       bwithsugar.setEnabled(false);
       ta.setText("The machine has run out of cups; please refill");
       }
    }

public void actionPerformed(ActionEvent e) {

if (e.getActionCommand() == "$0.05"){

ta.setText("You inserted 5 cents into the machine ");
amount += 5;
credit.setText("$"+ amount/100);
CheckButtons();
}
if (e.getActionCommand() == "$0.10"){

ta.setText("You inserted 10 cents into the machine ");
amount += 10;
credit.setText("$"+ amount/100);
CheckButtons();
}
if (e.getActionCommand() == "$0.25"){

ta.setText("You inserted 25 cents into the machine ");
amount += 25;
credit.setText("$"+ amount/100);
CheckButtons();
}
if (e.getActionCommand() == "$1.00"){

ta.setText("You inserted a dollar into the machine ");
amount += 100;
credit.setText("$"+ amount/100);
CheckButtons();
}
if (e.getActionCommand() == "$2.00"){

ta.setText("You inserted two dollars into the machine ");
amount += 200;
credit.setText("$"+ amount/100);
CheckButtons();
}
if (e.getActionCommand() == "Return Coins"){

ta.setText("The machine has given you back $" + amount/100 + " in change");
amount = 0.00;
credit.setText("$"+ amount);
CheckButtons();
}
if (e.getActionCommand() == "Black Coffee - $1.00"){

ta.setText("Here is your black coffee!");
amount = amount - 100;
credit.setText("$"+ amount/100);
boa = true;
boamilk = false;
boasugar = false;
boamilksugar = false;
//CheckButtons();
coffee--;
cups--;
disthebuttons();
}
if (e.getActionCommand() == "White Coffee - $1.25"){

ta.setText("Here is your Coffee with milk!");
amount = amount - 125;
credit.setText("$"+ amount/100);
boa = false;
boamilk = true;
boasugar = false;
boamilksugar = false;
//CheckButtons();
coffee--;
cups--;
milk--;
disthebuttons();
}
if (e.getActionCommand() == "Black Coffee with sugar  - $1.25"){

ta.setText("Here is your black coffee with sugar!");
amount = amount - 125;
credit.setText("$"+ amount/100);
boa = false;
boamilk = false;
boasugar = true;
boamilksugar = false;
//CheckButtons();
coffee--;
cups--;
sugar--;
disthebuttons();
}
if (e.getActionCommand() == "White Coffee with sugar - $1.50"){

ta.setText("Here is your white coffee with sugar!");
amount = amount - 150/100;
credit.setText("$"+ amount/100);
boa = false;
boamilk = false;
boasugar = false;
boamilksugar = true;
//CheckButtons();
coffee--;
cups--;
sugar--;
milk--;
disthebuttons();
}
if (e.getActionCommand() == "Refill Sugar"){

ta.setText("The coffeemaker's sugar supply was refilled");
sugar = 5;
CheckButtons();
}
if (e.getActionCommand() == "Refill Cups"){

ta.setText("The coffeemaker's cup supply was refilled");
cups = 10;
CheckButtons();
}
if (e.getActionCommand() == "Refill Milk"){

ta.setText("The coffeemaker's milk supply was refilled");
milk = 5;
CheckButtons();
}
if (e.getActionCommand() == "Refill Coffee"){

ta.setText("The coffeemaker's coffee supply was refilled");
coffee = 5;
CheckButtons();
}
if (e.getActionCommand() == "Take your coffee before it gets cold!"){
a.coffeetaken();
CheckButtons();
takecoffee.setEnabled(false);
twodollars.setEnabled(true);
onedollar.setEnabled(true);
quarter.setEnabled(true);
dime.setEnabled(true);
nickel.setEnabled(true);

rcoffee.setEnabled(true);
rmilk.setEnabled(true);
rsugar.setEnabled(true);
rcups.setEnabled(true);
}
}
public void disthebuttons(){
CheckButtons();
bcoffee.setEnabled(false);
wcoffee.setEnabled(false);
wwithsugar.setEnabled(false);
bwithsugar.setEnabled(false);

twodollars.setEnabled(false);
onedollar.setEnabled(false);
quarter.setEnabled(false);
dime.setEnabled(false);
nickel.setEnabled(false);

rcoffee.setEnabled(false);
rmilk.setEnabled(false);
rsugar.setEnabled(false);
rcups.setEnabled(false);

takecoffee.setEnabled(true);
}

public static void main (String[] args)throws Exception{
Coffee lucas = new Coffee();
}
}
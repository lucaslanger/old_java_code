public class SavAcct extends Account{

public SavAcct(String n, double b) {
    super(n,b);
}
 public void withDrawal(double x){
     if (x<=200 && x >= 0){
        balance = balance - x;
        accHistory += x + "$ was withdrawed from your Bank." + "\n";
    }
    else if (x <0){
    System.out.println("You cannot withdraw a negative amount.");
    }
        else {
        System.out.println("You can only withdraw a maximun of 200$ from your savings account!");
        }
    }
}
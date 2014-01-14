public class Account { // The account class keeps track of the amount of money a Account clas
// as well as the interest rate, and as the methods to withdraw money and deposit it.
    String name;
    double balance;
    double interestrate = 0.015;
    double increase;
    String accHistory ;

    public Account(String accname, double b){
        name = accname;
        balance = b;
        accHistory = "Account " + accname + " was created with a initial balance of: $" 
        + b + "." + "\n";
    }
    public void deposit(double d){
        if(d >= 0){
        balance = balance + d;
        accHistory += "$" + d + " was deposited into your Bank." + "\n";
    }
        else{
        System.out.println("You cannot deposit a negative amount." +  "\n");
        }
    }
    public void withDrawal(double x){
        if (x >=0){
        balance = balance - x;
        accHistory += "$" + x + " was withdrawed from your Bank."+ "\n";
    }
     else{
        System.out.println("You cannot withdraw a negative amount." +  "\n");
        }
    }
    public String toString(){
        return (name + " currently has a balance of: " + balance);
    }
    public double getBalance(){
        return balance;
    }
    public void setRate (double v){
    if (v >= 0){
    interestrate = v;
    accHistory += "The interest rate was set at " + v + "%."+ "\n";
    }
    else{
        System.out.println("You cannot have a negative interest rate." +  "\n");
        }
  }
    public void calcInterest(){
    increase = balance * interestrate;
    balance = balance + increase;
    }
    public String returnhistory(){
        return accHistory;
    }
    }
    













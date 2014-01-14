public class CheckAcct extends Account{

public CheckAcct(String n, double b) {
    super(n,b);
}
public void calcInterest(){
   if (balance > 1000){
    increase = balance * interestrate;
    balance = balance + increase;
}
    }
}










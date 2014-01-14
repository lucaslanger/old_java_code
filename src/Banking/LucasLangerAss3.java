public class LucasLangerAss3{ //This can be altered.

        public static void main (String [] args) throws Exception {

    Account a = new Account("Donald Duck", 100.00);
    CheckAcct chk = new CheckAcct("Scrooge McDuck", 5000.0);
    SavAcct sav = new SavAcct("Condoleeza Rice", 320.0);

    chk.deposit(100.00);
    sav.deposit(100.00);
    a.deposit(100.00);

    sav.withDrawal(300.0);
    chk.withDrawal(200.0);

    Bank CIBC = new Bank(10);

    a.deposit(100.00);
    a.withDrawal(50.00);

    System.out.println("Account a : " + a.getBalance() );
    System.out.println("Account chk : " + chk.getBalance() );

    CIBC.addAcct(a);
    CIBC.addAcct(sav);
    CIBC.addAcct(new Account("Scrooge McDuck", 1000.00));
    CIBC.history();
    System.out.println(a); //This could be used to get info for //account a or any other account
    System.out.println(CIBC.history());
    System.out.println("Total Balance for CIBC : " + CIBC.totalBalance() );
    //System.in.read(); //This is not necessary in BlueJ
    }


}
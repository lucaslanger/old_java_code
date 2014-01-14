// This Bank class has multiple methods including one that returns the history of all of the banks
public class Bank
{
  Account [] Accounts;
  int arrayslot = 0;
  int numberofacc = 0;
  double currentbalance = 0;
  String bankinghistory = "\n" +  "Banking History: " + "\n";;

   public Bank(int x){
       numberofacc = x; 
       Accounts = new Account[x];
}

public void addAcct(Account lol){
if (arrayslot < numberofacc){ 
Accounts[arrayslot] = lol;
arrayslot++;

}
else{
System.out.println("There is no more space in the array, please remove an account first!");
} 
}

public void calcInterestAll(){
  for(int x=0; x <= numberofacc; x++){
    Accounts[x].calcInterest();
  }
}

public double totalBalance(){
// for (int x=0;x <=numberofacc;x++){
for (int c = 0; Accounts[c] != null; c++){
  currentbalance = currentbalance + Accounts[c].getBalance();
}
return currentbalance;
}

public String history(){
for (int c=0;c<arrayslot;c++){
bankinghistory += "\n" + Accounts[c].returnhistory() ;
}
return bankinghistory;
}

}//close class







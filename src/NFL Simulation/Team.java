import java.util.Random;
// All the methods and info on the team class
class Team{
  
    String tname;
    int wins;
    int losses;
    int score;
    int ties;
    int pointsfor;
    int averageppg;
	int teamnumber;
    
    int position;
    
    public Team(String name){//this is the constructor, and it has to be the first method, and has to have the same name as the class
        tname=name;
        wins=0;
        losses=0;
        score=0;
    }
   /* public int scoregenerator(){//creates a random score for the team, and sends it back
     return position;
    }*/
   public int scoregenerator(){//creates a random score for the team, and sends it back
   Random randomGenerator = new Random();
       return(randomGenerator.nextInt(60));
     }
   
    public String getName(){
      return tname;
    }
     public void wins(){
        wins++;
    }  
    public void losses(){
      losses++;
    }
    public void ties(){
        ties++;
    }
    public int displaywins(){
        return wins;
    }
    public void pointsfor(int s){
        pointsfor = pointsfor + s;
    }
    public int displaypf(){
        return pointsfor;
    } 
    public int playoffscoregenerator(int a){
        //return this.scoregenerator();
        averageppg = a/31;
      Random randomGenerator = new Random();
       return(randomGenerator.nextInt(averageppg*2));
       
    }
  
    public String toString(){
      return (tname + " " + "wins: " + wins + " losses: " + losses + " ties: " + ties + " pointsfor: " + pointsfor);        
    }
}

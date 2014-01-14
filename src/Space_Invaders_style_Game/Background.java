import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Rectangle;
import java.awt.Point;
import java.util.Random;

public class Background extends JPanel implements ActionListener,KeyListener // Doesnt flicker with JPanel, ActionListener is used to continuasly paint things
{
                                                                            // keylistener is to transfer the keyevent to jet class.
    Jet as; // bombingjet

    Boost infoboost;
    ArrayList<Boost> ab; // Arraylist of boosts.
    ArrayList<Enemy> pirana;// piranas which appear in 2nd level;

    Image img;  //background
    Image img2; // imagenexttobackground
    Image life; // health

    Image bosstalk1; // messages bosses say.
    Image bosstalk2;
    Image bosstalk3;
    Image bosstalk4;
    Image bosstalk5;

    Image bombexplosion; // pic of explosion
    ImageIcon be; 

    Timer t;

    Jet j;

    ArrayList<Enemy> ae; // Arraylist of enemys
    Enemy einfo; // info about a enemy. (width,height) Note: Some enemys are different which is why I dont use this sometimes in CollisionDetection

    Missile minfo; // info about missiles...
    Missile sbinfo;

    int highscore;
    int timecycle;
    int terrainwidth;
    int terrainheight;
    int xterrain = 0;
    int yterrain = 0;
    int width;
    int height;
    int enemycount; //keeps track of number of enemys killed to know when boss comes in.
    int bosshealth = 5;
    int score;
    int level = 0;
    int bossshooting;
    int boss = 0;
    int leveldisplaytimer; // counts how long "Level level" is displayed
    int boostcount = 2;
    int movementspeed = 2;
    int leveldisplay = 2000; // ints that time how long a certain message is displayed.
    int whichenemy;
    int boostduration = 5000;
    int jethealth = 3; // jets health.
    int windtimer = 2000;
    int windmovement;
    int windcycle = 0;
    int gofish; // counts time in between pirana spawning
    int piranacount;
    int totalenemycount;
    int victorytimer = 0;
    int bosstalkmeter;
    int whichphrase;
    int windprep = 0;
    int killstreak;
    int bombingjetmove = 1000; // place where bomber starts (y cord.)

    String levelnumber; // used for display level to user

    Rectangle m; // Used for collision detection
    Rectangle e2;
    Rectangle rectj;
    Rectangle bo;
    Rectangle sb;
    Rectangle jb;
    Rectangle piranarect;

    Point pe; // used in collision detection to compare rectangles (method intersects)
    Point pm;
    Point pb;
    Point ps;

    Font font;

    Random r;

    Boss[] bosses;
    Boss bossinfo;

    boolean bossesdead[]; // holds which bosses are currently dead
    boolean restart = false; // sees if users has chosen restart option
    boolean[] levels;
    boolean gameover = false;
    boolean gamestart = true;   
    boolean[] bossesinplay;
    boolean boostinplay = false; // checks if a boost is in play
    boolean shield = false;
    boolean wind; // sees if user is at windy part of game
    boolean speedboostinplay = false;
    boolean restartlevel = false;
    boolean victory = false;
    boolean bosstalked = false;
    boolean airstrike = false;

    public Background(String jname,int x,int y) // Requires an string representing a boat image, a height, and a width
    {

        height = y;
        width = x;

        j = new Jet(jname);
        minfo = new Missile(0,0,"missile.gif");
        sbinfo = new Missile(0,0,"slimeball.gif");
        infoboost = new Boost(0,1500,1000);

        ImageIcon bt1 = new ImageIcon(getClass().getResource("bosstalk0.jpg"));
        ImageIcon bt2 = new ImageIcon(getClass().getResource("bosstalk1.jpg"));
        ImageIcon bt3 = new ImageIcon(getClass().getResource("bosstalk2.jpg"));
        ImageIcon bt4 = new ImageIcon(getClass().getResource("bosstalk3.jpg"));
        ImageIcon bt5 = new ImageIcon(getClass().getResource("bosstalk4.jpg"));

        ImageIcon be = new ImageIcon(getClass().getResource("bombexplosion.gif"));
        bombexplosion = be.getImage();

        bosstalk1 = bt1.getImage();
        bosstalk2 = bt2.getImage();
        bosstalk3 = bt3.getImage();
        bosstalk4 = bt4.getImage();
        bosstalk5 = bt5.getImage();

        bossesinplay = new boolean[5];
        bossesinplay[0] = false;
        bossesinplay[1] = false;
        bossesinplay[2] = false;
        bossesinplay[3] = false;
        bossesinplay[4] = false;

        bosses = new Boss[5];
        bossinfo = new Boss(0);
        bossesdead = new boolean[5];
        bossesdead[0] = false;
        bossesdead[1] = false;
        bossesdead[2] = false;
        bossesdead[3] = false;
        bossesdead[4] = false;

        levels = new boolean[5];
        levels[0] = true;
        levels[1] = false;
        levels[2] = false;
        levels[3] = false;

        ae = new ArrayList<Enemy>();
        ab = new ArrayList<Boost>();
        pirana = new ArrayList<Enemy>();

        addKeyListener(this);
        setFocusable(true);  
        ImageIcon i = new ImageIcon(getClass().getResource("terrain1.jpg")); 
        ImageIcon i2 = new ImageIcon(getClass().getResource("sideimage.jpg"));
        ImageIcon heart = new ImageIcon(getClass().getResource("life.gif"));
        terrainwidth = i.getIconWidth();
        terrainheight = i.getIconHeight();
        einfo = new Enemy("enemy1",terrainwidth,5);
        img = i.getImage();
        img2 = i2.getImage();
        life = heart.getImage();

        m = new Rectangle(minfo.getWidth(),minfo.getHeight());     
        e2 = new Rectangle(einfo.getWidth(),einfo.getHeight());
        bo = new Rectangle(bossinfo.getWidth(),bossinfo.getHeight());
        rectj = new Rectangle(j.getWidth(),j.getHeight());
        sb = new Rectangle(sbinfo.getWidth(),sbinfo.getHeight());
        jb = new Rectangle(infoboost.getHeight(),infoboost.getWidth());

        r = new Random();

        font = new Font("SanSerif", Font.BOLD, 50);
        t = new Timer(1,this); // uses to call actionperformed method periodicly
        t.start();

        setSize(width,height);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){ // This is where everything moves, shoots, where variables are set depending on locations of things
                                                // and where certain timer variables are incremented
        if (gameover){
            for (int c=0;c<ab.size();c++){
                ab.remove(c);
            }
            for (int c=0;c<ae.size();c++){
                ae.remove(c);
            }
            String[] choices = {"Retry Current Level","Restart Game",  "Exit"};
            int response = JOptionPane.showOptionDialog(null, "Would You Like to Continue?", "You Have Lost!",  JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, choices,"bla");
            if (response == JOptionPane.YES_OPTION){
                restartlevel = true;
                gameover = false;
                
            }
            else if (response == JOptionPane.NO_OPTION){
                 restart = true;
                gameover = false;
                if (score > highscore){
                    highscore = score;
                }
            }
            else if (response == JOptionPane.CANCEL_OPTION){
                System.exit(0);
            }
        }

        if (restart == true){
            bossesinplay[0] = false;
            bossesinplay[1] = false;
            bossesinplay[2] = false;
            bossesinplay[3] = false;
            bossesinplay[4] = false;
            bossesdead[0] = false;
            bossesdead[1] = false; 
            bossesdead[2] = false;
            bossesdead[3] = false;
            bossesdead[4] = false;
            levels[0] = true;
            levels[1] = false;
            levels[2] = false;
            levels[3] = false;
            levels[4] = false;

            if (score > highscore){
                highscore = score;
            }
            for (int c=0;c<ab.size();c++){
                ab.remove(c);
            }
            for (int c=0;c<ae.size();c++){
                ae.remove(c);
            }
            timecycle = 0;
            enemycount = 0;
            totalenemycount =0;
            bosshealth = 5;
            boss = 0;
            bossshooting = 0;
            restart = false;
            score = 0;
            j.setXLocation(400);
            j.setYLocation(500);
            boostcount = 2;
            j.normalize();
            jethealth = 3;
            piranacount = 0;
            windcycle = 0;
            wind = false;
            bosstalked = false;
            whichphrase = 0;
            bosstalkmeter = 0;
            windprep = 0;
            for (int c = 0;c<j.getMissiles().size();c++){
                j.getMissiles().remove(c);
            }
            boostduration = 5000;
            boostinplay = false;
            whichphrase = boss;
            killstreak = 0;
        }
        else if (restartlevel == true){
            bossesinplay[0] = false;
            bossesinplay[1] = false;
            bossesinplay[2] = false;
            bossesinplay[3] = false;
            bossesinplay[4] = false;

            for (int c=0;c<ab.size();c++){
                ab.remove(c);
            }
            for (int c=0;c<ae.size();c++){
                ae.remove(c);
            }
            if (score > highscore){
                highscore = score;
            }
            timecycle = 0;
            enemycount = 0;
            totalenemycount =0;
            bosshealth = 5;
            bossshooting = 0;
            restartlevel = false;
            score = 0;
            j.setXLocation(400);
            j.setYLocation(500);
            boostcount = 2;
            j.normalize();
            jethealth = 3;
            piranacount = 0;
            windcycle = 0;
            wind = false;
            bosstalked = false;
            bosstalkmeter = 0;
            windprep = 0;
            for (int c = 0;c<j.getMissiles().size();c++){
                j.getMissiles().remove(c);
            }
            boostduration = 5000;
            boostinplay = false;
            whichphrase = boss;
            killstreak = 0;
        }

        if (!victory){

            if(!airstrike){
                checkAirstrike();
            }
            if (airstrike){
                as = new Jet("bombingjet.gif");
                bombingjetmove = bombingjetmove - 20;
                            for (int c=0;c<ae.size();c++){
                                ae.remove(c);
                          }
                          for (int c=0;c<pirana.size();c++){
                                pirana.remove(c);
                          }
                            for (int g = 0;g<bossesinplay.length;g++){
                            if (bossesinplay[g]){
                          bosshealth = bosshealth - 3;
                            }
                            }
                if (bombingjetmove < 0){
                    airstrike = false;
                    killstreak = killstreak - 2;
                    bombingjetmove = 1000;
                }
            }

                j.shootinterval();

                for (int c=0;c<levels.length;c++){
                    if (levels[c]){
                        if (leveldisplaytimer < 2000){
                            leveldisplaytimer += 5;
                        }
                        else {
                            leveldisplaytimer = 0;
                            levels[c] = false;
                        }
                    }
                } 

                yterrain = yterrain + 2;   

                if (totalenemycount == boostcount){
                    ab.add(new Boost(r.nextInt(3),904,929)); 
                    boostcount = boostcount + 2;
                }
                for (int p=0;p<ab.size();p++){
                    if (ab.get(p).getTime() == 0){
                        ab.remove(p); 
                    }
                    else{
                        ab.get(p).decreaseTimeVisible(); 
                    }
                }       

                for (int a = 0; a < ae.size();a++){
                    if (!ae.get(a).checkDead()){
                        if (ae.get(a).getDeadTime() == 100){
                            ae.remove(a);
                        }
                        else{ 
                            ae.get(a).addDeadTime();
                        }
                    }   
                }      

                for (int c = 0;c<bosses.length;c++){    
                    if (bossesinplay[c]){  
                        if (bosses[c].getLevel() != 2 && bosses[c].getLevel() != 1){
                            bosses[c].move(); 
                            bossshooting += 5;
                            for (int g = 0; g < bosses[c].getSlimeballs().size();g++){
                                if (bosses[c].getSlimeballs().get(g).getX() >= 0 && bosses[c].getSlimeballs().get(g).getX() <= 1000 - sbinfo.getWidth()){
                                } 
                                else{
                                    bosses[c].getSlimeballs().remove(g); 
                                }
                            }
                            bosses[c].movemissiles();
                            if (bossshooting == 1000){
                                bosses[c].fire();
                                bossshooting = 0;
                            }
                        }
                        else if (bosses[c].getLevel() == 2){
                            wind = true;
                        }
                    }
                }                    

                if (!gameover && enemycount >= 5 && !bossesinplay[boss] && !bossesdead[boss]){ //5 * (boss + 1)
                    bosses[boss] = new Boss(boss);
                    bossesinplay[boss] = true; 
                    enemycount = 0;
                }
                else{
                    if (!gameover && !bossesinplay[boss] && timecycle >= 1000){
                        if (boss > 0){    
                            whichenemy = r.nextInt(boss + 1) + 1;    
                        }
                        else if (boss == 0){
                            whichenemy = 1;
                        }
                        ae.add(new Enemy("enemy" + whichenemy, terrainwidth, 5 + boss));  
                        timecycle = 0;
                        gamestart = false;
                    }
                }

                if (boostduration == 0 && boostinplay){
                    boostinplay = false;
                    speedboostinplay = false;
                    movementspeed = 2;
                }
                else if (boostinplay){
                    boostduration += -5;
                }

                timecycle+= 5;  

                for (int r=0;r<ae.size();r++){
                    if (ae.get(r).getYLocation() < terrainheight && ae.get(r).getXLocation() > 0 - ae.get(r).getWidth() && ae.get(r).getXLocation() < terrainwidth){    //+ ae.get(r).getHeight()
                        ae.get(r).move();
                    }
                    else{
                        ae.remove(r);
                        if (score > 100){
                            score = score - 100;
                            killstreak = 0;
                        }
                        else{
                            score = 0;
                        }
                    }
                }
                CollisionDetection();

                ArrayList missiles = j.getMissiles();
                for (int t = 0; t< missiles.size(); t++) {
                    Missile m = (Missile) missiles.get(t);
                    m.accelerate();
                }   
                j.rangecheck();
                for (int c=0; c<movementspeed;c++){
                    j.move(); 
                }
                if (!boostinplay){
                    j.normalize();
                    movementspeed = 2;
                }

                if (jethealth <= 0){
                   gameover = true;
                }
                if (wind == true){
                    windprep += 5;
                    if (windprep > 1000){
                        if (windtimer < 2000){
                            j.changeX(windmovement);
                            j.changeY(windmovement);
                            windtimer += 5;
                        }
                        else if (bossesinplay[2]){
                            windtimer = 0;
                            int a = r.nextInt(2);
                            windcycle++;
                            if (a == 0){
                                windmovement = -2;
                            }
                            else if (a == 1){
                                windmovement = 2;
                            }
                        }
                        if (windcycle == 3){
                            bossesinplay[boss] = false;
                            bossesdead[boss] = true;
                            boss++;
                            score = score + 500;
                            levels[boss] = true;
                            leveldisplay = 2000;
                            wind = false;
                            windcycle = 0;
                        }
                    }
                }
                if (bossesinplay[1]){
                    if (gofish == 100){
                        pirana.add(new Enemy("boss2",terrainwidth,20));
                        gofish = 0;
                        piranacount++;
                    }
                    else{
                        gofish = gofish + 5;
                    }
                    for (int g =0;g<pirana.size();g++){
                        pirana.get(g).move();
                    }
                }
                if (piranacount == 30 && bossesinplay[1]){
                    bossesinplay[boss] = false;
                    bossesdead[boss] = true;
                    boss++;
                    score = score + 500;
                    levels[boss] = true;
                    leveldisplay = 2000;
                }

                if (bossesinplay[3]){
                    movementspeed = 1;
                }

                if (j.getX() < 0){
                    gameover = true;
                }
                else if (j.getX() > 1000 - j.getWidth()){
                    gameover = true;
                }
                else if (j.getY() < 0){
                    gameover = true;
                }
                else if (j.getY() > 1000 - j.getHeight()){
                    gameover = true;
                }
            }
            repaint();
            if (victorytimer > 2000){
                System.exit(0);
            }

        }
    

    public void paint(Graphics g){ // Paints on images depending on the situation of certain variables in the game
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // helps graphics apperently Note: got this from Steven D.

        if (yterrain > height){
            yterrain = 0;
        }
        g2d.drawImage(img,xterrain,yterrain,null);

        g2d.drawImage(img,xterrain,yterrain-height,null);

        g2d.drawImage(img2,1000,0,null);
        for (int v = 0;v<ab.size();v++){
            g2d.drawImage(ab.get(v).getImage(),ab.get(v).getX(),ab.get(v).getY(),null);
        }
        if (!gameover){
            g2d.drawImage(j.getImage(),j.getX(),j.getY(),null);    
        }
        ArrayList missiles = j.getMissiles();
        for (int t = 0; t< missiles.size(); t++) {
            Missile m = (Missile) missiles.get(t);
            if(!gameover){
                g2d.drawImage(m.getImage(), m.getX(), m.getY(), null);
            }   
        }

        for (int v=0;v<ae.size();v++){
            if (!gameover){
                g2d.drawImage(ae.get(v).getImage(),ae.get(v).getXLocation(),ae.get(v).getYLocation(),null);
            }
        } 

        for (int v = 0;v<bosses.length;v++){
            if (bossesinplay[v]){
                if (bosses[v].getLevel() != 2 && bosses[v].getLevel() != 1)
                    g2d.drawImage(bosses[v].getImage(),bosses[v].getX(),bosses[v].getY(),null);        
            }
        }

        for (int d=0;d<bosses.length;d++){
            if (bossesinplay[d]){
                if (bosses[d].getLevel() != 2 && bosses[d].getLevel() != 1){
                    ArrayList<Missile> bossattack = bosses[d].getSlimeballs();
                    for (int r = 0;r < bossattack.size();r++){   
                        g2d.drawImage(bossattack.get(r).getImage(),bossattack.get(r).getX(),bossattack.get(r).getY(),null);
                    }
                }
            }
        }
        if (bossesinplay[1]){
            for (int c=0; c<pirana.size();c++){
                g2d.drawImage(pirana.get(c).getImage(),pirana.get(c).getXLocation(),pirana.get(c).getYLocation(),null);
            }
        }

        if (levels[0]){
            levelnumber = "ONE";
        }
        else if (levels[1]){
            levelnumber = "TWO";
        }
        if (levels[2]){
            levelnumber = "THREE";
        }
        if (levels[3]){
            levelnumber = "FOUR";
        }
        if (levels[4]){
            levelnumber = "FIVE";
        }
        g2d.setFont(font);
        g2d.setColor(Color.WHITE);
        font.deriveFont(20);
        g2d.setFont(font);
        g2d.setColor(Color.GREEN);
        g2d.drawString("Score: " + score,1000,100);
        g2d.drawString("Health Left:", 1000,300);
        g2d.drawString("Highscore: ",1000,700);
        if (score >= highscore){
            g2d.drawString("" + score ,1000,800);
        }
        else if(score < highscore){
            g2d.drawString("" + highscore,1000,800);
        }
        for (int r = 0;r<jethealth;r++){
            g2d.drawImage(life, 1000 + 50 * (r + 1), 350 ,null);
        }
        g2d.drawString("Level " + (1 + boss),1000,500);
        if (1 <killstreak){
        g2d.drawString("AIRSTRIKE"  ,1000, 900);
        g2d.drawString("READY!"  ,1000, 950);
    }
        for (int c=0;c<levels.length;c++){
            if (levels[c] && leveldisplay != 0 && !gameover){
                g2d.drawString("Level " + levelnumber,400,500); 
                leveldisplay = leveldisplay - 5;
            }
        }
        if (gameover){
            g2d.setColor(Color.RED);

            g2d.drawString("GAME OVER",400,500);
        }

        if (whichphrase != 5){
            if (bossesinplay[whichphrase]){    
                if (whichphrase == 0){
                    if (bosstalkmeter < 1000){
                        g2d.drawImage(bosstalk1,bosses[0].getX() + bosses[0].getWidth(),bosses[0].getY(),null);   
                        bosstalkmeter += 5;
                    }
                    else if (bosstalkmeter == 1000){
                        whichphrase++;
                        bosstalkmeter = 0;
                        bosstalked = true;
                    }
                } 
                if (whichphrase == 1){
                    if (bosstalkmeter < 1000){
                        g2d.drawImage(bosstalk2,j.getX()+ j.getWidth(),j.getY(),null);   
                        bosstalkmeter += 5;
                    }
                    else if (bosstalkmeter == 1000){
                        whichphrase++;
                        bosstalkmeter = 0;
                        bosstalked = true;
                    }
                } 
                if (whichphrase == 2){
                    if (bosstalkmeter < 1000){
                        g2d.drawImage(bosstalk3,j.getX()+ j.getWidth(),j.getY(),null);   
                        bosstalkmeter += 5;
                    }
                    else if (bosstalkmeter == 1000){
                        whichphrase++;
                        bosstalkmeter = 0;
                        bosstalked = true;
                    }
                } 
                if (whichphrase == 3){
                    if (bosstalkmeter < 1000){
                        g2d.drawImage(bosstalk4,bosses[3].getX()+ bosses[3].getWidth(),bosses[3].getY(),null);   
                        bosstalkmeter += 5;
                    }
                    else if (bosstalkmeter == 1000){
                        whichphrase++;
                        bosstalkmeter = 0;
                        bosstalked = true;
                    }
                } 
                if (whichphrase == 4){
                    if (bosstalkmeter < 1000){
                        g2d.drawImage(bosstalk5,bosses[4].getX()+ bosses[4].getWidth(),bosses[4].getY(),null);   
                        bosstalkmeter += 5;
                    }
                    else if (bosstalkmeter == 1000){
                        whichphrase++;
                        bosstalkmeter = 0;
                        bosstalked = true;
                    }
                } 
            }
        }
        if (airstrike){
            for(int i =0;i<10;i++){
                int x = r.nextInt(833);
                int y = r.nextInt(829);
                g2d.drawImage(bombexplosion,x,y,null);
            }
            g2d.drawImage(as.getImage(),250,bombingjetmove,null);
            g2d.drawImage(as.getImage(),500,bombingjetmove,null);
            g2d.drawImage(as.getImage(),750,bombingjetmove,null);

        }

        if (victory){
            g2d.setColor(Color.GREEN);
            g2d.drawString("VICTORY",400,500);
            victorytimer+= 5;
        }

    }

    public void CollisionDetection(){ // Checks if various objects have collided with each other.
        for (int v=0;v<ae.size();v++){        
            for (int o = 0;o<j.getMissiles().size();o++){
                pe = new Point(ae.get(v).getXLocation(),ae.get(v).getYLocation());
                pm = new Point(j.getMissiles().get(o).getX(),j.getMissiles().get(o).getY());
                e2 = new Rectangle(ae.get(v).getHeight(),ae.get(v).getWidth());
                m = new Rectangle(j.getMissiles().get(o).getWidth(),j.getMissiles().get(o).getHeight());
                e2.setLocation(pe);   
                m.setLocation(pm);
                if(e2.intersects(m) && ae.get(v).checkDead() == true){
                    ae.get(v).setImage("explosion.gif");
                    j.getMissiles().remove(o);
                    if (ae.get(v).checkDead()){
                        score = score + 50;
                    }
                    ae.get(v).setStationary();
                    enemycount++;
                    totalenemycount++;
                    killstreak++;
                }
            }
        }   
        for (int s = 0; s < ae.size();s++){
            rectj = new Rectangle(j.getWidth(),j.getHeight());
            e2 = new Rectangle(ae.get(s).getHeight(),ae.get(s).getWidth());
            rectj.setLocation(j.getX(),j.getY()); 
            e2.setLocation(ae.get(s).getXLocation(),ae.get(s).getYLocation());
            if (rectj.intersects(e2) && ae.get(s).checkDead()){
                ae.get(s).setImage("explosion.gif");
                 jethealth--;
                enemycount++;
                totalenemycount++;
                killstreak++;
                ae.get(s).setStationary();
                             
                if (!ae.get(s).checkDead()){
                    score = score + 50;
                }
                
                
            }
        }
        for (int g=0;g<bossesinplay.length;g++){
            if (bossesinplay[g]){
                bo = new Rectangle(bosses[g].getWidth(),bosses[g].getHeight());
                rectj.setLocation(j.getX(),j.getY()); 
                pb = new Point(bosses[g].getX(),bosses[g].getY());
                bo.setLocation(pb);
                rectj.setLocation(j.getX(),j.getY()); 
                if (rectj.intersects(bo)){
                    j.setXLocation(500);
                    j.setYLocation(750);
                    jethealth--;
                }
            }
        }

        for (int p=0;p<bosses.length;p++){
            if (bossesinplay[p]){
                for (int i=0;i<j.getMissiles().size();i++){
                    m = new Rectangle(j.getMissiles().get(i).getWidth(),j.getMissiles().get(i).getHeight());
                    pm = new Point(j.getMissiles().get(i).getX(),j.getMissiles().get(i).getY());
                    m.setLocation(pm);
                    bo = new Rectangle(bosses[p].getWidth(),bosses[p].getHeight());
                    pb = new Point(bosses[p].getX(),bosses[p].getY()); 
                    bo.setLocation(pb);
                    if (m.intersects(bo)){
                        bosshealth--;
                        j.getMissiles().remove(i);
                    }
                }
                if (bosshealth <= 0){
                    bossesinplay[p] = false;
                    bosshealth = 5;
                    bossesdead[p] = true;
                    boss++;
                    score = score + 500;
                    if (boss < 5){
                        levels[boss] = true;
                        bosstalked = false;
                    }
                    else{
                        victory = true;
                    }
                    leveldisplay = 2000;
                }
            }
        }

        for (int w=0;w<bosses.length;w++){
            if (bossesinplay[w]){
                if (bosses[w].getLevel() != 2 && bosses[w].getLevel() != 1){
                    for (int i=0;i<j.getMissiles().size();i++){
                        pm = new Point(j.getMissiles().get(i).getX(),j.getMissiles().get(i).getY());
                        m = new Rectangle(j.getMissiles().get(i).getWidth(),j.getMissiles().get(i).getHeight());
                        m.setLocation(pm);
                        for (int t=0;t<bosses[w].getSlimeballs().size();t++){
                            ps = new Point(bosses[w].getSlimeballs().get(t).getX(),bosses[w].getSlimeballs().get(t).getY());
                            sb = new Rectangle(bosses[w].getSlimeballs().get(t).getWidth(),bosses[w].getSlimeballs().get(t).getHeight());
                            sb.setLocation(ps);
                            if (m.intersects(sb)){
                                j.getMissiles().remove(i);
                                bosses[w].getSlimeballs().remove(t);
                            } 
                        }
                    }
                }
            }
        }

        rectj.setLocation(j.getX(),j.getY());
        for (int s = 0;s<bosses.length;s++){
            if (bossesinplay[s]){
                if (bosses[s].getLevel() != 2 && bosses[s].getLevel() != 1){
                    for (int k = 0;k<bosses[s].getSlimeballs().size();k++){
                        ps = new Point(bosses[s].getSlimeballs().get(k).getX(),bosses[s].getSlimeballs().get(k).getY());
                        sb = new Rectangle(bosses[s].getSlimeballs().get(k).getWidth(),bosses[s].getSlimeballs().get(k).getHeight());
                        sb.setLocation(ps);
                        if (sb.intersects(rectj)){
                            jethealth--;
                            bosses[s].getSlimeballs().remove(k);
                        }
                    }
                }
            }
        }
        rectj = new Rectangle(j.getWidth(),j.getHeight());
        rectj.setLocation(j.getX(),j.getY()); 
        for (int h=0;h<ab.size();h++){
            jb = new Rectangle(ab.get(h).getWidth(),ab.get(h).getWidth());
            jb.setLocation(ab.get(h).getX(),ab.get(h).getY());
            if (jb.intersects(rectj)){
                score = score + 150;
                if (ab.get(h).getBoostType() == 0){
                    movementspeed = movementspeed * 2;
                    boostinplay = true;
                    speedboostinplay = true;
                }
                else if (ab.get(h).getBoostType() == 1){
                    j.setShootTime(50);
                    boostinplay = true;
                }
                else if (ab.get(h).getBoostType() == 2){
                    if (jethealth < 3){
                        jethealth = 3;
                    }
                    else{
                        score = score + 150;
                    }
                    boostinplay = true;
                }
                ab.remove(h);
            }
        }
        if (bossesinplay[1]){
            rectj = new Rectangle(j.getWidth(),j.getHeight());
            rectj.setLocation(j.getX(),j.getY());
            for (int t = 0; t < pirana.size();t++){
                piranarect = new Rectangle(pirana.get(t).getWidth(),pirana.get(t).getHeight());
                piranarect.setLocation(pirana.get(t).getXLocation(),pirana.get(t).getYLocation());
                if (piranarect.intersects(rectj)){
                    jethealth--;
                    pirana.remove(t);
                }
                for (int u = 0;u < j.getMissiles().size();u++){
                    m = new Rectangle(j.getMissiles().get(u).getWidth(),j.getMissiles().get(u).getHeight());
                    pm = new Point(j.getMissiles().get(u).getX(),j.getMissiles().get(u).getY());
                    m.setLocation(pm);
                    if (m.intersects(piranarect)){
                        pirana.remove(t);
                        j.getMissiles().remove(u);                    
                    }

                }
            }
        }
    }

    public void keyReleased(KeyEvent e){ // transfers keyevents to jet class
        j.keyReleased(e);   
    }

    public void keyPressed(KeyEvent e){
        j.keyPressed(e); 
    }

    public void keyTyped(KeyEvent e){
        j.keyTyped(e);
    }    


    public void checkAirstrike(){ // checks if user has activited killstreak
        if (killstreak >= 2){
            airstrike = j.checkAirStrike(); 
        }
    }

}

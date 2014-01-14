import java.util.Scanner;
class NFL {

    String selected;            // These booleans are to test whether or not the input team made the playoffs or not
    boolean afcplayofft = false;
    boolean nfcplayofft = false;
    boolean nfcplayoffconferencefinalt = false;
    boolean afcplayoffconferencefinalt = false;
    boolean superbowlt = false;
    boolean afcpresuperbowl = false;
    boolean nfcpresuperbowl = false;

    Team Miami; // All of the Teams are declared
    Team Detroit;
    Team San_Diego;
    Team St_Louis;
    Team Baltimore;
    Team Green_Bay;
    Team New_England;
    Team Cleveland;
    Team Pittsburg;
    Team Kansas_City;
    Team Houston;
    Team New_York_G;
    Team New_York_J;
    Team Atlanta;
    Team Philidalphia;
    Team Cincinnati;
    Team Buffalo;
    Team New_Orleans;
    Team Washington;
    Team Chicago;
    Team San_Francisco;
    Team Carolina;
    Team Tampa_Bay;
    Team Tennesee;
    Team Oakland;
    Team Denver;
    Team Minnesota;
    Team Dallas;
    Team Seattle;
    Team Jacksonville;
    Team Indianapolis;
    Team Arizona;

    Team YourTeam;

    Team Champs;

    Team Temp;

    Team [] teamlist; // All groups of Teams are declared

    Team [] league;
    Team [] AFC;
    Team [] NFC;
    Team [] AFCeast;
    Team [] AFCwest ;
    Team [] AFCsouth ;
    Team [] AFCnorth ;
    Team [] NFCeast ;
    Team [] NFCwest ;
    Team [] NFCsouth ;
    Team [] NFCnorth ;
    Team [] afcplayoff;
    Team [] nfcplayoff;
    Team [] afcconferencefinal;
    Team [] nfcconferencefinal;
    Team [] superbowl;

    public NFL(){//constructor

        Miami = new Team        (" Miami Dolphins       "); // Each Team Object is created
        Detroit = new Team      (" Detroit Lions        ");
        Green_Bay = new Team    (" Green Bay Packers    ");
        San_Diego = new Team    (" San Diego Chargers   ");
        St_Louis = new Team     (" St. Louis Rams       ");
        Baltimore = new Team    (" Baltimore Ravens     ");
        New_England = new Team  (" New England Patriots ");
        Cleveland = new Team    (" Cleveland Browns     ");
        Pittsburg = new Team    (" Pittsburg Stealers   ");
        Kansas_City = new Team  (" Kansas City Chiefs   ");
        Houston = new Team      (" Houston Texans      ");
        New_York_G = new Team   (" New York Giants     ");
        New_York_J = new Team   (" New York Jets       ");
        Atlanta = new Team      (" Atlanta Falcons     ");
        Philidalphia = new Team (" Philidalphia Eagles ");
        Cincinnati = new Team   (" Cincinnati Bengals  ");
        Buffalo = new Team      (" Buffalo Bills       ");
        New_Orleans = new Team  (" New Orleans Saints  ");
        Washington = new Team   (" Washington Redskins ");
        Chicago = new Team      (" Chicago Bears       ");
        San_Francisco = new Team(" San Francisco 49ers ");
        Carolina = new Team     (" Carolina Panthers   "); 
        Tampa_Bay = new Team    (" Tampa Bay Buccaneers");
        Tennesee = new Team     (" Tennesee Titans     ");
        Oakland = new Team      (" Oakland Raiders     ");
        Minnesota = new Team    (" Minnesota Vikings   ");
        Dallas = new Team       (" Dallas Cowboys      ");
        Seattle = new Team      (" Seattle Seahawks    ");
        Jacksonville = new Team (" Jacksonville Jaguars");
        Indianapolis = new Team (" Indianapolis Colts  ");
        Arizona = new Team      (" Arizona Cardinals   ");
        Denver = new Team       (" Denver Broncos      ");

        Temp = new Team ("Teamp");

        Champs = new Team("Super Bowl Champions");

        teamlist = new Team[32]; // This array is here so that the user can view the list of the default teams.

        teamlist [0] = Miami;
        teamlist [1] = Detroit;
        teamlist [2] = Green_Bay;
        teamlist [3] = San_Diego;
        teamlist [4] = St_Louis;
        teamlist [5] = Baltimore;
        teamlist [6] = New_England; 
        teamlist [7] = Cleveland;
        teamlist [8] = Pittsburg;
        teamlist [9] = Kansas_City;
        teamlist [10] = Houston; 
        teamlist [11] = New_York_G;
        teamlist [12] = New_York_J;
        teamlist [13] = Atlanta;
        teamlist [14] = Philidalphia;
        teamlist [15] = Cincinnati;
        teamlist [16] = Buffalo;
        teamlist [17] = New_Orleans;
        teamlist [18] = Washington;
        teamlist [19] = Chicago;
        teamlist [20] = San_Francisco;
        teamlist [21] = Carolina;
        teamlist [22] = Tampa_Bay;
        teamlist [23] = Tennesee;
        teamlist [24] = Oakland;
        teamlist [25] = Minnesota;
        teamlist [26] = Dallas;
        teamlist [27] = Seattle;
        teamlist [28] = Jacksonville;
        teamlist [29] = Indianapolis;
        teamlist [30] = Arizona;
        teamlist [31] = Denver;

        for (int c=0;c<teamlist.length;c++){ // displays teams to user...
            System.out.println(c + teamlist[c].getName());
        }

        boolean exist = false; // This bit of code is here to let the user pick a team.
        System.out.println("\n" + "Please select a team you would like to manage for the 2010 NFL season, by entering it's corresponding number."+ "\n"); // Here is the user's involvement
        Scanner teamscanner = new Scanner(System.in);

        while(!exist){
            if (teamscanner.hasNextInt()  ){
                int tnumber = teamscanner.nextInt();
                if(tnumber < 32 && tnumber >= 0){
                    YourTeam = teamlist[tnumber];
                    selected = teamlist[tnumber].getName();
                    System.out.println("\n" + selected + "is your team for 2011!");        
                    exist = true;
                }
                else{ 
                    System.out.println("\n" + "This Team does not exist; please select a corresponding number on the list, and make sure you did not enter the team name." + "\n");
                    System.out.println();
                }
            }
            else{ 
                teamscanner.next(); 
                System.out.println("\n" + "This Team does not exist; please select a corresponding number on the list, and make sure you did not enter the team name." + "\n");
                System.out.println();
            }
        }

        System.out.println("\n" + "Here is how all the teams did in the regular season..." + "\n");

        try // delays the printout so user can follow along.
        {
            Thread.sleep(3000);
        }
        catch (Exception e)
        {}

        league = new Team[32]; // Here each of the divisions are created
        AFC = new Team[16]; 
        NFC = new Team[16];
        AFCeast = new Team[4];
        AFCwest = new Team[4];
        AFCsouth = new Team[4];
        AFCnorth = new Team[4];
        NFCeast = new Team[4];
        NFCwest = new Team[4];
        NFCsouth = new Team[4];
        NFCnorth = new Team[4];
        afcconferencefinal = new Team[4];
        nfcconferencefinal = new Team[4];
        afcplayoff = new Team[6];
        nfcplayoff = new Team[6];
        superbowl = new Team[2];

        league [0] = Miami;
        league [1] = Detroit;
        league [2] = Green_Bay;
        league [3] = San_Diego;
        league [4] = St_Louis;
        league [5] = Baltimore;
        league [6] = New_England; 
        league [7] = Cleveland;
        league [8] = Pittsburg;
        league [9] = Kansas_City;
        league [10] = Houston; 
        league [11] = New_York_G;
        league [12] = New_York_J;
        league [13] = Atlanta;
        league [14] = Philidalphia;
        league [15] = Cincinnati;
        league [16] = Buffalo;
        league [17] = New_Orleans;
        league [18] = Washington;
        league [19] = Chicago;
        league [20] = San_Francisco;
        league [21] = Carolina;
        league [22] = Tampa_Bay;
        league [23] = Tennesee;
        league [24] = Oakland;
        league [25] = Minnesota;
        league [26] = Dallas;
        league [27] = Seattle;
        league [28] = Jacksonville;
        league [29] = Indianapolis;
        league [30] = Arizona;
        league [31] = Denver;

        AFC [0] = New_York_J;
        AFC [1] = Baltimore;
        AFC [2] = Kansas_City;
        AFC [3] = Jacksonville;
        AFC [4] = New_England; 
        AFC [5] = Pittsburg;
        AFC [6] = San_Diego;
        AFC [7] = Indianapolis;
        AFC [8] = Miami;
        AFC [9] = Tennesee;
        AFC [10] = Oakland;
        AFC [11] = Houston;
        AFC [12] = Cleveland;
        AFC [13] = Denver;
        AFC [14] = Buffalo;
        AFC [15] = Cincinnati;

        NFC [0] = Atlanta;
        NFC [1] = Chicago;
        NFC [2] = Philidalphia;
        NFC [3] = St_Louis;
        NFC [4] = New_Orleans;
        NFC [5] = New_York_G;
        NFC [7] = Tampa_Bay;
        NFC [8] = Green_Bay;
        NFC [9] = Seattle;
        NFC [10] = Washington;
        NFC [11] = Minnesota;
        NFC [12] = San_Francisco;
        NFC [13] = Arizona;
        NFC [14] = Dallas;
        NFC [15] = Detroit;
        NFC [6] = Carolina;

        AFCeast [0] = New_York_J;
        AFCeast [1] = New_England;
        AFCeast [2] = Miami;
        AFCeast [3] = Buffalo;

        AFCnorth [0] = Baltimore;
        AFCnorth [1] = Pittsburg;
        AFCnorth [2] = Cleveland;
        AFCnorth [3] = Cincinnati;

        AFCsouth [0] = Jacksonville;
        AFCsouth [1] = Indianapolis;
        AFCsouth [2] = Tennesee;
        AFCsouth [3] = Houston;

        AFCwest [0] = Kansas_City;
        AFCwest [1] = San_Diego;
        AFCwest [2] = Oakland;
        AFCwest [3] = Denver;

        NFCeast [0] = Philidalphia;
        NFCeast [1] = New_York_G;
        NFCeast [2] = Washington;
        NFCeast [3] = Dallas;

        NFCnorth [0] = Chicago;
        NFCnorth [1] = Green_Bay;
        NFCnorth [2] = Minnesota;
        NFCnorth [3] = Detroit;

        NFCsouth [0] = Atlanta;
        NFCsouth [1] = New_Orleans;
        NFCsouth [2] = Tampa_Bay;
        NFCsouth [3] = Carolina;

        NFCwest [0] = St_Louis;
        NFCwest [1] = Seattle;
        NFCwest [2] = San_Francisco;
        NFCwest [3] = Arizona;

        afcplayoff[4] = Temp;
        afcplayoff[5] = Temp;
        nfcplayoff[4] = Temp;
        nfcplayoff[5] = Temp;

    }//close constructor

    int score;
    int secondscore;

    public void ss(){ // The teams go through the regular season
        for (int c=0; c < league.length;c++) {
            for (int t=c+1;t<league.length;t++) {
                score = league[c].scoregenerator();
                secondscore = league[t].scoregenerator();
                league[c].pointsfor(score);
                league[t].pointsfor(secondscore);

                if (score > secondscore){
                    league[c].wins();
                    league[t].losses();
                }
                else if (score == secondscore){
                    league[c].ties();
                    league[t].ties();
                }
                else {
                    league[t].wins();
                    league[c].losses();
                }
            }     
        }
        for (int c=0; c < AFC.length;c++) {
            for (int t=c+1;t<AFC.length;t++) {
                score = AFC[c].scoregenerator();
                secondscore = AFC[t].scoregenerator();
                AFC[c].pointsfor(score);
                AFC[t].pointsfor(secondscore);

                if (score > secondscore){
                    AFC[c].wins();
                    AFC[t].losses();
                }
                else if (score == secondscore){
                    AFC[c].ties();
                    AFC[t].ties();
                }
                else {
                    AFC[t].wins();
                    AFC[c].losses();
                }
            }     
        }
        for (int c=0; c < NFC.length;c++) {
            for (int t=c+1;t<NFC.length;t++) {
                score = NFC[c].scoregenerator();
                secondscore = NFC[t].scoregenerator();
                NFC[c].pointsfor(score);
                NFC[t].pointsfor(secondscore);

                if (score > secondscore){
                    NFC[c].wins();
                    NFC[t].losses();
                }
                else if (score == secondscore){
                    NFC[c].ties();
                    NFC[t].ties();
                }
                else {
                    NFC[t].wins();
                    NFC[c].losses();
                }
            }     
        }
        for (int c=0;c<AFCeast.length;c++) {
            for (int t=c+1;t<AFCeast.length;t++) {
                score = AFCeast[c].scoregenerator();
                secondscore = AFCeast[t].scoregenerator();
                AFCeast[c].pointsfor(score);
                AFCeast[t].pointsfor(secondscore);

                if (score > secondscore){
                    AFCeast[c].wins();
                    AFCeast[t].losses();
                }
                else if (score == secondscore){
                    AFCeast[c].ties();
                    AFCeast[t].ties();
                }
                else {
                    AFCeast[t].wins();
                    AFCeast[c].losses();
                }
            }     
        }
        for (int c=0; c < AFCnorth.length;c++) {
            for (int t=c+1;t<AFCnorth.length;t++) {
                score = AFCnorth[c].scoregenerator();
                secondscore = AFCnorth[t].scoregenerator();
                AFCnorth[c].pointsfor(score);
                AFCnorth[t].pointsfor(secondscore);

                if (score > secondscore){
                    AFCnorth[c].wins();
                    AFCnorth[t].losses();
                }
                else if (score == secondscore){
                    AFCnorth[c].ties();
                    AFCnorth[t].ties();
                }
                else {
                    AFCnorth[t].wins();
                    AFCnorth[c].losses();
                }
            }     
        }
        for (int c=0; c < AFCsouth.length;c++) {
            for (int t=c+1;t<AFCsouth.length;t++) {
                score = AFCsouth[c].scoregenerator();
                secondscore = AFCsouth[t].scoregenerator();
                AFCsouth[c].pointsfor(score);
                AFCsouth[t].pointsfor(secondscore);

                if (score > secondscore){
                    AFCsouth[c].wins();
                    AFCsouth[t].losses();
                }
                else if (score == secondscore){
                    AFCsouth[c].ties();
                    AFCsouth[t].ties();
                }
                else {
                    AFCsouth[t].wins();
                    AFCsouth[c].losses();
                }
            }     
        }
        for (int c=0; c < AFCwest.length;c++) {
            for (int t=c+1;t<AFCwest.length;t++) {
                score = AFCwest[c].scoregenerator();
                secondscore = AFCwest[t].scoregenerator();
                AFCwest[c].pointsfor(score);
                AFCwest[t].pointsfor(secondscore);

                if (score > secondscore){
                    AFCwest[c].wins();
                    AFCwest[t].losses();
                }
                else if (score == secondscore){
                    AFCwest[c].ties();
                    AFCwest[t].ties();
                }
                else {
                    AFCwest[t].wins();
                    AFCwest[c].losses();
                }
            }     
        }
        for (int c=0; c < NFCeast.length;c++) {
            for (int t=c+1;t<NFCeast.length;t++) {
                score = NFCeast[c].scoregenerator();
                secondscore = NFCeast[t].scoregenerator();
                NFCeast[c].pointsfor(score);
                NFCeast[t].pointsfor(secondscore);

                if (score > secondscore){
                    NFCeast[c].wins();
                    NFCeast[t].losses();
                }
                else if (score == secondscore){
                    NFCeast[c].ties();
                    NFCeast[t].ties();
                }
                else {
                    NFCeast[t].wins();
                    NFCeast[c].losses();
                }
            }     
        }
        for (int c=0; c < NFCnorth.length;c++) {
            for (int t=c+1;t<NFCnorth.length;t++) {
                score = NFCnorth[c].scoregenerator();
                secondscore = NFCnorth[t].scoregenerator();
                NFCnorth[c].pointsfor(score);
                NFCnorth[t].pointsfor(secondscore);

                if (score > secondscore){
                    NFCnorth[c].wins();
                    NFCnorth[t].losses();
                }
                else if (score == secondscore){
                    NFCnorth[c].ties();
                    NFCnorth[t].ties();
                }
                else {
                    NFCnorth[t].wins();
                    NFCnorth[c].losses();
                }
            }     
        }
        for (int c=0; c < NFCsouth.length;c++) {
            for (int t=c+1;t<NFCsouth.length;t++) {
                score = NFCsouth[c].scoregenerator();
                secondscore = NFCsouth[t].scoregenerator();
                NFCsouth[c].pointsfor(score);
                NFCsouth[t].pointsfor(secondscore);

                if (score > secondscore){
                    NFCsouth[c].wins();
                    NFCsouth[t].losses();
                }
                else if (score == secondscore){
                    NFCsouth[c].ties();
                    NFCsouth[t].ties();
                }
                else {
                    NFCsouth[t].wins();
                    NFCsouth[c].losses();
                }
            }     
        }
        for (int c=0; c < NFCwest.length;c++) {
            for (int t=c+1;t<NFCwest.length;t++) {
                score = NFCwest[c].scoregenerator();
                secondscore = NFCwest[t].scoregenerator();
                NFCwest[c].pointsfor(score);
                NFCwest[t].pointsfor(secondscore);

                if (score > secondscore){
                    NFCwest[c].wins();
                    NFCwest[t].losses();
                }
                else if (score == secondscore){
                    NFCwest[c].ties();
                    NFCwest[t].ties();
                }
                else {
                    NFCwest[t].wins();
                    NFCwest[c].losses();
                }
            }     
        }

        for (int c=0;c<league.length;c++){
            System.out.println(league[c]);
        }
        System.out.println("...");
        try
        {
            Thread.sleep(3000);
        }
        catch (Exception e)
        {}
        System.out.println("\n" + "Now let the playoffs begin!" + "\n");

        for (int y=0;y<4;y++){ // These next groups of code are sorting each division, and each conference based on wins
            for (int p=0;p<3;p++) {
                int a = p+1;
                if (AFCeast[a].displaywins() > AFCeast[p].displaywins()){
                    Temp = AFCeast[p];
                    AFCeast[p] = AFCeast[a];
                    AFCeast[a] = Temp;
                }
                else if (AFCeast[a].displaywins() == AFCeast[p].displaywins() && AFCeast[a].displaypf() > AFCeast[p].displaypf()){
                    Temp = league[p];
                    league[p] = league[a];
                    league[a] = Temp;
                }

            }
        }
        // System.out.println(AFCeast[0]);

        afcplayoff[0] = AFCeast[0];
        // System.out.println(afcplayoff[0]);
        for (int y=0;y<4;y++){
            for (int p=0;p<3;p++) {
                int a = p+1;
                if (AFCnorth[a].displaywins() > AFCnorth[p].displaywins()){
                    Temp = AFCnorth[p];
                    AFCnorth[p] = AFCnorth[a];
                    AFCnorth[a] = Temp;
                }
                else if (AFCnorth[a].displaywins() == AFCnorth[p].displaywins() && AFCnorth[a].displaypf() > AFCnorth[p].displaypf()){
                    Temp = league[p];
                    league[p] = league[a];
                    league[a] = Temp;
                }

            }
        }

        afcplayoff[1] = AFCnorth[0];
        for (int y=0;y<4;y++){
            for (int p=0;p<3;p++) {
                int a = p+1;
                if (AFCsouth[a].displaywins() > AFCsouth[p].displaywins()){
                    Temp = AFCsouth[p];
                    AFCsouth[p] = AFCsouth[a];
                    AFCsouth[a] = Temp;
                }
                else if (AFCsouth[a].displaywins() == AFCsouth[p].displaywins() && AFCsouth[a].displaypf() > AFCsouth[p].displaypf()){
                    Temp = league[p];
                    league[p] = league[a];
                    league[a] = Temp;
                }

            }
        }

        afcplayoff[2] = AFCsouth[0];
        for (int y=0;y<4;y++){
            for (int p=0;p<3;p++) {
                int a = p+1;
                if (AFCwest[a].displaywins() > AFCwest[p].displaywins()){
                    Temp = AFCwest[p];
                    AFCwest[p] = AFCwest[a];
                    AFCwest[a] = Temp;
                }
                else if (AFCwest[a].displaywins() == AFCwest[p].displaywins() && AFCwest[a].displaypf() > AFCwest[p].displaypf()){
                    Temp = league[p];
                    league[p] = league[a];
                    league[a] = Temp;
                }

            }
        }

        afcplayoff[3] = AFCwest[0];
        for (int y=0;y<4;y++){
            for (int p=0;p<3;p++) {
                int a = p+1;
                if (NFCeast[a].displaywins() > NFCeast[p].displaywins()){
                    Temp = NFCeast[p];
                    NFCeast[p] = NFCeast[a];
                    NFCeast[a] = Temp;
                }
                else if (NFCeast[a].displaywins() == NFCeast[p].displaywins() && NFCeast[a].displaypf() > NFCeast[p].displaypf()){
                    Temp = league[p];
                    league[p] = league[a];
                    league[a] = Temp;
                }

            }
        }
        nfcplayoff[0] = NFCeast[0];
        for (int y=0;y<4;y++){
            for (int p=0;p<3;p++) {
                int a = p+1;
                if (NFCnorth[a].displaywins() > NFCnorth[p].displaywins()){
                    Temp = NFCnorth[p];
                    NFCnorth[p] = NFCnorth[a];
                    NFCnorth[a] = Temp;
                }
                else if (NFCnorth[a].displaywins() == NFCnorth[p].displaywins() && NFCnorth[a].displaypf() > NFCnorth[p].displaypf()){
                    Temp = league[p];
                    league[p] = league[a];
                    league[a] = Temp;
                }

            }
        }
        nfcplayoff[1] = NFCnorth[0];
        for (int y=0;y<4;y++){
            for (int p=0;p<3;p++) {
                int a = p+1;
                if (NFCsouth[a].displaywins() > NFCsouth[p].displaywins()){
                    Temp = NFCsouth[p];
                    NFCsouth[p] = NFCsouth[a];
                    NFCsouth[a] = Temp;
                }
                else if (NFCsouth[a].displaywins() == NFCsouth[p].displaywins() && NFCsouth[a].displaypf() > NFCsouth[p].displaypf()){
                    Temp = league[p];
                    league[p] = league[a];
                    league[a] = Temp;
                }

            }
        }
        nfcplayoff[2] = NFCsouth[0];
        for (int y=0;y<4;y++){
            for (int p=0;p<3;p++) {
                int a = p+1;
                if (NFCwest[a].displaywins() > NFCwest[p].displaywins()){
                    Temp = NFCwest[p];
                    NFCwest[p] = NFCwest[a];
                    NFCwest[a] = Temp;
                }
                else if (NFCwest[a].displaywins() == NFCwest[p].displaywins() && NFCwest[a].displaypf() > NFCwest[p].displaypf()){
                    Temp = league[p];
                    league[p] = league[a];
                    league[a] = Temp;
                }

            }
        }
        nfcplayoff[3] = NFCwest[0];
        for (int y=0;y<16;y++){
            for (int p=0;p<15;p++) {
                int a = p+1;
                if (AFC[a].displaywins() > AFC[p].displaywins()){
                    Temp = AFC[p];
                    AFC[p] = AFC[a];
                    AFC[a] = Temp;
                }
                else if (AFC[a].displaywins() == AFC[p].displaywins() && AFC[a].displaypf() > AFC[p].displaypf()){
                    Temp = AFC[p];
                    AFC[p] = AFC[a];
                    AFC[a] = Temp;
                }

            }
        }
        for (int y=0;y<16;y++){
            for (int p=0;p<15;p++) {
                int a = p+1;
                if (NFC[a].displaywins() > NFC[p].displaywins()){
                    Temp = NFC[p];
                    NFC[p] = NFC[a];
                    NFC[a] = Temp;
                }
                else if (NFC[a].displaywins() == NFC[p].displaywins() && NFC[a].displaypf() > NFC[p].displaypf()){
                    Temp = NFC[p];
                    NFC[p] = NFC[a];
                    NFC[a] = Temp;
                }

            }
        }

        int maxw=0;

        for (int x=0;x<AFC.length;x++){

            if ((AFC[x].displaywins() > maxw) && 
            (AFC[x].getName() != afcplayoff[0].getName()) && 
            (AFC[x].getName() != afcplayoff[1].getName()) && 
            (AFC[x].getName() != afcplayoff[2].getName()) && 
            (AFC[x].getName() != afcplayoff[3].getName()) && 
            (AFC[x].getName() != afcplayoff[4].getName()) && 
            (AFC[x].getName() != afcplayoff[5].getName())){
                maxw = AFC[x].displaywins();
                afcplayoff[4] = AFC[x];  
            }

        }

        maxw=0;
        for (int x=0;x<AFC.length;x++){

            if (AFC[x].displaywins() > maxw && 
            AFC[x].getName() != afcplayoff[0].getName() && 
            AFC[x].getName() != afcplayoff[1].getName() && 
            AFC[x].getName() != afcplayoff[2].getName() && 
            AFC[x].getName() != afcplayoff[3].getName() && 
            AFC[x].getName() != afcplayoff[4].getName() && 
            AFC[x].getName() != afcplayoff[5].getName()){
                maxw = AFC[x].displaywins();
                afcplayoff[5] = AFC[x];  
            }
        }

        maxw=0;
        for (int x=0;x<NFC.length;x++){
            if (NFC[x].displaywins() > maxw && 
            NFC[x].getName() != nfcplayoff[0].getName() && 
            NFC[x].getName() != nfcplayoff[1].getName() && 
            NFC[x].getName() != nfcplayoff[2].getName() && 
            NFC[x].getName() != nfcplayoff[3].getName() && 
            NFC[x].getName() != nfcplayoff[4].getName() && 
            NFC[x].getName() != nfcplayoff[5].getName()){
                maxw = NFC[x].displaywins();
                nfcplayoff[4] = NFC[x];  
            }
        }
        maxw=0;
        for (int x=0;x<NFC.length;x++){

            if (NFC[x].displaywins() > maxw && 
            NFC[x].getName() != nfcplayoff[0].getName() && 
            NFC[x].getName() != nfcplayoff[1].getName() && 
            NFC[x].getName() != nfcplayoff[2].getName() && 
            NFC[x].getName() != nfcplayoff[3].getName() && 
            NFC[x].getName() != nfcplayoff[4].getName() && 
            NFC[x].getName() != nfcplayoff[5].getName()){
                maxw = NFC[x].displaywins();
                nfcplayoff[5] = NFC[x];  
            }
        }

        for (int y=0;y<4;y++){
            for (int p=0;p<3;p++) {
                int a = p+1;
                if (afcplayoff[a].displaywins() > afcplayoff[p].displaywins()){
                    Temp = afcplayoff[p];
                    afcplayoff[p] = afcplayoff[a];
                    afcplayoff[a] = Temp;
                }
                else if (afcplayoff[a].displaywins() == afcplayoff[p].displaywins() && afcplayoff[a].displaypf() > afcplayoff[p].displaypf()){
                    Temp = afcplayoff[p];
                    afcplayoff[p] = afcplayoff[a];
                    afcplayoff[a] = Temp;
                }

            }
        }
        for (int c=0;c<afcplayoff.length;c++){ // Testing to see if users team made the playoffs.
            if(YourTeam.getName().equals(afcplayoff[c].getName()))
                afcplayofft = true;
        }

        for (int y=0;y<4;y++){
            for (int r=0;r<3;r++) {
                int c = r+1;
                if (nfcplayoff[c].displaywins() > nfcplayoff[r].displaywins()){
                    Temp = nfcplayoff[r];
                    nfcplayoff[r] = nfcplayoff[c];
                    nfcplayoff[c] = Temp;
                }
                else if (nfcplayoff[c].displaywins() == nfcplayoff[r].displaywins() && nfcplayoff[c].displaypf() > nfcplayoff[r].displaypf()){
                    Temp = nfcplayoff[r];
                    nfcplayoff[r] = nfcplayoff[c];
                    nfcplayoff[c] = Temp;
                }

            }
        }
        for (int c=0;c<nfcplayoff.length;c++){
            if(YourTeam.getName().equals(nfcplayoff[c].getName()))
                nfcplayofft = true;
        }
        // This shows how the playoffs will look like to the user
        System.out.println("..." + "\n" + "Based on the regular season, here is what the first round of playoffs will look like:" + "\n");
        try
        {
            Thread.sleep(3000);
        }
        catch (Exception e)
        {}
        System.out.println(afcplayoff[0].getName() + " got a bye in the first round of the playoffs for placing first in the afc.");
        System.out.println(afcplayoff[1].getName() + " also got a bye in the first round of the playoffs for placing second in the afc." + "\n");
        System.out.println(nfcplayoff[0].getName() + " got a bye in the first round of the playoffs for placing first in the nfc.");
        System.out.println(nfcplayoff[1].getName() + " also got a bye in the first round of the playoffs for placing second in the nfc." + "\n");

        System.out.println(afcplayoff[2].getName());
        System.out.println("                    \\-----\\");
        System.out.println("                           ) Winner moves on to play the " + afcplayoff[0].getName());
        System.out.println("                    /-----/");
        System.out.println(afcplayoff[5].getName() + "\n");

        System.out.println(afcplayoff[3].getName());
        System.out.println("                    \\-----\\");
        System.out.println("                           ) Winner moves onto play the "+ afcplayoff[1].getName());
        System.out.println("                    /-----/");
        System.out.println(afcplayoff[4].getName() + "\n");

        System.out.println(nfcplayoff[2].getName());
        System.out.println("                    \\-----\\");
        System.out.println("                           ) Winner moves onto play the "+ nfcplayoff[0].getName());
        System.out.println("                    /-----/");
        System.out.println(nfcplayoff[5].getName() + "\n");

        System.out.println(nfcplayoff[3].getName());
        System.out.println("                    \\-----\\");
        System.out.println("                           ) Winner moves onto play the "+ nfcplayoff[1].getName());
        System.out.println("                    /-----/");
        System.out.println(nfcplayoff[4].getName() + "\n");

        System.out.println("..."+ "\n");

        try
        {
            Thread.sleep(3000);
        }
        catch (Exception e)

        {}
    }
// Goes through more rounds of playoffs.
    public void sp(){
        afcconferencefinal[0] = afcplayoff[0];
        afcconferencefinal[1] = afcplayoff[1];
        for (int c=2;c<4;c++){
            int b = 7-c;
            int a = 5-c;
            int cscore;
            int bscore;
            cscore = afcplayoff[c].playoffscoregenerator(afcplayoff[c].displaypf());
            bscore = afcplayoff[b].playoffscoregenerator(afcplayoff[b].displaypf());
            if (cscore > bscore){
                afcconferencefinal[a] = afcplayoff[c];
            }
            else if (cscore == bscore && 
            afcplayoff[c].playoffscoregenerator(afcplayoff[c].displaypf()) > afcplayoff[b].playoffscoregenerator(afcplayoff[b].displaypf()) ) {
                afcconferencefinal[a] = afcplayoff[c];
            }
            else {
                afcconferencefinal[a] = afcplayoff[b];
            }

        }

        for (int c=0;c<afcconferencefinal.length;c++){
            if(YourTeam.getName().equals(afcconferencefinal[c].getName()))
                afcplayoffconferencefinalt = true;
        }

        nfcconferencefinal[0] = nfcplayoff[0];
        nfcconferencefinal[1] = nfcplayoff[1];
        for (int c=2;c<4;c++){
            int b = 7-c;
            int a = 5-c;
            int cscore;
            int bscore;
            cscore = nfcplayoff[c].playoffscoregenerator(nfcplayoff[c].displaypf());
            bscore = nfcplayoff[b].playoffscoregenerator(nfcplayoff[b].displaypf());
            if (cscore > bscore){
                nfcconferencefinal[a] = nfcplayoff[c];
            }
            else if (cscore == bscore && 
            nfcplayoff[c].playoffscoregenerator(nfcplayoff[c].displaypf()) > nfcplayoff[b].playoffscoregenerator(nfcplayoff[b].displaypf()) ) {
                nfcconferencefinal[a] = nfcplayoff[c];
            }
            else {
                nfcconferencefinal[a] = nfcplayoff[b];
            }

        }

        for (int c=0;c<nfcconferencefinal.length;c++){
            if(YourTeam.getName().equals(nfcconferencefinal[c].getName()))
                nfcplayoffconferencefinalt = true;
        }

        System.out.println("Now for the second round of the playoffs:"+ "\n"); 
        try
        {
            Thread.sleep(3000);
        }
        catch (Exception e)
        {}
        System.out.println(afcconferencefinal[0].getName());
        System.out.println("                    \\-----\\");
        System.out.println("                           )" );
        System.out.println("                    /-----/");
        System.out.println(afcconferencefinal[3].getName() + "\n");

        System.out.println(afcconferencefinal[1].getName());
        System.out.println("                    \\-----\\");
        System.out.println("                           )" );
        System.out.println("                    /-----/");
        System.out.println(afcconferencefinal[2].getName() + "\n" );

        System.out.println("\n"); 
        System.out.println(nfcconferencefinal[0].getName());
        System.out.println("                    \\-----\\");
        System.out.println("                           )" );
        System.out.println("                    /-----/");
        System.out.println(nfcconferencefinal[3].getName() + "\n");

        System.out.println(nfcconferencefinal[1].getName());
        System.out.println("                    \\-----\\");
        System.out.println("                           )" );
        System.out.println("                    /-----/");
        System.out.println(nfcconferencefinal[2].getName() + "\n" );

        for (int c=0;c<2;c++){ // Here all of the teams in the conference final play each other
            int t = 3-c;
            int firstscore = afcconferencefinal[c].playoffscoregenerator(afcconferencefinal[c].displaypf());
            int secondscore = afcconferencefinal[t].playoffscoregenerator(afcconferencefinal[t].displaypf());
            if (secondscore > firstscore){
                Temp = afcconferencefinal[c];
                afcconferencefinal[c] = afcconferencefinal[t];
                afcconferencefinal[t] = afcconferencefinal[c];
            }
            else if (secondscore == firstscore &&
            afcconferencefinal[t].playoffscoregenerator(afcconferencefinal[t].displaypf()) > afcconferencefinal[c].playoffscoregenerator(afcconferencefinal[c].displaypf())){
                Temp = afcconferencefinal[c];
                afcconferencefinal[c] = afcconferencefinal[t];
                afcconferencefinal[t] = afcconferencefinal[c];
            }
        }
        for (int c=0;c<2;c++){ // Here all of the teams in the conference final play each other
            int t = 3-c;
            int firstscore = nfcconferencefinal[c].playoffscoregenerator(nfcconferencefinal[c].displaypf());
            int secondscore = nfcconferencefinal[t].playoffscoregenerator(nfcconferencefinal[t].displaypf());
            if (secondscore > firstscore){
                Temp = nfcconferencefinal[c];
                nfcconferencefinal[c] = nfcconferencefinal[t];
                nfcconferencefinal[t] = nfcconferencefinal[c];
            }
            else if (secondscore == firstscore &&
            nfcconferencefinal[t].playoffscoregenerator(nfcconferencefinal[t].displaypf()) > nfcconferencefinal[c].playoffscoregenerator(nfcconferencefinal[c].displaypf())){
                Temp = nfcconferencefinal[c];
                nfcconferencefinal[c] = nfcconferencefinal[t];
                nfcconferencefinal[t] = nfcconferencefinal[c];
            }
        }
        for (int c=0;c<1;c++){
            if (YourTeam.getName().equals(afcconferencefinal[c].getName())){
                afcpresuperbowl = true; 
            }
        }
        for (int c=0;c<1;c++){
            if (YourTeam.getName().equals(nfcconferencefinal[c].getName())){
                nfcpresuperbowl = true; 
            }
        }
        try
        {
            Thread.sleep(3000);
        }
        catch (Exception e)
        {}
        System.out.println("..."+"\n");
        try
        {
            Thread.sleep(3000);
        }
        catch (Exception e)
        {}
        System.out.println("In the conference finals we have the following teams playing each other in the afc and in the nfc" + "\n");
        try
        {
            Thread.sleep(3000);
        }
        catch (Exception e)
        {}
        // More demonstration to user on how the playoffs are progressing
        System.out.println("AFC:" + "\n");
        System.out.println(afcconferencefinal[0].getName());
        System.out.println("                    \\-----\\");
        System.out.println("                           )" );
        System.out.println("                    /-----/");
        System.out.println(afcconferencefinal[1].getName()+ "\n");

        System.out.println("NFC:" + "\n");

        System.out.println(nfcconferencefinal[0].getName());
        System.out.println("                    \\-----\\");
        System.out.println("                           )" );
        System.out.println("                    /-----/");
        System.out.println(nfcconferencefinal[1].getName());

        {   int firstscore = nfcconferencefinal[0].playoffscoregenerator(nfcconferencefinal[0].displaypf());
            int secondscore = nfcconferencefinal[1].playoffscoregenerator(nfcconferencefinal[1].displaypf());
            if (firstscore > secondscore){
                superbowl[0] = nfcconferencefinal[0];
            }
            else if (firstscore > secondscore &&
            nfcconferencefinal[0].playoffscoregenerator(nfcconferencefinal[0].displaypf()) > nfcconferencefinal[1].playoffscoregenerator(nfcconferencefinal[1].displaypf())){
                superbowl[0] = nfcconferencefinal[0];
            }
            else {
                superbowl[0] = nfcconferencefinal[1]; 
            }
        }

        { int firstscore = afcconferencefinal[0].playoffscoregenerator(afcconferencefinal[0].displaypf());
            int secondscore = afcconferencefinal[1].playoffscoregenerator(afcconferencefinal[1].displaypf());
            if (firstscore > secondscore){
                superbowl[1] = afcconferencefinal[0];
            }
            else if (firstscore > secondscore &&
            afcconferencefinal[0].playoffscoregenerator(afcconferencefinal[0].displaypf()) > afcconferencefinal[1].playoffscoregenerator(afcconferencefinal[1].displaypf())){
                superbowl[1] = afcconferencefinal[0];
            }
            else {
                superbowl[1] = afcconferencefinal[1]; 
            }
        }
        for (int c=0;c<superbowl.length;c++){
            if(YourTeam.getName().equals(superbowl[c].getName()))
                superbowlt = true;
        }
        try
        {
            Thread.sleep(3000);
        }
        catch (Exception e)
        {}
        System.out.println("\n"+ "...");
        System.out.println("\n"+"Now for this years long awaited Super bowl; the competing teams are:"+ "\n");
        try
        {
            Thread.sleep(3000);
        }
        catch (Exception e)
        {}
        System.out.println(superbowl[0].getName());
        System.out.println("                    \\-----\\");
        System.out.println("                           )     V.S" );
        System.out.println("                    /-----/");
        System.out.println(superbowl[1].getName()+"\n");
        System.out.println("..." + "\n");
        try
        {
            Thread.sleep(3000);
        }
        catch (Exception e)
        {}
        {   int firstscore = superbowl[0].playoffscoregenerator(superbowl[0].displaypf());
            int secondscore = superbowl[1].playoffscoregenerator(superbowl[1].displaypf());
            if (firstscore > secondscore){
                Champs = superbowl[0];
            }
            else if (firstscore > secondscore &&
            superbowl[0].playoffscoregenerator(superbowl[0].displaypf()) > superbowl[1].playoffscoregenerator(superbowl[1].displaypf())){
                Champs = superbowl[0];
            }
            else {
                Champs = superbowl[1];
            }
        }
        System.out.println("In the final minutes of the game the " + Champs.getName() + " pull off multiple miraculous passes to win the game." + "\n");
        for (int c=0;c<league.length;c++){
            for (int p=0;p<31;p++) {
                int a = p+1;
                if (league[a].displaywins() > league[p].displaywins()){
                    Temp = league[p];
                    league[p] = league[a];
                    league[a] = Temp;
                }
                else if (league[a].displaywins() == league[p].displaywins() && league[a].displaypf() > league[p].displaypf()){
                    Temp = league[p];
                    league[p] = league[a];
                    league[a] = Temp;
                }

            }
        }
        for (int c=0;c<league.length;c++){
            if (league[c].getName().equals(selected)){
                System.out.println("Your team finished number " + c + " out of 32 teams, the number 1 team being the best team in the regular season." + "\n");
                break;
            }

        } 
        // Here I let the user know how his team did.
        if(afcplayofft == true){
            System.out.println("Your team made the playoffs.");  
        }
        else if(nfcplayofft == true){
            System.out.println("Your team made the playoffs.");  
        }
        else{
            System.out.println("Your team did not make the playoffs.");  
        }
        if(afcplayoffconferencefinalt == true){
            System.out.println("Your team made wild card round.");
        }
        else if (nfcplayoffconferencefinalt == true){
            System.out.println("Your team made the wild card round.");
        }
        else{
            System.out.println("Your team did not make the wild card round.");
        }
        if(afcpresuperbowl == true){
            System.out.println("Your team made the conference finals.");
        }
        else if (nfcpresuperbowl == true){
            System.out.println("Your team made the conference finals.");
        }
        else{
            System.out.println("Your team did not make the conference finals.");
        }
        if(superbowlt == true){
            System.out.println("Your team made the super bowl final.");
        }
        else{   
            System.out.println("Your team did not make the super bowl final.");
        }
        if (selected.equals(Champs.getName())){
            System.out.println("Your team won the super bowl!");
        }
        else{
            System.out.println("Your team did not win the super bowl." + "\n");
        }
        System.out.println("Simulation Terminated!");

    }
}

//close class NFL
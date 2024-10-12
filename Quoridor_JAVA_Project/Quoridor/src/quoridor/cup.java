package quoridor;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;

public class cup {
static ArrayList<Player> cupPlayers = new ArrayList<Player>();
static Player pp ;
static int n; // n of players
static int nOfRounds = 0; //n of rounds
static int r = 0;  //round
static int nOfMatches = 1;
static int currentMatch = 1;
public static void start(int mode) throws IOException {
    System.out.println("Enter the num of players");
    n = Game.scanner.nextInt();
    int  tempPlayer = 0,oddguy = 0,key;
    //Player[] cupPlayers = new Player[n];

    for (int i = 0; i < n; i++) { //names
        System.out.println("Enter Player(" + (i + 1) + ")'s name : ");
        pp = new Player(Game.scanner.next());
        cupPlayers.add(0,pp);
    }
    double nn = n;
    for (double i = nn; i > 1; i = i / 2) nOfRounds++;
    System.out.println(nOfRounds + " = n of rounds,  " + cupPlayers.size() + " = n of players");

    for ( r = 0; r < nOfRounds; r++) {
        System.out.println(":: round : " + r);
        ArrayList<vs> teams = new ArrayList<vs>();
        int n2 = n % 2, n3 = n - n2; //n3=even num of teams dividable by 2

        //odd guy story
        if (n2 > 0) {
            tempPlayer = ThreadLocalRandom.current().nextInt(0, n - 1);
            //System.out.println(tempPlayer);
            cupPlayers.get(tempPlayer).played++;
            cupPlayers.get(tempPlayer).won++;
            //System.out.println(cupPlayers.get(tempPlayer).name + " ODD " + cupPlayers.get(tempPlayer).played);
            oddguy = tempPlayer;
        }

        for (int counterOfteams = 0; counterOfteams < n3 / 2; counterOfteams++) { //selecting teams
            Player[] temp = new Player[]{null, null}; //two temp players for each team

            for (int playern = 0; playern < 2; playern++) { //selecting 2 player for each team
                //System.out.println("choosing player : " +playern);
                boolean flag = true;
                while (flag) { //selecting a qualified random player from arr of players
                    tempPlayer = ThreadLocalRandom.current().nextInt(0, n ); //choosing a random player
                    //System.out.println(tempPlayer + " Temp Player __ size :  " + cupPlayers.size());
                    //System.out.println(r + " " + cupPlayers.get(tempPlayer).name+ " " + cupPlayers.get(tempPlayer).played );
                    if ((cupPlayers.get(tempPlayer).played == r)){ //&& (cupPlayers.get(tempPlayer).won == r)) {
                        flag = false;
                    }
                }
                temp[playern] = cupPlayers.get(tempPlayer);
                //System.out.println(temp[playern].name + " = selected player , played times : " + temp[playern].played + "   round : " + r);
                cupPlayers.get(tempPlayer).played++;

            }
            vs v = new vs(temp[0], temp[1]);
            teams.add(0, v);
            //System.out.println(temp[0].name + " temps ::: " + temp[1].name);
        }

        int match = 1;
        if (n2 > 0) {
            System.out.println("match 0 " + " : " + cupPlayers.get(oddguy).name + " (rest)");
        }
        for (vs team : teams) {
            System.out.println("match " + match + " : " + team.p1.name + " vs " + team.p2.name);
            match++;
        }
        nOfMatches = match;
        currentMatch = 1;
        for (vs team : teams) {
            System.out.println("___________________\n : " + team.p1.name + " vs " + team.p2.name);
            System.out.println(" Press '1' and enter to go to the game ");
            Game g = new Game(team.p1, team.p2);
            //g.board.print(team.p1.bead,team.p2.bead);
            Game.scanner.nextLine();
            //if (mode==0){ g.play(); } //terminal
            //if (mode == 1 )
            GUI singlePlayerGUI = new GUI(g,false); //GUI
            //while(!singlePlayerGUI.isGameEnded){}
            team.winner = g.getWinner();
            team.loser = g.getLoser();
//                team.winner = team.p1;
//                team.loser = team.p2;
            cupPlayers.remove(team.loser);
            System.out.println("Winner of the last match : " + team.winner.name);
            currentMatch++;
        }
        n = n - (teams.size() / 2)-1;
    }
    System.out.println("winner of cup : " + cupPlayers.get(0).name);
}
}



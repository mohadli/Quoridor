package quoridor;

import java.awt.*;

public class Player {
    String name;
    private int number;
    boolean isTheTopPlayer;
    int remainingWalls = 10;
    private static int counter = 1;
    Bead bead;
    int played = 0;
    int won = 0;
    Color color;
    boolean ai = false;

    /**
     * @param isTheTopPlayer is true, if this is the player playing at top
     **/
/*    public Player(String name, boolean isTheTopPlayer) {
        this.name = name;
        this.isTheTopPlayer = isTheTopPlayer;
        if (isTheTopPlayer){
            bead = new Bead(5, 1, "a");
            color = Color.blue;
        }else{
            bead = new Bead(5, 9, "b");
            color = new Color(175,9,255,255);
        }
        System.out.println("Player " + counter + ", " + name + " is Ready!");
        this.number = counter;
        counter++;
    }*/

public Player(String name){
    this.name = name;
    this.number = counter;
    counter++;
}

public void setTheTopPlayer(boolean theTopPlayer){
    isTheTopPlayer = theTopPlayer;
    if(isTheTopPlayer){
        bead = new Bead(5, 1, "a");
        color = Color.blue;
    }else{
        bead = new Bead(5, 9, "b");
        color = new Color(175,9,255,255);
    }
}

public int getPlayed() { return played; }
    public void setPlayed(int played) { this.played = played ; }
    public int getWon() { return won ; }
    public void setWon(int won) { this.won = won;}

@Override
public String toString(){
    return "Player[" + number + "], " + name;
}
}

package quoridor;

import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

import static quoridor.Wall.hWalls;
import static quoridor.Wall.wallsCoordinations;

public class Game {
    final int NUMBEROFPLAYERS = 2;
    final static int LOAD_MODE = 1;
    boolean isFinished = false;
    public static Player currentPlayer, otherPlayer;
    public static Player[] players = new Player[2];
    public static Board board;
    static int newx, newy;
    static int dotLocation;
    static int pos, opponentPos, moveDirection;
    static int turnCounter;
    static Scanner scanner = new Scanner(System.in);
    public static Player winner;
    public static Player loser;

    public Game(Player p1, Player p2) {
        board = new Board();
        players[0] = p1;
        players[0].setTheTopPlayer(true);
        players[1] = p2;
        players[1].setTheTopPlayer(false);
        //loser = null;
    }
    //load mode
    public Game(Player p1, Player p2, int mode){
        board = new Board();
        players[0].color = Color.blue;
        players[1].color = new Color(175,9,255,255);
        Player ttt ;
        if( save.nobat.equals("1"));{
            players[1].color = Color.blue;
            players[0].color = new Color(175,9,255,255);}
    }

    public void play() throws IOException {
        turnCounter = 0;

        while (!isFinished) {
            //if(turnCounter>0)
            currentPlayer = players[turnCounter % 2];
            otherPlayer = players[(turnCounter + 1) % 2];

            board.print(players[0].bead, players[1].bead);
            System.out.println(currentPlayer.name + "(" + currentPlayer.bead.sign + ")" + "'s Turn:");
            System.out.println("Remaining Walls: " + currentPlayer.remainingWalls);
            System.out.println(currentPlayer.bead.sign + "(" + currentPlayer.bead.x + "," + currentPlayer.bead.y + ")");
            //scanner.nextLine();
            String temp = "";
            if (currentPlayer.ai)
                temp = RandomAI.str(currentPlayer);
            else
                temp = scanner.nextLine();
            temp = temp.toLowerCase();
            opponentPos = mToP(otherPlayer.bead.x, otherPlayer.bead.y);
            pos = mToP(currentPlayer.bead.x, currentPlayer.bead.y);

            if (temp.contains(" ")) {
                if (Wall.inputWall(temp, currentPlayer, board)) {
                    currentPlayer.remainingWalls--;
                    turnCounter++;
                    board.updateBoard(Wall.wallsCoordinations);
                }
                else { System.out.println("invalid location for Wall"); }
            } else
                inputMovePawn(temp);
                board.updateBoard(Wall.wallsCoordinations);

            gameover();
        }
    }

    public void move() {
        pos = dotLocation;
        okHelper(pos);
        currentPlayer.bead.x = newx;
        currentPlayer.bead.y = newy;
        currentPlayer.bead.p = (9 * (newy-1) + newx);
        board.updateBoard(Wall.wallsCoordinations);
        turnCounter++;
    }

    public boolean inputMovePawn(String temp){
        char[] cha = temp.toCharArray();
        int xx = cha[0] - '0';
        int yy = cha[1] - (int) 'a' + 1;
        opponentPos = mToP(otherPlayer.bead.x, otherPlayer.bead.y);
        pos = mToP(currentPlayer.bead.x, currentPlayer.bead.y);
        dotLocation = mToP(yy, xx);
        moveDirection = dotLocation - pos;
        //System.out.println(moveDirection);
        switch (moveDirection){
            //simple moves to adjacent squares
            case 1:
                if(rightOk(pos) && opponentPos != dotLocation) move();
                else return false;
                break;
            case -1:
                if(leftOk(pos) && opponentPos != dotLocation) move();
                else return false;
                break;
            case 9:
                if(downOk(pos) && opponentPos != dotLocation) move();
                else return false;
                break;
            case -9:
                if(upOk(pos) && opponentPos != dotLocation) move();
                else return false;
                break;

            //jump over opponent
            case 2:
                if(rightOk(pos) && rightOk(pos + 1) && opponentPos == pos + 1) move();
                else return false;
                break;
            case -2:
                if(leftOk(pos) && leftOk(pos - 1) && opponentPos == pos - 1) move();
                else return false;
                break;
            case 18:
                if(downOk(pos) && downOk(pos + 9) && opponentPos == pos + 9) move();
                else return false;
                break;
            case -18:
                if(upOk(pos) && upOk(pos - 9) && opponentPos == pos - 9) move();
                else return false;
                break;

            //diagonal moves are allowed iff jumping over opponent is blocked
            case 8:
                if((leftOk(pos) && downOk(pos - 1) && opponentPos == pos - 1 && !leftOk(opponentPos)) ||
                        (downOk(pos) && leftOk(pos + 9) && opponentPos == pos + 9 && !downOk(opponentPos)))
                    move();
                else return false;
                break;
            case 10:
                if((rightOk(pos) && downOk(pos + 1) && opponentPos == pos + 1 && !rightOk(opponentPos)) ||
                        (downOk(pos) && rightOk(pos + 9) && opponentPos == pos + 9 && !downOk(opponentPos)))
                    move();
                else return false;
                break;
            case -8:
                if((rightOk(pos) && upOk(pos + 1) && opponentPos == pos + 1 && !rightOk(opponentPos)) ||
                        (upOk(pos) && rightOk(pos - 9) && opponentPos == pos - 9 && !upOk(opponentPos)))
                    move();
                else return false;
                break;
            case -10:
                if((leftOk(pos) && upOk(pos - 1) && opponentPos == pos - 1 && !leftOk(opponentPos)) ||
                        (upOk(pos) && leftOk(pos - 9) && opponentPos == pos - 9 && !upOk(opponentPos)))
                    move();
                else return false;
                break;
            default:
                System.out.println("wrong entery!");
                return false;
        }try {
            save.saveGame();
        }catch (Exception ee) {
            System.out.println("Sth Went Wrong");
        }
    return true;
    }


    public int mToP(int x, int y) {
        return (9 * (y - 1) + x);
    }

    static void okHelper(int in) {
        newx = in % 9;
        newy = ((in - newx) / 9) + 1;
    }

    static boolean leftOk(int position) {
        return position % 9 != 1 && !Wall.vWalls[position] && !Wall.vWalls[Math.max(0, position - 9)];
    }

    static boolean rightOk(int position) {
        return position % 9 != 0 && !Wall.vWalls[position + 1] && !Wall.vWalls[Math.max(0, position - 8)];
    }

    static boolean upOk(int position) {
        return position > 9 && position < 82 && !Wall.hWalls[position] && !Wall.hWalls[Math.max(0, position - 1)];
    }

    static boolean downOk(int position) {
        return position > 0 && position <= 72 && !Wall.hWalls[Math.min(82, position + 9)] && !Wall.hWalls[Math.min(82, position + 8)];
    }

    public void gameover() {
        //System.out.println(players[1].bead.getP()+"  vvvvv " + players[0].bead.getP());
        if (players[1].bead.getP() <= 9 ) {
            System.out.println(players[1].name + " won!");
            players[1].won++;
            winner = players[1];
            loser = players[0];
            isFinished = true;
        } else if (players[0].bead.getP() >= 72) {
            System.out.println(players[0].name + " won!");
            isFinished = true;
            players[0].won++;
            winner = players[0];
            loser = players[1];
            isFinished = true;
        }
    }

    public Player getWinner() {return winner;}
    public Player getLoser() {return loser;}

}
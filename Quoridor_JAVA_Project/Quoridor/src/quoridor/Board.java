package quoridor;

import java.util.ArrayList;

public class Board{
//board that will be printed
//walls will be actually added to the array
//pawns will be just displayed while printing

static String[] board = new String[19];

//creating the board with "*"
public Board(){
    for(int i = 0; i < 19; i++){
        if(i % 2 != 0){
            board[i] = " ";
            for(int k = 0; k < 36; k++)
                board[i] += " ";
        } else{
            board[i] = "*";
            for(int j = 1; j < 10; j++){
                board[i] += "   *";
            }
        }
    }
}

//printing the board and the pawns
public void print(Bead p1, Bead p2){
    System.out.println("    a   b   c   d   e   f   g   h   i   j");

    for(int i = 0; i < board.length; i++){
        if(i % 2 == 0){
            if(i < 18)
                System.out.print(" ");
            System.out.print(i / 2 + 1 + ": ");
        }
        for(int j = 0; j < board[i].length(); j++){

            if(((4 * p1.getX()) + 2) == j && ((2 * p1.getY()) - 1) == i)
                System.out.print(p1.getSign());
            else if(((4 * p2.getX()) + 2) == j && ((2 * p2.getY()) - 1) == i)
                System.out.print(p2.getSign());
            else
                System.out.print(board[i].charAt(j));
        }
        System.out.println();
    }
}

/**
 * adds the walls to the board string
 *
 * @param arr an array of (x,y) of every wall that has been added
 **/
public void updateBoard(ArrayList<Bead> arr){


    for(Bead k : arr){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length(); j++){
                char[] charLine = {};

                //for horizontal walls
                if(k.getSign().equals("_")){
                    if(((4 * k.getX()) - 2) == j && (2 * (k.getY() - 1)) == i){
                        charLine = board[i].toCharArray();
                        charLine[j] = k.getSign().charAt(0);
                        board[i] = String.valueOf(charLine);
                    }
                }

                if(k.getSign().equals("|")){
                    if((4 * (k.getX())) == j && (2 * (k.getY()) - 1) == i){
                        charLine = board[i].toCharArray();
                        charLine[j] = k.getSign().charAt(0);
                        board[i] = String.valueOf(charLine);
                    }
                }
            }
        }
    }
}

//to erase wrong walls after the breadth first search
public void eraseWall(Bead k){
    for(int i = 0; i < board.length; i++){
        for(int j = 0; j < board[i].length(); j++){
            char[] charLine = {};

            //for horizontal walls
            if(k.getSign().equals("_")){
                if(((4 * k.getX()) - 2) == j && (2 * (k.getY() - 1)) == i){
                    charLine = board[i].toCharArray();
                    charLine[j] = ' ';
                    board[i] = String.valueOf(charLine);
                    Wall.hWalls[(9 * (k.getY() - 1) + k.getX())]=false;
                }
            }

            if(k.getSign().equals("|")){
                if((4 * (k.getX())) == j && (2 * (k.getY()) - 1) == i){
                    charLine = board[i].toCharArray();
                    charLine[j] = ' ';
                    board[i] = String.valueOf(charLine);
                    Wall.vWalls[(9 * (k.getY() - 1) + k.getX())]=false;
                }
            }
        }
    }
}


public boolean isHWall(int x, int y){
    return board[2 * (y - 1)].charAt((4 * x) - 2) == '_';
}

public boolean isVWall(int x, int y){
    return board[(2 * y) - 1].charAt(4 * x) == '|';
}

}

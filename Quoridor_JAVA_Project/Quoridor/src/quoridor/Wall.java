package quoridor;

import java.io.IOException;
import java.util.ArrayList;

public class Wall extends Bead{
//    private int x1;
//    private int y1;
//    private int x2;
//    private int y2;

    private String sign;
    static ArrayList<Bead> wallsCoordinations = new ArrayList<>();
    static boolean[] vWalls = new boolean[100];
    static boolean[] hWalls = new boolean[100];

public Wall(int x1, int y1, int x2, int y2){
    super(x1,y1);

    if(x2 - x1 != 0){
        this.sign = "_";
    }else{
        this.sign = "|";
    }
    wallsCoordinations.add(new Bead(x1,y1,sign));
    wallsCoordinations.add(new Bead(x2,y2,sign));

//    this.x1 = x1;
//    this.y1 = y1;
//    this.x2 = x2;
//    this.y2 = y2;
}
//TODO: handle exceptions
//TODO: change the return value to reflect any error
static boolean inputWall(String input, Player player,Board board) throws IOException{
    //input example: 2b 3b
    String[] inputArr = input.split(" ");
    //Numeric parts 2 3
    int y1 = Integer.parseInt(inputArr[0].replaceAll("\\D+",""));
    int y2 = Integer.parseInt(inputArr[1].replaceAll("\\D+",""));
    //alphabetic parts b b
    inputArr[0] = inputArr[0].replaceAll("[^a-zA-Z]","");
    inputArr[1] = inputArr[1].replaceAll("[^a-zA-Z]","");

    int x1 = inputArr[0].charAt(0) - (int)'a' + 1;
    int x2 = inputArr[1].charAt(0) - (int)'a' + 1;

    int one = (9 * (y1 - 1) + x1);
    int two = (9 * (y2 - 1) + x2);
    int wallLocation = one;
    //System.out.println("("+x1+","+y1+")\n("+x2+","+y2+")");
    if ((two - one) == 9) {
        if (!vWalls[wallLocation] &&
                wallLocation % 9 != 1 && wallLocation <= 72 &&
                !vWalls[Math.max(0, wallLocation - 9)] && !vWalls[wallLocation + 9] && !hWalls[wallLocation + 8] &&
                (( player.remainingWalls > 0))){
            vWalls[wallLocation] = true;
            Wall wall = new Wall(x1, y1, x2, y2);
        }
        else return false;
    }
    else if ((two - one) == 1){
        if (!hWalls[wallLocation] &&
                wallLocation % 9 > 0 && wallLocation > 9 && wallLocation < 82 &&
                !hWalls[Math.max(0, wallLocation - 1)] && !hWalls[wallLocation + 1] && !vWalls[Math.max(0, wallLocation - 8)] &&
                ((player.remainingWalls > 0) )) {
            hWalls[wallLocation] = true;
            Wall wall = new Wall(x1, y1, x2, y2);
        }
        else return false;
    }

    else{
        System.out.println("Wrong Entery");
        return false;
    }
    board.updateBoard(Wall.wallsCoordinations);
    //checks if it doesn't completely blocks off the path
BreadthFirstSearch.BreadthFirstSearch(board);
    if(!BreadthFirstSearch.BreadthFirstSearch(board)){
        board.eraseWall(wallsCoordinations.get(wallsCoordinations.size()-1));
        wallsCoordinations.remove(wallsCoordinations.size()-1);
        board.eraseWall(wallsCoordinations.get(wallsCoordinations.size()-1));
        wallsCoordinations.remove(wallsCoordinations.size()-1);

        board.updateBoard(Wall.wallsCoordinations);
        return false;
    }
    save.saveGame();
    return true;
}
}

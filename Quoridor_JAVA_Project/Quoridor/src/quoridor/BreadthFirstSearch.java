package quoridor;


public class BreadthFirstSearch {
/* this method determines whether there is a path from one square to another
 *it is used to implement the rule that you cannot place a wall that totally
 *blocks in an opponent */

//holds the queue
static Bead[] toCheckList = new Bead[100];



//bookmarks within toCheckList
static int toCheckTail = 1;
static int toCheckHead = 0;

static boolean[] endCondition = new boolean[2];




static public boolean BreadthFirstSearch (Board board){
    //The toCheckList array functions as a queue (FIFO)
    //toCheckHead and toCheckTail serve as bookmarks within toCheckList
    //All of these are declared at the top of the page.

    //Set up the queue and add the starting point to the queue

    for (int i = 0; i < toCheckList.length; i++)
        toCheckList[i] = new Bead(0,0);
    Bead pawn;
    int endRow = 9;
    endCondition[0] = false;
    endCondition[1] = false;


    for(int i = 0; i < 2; i++){
        wipe();
        pawn = Game.players[i].bead;
        toCheckList[0].x = pawn.x;
        toCheckList[0].y = pawn.y;
        toCheckList[0].sign = pawn.sign;
        if(i > 0) endRow = 1;

        while(toCheckHead < toCheckTail && !toCheckList[toCheckHead].equals(new Bead(0,0))){
            Bead currentSquare = toCheckList[toCheckHead];
            //System.out.println("current Square: " + currentSquare);


            //to the left:
            //checks it doesn't get out of board
            Bead leftOfCurrent = new Bead(Math.max(1, currentSquare.x-1), currentSquare.y);
            //checks if you can go to left
            if(!board.isVWall(currentSquare.x, currentSquare.y)
                    //checks if it isn't already added to the queue
                    && !loop(leftOfCurrent)){
                toCheckList[toCheckTail] = leftOfCurrent;
                toCheckTail++;
            }

            //to the right
            Bead rightOfCurrent = new Bead(Math.min(9, currentSquare.x + 1), currentSquare.y);
            if(!board.isVWall(Math.min(9, currentSquare.x + 1), currentSquare.y) && !loop(rightOfCurrent)){
                toCheckList[toCheckTail] = rightOfCurrent;
                toCheckTail++;
            }

            //down
            Bead belowCurrent = new Bead(currentSquare.x, Math.min(9, currentSquare.y + 1));
            if(!board.isHWall(currentSquare.x, Math.min(9, currentSquare.y + 1)) && !loop(belowCurrent)){
                toCheckList[toCheckTail] = belowCurrent;
                toCheckTail++;
            }

            //up
            Bead aboveCurrent = new Bead(currentSquare.x, Math.max(1, currentSquare.y - 1));
            if(!board.isHWall(currentSquare.x, Math.max(1, currentSquare.y)) && !loop(aboveCurrent)){
                toCheckList[toCheckTail] = aboveCurrent;
                toCheckTail++;
            }

            if(currentSquare.y == endRow){
                System.out.println("\n\n\n");
                endCondition[i] = true;
                break;
            }
            toCheckHead++;
        }
    }
    //System.out.println("\n\n\n");
    //System.out.println("endCondition[0]:" + endCondition[0]);
    //System.out.println("endCondition[1]:" + endCondition[1]);
    return endCondition[0] && endCondition[1];
}



//checks whether 'newSquare' is repeated or not
static boolean loop(Bead newSquare) {
    for (int j = 0; (toCheckList[j].y != 0); j++) {
        if (toCheckList[j].equals(newSquare)) {
            return true;
        }
    }

    return false;
}

static void wipe() {
    //wipes the queue to prepare for future searches
    //needs to wipe to 0 to avoid conflicts with square 1.
    for (int i = 0; i < toCheckList.length; i++) {
        toCheckList[i].y = 0;
        toCheckList[i].x = 0;
        toCheckList[i].sign = "@";
    }
    toCheckTail = 1;
    toCheckHead = 0;

}

}

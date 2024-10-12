package quoridor;

import java.util.ArrayList;

public class LoadGUI{
public LoadGUI(){
    try {
        save.load();

    }catch (Exception ee){ee.printStackTrace();}
    for(int i = 0; i < Wall.wallsCoordinations.size(); i +=2){
        int X, Y;
        Bead w1 = Wall.wallsCoordinations.get(i);
        Bead w2 = Wall.wallsCoordinations.get(i+1);
        if(w1.y == w2.y){
            //horizontal
            Y = 40 * (w1.y - 1) + 155;
            X = 40 * (w1.x - 2) + 625;

        }else{
            //vertical
            Y = 40 * (w1.y - 2) + 165;
            X = 40 * (w1.x - 1) + 615;
        }
        GUI.cordX.add(X);
        GUI.cordY.add(Y);
    }

    Game game = new Game(Game.players[0], Game.players[1], Game.LOAD_MODE);

    GUI loadedGUI = new GUI(game,true);



}
}



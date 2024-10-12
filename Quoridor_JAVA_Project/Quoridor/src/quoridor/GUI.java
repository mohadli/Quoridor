/*
 * Created by JFormDesigner on Sun Jul 26 15:35:00 IRDT 2020
 */

package quoridor;

import jaco.mp3.player.MP3Player;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * @author Aref Borhani
 */
public class GUI extends JFrame{
JButton[] walls = new JButton[128];
JButton[] boxes = new JButton[81];
JLabel background, label1, label2, player1Label, player2Label;
JButton label1color, label2color, muteButton;
Game game;
JButton topPawn, buttonPawn;
static byte turnCounter = 0;
final Color WALL_COLOR = new Color(0, 204, 204);
final Color BOX_COLOR = new Color(204, 255, 255);
final Color SELECTED_WALL_COLOR = new Color(63,4,141);
Player theWinner;
public boolean isGameEnded = false, isLoaded = false;

public static ArrayList<Integer> cordX = new ArrayList<>();
public static ArrayList<Integer> cordY = new ArrayList<>();

public void setLoaded(boolean loaded){
    isLoaded = loaded;
}

public GUI(Game game,boolean loaded){
    this.game = game;
    isLoaded = loaded;
    initComponents();






    label1 = new JLabel(Game.players[0].name + "'s Remaining Walls: " + Game.players[0].remainingWalls);
    label1.setBounds(180,295,350,45);
    label1.setForeground(new Color(221, 247, 255 ));
    label1.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 22));
    add(label1);

    label1color = new JButton();
    label1color.setBounds(150,308,20,20);
    label1color.setBackground(Game.players[0].color);
    label1color.setEnabled(false);
    label1color.setBorderPainted(false);
    add(label1color);


    label2 = new JLabel(Game.players[1].name + "'s Remaining Walls: " + Game.players[1].remainingWalls);
    label2.setBounds(180,360,350,45);
    label2.setForeground(new Color(221, 247, 255 ));
    label2.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 22));
    add(label2);

    label2color = new JButton();
    label2color.setBounds(150,373,20,20);
    label2color.setBackground(Game.players[1].color);
    label2color.setEnabled(false);
    label2color.setBorderPainted(false);
    add(label2color);


    player1Label = new JLabel(Game.players[0].name + "'s Turn:");
    player1Label.setBounds(730 ,115,160,30);
    player1Label.setForeground(new Color(221, 247, 255 ));
    player1Label.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 28));
    //player1Label.setVisible(false);
    add(player1Label);

    player2Label = new JLabel(Game.players[1].name + "'s Turn:");
    player2Label.setBounds(730 ,530,160,30);
    player2Label.setForeground(new Color(221, 247, 255 ));
    player2Label.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 28));
    player2Label.setVisible(false);
    add(player2Label);


    try {
        //Mute Button
        Image muteImage = ImageIO.read(this.getClass().getResource("\\Resources\\Mute.png"));
        muteButton = new JButton(new ImageIcon(muteImage));
        muteButton.setBackground(Color.black);
        muteButton.setBounds(1010,600,43,41);
        muteButton.setBorderPainted(false);
        add(muteButton);

        background = new JLabel(new ImageIcon(getClass().getResource("\\Resources\\P8.png")));
        background.setBounds(0,0,1100,700);
        add(background);

    }catch (Exception e){
        System.out.println("Error!!");
    }


    setSize(1100,700);

    walls[0] = wall1;
    walls[1] = wall2;
    walls[2] = wall3;
    walls[3] = wall4;
    walls[4] = wall5;
    walls[5] = wall6;
    walls[6] = wall7;
    walls[7] = wall8;
    walls[8] = wall9;
    walls[9] = wall10;
    walls[10] = wall11;
    walls[11] = wall12;
    walls[12] = wall13;
    walls[13] = wall14;
    walls[14] = wall15;
    walls[15] = wall16;
    walls[16] = wall17;
    walls[17] = wall18;
    walls[18] = wall19;
    walls[19] = wall20;
    walls[20] = wall21;
    walls[21] = wall22;
    walls[22] = wall23;
    walls[23] = wall24;
    walls[24] = wall25;
    walls[25] = wall26;
    walls[26] = wall27;
    walls[27] = wall28;
    walls[28] = wall29;
    walls[29] = wall30;
    walls[30] = wall31;
    walls[31] = wall32;
    walls[32] = wall33;
    walls[33] = wall34;
    walls[34] = wall35;
    walls[35] = wall36;
    walls[36] = wall37;
    walls[37] = wall38;
    walls[38] = wall39;
    walls[39] = wall40;
    walls[40] = wall41;
    walls[41] = wall42;
    walls[42] = wall43;
    walls[43] = wall44;
    walls[44] = wall45;
    walls[45] = wall46;
    walls[46] = wall47;
    walls[47] = wall48;
    walls[48] = wall49;
    walls[49] = wall50;
    walls[50] = wall51;
    walls[51] = wall52;
    walls[52] = wall53;
    walls[53] = wall54;
    walls[54] = wall55;
    walls[55] = wall56;
    walls[56] = wall57;
    walls[57] = wall58;
    walls[58] = wall59;
    walls[59] = wall60;
    walls[60] = wall61;
    walls[61] = wall62;
    walls[62] = wall63;
    walls[63] = wall64;
    walls[64] = wall65;
    walls[65] = wall66;
    walls[66] = wall67;
    walls[67] = wall68;
    walls[68] = wall69;
    walls[69] = wall70;
    walls[70] = wall71;
    walls[71] = wall72;
    walls[72] = wall73;
    walls[73] = wall74;
    walls[74] = wall75;
    walls[75] = wall76;
    walls[76] = wall77;
    walls[77] = wall78;
    walls[78] = wall79;
    walls[79] = wall80;
    walls[80] = wall81;
    walls[81] = wall82;
    walls[82] = wall83;
    walls[83] = wall84;
    walls[84] = wall85;
    walls[85] = wall86;
    walls[86] = wall87;
    walls[87] = wall88;
    walls[88] = wall89;
    walls[89] = wall90;
    walls[90] = wall91;
    walls[91] = wall92;
    walls[92] = wall93;
    walls[93] = wall94;
    walls[94] = wall95;
    walls[95] = wall96;
    walls[96] = wall97;
    walls[97] = wall98;
    walls[98] = wall99;
    walls[99] = wall100;
    walls[100] = wall101;
    walls[101] = wall102;
    walls[102] = wall103;
    walls[103] = wall104;
    walls[104] = wall105;
    walls[105] = wall106;
    walls[106] = wall107;
    walls[107] = wall108;
    walls[108] = wall109;
    walls[109] = wall110;
    walls[110] = wall111;
    walls[111] = wall112;
    walls[112] = wall113;
    walls[113] = wall114;
    walls[114] = wall115;
    walls[115] = wall116;
    walls[116] = wall117;
    walls[117] = wall118;
    walls[118] = wall119;
    walls[119] = wall120;
    walls[120] = wall121;
    walls[121] = wall122;
    walls[122] = wall123;
    walls[123] = wall124;
    walls[124] = wall125;
    walls[125] = wall126;
    walls[126] = wall127;
    walls[127] = wall128;

    boxes[0] = box1;
    boxes[1] = box2;
    boxes[2] = box3;
    boxes[3] = box4;
    boxes[4] = box5;
    boxes[5] = box6;
    boxes[6] = box7;
    boxes[7] = box8;
    boxes[8] = box9;
    boxes[9] = box10;
    boxes[10] = box11;
    boxes[11] = box12;
    boxes[12] = box13;
    boxes[13] = box14;
    boxes[14] = box15;
    boxes[15] = box16;
    boxes[16] = box17;
    boxes[17] = box18;
    boxes[18] = box19;
    boxes[19] = box20;
    boxes[20] = box21;
    boxes[21] = box22;
    boxes[22] = box23;
    boxes[23] = box24;
    boxes[24] = box25;
    boxes[25] = box26;
    boxes[26] = box27;
    boxes[27] = box28;
    boxes[28] = box29;
    boxes[29] = box30;
    boxes[30] = box31;
    boxes[31] = box32;
    boxes[32] = box33;
    boxes[33] = box34;
    boxes[34] = box35;
    boxes[35] = box36;
    boxes[36] = box37;
    boxes[37] = box38;
    boxes[38] = box39;
    boxes[39] = box40;
    boxes[40] = box41;
    boxes[41] = box42;
    boxes[42] = box43;
    boxes[43] = box44;
    boxes[44] = box45;
    boxes[45] = box46;
    boxes[46] = box47;
    boxes[47] = box48;
    boxes[48] = box49;
    boxes[49] = box50;
    boxes[50] = box51;
    boxes[51] = box52;
    boxes[52] = box53;
    boxes[53] = box54;
    boxes[54] = box55;
    boxes[55] = box56;
    boxes[56] = box57;
    boxes[57] = box58;
    boxes[58] = box59;
    boxes[59] = box60;
    boxes[60] = box61;
    boxes[61] = box62;
    boxes[62] = box63;
    boxes[63] = box64;
    boxes[64] = box65;
    boxes[65] = box66;
    boxes[66] = box67;
    boxes[67] = box68;
    boxes[68] = box69;
    boxes[69] = box70;
    boxes[70] = box71;
    boxes[71] = box72;
    boxes[72] = box73;
    boxes[73] = box74;
    boxes[74] = box75;
    boxes[75] = box76;
    boxes[76] = box77;
    boxes[77] = box78;
    boxes[78] = box79;
    boxes[79] = box80;
    boxes[80] = box81;


    topPawn = box5;
    topPawn.setBackground(Game.players[0].color);
    buttonPawn = box77;
    buttonPawn.setBackground(Game.players[1].color);

    for(int i = 0; i < 128; i++){
        JButton theWall = walls[i];
        theWall.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                inputGUIWalls(theWall);
                disableBadWalls();
                inputGUIWalls(theWall);
            }
        });
    }

    for(int i = 0; i < 81; i++){
        JButton theBox = boxes[i];
        theBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(inputGUIBoxes(theBox)){
                    if(Game.currentPlayer == Game.players[0]){
                        topPawn.setBackground(BOX_COLOR);
                        topPawn = theBox;
                    } else{
                        buttonPawn.setBackground(BOX_COLOR);
                        buttonPawn = theBox;
                    }
                    theBox.setBackground(Game.currentPlayer.color);
                    Game.board.updateBoard(Wall.wallsCoordinations);
                    if(Game.otherPlayer.equals(Game.players[0])){
                        player2Label.setVisible(false);
                        player1Label.setVisible(true);
                    }else {
                        player1Label.setVisible(false);
                        player2Label.setVisible(true);
                    }
                    turnCounter++;
                    turnCounter %= 2;
                }
                if(winnerCheck()){
                    //System.out.println(theWinner + " is the Winner!!!");
                    Music.bcmStop();
                    setVisible(false);
                    dispose();
                    new MatchWinnerPage(theWinner);
                }
                //Game.board.print(Game.players[0].bead, Game.players[1].bead);
            }
        });
    }

    muteButton.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            Music.bcmStop();
        }
    });

    muteButton.addMouseListener(new MouseListener(){
        @Override
        public void mouseClicked(MouseEvent e){

        }

        @Override
        public void mousePressed(MouseEvent e){

        }

        @Override
        public void mouseReleased(MouseEvent e){

        }

        @Override
        public void mouseEntered(MouseEvent e){
            muteButton.setBounds(muteButton.getX()-2,muteButton.getY()-2,muteButton.getWidth(),muteButton.getHeight());
        }

        @Override
        public void mouseExited(MouseEvent e){
            muteButton.setBounds(muteButton.getX()+2,muteButton.getY()+2,muteButton.getWidth(),muteButton.getHeight());
        }
    });



    //to create the walls that are loading
    if(isLoaded){
        if(!topPawn.equals(boxes[Game.players[0].bead.getP()-1])){
            topPawn.setBackground(BOX_COLOR);
            topPawn = boxes[Game.players[0].bead.getP() - 1];
            topPawn.setBackground(Game.players[0].color);
        }
        //System.out.println(Game.players[0].bead.getP());

        if(!buttonPawn.equals(boxes[Game.players[1].bead.getP()-1])){
            buttonPawn.setBackground(BOX_COLOR);
            buttonPawn = boxes[Game.players[1].bead.getP() - 1];
            buttonPawn.setBackground(Game.players[1].color);
        }
        //System.out.println(Game.players[1].bead.getP());

        Player actualCurrentPlayer = Game.currentPlayer;
        Player actualOtherPlayer = Game.otherPlayer;
        int actualP0Walls = Game.players[0].remainingWalls, actualP1Walls = Game.players[1].remainingWalls;
        for(int i = 0; i < cordX.size(); i++){
            for(JButton j:walls){
                if(j.getY() == cordY.get(i) && j.getX() == cordX.get(i)){
                    j.setBackground(SELECTED_WALL_COLOR);
                    //Game.currentPlayer.remainingWalls++;
                }
            }
        }
        try {
            disableBadWalls();
        }catch (Exception ee) {
            //ee.printStackTrace();
            System.out.println("No Walls");
        }

//        (9 * (y - 1) + x)












        Game.currentPlayer = actualCurrentPlayer;
        Game.otherPlayer = actualOtherPlayer;
        Game.players[0].remainingWalls = actualP0Walls;
        Game.players[1].remainingWalls = actualP1Walls;

        label1.setText(Game.players[0].name + "'s Remaining Walls: " + Game.players[0].remainingWalls);
        label2.setText(Game.players[1].name + "'s Remaining Walls: " + Game.players[1].remainingWalls);


    }
    Music.bcm();
    setTitle("Quoridor");
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    //loading();
}

private void inputGUIWalls(JButton theWall){

    char x1, x2;
    int y1 = 0, y2 = 0;
    Game.currentPlayer = Game.players[turnCounter];
    Game.otherPlayer = Game.players[(turnCounter + 1) % 2];


    //vertical wall
    if(theWall.getWidth() < theWall.getHeight()){
        y1 = ((theWall.getY() - 165) / 40) + 1;
        y2 = y1 + 1;
        x1 = (char) ((int) 'a' + (theWall.getX()-625 + 10) / 40);
        x2 = x1;
    }//horizontal wall
    else{
        y1 = (theWall.getY() - 165 + 10) / 40 + 1;
        y2 = y1;
        x1 = (char) ((int) 'a' + (theWall.getX() - 625) / 40);
        x2 = (char) (x1 + 1);
    }
        String input = y1 + "" + x1 + " " + y2 + x2;
    try {
        if(Wall.inputWall(input, Game.currentPlayer, Game.board)){
            theWall.setBackground(SELECTED_WALL_COLOR);
            Game.currentPlayer.remainingWalls--;
            label1.setText(Game.players[0].name + "'s Remaining Walls: " + Game.players[0].remainingWalls);
            label2.setText(Game.players[1].name + "'s Remaining Walls: " + Game.players[1].remainingWalls);
            if(Game.otherPlayer.equals(Game.players[0])){
                player2Label.setVisible(false);
                player1Label.setVisible(true);
            }else {
                player1Label.setVisible(false);
                player2Label.setVisible(true);
            }
            turnCounter++;
            turnCounter %= 2;
        }
    } catch (IOException e) {
        System.out.println("sth went wrong!");
    }
}

private Boolean inputGUIBoxes(JButton theBox){
    char x1;
    int y1;
    Game.currentPlayer = Game.players[turnCounter];
    Game.otherPlayer = Game.players[(turnCounter + 1) % 2];

    x1 = (char) ((int) 'a' + (theBox.getX() - 625)/ 40);
    y1 = (theBox.getY()-165)/ 40 + 1;

    return game.inputMovePawn(y1 + "" + x1);

}

private void disableBadWalls(){
    char x1, x2;
    int y1 = 0, y2 = 0;
    String input;
    for(JButton theWall : walls){
        if(theWall.getWidth() < theWall.getHeight()){
            y1 = ((theWall.getY() - 165) / 40) + 1;
            y2 = y1 + 1;
            x1 = (char) ((int) 'a' + (theWall.getX()-625 + 10) / 40);
            x2 = x1;
        }//horizontal wall
        else{
            y1 = (theWall.getY() - 165 + 10) / 40 + 1;
            y2 = y1;
            x1 = (char) ((int) 'a' + (theWall.getX() - 625) / 40);
            x2 = (char) (x1 + 1);
        }
        input = y1 + "" + x1 + " " + y2 + x2;

        try {
            if(Wall.inputWall(input, Game.otherPlayer, Game.board)){
                Game.board.eraseWall(Wall.wallsCoordinations.get(Wall.wallsCoordinations.size() - 1));
                Wall.wallsCoordinations.remove(Wall.wallsCoordinations.size() - 1);
                Game.board.eraseWall(Wall.wallsCoordinations.get(Wall.wallsCoordinations.size() - 1));
                Wall.wallsCoordinations.remove(Wall.wallsCoordinations.size() - 1);
            }else{
                if(theWall.getBackground().equals(WALL_COLOR))
                    theWall.setVisible(false);
            }
        } catch (IOException e) {
            System.out.println("Error!");
        }

    }


}

private boolean winnerCheck(){
    int topLocation = 0, buttonLocation = 0;

    for(int i = 0; i < 81; i++)
        if(topPawn.equals(boxes[i])){
            topLocation = i;
            break;
        }
    if(topLocation > 72){
        theWinner = Game.players[0];
        Game.winner = Game.players[0];
        Game.loser = Game.players[1];
        isGameEnded = true;
        return true;
    }
    for(int i = 0; i < 81; i++)
        if(buttonPawn.equals(boxes[i])){
            buttonLocation = i;
            break;
        }
    if(buttonLocation < 9){
        theWinner = Game.players[1];
        Game.winner = Game.players[1];
        Game.loser = Game.players[0];
        isGameEnded = true;
        return true;
    }
    isGameEnded = false;
    return false;
}

private void buttonMouseClicked(MouseEvent e) {
    Music.click();
}

void loading(){
    Thread pb = new Thread(new Runnable() {
        @Override
        public void run() {
        int i = 0;
        try {
            while (i<=100){
                progressBar1.setValue(i);
                label3.setText(Integer.toString(i));
                Thread.sleep(200);
                i+=10;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        progressBar1.setVisible(false);
        label3.setVisible(false);
        labelb.setVisible(false);
        label4.setVisible(false);
        labela.setVisible(false);
        }
    });pb.start();
    }

    private void thisMouseEntered(MouseEvent e) {
        // TODO add your code here
        loading();
    }
private void initComponents(){
    // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
    // Generated using JFormDesigner Evaluation license - Aref
    label3 = new JLabel();
    label4 = new JLabel();
    progressBar1 = new JProgressBar();
    labelb = new JLabel();
    labela = new JLabel();
    box1 = new JButton();
    wall1 = new JButton();
    box2 = new JButton();
    wall2 = new JButton();
    box3 = new JButton();
    wall3 = new JButton();
    box4 = new JButton();
    wall4 = new JButton();
    box5 = new JButton();
    wall5 = new JButton();
    box6 = new JButton();
    wall6 = new JButton();
    box7 = new JButton();
    wall7 = new JButton();
    box8 = new JButton();
    wall8 = new JButton();
    box9 = new JButton();
    wall9 = new JButton();
    wall10 = new JButton();
    wall11 = new JButton();
    wall12 = new JButton();
    wall13 = new JButton();
    wall14 = new JButton();
    wall15 = new JButton();
    wall16 = new JButton();
    box10 = new JButton();
    wall17 = new JButton();
    box11 = new JButton();
    wall18 = new JButton();
    box12 = new JButton();
    wall19 = new JButton();
    box13 = new JButton();
    wall20 = new JButton();
    box14 = new JButton();
    wall21 = new JButton();
    box15 = new JButton();
    wall22 = new JButton();
    box16 = new JButton();
    wall23 = new JButton();
    box17 = new JButton();
    wall24 = new JButton();
    box18 = new JButton();
    wall25 = new JButton();
    wall26 = new JButton();
    wall27 = new JButton();
    wall28 = new JButton();
    wall29 = new JButton();
    wall30 = new JButton();
    wall31 = new JButton();
    wall32 = new JButton();
    box19 = new JButton();
    wall33 = new JButton();
    box20 = new JButton();
    wall34 = new JButton();
    box21 = new JButton();
    wall35 = new JButton();
    box22 = new JButton();
    wall36 = new JButton();
    box23 = new JButton();
    wall37 = new JButton();
    box24 = new JButton();
    wall38 = new JButton();
    box25 = new JButton();
    wall39 = new JButton();
    box26 = new JButton();
    wall40 = new JButton();
    box27 = new JButton();
    wall41 = new JButton();
    wall42 = new JButton();
    wall43 = new JButton();
    wall44 = new JButton();
    wall45 = new JButton();
    wall46 = new JButton();
    wall47 = new JButton();
    wall48 = new JButton();
    box28 = new JButton();
    wall49 = new JButton();
    box29 = new JButton();
    wall50 = new JButton();
    box30 = new JButton();
    wall51 = new JButton();
    box31 = new JButton();
    wall52 = new JButton();
    box32 = new JButton();
    wall53 = new JButton();
    box33 = new JButton();
    wall54 = new JButton();
    box34 = new JButton();
    wall55 = new JButton();
    box35 = new JButton();
    wall56 = new JButton();
    box36 = new JButton();
    wall57 = new JButton();
    wall58 = new JButton();
    wall59 = new JButton();
    wall60 = new JButton();
    wall61 = new JButton();
    wall62 = new JButton();
    wall63 = new JButton();
    wall64 = new JButton();
    box37 = new JButton();
    wall65 = new JButton();
    box38 = new JButton();
    wall66 = new JButton();
    box39 = new JButton();
    wall67 = new JButton();
    box40 = new JButton();
    wall68 = new JButton();
    box41 = new JButton();
    wall69 = new JButton();
    box42 = new JButton();
    wall70 = new JButton();
    box43 = new JButton();
    wall71 = new JButton();
    box44 = new JButton();
    wall72 = new JButton();
    box45 = new JButton();
    wall73 = new JButton();
    wall74 = new JButton();
    wall75 = new JButton();
    wall76 = new JButton();
    wall77 = new JButton();
    wall78 = new JButton();
    wall79 = new JButton();
    wall80 = new JButton();
    box46 = new JButton();
    wall81 = new JButton();
    box47 = new JButton();
    wall82 = new JButton();
    box48 = new JButton();
    wall83 = new JButton();
    box49 = new JButton();
    wall84 = new JButton();
    box50 = new JButton();
    wall85 = new JButton();
    box51 = new JButton();
    wall86 = new JButton();
    box52 = new JButton();
    wall87 = new JButton();
    box53 = new JButton();
    wall88 = new JButton();
    box54 = new JButton();
    wall89 = new JButton();
    wall90 = new JButton();
    wall91 = new JButton();
    wall92 = new JButton();
    wall93 = new JButton();
    wall94 = new JButton();
    wall95 = new JButton();
    wall96 = new JButton();
    box55 = new JButton();
    wall97 = new JButton();
    box56 = new JButton();
    wall98 = new JButton();
    box57 = new JButton();
    wall99 = new JButton();
    box58 = new JButton();
    wall100 = new JButton();
    box59 = new JButton();
    wall101 = new JButton();
    box60 = new JButton();
    wall102 = new JButton();
    box61 = new JButton();
    wall103 = new JButton();
    box62 = new JButton();
    wall104 = new JButton();
    box63 = new JButton();
    wall105 = new JButton();
    wall106 = new JButton();
    wall107 = new JButton();
    wall108 = new JButton();
    wall109 = new JButton();
    wall110 = new JButton();
    wall111 = new JButton();
    wall112 = new JButton();
    box64 = new JButton();
    wall113 = new JButton();
    box65 = new JButton();
    wall114 = new JButton();
    box66 = new JButton();
    wall115 = new JButton();
    box67 = new JButton();
    wall116 = new JButton();
    box68 = new JButton();
    wall117 = new JButton();
    box69 = new JButton();
    wall118 = new JButton();
    box70 = new JButton();
    wall119 = new JButton();
    box71 = new JButton();
    wall120 = new JButton();
    box72 = new JButton();
    wall121 = new JButton();
    wall122 = new JButton();
    wall123 = new JButton();
    wall124 = new JButton();
    wall125 = new JButton();
    wall126 = new JButton();
    wall127 = new JButton();
    wall128 = new JButton();
    box73 = new JButton();
    box74 = new JButton();
    box75 = new JButton();
    box76 = new JButton();
    box77 = new JButton();
    box78 = new JButton();
    box79 = new JButton();
    box80 = new JButton();
    box81 = new JButton();
    button2 = new JButton();

    //======== this ========
    setResizable(false);
    setBackground(new Color(0, 204, 204));
    addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            thisMouseEntered(e);
        }
    });
    var contentPane = getContentPane();
    contentPane.setLayout(null);

    //---- label3 ----
    label3.setText("01");
    label3.setForeground(Color.white);
    label3.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 48));
    contentPane.add(label3);
    label3.setBounds(510, 205, 75, 75);

    //---- label4 ----
    label4.setText("%");
    label4.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 48));
    label4.setForeground(Color.white);
    contentPane.add(label4);
    label4.setBounds(new Rectangle(new Point(570, 215), label4.getPreferredSize()));

    //---- progressBar1 ----
    progressBar1.setBackground(Color.black);
    progressBar1.setForeground(Color.white);
    progressBar1.setStringPainted(true);
    contentPane.add(progressBar1);
    progressBar1.setBounds(395, 470, 295, 15);

    //---- labelb ----
    labelb.setText("text");
    labelb.setIcon(new ImageIcon(getClass().getResource("\\Resources\\load.gif")));
    contentPane.add(labelb);
    labelb.setBounds(315, 25, 460, 435);

    //---- labela ----
    labela.setText("text");
    labela.setIcon(new ImageIcon(getClass().getResource("\\Resources\\black.png")));
    contentPane.add(labela);
    labela.setBounds(0, 0, 1090, 665);

    //---- box1 ----
    box1.setBackground(new Color(204, 255, 255));
    box1.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box1);
    box1.setBounds(625, 165, 30, 30);

    //---- wall1 ----
    wall1.setBackground(new Color(0, 204, 204));
    wall1.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall1);
    wall1.setBounds(655, 165, 10, 70);

    //---- box2 ----
    box2.setBackground(new Color(204, 255, 255));
    box2.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box2);
    box2.setBounds(665, 165, 30, 30);

    //---- wall2 ----
    wall2.setBackground(new Color(0, 204, 204));
    wall2.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall2);
    wall2.setBounds(695, 165, 10, 70);

    //---- box3 ----
    box3.setBackground(new Color(204, 255, 255));
    box3.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box3);
    box3.setBounds(705, 165, 30, 30);

    //---- wall3 ----
    wall3.setBackground(new Color(0, 204, 204));
    wall3.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall3);
    wall3.setBounds(735, 165, 10, 70);

    //---- box4 ----
    box4.setBackground(new Color(204, 255, 255));
    box4.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box4);
    box4.setBounds(745, 165, 30, 30);

    //---- wall4 ----
    wall4.setBackground(new Color(0, 204, 204));
    wall4.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall4);
    wall4.setBounds(775, 165, 10, 70);

    //---- box5 ----
    box5.setBackground(new Color(204, 255, 255));
    box5.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box5);
    box5.setBounds(785, 165, 30, 30);

    //---- wall5 ----
    wall5.setBackground(new Color(0, 204, 204));
    wall5.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall5);
    wall5.setBounds(815, 165, 10, 70);

    //---- box6 ----
    box6.setBackground(new Color(204, 255, 255));
    box6.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box6);
    box6.setBounds(825, 165, 30, 30);

    //---- wall6 ----
    wall6.setBackground(new Color(0, 204, 204));
    wall6.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall6);
    wall6.setBounds(855, 165, 10, 70);

    //---- box7 ----
    box7.setBackground(new Color(204, 255, 255));
    box7.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box7);
    box7.setBounds(865, 165, 30, 30);

    //---- wall7 ----
    wall7.setBackground(new Color(0, 204, 204));
    wall7.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall7);
    wall7.setBounds(895, 165, 10, 70);

    //---- box8 ----
    box8.setBackground(new Color(204, 255, 255));
    box8.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box8);
    box8.setBounds(905, 165, 30, 30);

    //---- wall8 ----
    wall8.setBackground(new Color(0, 204, 204));
    wall8.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall8);
    wall8.setBounds(935, 165, 10, 70);

    //---- box9 ----
    box9.setBackground(new Color(204, 255, 255));
    box9.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box9);
    box9.setBounds(945, 165, 30, 30);

    //---- wall9 ----
    wall9.setBackground(new Color(0, 204, 204));
    wall9.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall9);
    wall9.setBounds(625, 195, 70, 10);

    //---- wall10 ----
    wall10.setBackground(new Color(0, 204, 204));
    wall10.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall10);
    wall10.setBounds(665, 195, 70, 10);

    //---- wall11 ----
    wall11.setBackground(new Color(0, 204, 204));
    wall11.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall11);
    wall11.setBounds(705, 195, 70, 10);

    //---- wall12 ----
    wall12.setBackground(new Color(0, 204, 204));
    wall12.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall12);
    wall12.setBounds(745, 195, 70, 10);

    //---- wall13 ----
    wall13.setBackground(new Color(0, 204, 204));
    wall13.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall13);
    wall13.setBounds(785, 195, 70, 10);

    //---- wall14 ----
    wall14.setBackground(new Color(0, 204, 204));
    wall14.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall14);
    wall14.setBounds(825, 195, 70, 10);

    //---- wall15 ----
    wall15.setBackground(new Color(0, 204, 204));
    wall15.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall15);
    wall15.setBounds(865, 195, 70, 10);

    //---- wall16 ----
    wall16.setBackground(new Color(0, 204, 204));
    wall16.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall16);
    wall16.setBounds(905, 195, 70, 10);

    //---- box10 ----
    box10.setBackground(new Color(204, 255, 255));
    box10.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box10);
    box10.setBounds(625, 205, 30, 30);

    //---- wall17 ----
    wall17.setBackground(new Color(0, 204, 204));
    wall17.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall17);
    wall17.setBounds(655, 205, 10, 70);

    //---- box11 ----
    box11.setBackground(new Color(204, 255, 255));
    box11.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box11);
    box11.setBounds(665, 205, 30, 30);

    //---- wall18 ----
    wall18.setBackground(new Color(0, 204, 204));
    wall18.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall18);
    wall18.setBounds(695, 205, 10, 70);

    //---- box12 ----
    box12.setBackground(new Color(204, 255, 255));
    box12.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box12);
    box12.setBounds(705, 205, 30, 30);

    //---- wall19 ----
    wall19.setBackground(new Color(0, 204, 204));
    wall19.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall19);
    wall19.setBounds(735, 205, 10, 70);

    //---- box13 ----
    box13.setBackground(new Color(204, 255, 255));
    box13.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box13);
    box13.setBounds(745, 205, 30, 30);

    //---- wall20 ----
    wall20.setBackground(new Color(0, 204, 204));
    wall20.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall20);
    wall20.setBounds(775, 205, 10, 70);

    //---- box14 ----
    box14.setBackground(new Color(204, 255, 255));
    box14.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box14);
    box14.setBounds(785, 205, 30, 30);

    //---- wall21 ----
    wall21.setBackground(new Color(0, 204, 204));
    wall21.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall21);
    wall21.setBounds(815, 205, 10, 70);

    //---- box15 ----
    box15.setBackground(new Color(204, 255, 255));
    box15.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box15);
    box15.setBounds(825, 205, 30, 30);

    //---- wall22 ----
    wall22.setBackground(new Color(0, 204, 204));
    wall22.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall22);
    wall22.setBounds(855, 205, 10, 70);

    //---- box16 ----
    box16.setBackground(new Color(204, 255, 255));
    box16.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box16);
    box16.setBounds(865, 205, 30, 30);

    //---- wall23 ----
    wall23.setBackground(new Color(0, 204, 204));
    wall23.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall23);
    wall23.setBounds(895, 205, 10, 70);

    //---- box17 ----
    box17.setBackground(new Color(204, 255, 255));
    box17.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box17);
    box17.setBounds(905, 205, 30, 30);

    //---- wall24 ----
    wall24.setBackground(new Color(0, 204, 204));
    wall24.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall24);
    wall24.setBounds(935, 205, 10, 70);

    //---- box18 ----
    box18.setBackground(new Color(204, 255, 255));
    box18.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box18);
    box18.setBounds(945, 205, 30, 30);

    //---- wall25 ----
    wall25.setBackground(new Color(0, 204, 204));
    wall25.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall25);
    wall25.setBounds(625, 235, 70, 10);

    //---- wall26 ----
    wall26.setBackground(new Color(0, 204, 204));
    wall26.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall26);
    wall26.setBounds(665, 235, 70, 10);

    //---- wall27 ----
    wall27.setBackground(new Color(0, 204, 204));
    wall27.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall27);
    wall27.setBounds(705, 235, 70, 10);

    //---- wall28 ----
    wall28.setBackground(new Color(0, 204, 204));
    wall28.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall28);
    wall28.setBounds(745, 235, 70, 10);

    //---- wall29 ----
    wall29.setBackground(new Color(0, 204, 204));
    wall29.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall29);
    wall29.setBounds(785, 235, 70, 10);

    //---- wall30 ----
    wall30.setBackground(new Color(0, 204, 204));
    wall30.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall30);
    wall30.setBounds(825, 235, 70, 10);

    //---- wall31 ----
    wall31.setBackground(new Color(0, 204, 204));
    wall31.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall31);
    wall31.setBounds(865, 235, 70, 10);

    //---- wall32 ----
    wall32.setBackground(new Color(0, 204, 204));
    wall32.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall32);
    wall32.setBounds(905, 235, 70, 10);

    //---- box19 ----
    box19.setBackground(new Color(204, 255, 255));
    box19.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box19);
    box19.setBounds(625, 245, 30, 30);

    //---- wall33 ----
    wall33.setBackground(new Color(0, 204, 204));
    wall33.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall33);
    wall33.setBounds(655, 245, 10, 70);

    //---- box20 ----
    box20.setBackground(new Color(204, 255, 255));
    box20.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box20);
    box20.setBounds(665, 245, 30, 30);

    //---- wall34 ----
    wall34.setBackground(new Color(0, 204, 204));
    wall34.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall34);
    wall34.setBounds(695, 245, 10, 70);

    //---- box21 ----
    box21.setBackground(new Color(204, 255, 255));
    box21.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box21);
    box21.setBounds(705, 245, 30, 30);

    //---- wall35 ----
    wall35.setBackground(new Color(0, 204, 204));
    wall35.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall35);
    wall35.setBounds(735, 245, 10, 70);

    //---- box22 ----
    box22.setBackground(new Color(204, 255, 255));
    box22.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box22);
    box22.setBounds(745, 245, 30, 30);

    //---- wall36 ----
    wall36.setBackground(new Color(0, 204, 204));
    wall36.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall36);
    wall36.setBounds(775, 245, 10, 70);

    //---- box23 ----
    box23.setBackground(new Color(204, 255, 255));
    box23.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box23);
    box23.setBounds(785, 245, 30, 30);

    //---- wall37 ----
    wall37.setBackground(new Color(0, 204, 204));
    wall37.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall37);
    wall37.setBounds(815, 245, 10, 70);

    //---- box24 ----
    box24.setBackground(new Color(204, 255, 255));
    box24.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box24);
    box24.setBounds(825, 245, 30, 30);

    //---- wall38 ----
    wall38.setBackground(new Color(0, 204, 204));
    wall38.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall38);
    wall38.setBounds(855, 245, 10, 70);

    //---- box25 ----
    box25.setBackground(new Color(204, 255, 255));
    box25.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box25);
    box25.setBounds(865, 245, 30, 30);

    //---- wall39 ----
    wall39.setBackground(new Color(0, 204, 204));
    wall39.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall39);
    wall39.setBounds(895, 245, 10, 70);

    //---- box26 ----
    box26.setBackground(new Color(204, 255, 255));
    box26.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box26);
    box26.setBounds(905, 245, 30, 30);

    //---- wall40 ----
    wall40.setBackground(new Color(0, 204, 204));
    wall40.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall40);
    wall40.setBounds(935, 245, 10, 70);

    //---- box27 ----
    box27.setBackground(new Color(204, 255, 255));
    box27.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box27);
    box27.setBounds(945, 245, 30, 30);

    //---- wall41 ----
    wall41.setBackground(new Color(0, 204, 204));
    wall41.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall41);
    wall41.setBounds(625, 275, 70, 10);

    //---- wall42 ----
    wall42.setBackground(new Color(0, 204, 204));
    wall42.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall42);
    wall42.setBounds(665, 275, 70, 10);

    //---- wall43 ----
    wall43.setBackground(new Color(0, 204, 204));
    wall43.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall43);
    wall43.setBounds(705, 275, 70, 10);

    //---- wall44 ----
    wall44.setBackground(new Color(0, 204, 204));
    wall44.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall44);
    wall44.setBounds(745, 275, 70, 10);

    //---- wall45 ----
    wall45.setBackground(new Color(0, 204, 204));
    wall45.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall45);
    wall45.setBounds(785, 275, 70, 10);

    //---- wall46 ----
    wall46.setBackground(new Color(0, 204, 204));
    wall46.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall46);
    wall46.setBounds(825, 275, 70, 10);

    //---- wall47 ----
    wall47.setBackground(new Color(0, 204, 204));
    wall47.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall47);
    wall47.setBounds(865, 275, 70, 10);

    //---- wall48 ----
    wall48.setBackground(new Color(0, 204, 204));
    wall48.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall48);
    wall48.setBounds(905, 275, 70, 10);

    //---- box28 ----
    box28.setBackground(new Color(204, 255, 255));
    box28.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box28);
    box28.setBounds(625, 285, 30, 30);

    //---- wall49 ----
    wall49.setBackground(new Color(0, 204, 204));
    wall49.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall49);
    wall49.setBounds(655, 285, 10, 70);

    //---- box29 ----
    box29.setBackground(new Color(204, 255, 255));
    box29.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box29);
    box29.setBounds(665, 285, 30, 30);

    //---- wall50 ----
    wall50.setBackground(new Color(0, 204, 204));
    wall50.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall50);
    wall50.setBounds(695, 285, 10, 70);

    //---- box30 ----
    box30.setBackground(new Color(204, 255, 255));
    box30.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box30);
    box30.setBounds(705, 285, 30, 30);

    //---- wall51 ----
    wall51.setBackground(new Color(0, 204, 204));
    wall51.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall51);
    wall51.setBounds(735, 285, 10, 70);

    //---- box31 ----
    box31.setBackground(new Color(204, 255, 255));
    box31.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box31);
    box31.setBounds(745, 285, 30, 30);

    //---- wall52 ----
    wall52.setBackground(new Color(0, 204, 204));
    wall52.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall52);
    wall52.setBounds(775, 285, 10, 70);

    //---- box32 ----
    box32.setBackground(new Color(204, 255, 255));
    box32.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box32);
    box32.setBounds(785, 285, 30, 30);

    //---- wall53 ----
    wall53.setBackground(new Color(0, 204, 204));
    wall53.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall53);
    wall53.setBounds(815, 285, 10, 70);

    //---- box33 ----
    box33.setBackground(new Color(204, 255, 255));
    box33.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box33);
    box33.setBounds(825, 285, 30, 30);

    //---- wall54 ----
    wall54.setBackground(new Color(0, 204, 204));
    wall54.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall54);
    wall54.setBounds(855, 285, 10, 70);

    //---- box34 ----
    box34.setBackground(new Color(204, 255, 255));
    box34.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box34);
    box34.setBounds(865, 285, 30, 30);

    //---- wall55 ----
    wall55.setBackground(new Color(0, 204, 204));
    wall55.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall55);
    wall55.setBounds(895, 285, 10, 70);

    //---- box35 ----
    box35.setBackground(new Color(204, 255, 255));
    box35.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box35);
    box35.setBounds(905, 285, 30, 30);

    //---- wall56 ----
    wall56.setBackground(new Color(0, 204, 204));
    wall56.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall56);
    wall56.setBounds(935, 285, 10, 70);

    //---- box36 ----
    box36.setBackground(new Color(204, 255, 255));
    box36.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box36);
    box36.setBounds(945, 285, 30, 30);

    //---- wall57 ----
    wall57.setBackground(new Color(0, 204, 204));
    wall57.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall57);
    wall57.setBounds(625, 315, 70, 10);

    //---- wall58 ----
    wall58.setBackground(new Color(0, 204, 204));
    wall58.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall58);
    wall58.setBounds(665, 315, 70, 10);

    //---- wall59 ----
    wall59.setBackground(new Color(0, 204, 204));
    wall59.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall59);
    wall59.setBounds(705, 315, 70, 10);

    //---- wall60 ----
    wall60.setBackground(new Color(0, 204, 204));
    wall60.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall60);
    wall60.setBounds(745, 315, 70, 10);

    //---- wall61 ----
    wall61.setBackground(new Color(0, 204, 204));
    wall61.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall61);
    wall61.setBounds(785, 315, 70, 10);

    //---- wall62 ----
    wall62.setBackground(new Color(0, 204, 204));
    wall62.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall62);
    wall62.setBounds(825, 315, 70, 10);

    //---- wall63 ----
    wall63.setBackground(new Color(0, 204, 204));
    wall63.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall63);
    wall63.setBounds(865, 315, 70, 10);

    //---- wall64 ----
    wall64.setBackground(new Color(0, 204, 204));
    wall64.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall64);
    wall64.setBounds(905, 315, 70, 10);

    //---- box37 ----
    box37.setBackground(new Color(204, 255, 255));
    box37.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box37);
    box37.setBounds(625, 325, 30, 30);

    //---- wall65 ----
    wall65.setBackground(new Color(0, 204, 204));
    wall65.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall65);
    wall65.setBounds(655, 325, 10, 70);

    //---- box38 ----
    box38.setBackground(new Color(204, 255, 255));
    box38.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box38);
    box38.setBounds(665, 325, 30, 30);

    //---- wall66 ----
    wall66.setBackground(new Color(0, 204, 204));
    wall66.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall66);
    wall66.setBounds(695, 325, 10, 70);

    //---- box39 ----
    box39.setBackground(new Color(204, 255, 255));
    box39.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box39);
    box39.setBounds(705, 325, 30, 30);

    //---- wall67 ----
    wall67.setBackground(new Color(0, 204, 204));
    wall67.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall67);
    wall67.setBounds(735, 325, 10, 70);

    //---- box40 ----
    box40.setBackground(new Color(204, 255, 255));
    box40.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box40);
    box40.setBounds(745, 325, 30, 30);

    //---- wall68 ----
    wall68.setBackground(new Color(0, 204, 204));
    wall68.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall68);
    wall68.setBounds(775, 325, 10, 70);

    //---- box41 ----
    box41.setBackground(new Color(204, 255, 255));
    box41.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box41);
    box41.setBounds(785, 325, 30, 30);

    //---- wall69 ----
    wall69.setBackground(new Color(0, 204, 204));
    wall69.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall69);
    wall69.setBounds(815, 325, 10, 70);

    //---- box42 ----
    box42.setBackground(new Color(204, 255, 255));
    box42.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box42);
    box42.setBounds(825, 325, 30, 30);

    //---- wall70 ----
    wall70.setBackground(new Color(0, 204, 204));
    wall70.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall70);
    wall70.setBounds(855, 325, 10, 70);

    //---- box43 ----
    box43.setBackground(new Color(204, 255, 255));
    box43.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box43);
    box43.setBounds(865, 325, 30, 30);

    //---- wall71 ----
    wall71.setBackground(new Color(0, 204, 204));
    wall71.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall71);
    wall71.setBounds(895, 325, 10, 70);

    //---- box44 ----
    box44.setBackground(new Color(204, 255, 255));
    box44.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box44);
    box44.setBounds(905, 325, 30, 30);

    //---- wall72 ----
    wall72.setBackground(new Color(0, 204, 204));
    wall72.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall72);
    wall72.setBounds(935, 325, 10, 70);

    //---- box45 ----
    box45.setBackground(new Color(204, 255, 255));
    box45.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box45);
    box45.setBounds(945, 325, 30, 30);

    //---- wall73 ----
    wall73.setBackground(new Color(0, 204, 204));
    wall73.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall73);
    wall73.setBounds(625, 355, 70, 10);

    //---- wall74 ----
    wall74.setBackground(new Color(0, 204, 204));
    wall74.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall74);
    wall74.setBounds(665, 355, 70, 10);

    //---- wall75 ----
    wall75.setBackground(new Color(0, 204, 204));
    wall75.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall75);
    wall75.setBounds(705, 355, 70, 10);

    //---- wall76 ----
    wall76.setBackground(new Color(0, 204, 204));
    wall76.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall76);
    wall76.setBounds(745, 355, 70, 10);

    //---- wall77 ----
    wall77.setBackground(new Color(0, 204, 204));
    wall77.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall77);
    wall77.setBounds(785, 355, 70, 10);

    //---- wall78 ----
    wall78.setBackground(new Color(0, 204, 204));
    wall78.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall78);
    wall78.setBounds(825, 355, 70, 10);

    //---- wall79 ----
    wall79.setBackground(new Color(0, 204, 204));
    wall79.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall79);
    wall79.setBounds(865, 355, 70, 10);

    //---- wall80 ----
    wall80.setBackground(new Color(0, 204, 204));
    wall80.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall80);
    wall80.setBounds(905, 355, 70, 10);

    //---- box46 ----
    box46.setBackground(new Color(204, 255, 255));
    box46.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box46);
    box46.setBounds(625, 365, 30, 30);

    //---- wall81 ----
    wall81.setBackground(new Color(0, 204, 204));
    wall81.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall81);
    wall81.setBounds(655, 365, 10, 70);

    //---- box47 ----
    box47.setBackground(new Color(204, 255, 255));
    box47.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box47);
    box47.setBounds(665, 365, 30, 30);

    //---- wall82 ----
    wall82.setBackground(new Color(0, 204, 204));
    wall82.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall82);
    wall82.setBounds(695, 365, 10, 70);

    //---- box48 ----
    box48.setBackground(new Color(204, 255, 255));
    box48.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box48);
    box48.setBounds(705, 365, 30, 30);

    //---- wall83 ----
    wall83.setBackground(new Color(0, 204, 204));
    wall83.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall83);
    wall83.setBounds(735, 365, 10, 70);

    //---- box49 ----
    box49.setBackground(new Color(204, 255, 255));
    box49.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box49);
    box49.setBounds(745, 365, 30, 30);

    //---- wall84 ----
    wall84.setBackground(new Color(0, 204, 204));
    wall84.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall84);
    wall84.setBounds(775, 365, 10, 70);

    //---- box50 ----
    box50.setBackground(new Color(204, 255, 255));
    box50.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box50);
    box50.setBounds(785, 365, 30, 30);

    //---- wall85 ----
    wall85.setBackground(new Color(0, 204, 204));
    wall85.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall85);
    wall85.setBounds(815, 365, 10, 70);

    //---- box51 ----
    box51.setBackground(new Color(204, 255, 255));
    box51.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box51);
    box51.setBounds(825, 365, 30, 30);

    //---- wall86 ----
    wall86.setBackground(new Color(0, 204, 204));
    wall86.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall86);
    wall86.setBounds(855, 365, 10, 70);

    //---- box52 ----
    box52.setBackground(new Color(204, 255, 255));
    box52.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box52);
    box52.setBounds(865, 365, 30, 30);

    //---- wall87 ----
    wall87.setBackground(new Color(0, 204, 204));
    wall87.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall87);
    wall87.setBounds(895, 365, 10, 70);

    //---- box53 ----
    box53.setBackground(new Color(204, 255, 255));
    box53.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box53);
    box53.setBounds(905, 365, 30, 30);

    //---- wall88 ----
    wall88.setBackground(new Color(0, 204, 204));
    wall88.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall88);
    wall88.setBounds(935, 365, 10, 70);

    //---- box54 ----
    box54.setBackground(new Color(204, 255, 255));
    box54.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box54);
    box54.setBounds(945, 365, 30, 30);

    //---- wall89 ----
    wall89.setBackground(new Color(0, 204, 204));
    wall89.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall89);
    wall89.setBounds(625, 395, 70, 10);

    //---- wall90 ----
    wall90.setBackground(new Color(0, 204, 204));
    wall90.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall90);
    wall90.setBounds(665, 395, 70, 10);

    //---- wall91 ----
    wall91.setBackground(new Color(0, 204, 204));
    wall91.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall91);
    wall91.setBounds(705, 395, 70, 10);

    //---- wall92 ----
    wall92.setBackground(new Color(0, 204, 204));
    wall92.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall92);
    wall92.setBounds(745, 395, 70, 10);

    //---- wall93 ----
    wall93.setBackground(new Color(0, 204, 204));
    wall93.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall93);
    wall93.setBounds(785, 395, 70, 10);

    //---- wall94 ----
    wall94.setBackground(new Color(0, 204, 204));
    wall94.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall94);
    wall94.setBounds(825, 395, 70, 10);

    //---- wall95 ----
    wall95.setBackground(new Color(0, 204, 204));
    wall95.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall95);
    wall95.setBounds(865, 395, 70, 10);

    //---- wall96 ----
    wall96.setBackground(new Color(0, 204, 204));
    wall96.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall96);
    wall96.setBounds(905, 395, 70, 10);

    //---- box55 ----
    box55.setBackground(new Color(204, 255, 255));
    box55.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box55);
    box55.setBounds(625, 405, 30, 30);

    //---- wall97 ----
    wall97.setBackground(new Color(0, 204, 204));
    wall97.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall97);
    wall97.setBounds(655, 405, 10, 70);

    //---- box56 ----
    box56.setBackground(new Color(204, 255, 255));
    box56.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box56);
    box56.setBounds(665, 405, 30, 30);

    //---- wall98 ----
    wall98.setBackground(new Color(0, 204, 204));
    wall98.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall98);
    wall98.setBounds(695, 405, 10, 70);

    //---- box57 ----
    box57.setBackground(new Color(204, 255, 255));
    box57.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box57);
    box57.setBounds(705, 405, 30, 30);

    //---- wall99 ----
    wall99.setBackground(new Color(0, 204, 204));
    wall99.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall99);
    wall99.setBounds(735, 405, 10, 70);

    //---- box58 ----
    box58.setBackground(new Color(204, 255, 255));
    box58.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box58);
    box58.setBounds(745, 405, 30, 30);

    //---- wall100 ----
    wall100.setBackground(new Color(0, 204, 204));
    wall100.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall100);
    wall100.setBounds(775, 405, 10, 70);

    //---- box59 ----
    box59.setBackground(new Color(204, 255, 255));
    box59.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box59);
    box59.setBounds(785, 405, 30, 30);

    //---- wall101 ----
    wall101.setBackground(new Color(0, 204, 204));
    wall101.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall101);
    wall101.setBounds(815, 405, 10, 70);

    //---- box60 ----
    box60.setBackground(new Color(204, 255, 255));
    box60.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box60);
    box60.setBounds(825, 405, 30, 30);

    //---- wall102 ----
    wall102.setBackground(new Color(0, 204, 204));
    wall102.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall102);
    wall102.setBounds(855, 405, 10, 70);

    //---- box61 ----
    box61.setBackground(new Color(204, 255, 255));
    box61.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box61);
    box61.setBounds(865, 405, 30, 30);

    //---- wall103 ----
    wall103.setBackground(new Color(0, 204, 204));
    wall103.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall103);
    wall103.setBounds(895, 405, 10, 70);

    //---- box62 ----
    box62.setBackground(new Color(204, 255, 255));
    box62.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box62);
    box62.setBounds(905, 405, 30, 30);

    //---- wall104 ----
    wall104.setBackground(new Color(0, 204, 204));
    wall104.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall104);
    wall104.setBounds(935, 405, 10, 70);

    //---- box63 ----
    box63.setBackground(new Color(204, 255, 255));
    box63.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box63);
    box63.setBounds(945, 405, 30, 30);

    //---- wall105 ----
    wall105.setBackground(new Color(0, 204, 204));
    wall105.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall105);
    wall105.setBounds(625, 435, 70, 10);

    //---- wall106 ----
    wall106.setBackground(new Color(0, 204, 204));
    wall106.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall106);
    wall106.setBounds(665, 435, 70, 10);

    //---- wall107 ----
    wall107.setBackground(new Color(0, 204, 204));
    wall107.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall107);
    wall107.setBounds(705, 435, 70, 10);

    //---- wall108 ----
    wall108.setBackground(new Color(0, 204, 204));
    wall108.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall108);
    wall108.setBounds(745, 435, 70, 10);

    //---- wall109 ----
    wall109.setBackground(new Color(0, 204, 204));
    wall109.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall109);
    wall109.setBounds(785, 435, 70, 10);

    //---- wall110 ----
    wall110.setBackground(new Color(0, 204, 204));
    wall110.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall110);
    wall110.setBounds(825, 435, 70, 10);

    //---- wall111 ----
    wall111.setBackground(new Color(0, 204, 204));
    wall111.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall111);
    wall111.setBounds(865, 435, 70, 10);

    //---- wall112 ----
    wall112.setBackground(new Color(0, 204, 204));
    wall112.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall112);
    wall112.setBounds(905, 435, 70, 10);

    //---- box64 ----
    box64.setBackground(new Color(204, 255, 255));
    box64.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box64);
    box64.setBounds(625, 445, 30, 30);

    //---- wall113 ----
    wall113.setBackground(new Color(0, 204, 204));
    wall113.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall113);
    wall113.setBounds(655, 445, 10, 70);

    //---- box65 ----
    box65.setBackground(new Color(204, 255, 255));
    box65.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box65);
    box65.setBounds(665, 445, 30, 30);

    //---- wall114 ----
    wall114.setBackground(new Color(0, 204, 204));
    wall114.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall114);
    wall114.setBounds(695, 445, 10, 70);

    //---- box66 ----
    box66.setBackground(new Color(204, 255, 255));
    box66.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box66);
    box66.setBounds(705, 445, 30, 30);

    //---- wall115 ----
    wall115.setBackground(new Color(0, 204, 204));
    wall115.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall115);
    wall115.setBounds(735, 445, 10, 70);

    //---- box67 ----
    box67.setBackground(new Color(204, 255, 255));
    box67.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box67);
    box67.setBounds(745, 445, 30, 30);

    //---- wall116 ----
    wall116.setBackground(new Color(0, 204, 204));
    wall116.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall116);
    wall116.setBounds(775, 445, 10, 70);

    //---- box68 ----
    box68.setBackground(new Color(204, 255, 255));
    box68.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box68);
    box68.setBounds(785, 445, 30, 30);

    //---- wall117 ----
    wall117.setBackground(new Color(0, 204, 204));
    wall117.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall117);
    wall117.setBounds(815, 445, 10, 70);

    //---- box69 ----
    box69.setBackground(new Color(204, 255, 255));
    box69.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box69);
    box69.setBounds(825, 445, 30, 30);

    //---- wall118 ----
    wall118.setBackground(new Color(0, 204, 204));
    wall118.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall118);
    wall118.setBounds(855, 445, 10, 70);

    //---- box70 ----
    box70.setBackground(new Color(204, 255, 255));
    box70.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box70);
    box70.setBounds(865, 445, 30, 30);

    //---- wall119 ----
    wall119.setBackground(new Color(0, 204, 204));
    wall119.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall119);
    wall119.setBounds(895, 445, 10, 70);

    //---- box71 ----
    box71.setBackground(new Color(204, 255, 255));
    box71.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box71);
    box71.setBounds(905, 445, 30, 30);

    //---- wall120 ----
    wall120.setBackground(new Color(0, 204, 204));
    wall120.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall120);
    wall120.setBounds(935, 445, 10, 70);

    //---- box72 ----
    box72.setBackground(new Color(204, 255, 255));
    box72.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box72);
    box72.setBounds(945, 445, 30, 30);

    //---- wall121 ----
    wall121.setBackground(new Color(0, 204, 204));
    wall121.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall121);
    wall121.setBounds(625, 475, 70, 10);

    //---- wall122 ----
    wall122.setBackground(new Color(0, 204, 204));
    wall122.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall122);
    wall122.setBounds(665, 475, 70, 10);

    //---- wall123 ----
    wall123.setBackground(new Color(0, 204, 204));
    wall123.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall123);
    wall123.setBounds(705, 475, 70, 10);

    //---- wall124 ----
    wall124.setBackground(new Color(0, 204, 204));
    wall124.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall124);
    wall124.setBounds(745, 475, 70, 10);

    //---- wall125 ----
    wall125.setBackground(new Color(0, 204, 204));
    wall125.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall125);
    wall125.setBounds(785, 475, 70, 10);

    //---- wall126 ----
    wall126.setBackground(new Color(0, 204, 204));
    wall126.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall126);
    wall126.setBounds(825, 475, 70, 10);

    //---- wall127 ----
    wall127.setBackground(new Color(0, 204, 204));
    wall127.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall127);
    wall127.setBounds(865, 475, 70, 10);

    //---- wall128 ----
    wall128.setBackground(new Color(0, 204, 204));
    wall128.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(wall128);
    wall128.setBounds(905, 475, 70, 10);

    //---- box73 ----
    box73.setBackground(new Color(204, 255, 255));
    box73.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box73);
    box73.setBounds(625, 485, 30, 30);

    //---- box74 ----
    box74.setBackground(new Color(204, 255, 255));
    box74.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box74);
    box74.setBounds(665, 485, 30, 30);

    //---- box75 ----
    box75.setBackground(new Color(204, 255, 255));
    box75.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box75);
    box75.setBounds(705, 485, 30, 30);

    //---- box76 ----
    box76.setBackground(new Color(204, 255, 255));
    box76.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box76);
    box76.setBounds(745, 485, 30, 30);

    //---- box77 ----
    box77.setBackground(new Color(204, 255, 255));
    box77.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box77);
    box77.setBounds(785, 485, 30, 30);

    //---- box78 ----
    box78.setBackground(new Color(204, 255, 255));
    box78.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box78);
    box78.setBounds(825, 485, 30, 30);

    //---- box79 ----
    box79.setBackground(new Color(204, 255, 255));
    box79.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box79);
    box79.setBounds(865, 485, 30, 30);

    //---- box80 ----
    box80.setBackground(new Color(204, 255, 255));
    box80.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box80);
    box80.setBounds(905, 485, 30, 30);

    //---- box81 ----
    box81.setBackground(new Color(204, 255, 255));
    box81.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonMouseClicked(e);
        }
    });
    contentPane.add(box81);
    box81.setBounds(945, 485, 30, 30);

    //---- button2 ----
    button2.setEnabled(false);
    button2.setBackground(new Color(0, 204, 204));
    contentPane.add(button2);
    button2.setBounds(625, 165, 350, 350);

    {
        // compute preferred size
        Dimension preferredSize = new Dimension();
        for(int i = 0; i < contentPane.getComponentCount(); i++) {
            Rectangle bounds = contentPane.getComponent(i).getBounds();
            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
        }
        Insets insets = contentPane.getInsets();
        preferredSize.width += insets.right;
        preferredSize.height += insets.bottom;
        contentPane.setMinimumSize(preferredSize);
        contentPane.setPreferredSize(preferredSize);
    }
    pack();
    setLocationRelativeTo(getOwner());
    // JFormDesigner - End of component initialization  //GEN-END:initComponents
}

// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
// Generated using JFormDesigner Evaluation license - Aref
private JLabel label3;
private JLabel label4;
private JProgressBar progressBar1;
private JLabel labelb;
private JLabel labela;
private JButton box1;
private JButton wall1;
private JButton box2;
private JButton wall2;
private JButton box3;
private JButton wall3;
private JButton box4;
private JButton wall4;
private JButton box5;
private JButton wall5;
private JButton box6;
private JButton wall6;
private JButton box7;
private JButton wall7;
private JButton box8;
private JButton wall8;
private JButton box9;
private JButton wall9;
private JButton wall10;
private JButton wall11;
private JButton wall12;
private JButton wall13;
private JButton wall14;
private JButton wall15;
private JButton wall16;
private JButton box10;
private JButton wall17;
private JButton box11;
private JButton wall18;
private JButton box12;
private JButton wall19;
private JButton box13;
private JButton wall20;
private JButton box14;
private JButton wall21;
private JButton box15;
private JButton wall22;
private JButton box16;
private JButton wall23;
private JButton box17;
private JButton wall24;
private JButton box18;
private JButton wall25;
private JButton wall26;
private JButton wall27;
private JButton wall28;
private JButton wall29;
private JButton wall30;
private JButton wall31;
private JButton wall32;
private JButton box19;
private JButton wall33;
private JButton box20;
private JButton wall34;
private JButton box21;
private JButton wall35;
private JButton box22;
private JButton wall36;
private JButton box23;
private JButton wall37;
private JButton box24;
private JButton wall38;
private JButton box25;
private JButton wall39;
private JButton box26;
private JButton wall40;
private JButton box27;
private JButton wall41;
private JButton wall42;
private JButton wall43;
private JButton wall44;
private JButton wall45;
private JButton wall46;
private JButton wall47;
private JButton wall48;
private JButton box28;
private JButton wall49;
private JButton box29;
private JButton wall50;
private JButton box30;
private JButton wall51;
private JButton box31;
private JButton wall52;
private JButton box32;
private JButton wall53;
private JButton box33;
private JButton wall54;
private JButton box34;
private JButton wall55;
private JButton box35;
private JButton wall56;
private JButton box36;
private JButton wall57;
private JButton wall58;
private JButton wall59;
private JButton wall60;
private JButton wall61;
private JButton wall62;
private JButton wall63;
private JButton wall64;
private JButton box37;
private JButton wall65;
private JButton box38;
private JButton wall66;
private JButton box39;
private JButton wall67;
private JButton box40;
private JButton wall68;
private JButton box41;
private JButton wall69;
private JButton box42;
private JButton wall70;
private JButton box43;
private JButton wall71;
private JButton box44;
private JButton wall72;
private JButton box45;
private JButton wall73;
private JButton wall74;
private JButton wall75;
private JButton wall76;
private JButton wall77;
private JButton wall78;
private JButton wall79;
private JButton wall80;
private JButton box46;
private JButton wall81;
private JButton box47;
private JButton wall82;
private JButton box48;
private JButton wall83;
private JButton box49;
private JButton wall84;
private JButton box50;
private JButton wall85;
private JButton box51;
private JButton wall86;
private JButton box52;
private JButton wall87;
private JButton box53;
private JButton wall88;
private JButton box54;
private JButton wall89;
private JButton wall90;
private JButton wall91;
private JButton wall92;
private JButton wall93;
private JButton wall94;
private JButton wall95;
private JButton wall96;
private JButton box55;
private JButton wall97;
private JButton box56;
private JButton wall98;
private JButton box57;
private JButton wall99;
private JButton box58;
private JButton wall100;
private JButton box59;
private JButton wall101;
private JButton box60;
private JButton wall102;
private JButton box61;
private JButton wall103;
private JButton box62;
private JButton wall104;
private JButton box63;
private JButton wall105;
private JButton wall106;
private JButton wall107;
private JButton wall108;
private JButton wall109;
private JButton wall110;
private JButton wall111;
private JButton wall112;
private JButton box64;
private JButton wall113;
private JButton box65;
private JButton wall114;
private JButton box66;
private JButton wall115;
private JButton box67;
private JButton wall116;
private JButton box68;
private JButton wall117;
private JButton box69;
private JButton wall118;
private JButton box70;
private JButton wall119;
private JButton box71;
private JButton wall120;
private JButton box72;
private JButton wall121;
private JButton wall122;
private JButton wall123;
private JButton wall124;
private JButton wall125;
private JButton wall126;
private JButton wall127;
private JButton wall128;
private JButton box73;
private JButton box74;
private JButton box75;
private JButton box76;
private JButton box77;
private JButton box78;
private JButton box79;
private JButton box80;
private JButton box81;
private JButton button2;
// JFormDesigner - End of variables declaration  //GEN-END:variables
}

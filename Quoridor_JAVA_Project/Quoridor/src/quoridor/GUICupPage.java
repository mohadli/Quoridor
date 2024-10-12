/*
 * Created by JFormDesigner on Tue Aug 04 23:26:31 IRDT 2020
 */
package quoridor;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.*;

/**
 * @author Aref
 */
public class GUICupPage extends JFrame {
    static ArrayList<Player> cupPlayers = new ArrayList<Player>();
    static Player pp;
    static int n; // n of players
    static int nOfRounds = 0; //n of rounds
    static int r = 0;  //round
    static int nOfMatches = 1;
    static int currentMatch = 1;
    JLabel background;
    String text = "";
    boolean countinue = false;
    vs thisTeam;
    static ArrayList<vs> teams = new ArrayList<vs>();
    int roundCount = 0, matchCount = 0;
    int tempPlayer = 0, oddguy = 0;
    double nn = n;
    static Game g;
    static vs team;

    public GUICupPage() {

        initComponents();
        try {
            background = new JLabel(new ImageIcon(getClass().getResource("\\Resources\\P12.png")));
            background.setBounds(0, 0, 1100, 700);
            add(background);
            start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        nextMatch.setEnabled(false);
        mohasebat.setEnabled(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1100, 700);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void start() throws IOException {
        for (double i = nn; i > 1; i = i / 2) nOfRounds++;
        text = text.concat(nOfRounds + " = n of rounds,  " + cupPlayers.size() + " = n of players\n\n");
    }

    private void button1ActionPerformed(ActionEvent e) {
        countinue = true;
    }

    private void button1MousePressed(MouseEvent e) {
        countinue = true;
    }

    private void button1MouseReleased(MouseEvent e) {
        countinue = false;
    }

    //match
    private void button2ActionPerformed(ActionEvent e) {
        Music.round();
        nextMatch.setEnabled(false);
        System.out.println(teams.size());
        team = teams.get(matchCount);
        team.p1.setTheTopPlayer(true);
        team.p2.setTheTopPlayer(false);
        g = new Game(team.p1, team.p2);
        Thread tt = new Thread(new Runnable() {
            @Override
            public void run() {
                GUI singlePlayerGUI = new GUI(g, false); //GUI
            }
        });
        tt.start();
        mohasebat.setEnabled(true);
    }
    //round
    private void button3ActionPerformed(ActionEvent e) {
        matchCount = 0;
        System.out.println(teams.size() +"SIZE");
        if (r > 0) n = n - (teams.size() / 2) - 1;
        teams.clear();
        text = text.concat("\n Round : " + (r+1  ) + "\n");
        int n2 = n % 2, n3 = n - n2;
        System.out.println(n +"NNNNNNNN");
        //odd guy story
        if (n2 > 0) {
            tempPlayer = ThreadLocalRandom.current().nextInt(0, n - 1);
            cupPlayers.get(tempPlayer).played++;
            cupPlayers.get(tempPlayer).won++;
            oddguy = tempPlayer;
        }
        for (int counterOfteams = 0; counterOfteams < n3 / 2; counterOfteams++) { //selecting teams
            Player[] temp = new Player[]{null, null}; //two temp players for each team
            for (int playern = 0; playern < 2; playern++) { //selecting 2 player for each team
                boolean flag = true;
                while (flag) { //selecting a qualified random player from arr of players
                    tempPlayer = ThreadLocalRandom.current().nextInt(0, n); //choosing a random player
                    System.out.println(cupPlayers.get(tempPlayer).played);
                    if ((cupPlayers.get(tempPlayer).played == r)) { //&& (cupPlayers.get(tempPlayer).won == r)) {
                        flag = false;
                    }
                }
                temp[playern] = cupPlayers.get(tempPlayer);
                cupPlayers.get(tempPlayer).played++;
            }
            vs v = new vs(temp[0], temp[1]);
            teams.add(0, v);
        }
        int match = 1;
        if (n2 > 0) {
            text = text.concat("match 0 " + " : " + cupPlayers.get(oddguy).name + " (rest)\n");
        }
        for (vs team : teams) {
            text = text.concat("match " + match + " : " + team.p1.name + " vs " + team.p2.name + "\n");
            match++;
        }
        textPane1.setText(text);
        nOfMatches = match;
        currentMatch = 1;
        r++;
        nextMatch.setEnabled(true);
        nextRound.setEnabled(false);
        mohasebat.setEnabled(false);
    }
    //status
    private void button4MouseClicked(MouseEvent e) {
        //System.out.println("AAA" + cupPlayers.size() + "AA" + currentMatch + "A" + nOfMatches + "Q" + r + "W" + nOfRounds + " " + matchCount + "   " + teams.size());
        team.winner = g.getWinner();
        team.loser = g.getLoser();
        cupPlayers.remove(team.loser);
        text = "Winner of the last match : " + team.winner.name;
        textPane1.setText(text);
        matchCount++;
        if (cupPlayers.size() == 1) {
            new CupWinnerPage(cupPlayers.get(0));
            Music.winner();
            nextMatch.setEnabled(false);
            nextRound.setEnabled(false);
        } else {
            if (matchCount == teams.size()) {
            nextRound.setEnabled(true);
            nextMatch.setEnabled(false);
            }
            else {
                nextRound.setEnabled(false);
                nextMatch.setEnabled(true);
            }
            currentMatch++;
            mohasebat.setEnabled(false);
        }
        //System.out.println("AAA" + cupPlayers.size() + "AA" + currentMatch + "A" + nOfMatches + "Q" + r + "W" + nOfRounds + " " + matchCount + "   " + teams.size());
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        scrollPane1 = new JScrollPane();
        textPane1 = new JTextPane();
        button1 = new JButton();
        nextRound = new JButton();
        nextMatch = new JButton();
        mohasebat = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- textPane1 ----
            textPane1.setFont(new Font("Fira Code Medium", Font.BOLD, 20));
            textPane1.setBackground(Color.black);
            textPane1.setForeground(Color.white);
            scrollPane1.setViewportView(textPane1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(370, 165, 325, 375);

        //---- button1 ----
        button1.setText("OK");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button1MousePressed(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                button1MouseReleased(e);
            }
        });
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(490, 555), button1.getPreferredSize()));

        //---- nextRound ----
        nextRound.setText("Ghore Keshi");
        nextRound.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
        nextRound.addActionListener(e -> {
            button3ActionPerformed(e);
            //	button3ActionPerformed(e);
            //	button3ActionPerformed(e);
            //	button3ActionPerformed(e);
        });
        contentPane.add(nextRound);
        nextRound.setBounds(110, 390, 200, nextRound.getPreferredSize().height);

        //---- nextMatch ----
        nextMatch.setText("Playing the Match");
        nextMatch.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
        nextMatch.addActionListener(e -> {
            button2ActionPerformed(e);
//			button2ActionPerformed(e);
        });
        contentPane.add(nextMatch);
        nextMatch.setBounds(110, 480, 200, nextMatch.getPreferredSize().height);

        //---- mohasebat ----
        mohasebat.setText("Game Status");
        mohasebat.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button4MouseClicked(e);
//            button4MouseClicked(e);
            }
        });
        contentPane.add(mohasebat);
        mohasebat.setBounds(110, 305, 200, mohasebat.getPreferredSize().height);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for (int i = 0; i < contentPane.getComponentCount(); i++) {
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
// Generated using JFormDesigner Evaluation license - unknown
    private JScrollPane scrollPane1;
    private JTextPane textPane1;
    private JButton button1;
    private JButton nextRound;
    private JButton nextMatch;
    private JButton mohasebat;
// JFormDesigner - End of variables declaration  //GEN-END:variables
}

/*
 * Created by JFormDesigner on Tue Aug 04 05:18:47 IRDT 2020
 */

package quoridor;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * @author Aref
 */
public class FormPage extends JFrame {

JLabel background, announcer;
int numberOfNames, count;
static final int AI = 1;
static final int TWO_PLAYERS = 2;

public ArrayList <Player> playerArrayList = new ArrayList<>();

    public FormPage(int num) {
        numberOfNames = num;

        announcer = new JLabel("Player "+(count+1)+":");
        announcer.setBounds(600,173,135,80);
        announcer.setForeground(new Color(221, 247, 255 ));
        announcer.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
        add(announcer);

        initComponents();
        try {
            background = new JLabel(new ImageIcon(getClass().getResource("\\Resources\\P11.png")));
            background.setBounds(0,0,1100,700);
            add(background);
        }catch (Exception e){
            System.out.println("Error!!");
        }
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1100,700);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    private void button1ActionPerformed(ActionEvent e) {
        if(numberOfNames > count){
            playerArrayList.add(new Player(textField1.getText()));

            count++;
            textField1.setText("");
        }
        if(numberOfNames == count){
            //AI mode
            if(count == 1){
                Game game = new Game(playerArrayList.get(0),new Player("Smart AI"));
                RandomAiBoard ai = new RandomAiBoard(game);
            }
            //normal mode
            if(count == 2){
                Game game = new Game(playerArrayList.get(0), playerArrayList.get(1));
                GUI singlePlayerGUI = new GUI(game,false);
            }//cup mode
            if(count > 2){
                for(int i = 0; i < count; i++){
                    GUICupPage.cupPlayers.add(playerArrayList.get(i));
                }

                GUICupPage.n = numberOfNames;
                GUICupPage guiCupPage = new GUICupPage();
            }
            dispose();
        }
        announcer.setText("Player "+(count+1)+":");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        textField1 = new JTextField();
        label1 = new JLabel();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- textField1 ----
        textField1.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 24));
        contentPane.add(textField1);
        textField1.setBounds(525, 305, 200, 40);

        //---- label1 ----
        label1.setText("Name: ");
        label1.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 24));
        label1.setBackground(Color.white);
        label1.setForeground(Color.white);
        contentPane.add(label1);
        label1.setBounds(440, 305, 105, 35);

        //---- button1 ----
        button1.setText("Submit");
        button1.setFont(new Font("Fira Code Retina", Font.BOLD, 24));
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1);
        button1.setBounds(520, 415, 130, 45);

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
    // Generated using JFormDesigner Evaluation license - unknown
    private JTextField textField1;
    private JLabel label1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

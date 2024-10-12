/*
 * Created by JFormDesigner on Tue Aug 04 03:22:35 IRDT 2020
 */

package quoridor;

import java.awt.*;
import javax.swing.*;

/**
 * @author Aref
 */
public class CupWinnerPage extends JFrame {
JLabel background, text;
Player winner;
    public CupWinnerPage(Player player) {
        this.winner = player;
        initComponents();
        Music.winner();
        text = new JLabel("       "+winner.name + " is the WINNER!!!");
        text.setBounds(230,530,630,100);
        text.setForeground(new Color(221, 247, 255 ));
        text.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 50));
        add(text);

        try {
            background = new JLabel(new ImageIcon(getClass().getResource("\\Resources\\P10.png")));
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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Aref

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

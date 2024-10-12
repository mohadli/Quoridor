/*
 * Created by JFormDesigner on Mon Aug 03 00:48:07 IRDT 2020
 */

package quoridor;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;


/**
 * @author Aref
 */
public class MainMenu extends JFrame{

Image roundButtonImage;
Image roundButtonImageSelected;
Image help;

Image SP1,SP2,TP1,TP2,C1,C2,L1,L2;



JButton[] buttons = new JButton[4];

public MainMenu(){

    try {

        UIManager.put("Button.select", Color.black);
        initComponents();


        BufferedImage backGround = ImageIO.read(this.getClass().getResource("\\Resources\\P7.png"));
        Image backGroundImage = backGround.getScaledInstance(1100, 700, Image.SCALE_SMOOTH);
        JLabel backgroundIcon = new JLabel(new ImageIcon(backGroundImage));
        backgroundIcon.setBounds(0, 0, 1100, 700);
        add(backgroundIcon);

        roundButtonImage = ImageIO.read(this.getClass().getResource("\\Resources\\btt1.png"));

        roundButtonImageSelected = ImageIO.read(this.getClass().getResource("\\Resources\\btt1Selected.png"));


        SP1 = ImageIO.read(this.getClass().getResource("\\Resources\\SP1.png"));
        SP2 = ImageIO.read(this.getClass().getResource("\\Resources\\SP2.png"));
        TP1 = ImageIO.read(this.getClass().getResource("\\Resources\\TP1.png"));
        TP2 = ImageIO.read(this.getClass().getResource("\\Resources\\TP2.png"));
        C1 = ImageIO.read(this.getClass().getResource("\\Resources\\C1.png"));
        C2 = ImageIO.read(this.getClass().getResource("\\Resources\\C2.png"));
        L1 = ImageIO.read(this.getClass().getResource("\\Resources\\L1.png"));
        L2 = ImageIO.read(this.getClass().getResource("\\Resources\\L2.png"));

        help = ImageIO.read(this.getClass().getResource("\\Resources\\h.png"));

    } catch (Exception e) {
        System.out.println("Error!");
    }
    button1.setIcon(new ImageIcon(SP1));
    button2.setIcon(new ImageIcon(TP1));
    button3.setIcon(new ImageIcon(C1));
    button4.setIcon(new ImageIcon(L1));
    button5.setIcon(new ImageIcon(help));
    buttons[0] = button1;
    buttons[1] = button2;
    buttons[2] = button3;
    buttons[3] = button4;
    Music.menu();




    setSize(1100, 700);
    setVisible(true);
}

private void button1MouseEntered(MouseEvent e) {
    button1.setIcon(new ImageIcon(SP2));
}

private void button1MouseExited(MouseEvent e) {
    button1.setIcon(new ImageIcon(SP1));
}

private void button2MouseEntered(MouseEvent e) {
    button2.setIcon(new ImageIcon(TP2));
}

private void button2MouseExited(MouseEvent e) {
    button2.setIcon(new ImageIcon(TP1));
}

private void button3MouseEntered(MouseEvent e) {
    button3.setIcon(new ImageIcon(C2));
}

private void button3MouseExited(MouseEvent e) {
    button3.setIcon(new ImageIcon(C1));
}

private void button4MouseEntered(MouseEvent e) {
    button4.setIcon(new ImageIcon(L2));
}

private void button4MouseExited(MouseEvent e) {
    button4.setIcon(new ImageIcon(L1));
}

private void buttonsMousePressed(MouseEvent e){
    if(e.getSource().equals(button1))
        button1.setBounds(button1.getX()-2,button1.getY()-2,200,200);
    if(e.getSource().equals(button2))
        button2.setBounds(button2.getX()-2,button2.getY()-2,200,200);
    if(e.getSource().equals(button3))
        button3.setBounds(button3.getX()-2,button3.getY()-2,200,200);
    if(e.getSource().equals(button4))
        button4.setBounds(button4.getX()-2,button4.getY()-2,200,200);
    if(e.getSource().equals(button5))
        button5.setBounds(button5.getX()-2,button5.getY()-2,128,74);
}

private void buttonsMouseReleased(MouseEvent e){
    if(e.getSource().equals(button1))
        button1.setBounds(button1.getX()+2,button1.getY()+2,200,200);
    if(e.getSource().equals(button2))
        button2.setBounds(button2.getX()+2,button2.getY()+2,200,200);
    if(e.getSource().equals(button3))
        button3.setBounds(button3.getX()+2,button3.getY()+2,200,200);
    if(e.getSource().equals(button4))
        button4.setBounds(button4.getX()+2,button4.getY()+2,200,200);
    if(e.getSource().equals(button5))
        button5.setBounds(button5.getX()+2,button5.getY()+2,128,74);
}

private void button1ActionPerformed(ActionEvent e) {
    Music.menuStop();
    FormPage twoPlayerForm = new FormPage(FormPage.AI);
    dispose();
}

private void button2ActionPerformed(ActionEvent e){
    Music.menuStop();
    FormPage twoPlayerForm = new FormPage(FormPage.TWO_PLAYERS);
    dispose();
}

private void button3ActionPerformed(ActionEvent e) {
    Music.menuStop();
    int numberOfPlayers;
    while(true){
        try {
            String num = JOptionPane.showInputDialog(this, "Number of Players:");
            numberOfPlayers = Integer.parseInt(num);
            break;
        }catch (Exception ee){}
    }

    FormPage cupForm = new FormPage(numberOfPlayers);
    dispose();
}

private void buttonsMouseClicked(MouseEvent e) {
    Music.menuStop();
}

private void helpMouseClicked(ActionEvent e) throws IOException {
    // TODO add your code here
    File file = new File("Help.pdf");
    //first check if Desktop is supported by Platform or not
    if(!Desktop.isDesktopSupported()){
        System.out.println("Desktop is not supported");
        return;
    }
    Desktop desktop = Desktop.getDesktop();
    if(file.exists()) desktop.open(file);
}

private void button5MouseEntered(MouseEvent e) {
    button5.setBounds(button5.getX()-2,button5.getY()-2,128,74);
}

private void button5MouseExited(MouseEvent e) {
    button5.setBounds(button5.getX()+2,button5.getY()+2,128,74);
}

private void button4ActionPerformed(ActionEvent e) {
    Music.menuStop();
    LoadGUI loadGUI = new LoadGUI();
    dispose();
}






private void initComponents(){
    // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
    // Generated using JFormDesigner Evaluation license - unknown
    button1 = new JButton();
    button2 = new JButton();
    button3 = new JButton();
    button4 = new JButton();
    button5 = new JButton();

    //======== this ========
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setResizable(false);
    var contentPane = getContentPane();
    contentPane.setLayout(null);

    //---- button1 ----
    button1.setForeground(Color.white);
    button1.setBackground(Color.black);
    button1.setBorder(null);
    button1.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonsMouseClicked(e);
        }
        @Override
        public void mouseEntered(MouseEvent e) {
            button1MouseEntered(e);
        }
        @Override
        public void mouseExited(MouseEvent e) {
            button1MouseExited(e);
        }
        @Override
        public void mousePressed(MouseEvent e) {
            buttonsMousePressed(e);
        }
        @Override
        public void mouseReleased(MouseEvent e) {
            buttonsMouseReleased(e);
        }
    });
    button1.addActionListener(e -> button1ActionPerformed(e));
    contentPane.add(button1);
    button1.setBounds(130, 390, 200, 200);

    //---- button2 ----
    button2.setBackground(Color.black);
    button2.setBorder(null);
    button2.setForeground(Color.white);
    button2.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonsMouseClicked(e);
        }
        @Override
        public void mouseEntered(MouseEvent e) {
            button2MouseEntered(e);
        }
        @Override
        public void mouseExited(MouseEvent e) {
            button2MouseExited(e);
        }
        @Override
        public void mousePressed(MouseEvent e) {
            buttonsMousePressed(e);
        }
        @Override
        public void mouseReleased(MouseEvent e) {
            buttonsMouseReleased(e);
        }
    });
    button2.addActionListener(e -> button2ActionPerformed(e));
    contentPane.add(button2);
    button2.setBounds(370, 390, 200, 200);

    //---- button3 ----
    button3.setBackground(Color.black);
    button3.setOpaque(false);
    button3.setForeground(Color.white);
    button3.setBorder(null);
    button3.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonsMouseClicked(e);
        }
        @Override
        public void mouseEntered(MouseEvent e) {
            button3MouseEntered(e);
        }
        @Override
        public void mouseExited(MouseEvent e) {
            button3MouseExited(e);
        }
        @Override
        public void mousePressed(MouseEvent e) {
            buttonsMousePressed(e);
        }
        @Override
        public void mouseReleased(MouseEvent e) {
            buttonsMouseReleased(e);
        }
    });
    button3.addActionListener(e -> button3ActionPerformed(e));
    contentPane.add(button3);
    button3.setBounds(610, 390, 200, 200);

    //---- button4 ----
    button4.setBackground(Color.black);
    button4.setBorder(null);
    button4.setForeground(Color.white);
    button4.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            buttonsMouseClicked(e);
        }
        @Override
        public void mouseEntered(MouseEvent e) {
            button4MouseEntered(e);
        }
        @Override
        public void mouseExited(MouseEvent e) {
            button4MouseExited(e);
        }
        @Override
        public void mousePressed(MouseEvent e) {
            buttonsMousePressed(e);
        }
        @Override
        public void mouseReleased(MouseEvent e) {
            buttonsMouseReleased(e);
        }
    });
    button4.addActionListener(e -> button4ActionPerformed(e));
    contentPane.add(button4);
    button4.setBounds(850, 390, 200, 200);

    //---- button5 ----
    button5.setText("text");
    button5.setForeground(Color.black);
    button5.setBackground(Color.black);
    button5.setBorder(null);
    button5.addActionListener(e -> {
        try {
            helpMouseClicked(e);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    });
    button5.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            button5MouseEntered(e);
        }
        @Override
        public void mouseExited(MouseEvent e) {
            button5MouseExited(e);
        }
    });
    contentPane.add(button5);
    button5.setBounds(5, 5, 128, 74);

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
private JButton button1;
private JButton button2;
private JButton button3;
private JButton button4;
private JButton button5;
// JFormDesigner - End of variables declaration  //GEN-END:variables


}


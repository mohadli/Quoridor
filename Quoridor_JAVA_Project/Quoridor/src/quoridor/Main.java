package quoridor;


import jaco.mp3.player.MP3Player;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public GUI gui;

    public static void main(String[] args) throws IOException {
        Player p1 = new Player("P1");
        Player p2 = new Player("P2");
        Game game = new Game(p1,p2);
        mainMenuT(p1,p2,game);
    }

    public static void mainMenuT(Player p1,Player p2,Game game) throws IOException {
        save.file();
        System.out.println("\u001B[35m" + "\u2694\uFE0F" + "Welcome to this game! " + "\u2694\uFE0F" +"\u001B[30m");
        System.out.println("\u001B[34m" +"\uD83C\uDF00" + "0.GUI \n" +"\uD83C\uDF00"+"1.New 2P game\n"+"\uD83C\uDF00"+"2.Load \n"+"\uD83C\uDF00"+"3.Cup\n"+"\uD83C\uDF00"+"4.Play with AI"+"\u001B[30m");
        Scanner sc = new Scanner(System.in);

        switch (sc.next()) {
            case "0":
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new MainMenu();
                    }
                });
                break;
            case "1":
                System.out.println("Enter the first player's name : ");
                p1.name= sc.next();
                System.out.println("Enter the Second player's name : ");
                p2.name= sc.next();
                System.out.println("Ex: '2c 3c' > wall ,or '2e' > move \n");
                game.play();
                break;
            case "2":
                save.load();
                game.play();
                break;
            case "3":
                cup.start(0);
                break;
            case "4":
                System.out.println("Enter the first player's name : ");
                p1.name = sc.next();
                p2.name = "Ai";
                p2.ai = true;
                System.out.println("Ex: '2c 3c' > wall ,or '2e' > move \n");
                game.play();
            default:
                System.out.println("wrong entery!");
                mainMenuT(p1,p2,game);
                break;
        }
    }
}
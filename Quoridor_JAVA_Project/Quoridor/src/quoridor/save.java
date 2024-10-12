package quoridor;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class save {
    public save() throws IOException {
    }
    public static String nobat;
    public static void file() throws IOException {
        try {
            File myObj = new File("data.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("Load option is available");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void saveGame() throws IOException {
        FileWriter writer = new FileWriter("data.txt", false);
        String c = "";
        try {
            PrintWriter pr = new PrintWriter(writer);
            pr.println(Game.currentPlayer.bead.toString2() +" "+ Game.currentPlayer.name +" "+ Game.currentPlayer.remainingWalls +" "+ Game.currentPlayer.isTheTopPlayer+" "+Game.currentPlayer.ai  );
            pr.println(Game.otherPlayer.bead.toString2() +" "+ Game.otherPlayer.name +" "+ Game.otherPlayer.remainingWalls +" "+ Game.otherPlayer.isTheTopPlayer+" "+Game.otherPlayer.ai  );
            for (boolean a : Wall.hWalls)
                pr.print(a + " ");
            pr.println();
            for (boolean a : Wall.vWalls)
                pr.print(a + " ");
            pr.println();
            if( Game.currentPlayer == Game.players[1]) pr.print("0");
            else pr.print("1");
            pr.println();
            for (Bead a : Wall.wallsCoordinations)
                pr.print(a.toString2() + "%");
            pr.close();
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void load() throws IOException {
        int linesNumber = 0;
        String str;
        String content = "";
        FileReader reader = new FileReader("data.txt");
        BufferedReader br = new BufferedReader(reader);
        while ((str = br.readLine()) != null) {
            linesNumber++;
        }
        int n=1;
        String[] a = (Files.readAllLines(Paths.get("data.txt")).get(0)).split(" ");
        Game.players[n].bead.x = Integer.parseInt(a[0]);
        Game.players[n].bead.y = Integer.parseInt(a[1]);
        Game.players[n].bead.sign = a[2];
        Game.players[n].name = a[3];
        Game.players[n].remainingWalls = Integer.parseInt(a[4]);
        Game.players[n].isTheTopPlayer = Boolean.parseBoolean(a[5]);
        Game.players[n].ai = Boolean.parseBoolean(a[6]);
        //System.out.println(Game.players[n].bead.getP());

        n=0;
        a = (Files.readAllLines(Paths.get("data.txt")).get(1)).split(" ");
        Game.players[n].bead.x = Integer.parseInt(a[0]);
        Game.players[n].bead.y = Integer.parseInt(a[1]);
        Game.players[n].bead.sign = a[2];
        Game.players[n].name = a[3];
        Game.players[n].remainingWalls = Integer.parseInt(a[4]);
        Game.players[n].isTheTopPlayer = Boolean.parseBoolean(a[5]);
        Game.players[n].ai = Boolean.parseBoolean(a[6]);
        //System.out.println(Game.players[n].bead.getP());


        String[] b = (Files.readAllLines(Paths.get("data.txt")).get(2)).split(" ");
        for (int i = 0; i < 100; i++) Wall.hWalls[i] = Boolean.parseBoolean(b[i]);
        b = (Files.readAllLines(Paths.get("data.txt")).get(3)).split(" ");
        for (int i = 0; i < 100; i++) Wall.vWalls[i] = Boolean.parseBoolean(b[i]);
        if(linesNumber>5) {
            String[] c = (Files.readAllLines(Paths.get("data.txt")).get(5)).split("%");
            System.out.println(c[1]);
            for (String ss : c) {
                String[] cc = ss.split(" ");
                Bead bb = new Bead(Integer.parseInt(cc[0]), Integer.parseInt(cc[1]), cc[2]);
                Wall.wallsCoordinations.add(0, bb);
            }
        }
        save.nobat = Files.readAllLines(Paths.get("data.txt")).get(4);
        Game.board.updateBoard(Wall.wallsCoordinations);


    }
}
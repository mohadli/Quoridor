package quoridor;

import java.util.concurrent.ThreadLocalRandom;

public class RandomAI {
    static String str(Player p) {
        int x1 = 0, y1 = 0, x2 = 0, y2 = 0, p1 = 0, p2 = 0;

        if (ThreadLocalRandom.current().nextBoolean() && ThreadLocalRandom.current().nextBoolean() && p.remainingWalls > 0) { //wall , 25%chance
            if (ThreadLocalRandom.current().nextBoolean()) { //horizontal wall
                x1 = ThreadLocalRandom.current().nextInt(2, 9 + 1);
                y1 = ThreadLocalRandom.current().nextInt(97, 104 + 1);
                y2 = y1 + 1;
                x2 = x1;
            } else { // horizontal wall
                x1 = ThreadLocalRandom.current().nextInt(1, 8 + 1);
                y1 = ThreadLocalRandom.current().nextInt(97, 105 + 1);
                y2 = y1;
                x2 = x1 + 1;
            }

            String x1s = Integer.toString(x1);
            String x2s = Integer.toString(x2);
            char y1c = (char) y1;
            char y2c = (char) y2;
            String y1s = Character.toString(y1c);
            String y2s = Character.toString(y2c);
            return x1s + y1s + " " + x2s + y2s;
        } else { //move
            p1 = p.bead.getP();
            int ch = ThreadLocalRandom.current().nextInt(1, 5);
            switch (ch) {
                case 1:
                    p2 = p1 + 1;
                    break;
                case 2:
                    p2 = p1 - 1;
                    break;
                case 3:
                    p2 = p1 + 9;
                    break;
                case 4:
                    p2 = p1 - 9;
                    break;
            }
            Game.okHelper(p2);
            y2 = Game.newx;
            x2 = Game.newy;
            char y2c = (char) ((int) 'a' + y2 - 1);
            String x2s = Integer.toString(x2);
            String y2s = Character.toString(y2c);
            return x2s + y2s;
        }
    }
}
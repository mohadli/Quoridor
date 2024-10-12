package quoridor;
import jaco.mp3.player.MP3Player;
import java.io.File;
public class Music {
static MP3Player player = new MP3Player();
static MP3Player m = new MP3Player();

public static void bcm() { //background music thread
    Thread t = new Thread(new Runnable() {
        @Override
        public void run() {
            player.addToPlayList(new File("music/everything.mp3"));
            player.addToPlayList(new File("music/lp.mp3"));
            player.addToPlayList(new File("music/numb.mp3"));
            player.setRepeat(true);
            player.setShuffle(true);
            player.play();
        }
    }); t.start();
}
public static void bcmStop() {
    player.stop();
}
public static void menu(){ m.addToPlayList(new File("music/menu.mp3")); m.play(); }
public static void click(){
    new MP3Player(new File("music/click2.mp3")).play();
}
public static void round(){
    new MP3Player(new File("music/round.mp3")).play();
}
public static void winner(){
    new MP3Player(new File("music/winner.mp3")).play();
}
public static void menuStop(){
    m.stop();
}
}

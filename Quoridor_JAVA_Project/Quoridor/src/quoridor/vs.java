package quoridor;

public class vs {
        Player p1;
        Player p2;
        Player winner;
        Player loser;
        public vs (Player p1, Player p2){
            this.p1=p1;
            this.p2=p2;
        }
        public Player getWinner() { return winner ; }
        public Player getLoser() { return loser ; }
        public void setWinner(Player p) { this.winner = p ; }
        public void setLoser(Player p) { this.loser = p ; }
        public Player getP1() { return p1 ; }
}

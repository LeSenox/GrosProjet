import model.Board;
import model.Game;
import view.BoardView;

public class Main {
    public static void main(String[] args) {
        Board b = new Board();
        Game g = new Game(b);
        new BoardView(g);
    }
}
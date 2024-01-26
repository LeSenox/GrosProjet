package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import model.Board;
import model.Coordinate;
import model.Game;
import model.tile.Tile;
import utils.Observer;
import utils.Subject;
import java.awt.Point;

public class BoardView extends JFrame implements Observer{
    
    private static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    private static final int SCREEN_WIDTH = (int)SCREEN_SIZE.getWidth();
    private static final int SCREEN_HEIGHT = (int)SCREEN_SIZE.getHeight();
    private static final int WIDTH = (int)(SCREEN_WIDTH * (2.0 / 3.0));
    private static final int HEIGHT = (int)(SCREEN_HEIGHT * (2.0 / 3.0));

    protected Point center(){
        return new Point((SCREEN_WIDTH - getWidth()) / 2, (SCREEN_HEIGHT - getHeight()) / 2);
    }

    public BoardView(Game game){
        setSize(WIDTH,HEIGHT);
        setLocation(center());
        setTitle("Dice Dungeon");
        game.attach(this);
        add(new BoardCanvas(game.board));
        setVisible(true);
    }

    @Override
    public void update(Subject game) {
        repaint();
    }

    @Override
    public void update(Subject game, Object data) {
        if(data instanceof Coordinate){
            
        }else if(data instanceof Tile){
            repaint();
        }
    }


}

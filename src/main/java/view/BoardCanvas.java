package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.Board;
import model.Coordinate;

public class BoardCanvas extends JPanel{
    protected Board boardounet;
    private static final int TILE_SIZE = 40;
    
    public BoardCanvas(Board board){
        boardounet = board;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        paintBoard(g);
    }

    public void paintBoard(Graphics g){
        int i = 0;
        for(Coordinate c : boardounet.tiles.keySet()){
            paintTile(g, c, i++);
        }System.out.println(i);
    }

    public void paintTile(Graphics g, Coordinate c, int i){
        g.setColor(Color.GREEN);
        int xPos = getWidth()/2 + (int)(c.x * TILE_SIZE * 1.2); 
        int yPos = getHeight()/2 + (int)(c.y * TILE_SIZE * 1.2);
        g.fillRect(xPos, yPos, TILE_SIZE, TILE_SIZE);
        g.setColor(Color.BLACK);
        g.drawString(i + "", xPos, yPos + TILE_SIZE);
    }
}

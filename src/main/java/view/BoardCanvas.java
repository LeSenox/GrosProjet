package view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Set;
import java.util.Map.Entry;

import javax.swing.JPanel;

import model.Board;
import model.Coordinate;
import model.tile.Tile;

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
        /*
        int i = 0;
        for(Coordinate c : boardounet.tiles.keySet()){
            paintTile(g, c, i++);
        }System.out.println(i);
        */

        for(Entry<Coordinate, Tile> e : boardounet.tiles.entrySet()){
            paintTile(g, e.getKey(), e.getValue());
        }
    }

    public void paintTile(Graphics g, Coordinate c, Tile t){
        int xPos = getWidth()/2 + (int)(c.x * TILE_SIZE * 1.2); 
        int yPos = getHeight()/2 + (int)(c.y * TILE_SIZE * 1.2);
        g.setColor(Color.BLACK);
        g.fillRect(xPos-2, yPos-2, TILE_SIZE+4, TILE_SIZE+4);
        g.setColor(t.getColor());
        g.fillRect(xPos, yPos, TILE_SIZE, TILE_SIZE);
        g.setColor(Color.BLACK);
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
package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import model.tile.Tile;

public class Board {
    
    private Map<Coordinate,Tile> tiles;
    private Random random;

    public Board(){
        tiles = new HashMap<>();
    }

    public void generateBoard(){
        
    }
}

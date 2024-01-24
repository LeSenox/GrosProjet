package model.tile;

import java.awt.Color;

public class TreasureTile implements Tile{

    @Override
    public void doTile() {
                
    }

    @Override
    public String getName() {
        return "Treasure";
    }

    @Override
    public int getRarity() {
        return 10;
    }

    @Override
    public Color getColor(){
        return Color.YELLOW;
    }

}

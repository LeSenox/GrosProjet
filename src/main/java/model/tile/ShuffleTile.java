package model.tile;

import java.awt.Color;

public class ShuffleTile implements Tile{
    @Override
    public void doTile() {
                
    }

    @Override
    public String getName() {
        return "Shuffle";
    }

    @Override
    public int getRarity() {
        return 10;
    }
       
    @Override
    public Color getColor(){
        return Color.MAGENTA;
    }

}

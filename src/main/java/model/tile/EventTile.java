package model.tile;

import java.awt.Color;

public class EventTile implements Tile{

    @Override
    public void doTile() {
        
    }

    @Override
    public String getName() {
        return "Event";
    }

    @Override
    public int getRarity() {
        return 15;
    }

    @Override
    public Color getColor(){
        return Color.BLUE;
    }

}

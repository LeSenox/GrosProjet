package model.tile;

import java.awt.Color;

public class MonsterTile implements Tile{
    @Override
    public void doTile() {
                
    }

    @Override
    public String getName() {
        return "Monster";
    }

    @Override
    public int getRarity() {
        return 35;
    }
       
    @Override
    public Color getColor(){
        return Color.ORANGE;
    }

}

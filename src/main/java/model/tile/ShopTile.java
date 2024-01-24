package model.tile;

import java.awt.Color;

public class ShopTile implements Tile{
    @Override
    public void doTile() {
                
    }

    @Override
    public String getName() {
        return "Shop";
    }

    @Override
    public int getRarity() {
        return 20;
    }
       
    @Override
    public Color getColor(){
        return Color.GREEN;
    }

}

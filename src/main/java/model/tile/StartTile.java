package model.tile;

public class StartTile implements Tile {

    @Override
    public String getName() {
        return "Start";
    }

    @Override
    public int getRarity() {
        return 0;
    }

    @Override
    public void doTile() {
        System.out.println("start");
    }
    
}

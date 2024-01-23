package model;

public class TilePos extends Coordinate{
    public Coordinate[] nextTiles;
    public TilePos(int x, int y, Coordinate[] next){
        super(x, y);
        nextTiles = next.clone();
    }

    public TilePos(int x, int y){
        this(x, y, new Coordinate[]{});
    }

    public TilePos(int x, int y, Coordinate next){
        this(x, y, new Coordinate[]{next});
    }

    public TilePos(Coordinate c){
        this(c.x, c.y);
    }

    public String toString(){
        StringBuilder s = new StringBuilder(super.toString());
        if(nextTiles.length > 0)
        s.append(" -> " + nextTiles[0]);
        return s.toString();
    }

}

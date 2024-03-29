package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

import model.tile.ShopTile;
import model.tile.StartTile;
import model.tile.Tile;
import model.tile.TileFactory;

public class Board{
    public static final int DEFAULTBOARDSIZE = 8;

    public int length;
    public int height;
    public Map<Coordinate,Tile> tiles;
    private static Random random = new Random();

    public Board(int length, int height){
        this.length = length;
        this.height = height;
        tiles = new HashMap<>();
        generateBoardV3();
        getDimensions();
    }

    public Board(){
        this(DEFAULTBOARDSIZE, DEFAULTBOARDSIZE);
    }

    public void getDimensions(){
        int maxX = 0;
        int maxY = 0;
        int minX = 0;
        int minY = 0;
        for(Entry<Coordinate, Tile> t : tiles.entrySet()){
            if(t.getKey().x > maxX) maxX = t.getKey().x;
            if(t.getKey().y > maxY) maxY = t.getKey().y;
            if(t.getKey().x < minX) minX = t.getKey().x;
            if(t.getKey().y < minY) minY = t.getKey().y;
        }
        length = maxX - minX;
        height = maxY - minY;
    }

    public void generateBoardV2(){
        TilePos pos = new TilePos(0,0);
        pos = createPathToPointV2(pos, getCorner(true, true));
        pos = createPathToPointV2(pos, getCorner(false, true));
        pos = createPathToPointV2(pos, getCorner(false, false));
        pos = createPathToPointV2(pos, new Coordinate(0, 0));
        pos.nextTiles = new Coordinate[]{new Coordinate(0,0)};
        tiles.put(pos, new ShopTile());

    }

    public void generateBoardV3(){
        TilePos pos = new TilePos(0,0);
        pos = createPathToPointV2(pos, new Coordinate(3, -4));        
        pos = createPathToPointV2(pos, getCorner(true, true));
        pos = createPathToPointV2(pos, new Coordinate(12, 4));        
        pos = createPathToPointV2(pos, new Coordinate(10, 5));        
        pos = createPathToPointV2(pos, getCorner(false, true));
        pos = createPathToPointV2(pos, new Coordinate(3, 4));        

        pos = createPathToPointV2(pos, getCorner(false, false));
        pos = createPathToPointV2(pos, new Coordinate(-3, 4));        

        pos = createPathToPointV2(pos, new Coordinate(0, 0));
        pos.nextTiles = new Coordinate[]{new Coordinate(0,0)};
        tiles.put(pos, TileFactory.createTile());
    }

    public TilePos createPathToPointV2(TilePos pos, Coordinate point){
        Coordinate c = pos;
        while(!(c = c.towardCoordinate(point)).equals(point)){
            if(!tiles.containsKey(c)){
                pos.nextTiles = new Coordinate[]{c};
                System.out.println(pos.toString());
                if(pos.x == 0 && pos.y == 0){
                    tiles.put(pos, new StartTile());
                }
                else tiles.put(pos, TileFactory.createTile());
                pos = new TilePos(c);
            }
        }
        return pos;
    }

    public Coordinate getCorner(boolean onTop, boolean onRight){
        int x = onRight ? random.nextInt(length, length + 1) : random.nextInt(-1, 0);
        int y = onTop ? random.nextInt(-1, 0) : random.nextInt(height, height + 1);
        return new Coordinate(x, y);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Coordinate c : tiles.keySet()){
            sb.append(c.toString() + "\n");
        }return sb.toString();
    }


    ////////////// OLD ///////////////////////

    public void generateBoard(){
        Coordinate pos = new Coordinate(0,0);
        tiles.put(pos, TileFactory.createTile());
        pos = createPathToPoint(pos, getCorner(true, true));
        pos = createPathToPoint(pos, getCorner(false, true));
        pos = createPathToPoint(pos, getCorner(false, false));
        createPathToPoint(pos, new Coordinate(0, 0));

    }

    public Coordinate createPathToPoint(Coordinate pos, Coordinate point){
        System.out.println("point " + point.toString());
        Coordinate c = pos.clone();
        while(!(c = c.towardCoordinate(point)).equals(point)){
            if(!tiles.containsKey(c)){
                tiles.put(c, TileFactory.createTile());
            }
        }
        tiles.put(c, new StartTile());
        return c;
    }


}

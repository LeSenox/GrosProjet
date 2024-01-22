package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import model.tile.StartTile;
import model.tile.Tile;

public class Board {
    public static final int DEFAULTBOARDSIZE = 8;

    public int length;
    public int width;
    private Map<Coordinate,Tile> tiles;
    private static Random random = new Random();

    public Board(int length, int width){
        this.length = length;
        this.width = width;
        tiles = new HashMap<>();
    }

    public Board(){
        this(DEFAULTBOARDSIZE, DEFAULTBOARDSIZE);
    }

    public void generateBoard(){
        Coordinate pos = new Coordinate(0,0);
        tiles.put(pos, new StartTile());
        pos = createPathToPoint(pos, getCorner(true, true));
        pos = createPathToPoint(pos, getCorner(false, true));
        pos = createPathToPoint(pos, getCorner(false, false));
        createPathToPoint(pos, new Coordinate(0, 0));

    }

    public Coordinate createPathToPoint(Coordinate pos, Coordinate point){
        System.out.println("POS" + pos.toString());
        Coordinate c = pos.clone();
        while(!(c = c.towardCoordinate(point)).equals(point)){
            if(!tiles.containsKey(c)) tiles.put(c, new StartTile());
        }
        return c;
    }

    public Coordinate getCorner(boolean onTop, boolean onRight){
        int x = onRight ? random.nextInt(length, length + 1) : random.nextInt(-1, 0);
        int y = onTop ? random.nextInt(-1, 0) : random.nextInt(width, width + 1);
        return new Coordinate(x, y);
    }

    /*
     *  Stack<Cellule> p = new Stack<Cellule>();
        p.push(new Cellule(maze.getMonsterSpawn().getCol(),maze.getMonsterSpawn().getRow()));
        maze.putMark(p.peek().toCoord()); 
        while(!p.isEmpty()){
            Cellule c = p.peek();
            if(maze.isExit(c.toCoord())){
                return true;
            }else{
                if(c.ouest().estPassageNonMarque(maze)){
                    maze.putMark(c.ouest().toCoord());
                    p.push(c.ouest());
                }else if(c.est().estPassageNonMarque(maze)){
                    maze.putMark(c.est().toCoord());
                    p.push(c.est());
                }else if(c.nord().estPassageNonMarque(maze)){
                    maze.putMark(c.nord().toCoord());
                    p.push(c.nord());
                }else if(c.sud().estPassageNonMarque(maze)){
                    maze.putMark(c.sud().toCoord());
                    p.push(c.sud());
                }else{
                    p.pop();
                }
            }
        }
        return false;
    }

     */

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Coordinate c : tiles.keySet()){
            sb.append(c.toString() + "\n");
        }return sb.toString();
    }
}

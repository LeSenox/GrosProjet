package model;

import java.util.Random;

public class Coordinate{
    protected int x;
    protected int y;

    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Coordinate other = (Coordinate) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }

    public Coordinate towardCoordinate(Coordinate c){
        Coordinate newC = (Coordinate)this.clone();
        if(new Random().nextBoolean()){
            if(x > c.x) 
                newC.x--;
            else
                newC.x++;
        }else{
            if(y > c.y)
                newC.y--;
            else 
                newC.y++;
        }
        return newC;
    }

    public Coordinate clone(){
        return new Coordinate(x, y);
    }

    public String toString(){
        return "[" + x + ";" + y + "]";
    }


}

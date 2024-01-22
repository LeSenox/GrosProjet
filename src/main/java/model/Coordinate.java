package model;

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


}

package model;

import java.util.Random;

public class Dice extends Article{
    protected int[] faces;
    private static Random rd;

    public Dice(int price, String name, int[] faces){
        super(price, name);
        this.faces = faces.clone();
        rd = new Random();
    }

    public int roll(){
        return faces[rd.nextInt(faces.length)];        
    }
    
}

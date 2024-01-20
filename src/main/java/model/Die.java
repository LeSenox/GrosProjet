package model;

import java.util.Random;

public class Die extends Article{
    protected int[] faces;
    private static Random rd;

    public Die(int price, String name, int[] faces){
        super(price, name);
        this.faces = faces.clone();
        rd = new Random();
    }

    public int roll(){
        return faces[rd.nextInt(faces.length)];        
    }
    
}

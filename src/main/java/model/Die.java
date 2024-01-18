package model;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Die extends Article{
    int[] faces;

    public Die(int price, String name, int[] faces){
        super(price, name);
        this.faces = faces.clone();
    }

    public int roll(){
    }
    
}

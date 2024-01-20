package model;

public class Equipment extends Article {
    protected Health stats;

    public Equipment(int price, String name){
        super(price, name);
        //stats = new Buff(price, price)
    }
}

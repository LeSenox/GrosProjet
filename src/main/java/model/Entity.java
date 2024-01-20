package model;

public class Entity {
    protected Health stats;
    public String name;
    protected int money;

    public Entity(String name, int money, int hp, int def, int bravery){
        stats = new Health(hp, def, bravery);
        this.name = name;
        this.money = money;
    }
}

package model.entityAssets;

import java.util.ArrayList;

public class Health {
    protected final int maxHP;
    protected int hp;
    protected int def;
    protected int bravery;
    protected ArrayList<Buff> buffList;

    public Health(int hp, int def, int bravery){
        this.maxHP = hp;
        this.hp = hp;
        this.def = def;
        this.bravery = bravery;
        buffList = new ArrayList<>();
    }

    public Health(int HP, int def){
        this(HP, def, 0);
    }

    public void damage(int dmg){
        int dmgAfterDef = dmgAfterDef(dmg); 
        if(bravery > 0) {
            int tmp = bravery;
            bravery = backToZero(bravery - dmgAfterDef);
            dmgAfterDef = backToZero(dmgAfterDef - tmp);
        }
        if(dmgAfterDef > 0){
            hp = backToZero(hp - dmgAfterDef);
        }
    }

    public int dmgAfterDef(int dmg){
        int tmp = dmg - def;
        return tmp < 0 ? 0 : tmp;
    }

    public static int backToZero(int n){
        if(n < 0) return 0;
        return n;
    }

    public void heal(int amount){
        hp = hp + amount;
        if(hp > maxHP) hp = maxHP;
    }

    public void decrementTime(){
        for(int i = buffList.size()-1 ; i > 0 ; --i){
            buffList.get(i).decrementTime();
            if(buffList.get(i).isFinished()) buffList.remove(i);
        }
    }
}

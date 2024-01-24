package model.tile;

import java.util.Random;

public class TileFactory {
    public static int shopRarity = 20;
    public static int eventRarity = 15 + shopRarity;
    public static int treasureRarity = 10 + eventRarity;
    public static int monsterRarity = 35 + treasureRarity;
    public static int backRarity = 10 + monsterRarity;
    public static int shuffleRarity = 10 + backRarity;

    public static Random r = new Random();

    public static int junctionRarity = 20;
    
    public static int bossRarity = 50;

    
    public static Tile[] tiles = new Tile[]{new ShopTile(), new EventTile(), new TreasureTile()
        , new MonsterTile()
        , new BackTile()
        , new ShuffleTile()
    };
    
    public static int raritySum = tiles[0].getRarity() + tiles[1].getRarity() + tiles[2].getRarity() + tiles[3].getRarity() + tiles[4].getRarity() + tiles[5].getRarity();

    
    public static Tile createTile(){
        int rarity = r.nextInt(0,raritySum);
        int i;
        for(i = 0 ; i < tiles.length && tiles[i].getRarity() <= rarity ; ++i){
            rarity -= tiles[i].getRarity();
        }
        return tiles[i];
    }

}

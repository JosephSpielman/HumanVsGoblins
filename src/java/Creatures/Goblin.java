package Creatures;

import Inventory.*;

import java.util.Random;

//goblin face "\uD83D\uDC79"
public class Goblin extends Humanoid{

    Loot treasure;

    public Goblin(){
        super(2,5,7,0,2,"\uD83D\uDC79");
        generateGoblinTreasure();
    }
    public Goblin(int strength, int hp, int armorClass, int posRow, int posColumn,String displayValue,Loot loot) {
        super(strength, hp, armorClass, posRow, posColumn,displayValue);

    }

    public Loot getTreasure() {
        return treasure;
    }

    public void setTreasure(Loot treasure) {
        this.treasure = treasure;
    }

    public void generateGoblinTreasure(){
        Random rnd = new Random();
        int roll = rnd.nextInt(6);
        if(roll <=1){
            this.treasure= new Loot("Bag of Dirt",1,"At least the bag is reusable.");
            return;
        }
        if (roll == 2) {
            this.treasure=new Loot("A Piece of copper ore",10,"It's better than nothing");
            return;
        }
        if(roll ==3){
            this.treasure= new Loot("Meat Haunch",10,"A standard goblin lunch");
            return;
        }
        if(roll ==4){
            this.treasure= new Loot("Ruby",100,"It's the size of a tangerine");
            return;
        }
        this.treasure =new Loot("Diamond",500,"You hit the jackpot!");
    }


    @Override
    public String toString() {
        return "Goblin{" +
                "treasure=" + treasure +
                ", strength=" + strength +
                ", hp=" + hp +
                ", armorClass=" + armorClass +
                ", posRow=" + posRow +
                ", posColumn=" + posColumn +
                ", displayValue='" + displayValue + '\'' +
                '}';
    }
}

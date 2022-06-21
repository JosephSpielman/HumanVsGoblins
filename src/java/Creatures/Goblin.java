package Creatures;
//goblin face "\uD83D\uDC79"
public class Goblin extends Humanoid{

    public Goblin(){
        super(2,5,7,0,7,"\uD83D\uDC79");
    }
    public Goblin(int strength, int hp, int armorClass, int posRow, int posColumn,String displayValue) {
        super(strength, hp, armorClass, posRow, posColumn,displayValue);
    }

}

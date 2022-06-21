package Creatures;

public class Knight extends Humanoid{
//this.getClass().getSuperclass();
int buffs;
String displayValue;
    public Knight(){
        super(2,7,10,7,0,"\uD83D\uDDE1");
        this.buffs =0;
    }


    @Override
    public int dealDamage() {

        return this.strength+this.buffs;
    }

    @Override
    public String toString() {
        return "Creatures.Knight{" +
                "buffs=" + buffs +
                ", strength=" + strength +
                ", hp=" + hp +
                ", armorClass=" + armorClass +
                ", posRow=" + posRow +
                ", posColumn=" + posColumn +
                '}';
    }
}

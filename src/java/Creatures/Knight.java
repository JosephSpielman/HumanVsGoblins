package Creatures;

import Inventory.Item;

import java.util.ArrayList;

//this.getClass().getSimpleName()
public class Knight extends Humanoid{

int buffs;
Item equipmentSlot1;
Item equipmentSlot2;
Item equipmentSlot3;

ArrayList<Item> loot = new ArrayList<>();


    public Knight(){
        super(2,7,10,2,0,"\uD83D\uDDE1");
        this.buffs =0;
    }

    public Item getEquipmentSlot1() {
        return equipmentSlot1;
    }

    public void setEquipmentSlot1(Item equipmentSlot1) {
        this.equipmentSlot1 = equipmentSlot1;
    }

    public Item getEquipmentSlot2() {
        return equipmentSlot2;
    }

    public void setEquipmentSlot2(Item equipmentSlot2) {
        this.equipmentSlot2 = equipmentSlot2;
    }

    public Item getEquipmentSlot3() {
        return equipmentSlot3;
    }

    public void setEquipmentSlot3(Item equipmentSlot3) {
        this.equipmentSlot3 = equipmentSlot3;
    }

    public ArrayList<Item> getLoot() {
        return loot;
    }

    public void setLoot(ArrayList<Item> loot) {
        this.loot = loot;
    }

    public int getBuffs() {
        return buffs;
    }

    public void setBuffs(int buffs) {
        this.buffs = buffs;
    }

    public Boolean checkIfEquipmentFull(){
        return this.getEquipmentSlot1() == null;
    }
    @Override
    public int dealDamage() {

        return this.strength+this.buffs;
    }
    public void replaceEquipment(Item in){

    }
    public void calcItemStats(Item in){
        if(in.getApplyTo().equals("buffs")){
            this.buffs +=in.getBonus();
        }
        if(in.getApplyTo().equals("curse")){
            this.buffs -= in.getCurse();
        }
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName()+"{" +
                "buffs=" + buffs +
                ", strength=" + strength +
                ", hp=" + hp +
                ", armorClass=" + armorClass +
                ", posRow=" + posRow +
                ", posColumn=" + posColumn +
                '}';
    }
}

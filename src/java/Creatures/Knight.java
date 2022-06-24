package Creatures;
import Inventory.Item;
import Inventory.Loot;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class Knight extends Humanoid{
    int buffs;
    Item equipmentSlot1;
    Item equipmentSlot2;
    Item equipmentSlot3;
    ArrayList<Loot> loot = new ArrayList<>();

    public Knight(){
        super(5,20,10,5,3,"\uD83D\uDDE1");
        this.buffs =0;
        this.equipmentSlot1 = new Item("Iron Sword",1,0,"Standard Issue Knight's sword","buffs");
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

    public ArrayList<Loot> getLoot() {
        return loot;
    }

    public void setLoot(ArrayList<Loot> loot) {
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
        this.buffs =0;
        if(in.getApplyTo().equals("buffs")){
            this.buffs +=in.getBonus();
        }
        if(in.getApplyTo().equals("curse")){
            this.buffs -= in.getCurse();
        }
    }
    public void getPlayerMove(){
        Scanner sc = new Scanner(System.in);
        boolean valid = false;
        do{
            try{
                System.out.println("Which direction do you move? (N,E,S,W)");
                String input = sc.nextLine();
                if(input.matches("[NnEeSsWw]")){
                    input =input.toLowerCase();
                    switch (input){
                        case"n":
                            this.setPosRow((this.getPosRow()-1));
                            break;
                        case"s":
                            this.setPosRow((this.getPosRow()+1));
                            break;
                        case"w":
                            this.setPosColumn((this.getPosColumn()-1));
                            break;
                        default:
                            this.setPosColumn((this.getPosColumn()+1));
                            break;
                    }
                    valid = true;
                }
            }catch(Exception e){
                System.out.println("Invalid Entry!");
            }
        }while(!valid);
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
    public void displayLoot(){
        Stream.of(loot).forEach(System.out::println);
    }
}

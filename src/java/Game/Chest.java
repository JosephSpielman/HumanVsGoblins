package Game;

import Inventory.Item;

import java.util.Random;

public class Chest extends Land {
    Item equipment;

    public Chest(String name, String displayValue, Item equipment) {
        super(name, displayValue);
        generateEquipment();
    }

    public Item getEquipment() {
        return equipment;
    }

    public void setEquipment(Item equipment) {
        this.equipment = equipment;
    }

    public void generateEquipment() {
        Random rnd = new Random();
        int roll = rnd.nextInt(6);
        if (roll <= 1) {
            this.equipment = new Item("Rusty Knife", 1, 0, "A Simple rusty knife.", "buffs");
            return;
        }
        if (roll == 2) {
            this.equipment = new Item("Steel Sword", 3, 0, "Stronger than a standard broadsword.", "buffs");
            return;
        }
        if (roll == 3) {
            this.equipment = new Item("Cursed Amulet", 0, 2, "Lowers your strength. Does it have a use?", "curse");
            return;
        }
        if (roll == 4) {
            this.equipment = new Item("Great Axe", 5, 0, "The goblins won't know what hit them.", "buffs");
            return;
        }
        this.equipment = new Item("Golden Sword", 0, 0, "It's not very powerful but it is SHINY!", "buffs");
    }
}

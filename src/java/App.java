import Creatures.Goblin;
import Creatures.Knight;
import Game.Board;
import Game.Land;
import Inventory.*;


public class App {
    public static void main(String[] args) {
        Knight k= new Knight();
        Goblin g = new Goblin();
        Goblin g2 = new Goblin();
        Goblin g3 = new Goblin();

        //
        System.out.println(k.toString());
        k.setEquipmentSlot1(new Item("Broadsword",2,0,"Standard Issue sword","buffs"));
        k.calcItemStats(k.getEquipmentSlot1());
        k.setEquipmentSlot2(new Item("Broadsword",2,0,"Standard Issue sword","buffs"));
        k.calcItemStats(k.getEquipmentSlot2());
        k.setEquipmentSlot3(new Item("Broadsword",2,0,"Standard Issue sword","buffs"));
        k.calcItemStats(k.getEquipmentSlot3());


        System.out.println(g.toString());
        System.out.println();
        System.out.println(g2.toString());
        System.out.println();
        System.out.println(g3.toString());
        System.out.println();


        String[][] gameBoard = Board.generateBoard(new Land(),6,4,k,g);
        Board.displayBoard(gameBoard);
        System.out.println();
        gameBoard[2][2]="\uD83C\uDF81";
        Board.displayBoard(gameBoard);

        System.out.println();
        Board.displayBoard(gameBoard);








        /*
        do{
            g.attack(k);
            k.attack(g);
            System.out.println("Creatures.Goblin HP: "+g.getHp());
            System.out.println("Creatures.Knight HP: "+k.getHp());

        }
        while(g.isDead() && k.isDead());
    }
    */
    }
}
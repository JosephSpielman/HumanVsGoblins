import Creatures.Goblin;
import Creatures.Knight;
import Game.Board;
import Game.Land;

public class App {
    public static void main(String[] args) {
        Knight k= new Knight();
        Goblin g = new Goblin();
        String[][] gameBoard = Board.generateBoard(new Land(),10,10);
        Board.displayBoard(gameBoard);
        System.out.println();
        Board.movePiece(k,gameBoard,1);
        Board.displayBoard(gameBoard);
        System.out.println();
        Board.movePiece(g,gameBoard,1);
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
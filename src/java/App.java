import Creatures.*;
import Game.*;

public class App {
    public static void main(String[] args) {
        Knight player = new Knight();
        Goblin enemy = new Goblin();
        int row = 8;
        int column = 8;
        String[][] gameBoard = Board.generateBoard(new Land(), row, column, player, enemy);


        boolean inGame = true;
        boolean gameRunning = true;
        while (gameRunning) {
            enemy.generatePlacement(row,column);
            Board.setPosition(gameBoard,enemy);
            gameBoard = Board.generateBoard(new Land(), row, column, player, enemy);
            Board.displayBoard(gameBoard);
            boolean moving = true;
            while(moving){
             Board.movePiece(gameBoard,player);
                System.out.println();
                Board.displayBoard(gameBoard);
                System.out.println();
                Board.goblinMove(gameBoard,enemy,player);
                Board.displayBoard(gameBoard);
                if(Board.startBattle(player,enemy)){
                    moving = false;}

            }
            while(!player.isDead()&&!enemy.isDead()) {
                player.attack(enemy);
                enemy.attack(player);

            }
            if(enemy.isDead()){
                enemy.giveTreasure(player);
                enemy = new Goblin();
            } else if (player.isDead()) {
                System.out.println("YOU HAVE FAILED!!!!!!");
                gameRunning = false;
            }

        }
    }
}
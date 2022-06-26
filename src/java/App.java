import Creatures.*;
import Game.*;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Knight player = new Knight();
        Goblin enemy = new Goblin();
        Chest chest = new Chest();
        int row = 8;
        int column = 8;
        int round =1;
        Object[][] objectBoard = new Object[row][column];

        Board.openingMessage();
        boolean gameRunning = true;
        while (gameRunning) {
            enemy.generatePlacement(row,column);
            Board.setPosition(objectBoard,enemy);
            objectBoard = Board.generateObjectBoard(new Land(), row, column, player, enemy);
            if(round >1) {
                chest.setChestColumn(0);
                chest.setChestRow(0);
                chest.generateEquipment();
                Board.setChest(objectBoard, chest);
            }
            if(round %3 ==0){
                enemy.upgradeGoblin();
                player.healForBoss();
            }
            Board.displayObjectBoard(objectBoard);
            boolean moving = true;
            while(moving){
                Board.movePiece(objectBoard,player);
                System.out.println(player.displayStats());
                System.out.println(enemy.displayStats());
                Board.displayObjectBoard(objectBoard);
                System.out.println();
                Board.openTreasureChest(player,chest);
                if(Board.startBattle(player,enemy)){
                    moving = false;
                    continue;
                }
                Board.goblinMove(objectBoard,enemy,player);
                Board.displayObjectBoard(objectBoard);
                if(Board.startBattle(player,enemy)){
                    moving = false;}
            }
            System.out.println("-----Prepare for combat!-----");
            while(!player.isDead()&&!enemy.isDead()) {
                player.attack(enemy);
                enemy.attack(player);
                System.out.println("Press any key to continue combat.");
                sc.nextLine();
            }
            if(enemy.isDead()){
                System.out.println("The Goblin has died!");
                enemy.giveTreasure(player);
                enemy = new Goblin();
                round++;
            }
            if (player.isDead()) {
                System.out.println("-----The knight's journey has come to an end!-----");
                player.displayLoot();
                gameRunning = false;
            }
        }
    }
}
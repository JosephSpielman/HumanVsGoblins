package Game;
import Creatures.*;
import java.util.Arrays;

public class Board {
     int row;
     int column;
     int round;

     public Board(){
         this.row = 8;
         this.column=8;
         this.round =1;

     }
    public Board(int row, int column) {
        this.row = row;
        this.column = column;
        this.round = 1;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public static String[][] generateBoard(Land l, int row, int column, Knight k, Goblin g){
        String[][] out = new String[column][row];
        for(String[] land:out){
            Arrays.fill(land,l.getDisplayValue());
        }
        out[k.getPosRow()][k.getPosColumn()]=k.getDisplayValue();
        out[g.getPosRow()][g.getPosColumn()]=g.getDisplayValue();
        return out;
    }
    public static void displayBoard(String[][] board){
        for (String[] x : board) {
            for (String y : x) {
                System.out.print(y);
            }
            System.out.println();
        }
    }
    public static void reDraw(String[][] board,Knight k,Goblin g){
         board[k.getPosRow()][k.getPosColumn()]=k.getDisplayValue();
         board[g.getPosRow()][g.getPosColumn()]=g.getDisplayValue();
    }


/*
    public static boolean startBattle(Knight k,Goblin g){
         int check = (k.getPosRow() - g.getPosRow()) + (k.getPosColumn() - g.getPosColumn());
         return check == 1;
    }
*/

    public static boolean startBattle(Knight k,Goblin g){
        return(k.getPosColumn() == g.getPosColumn() && k.getPosRow() == g.getPosRow());
    }


    public static boolean openTreasureChest(Humanoid h,Chest c){
        int range = (h.getPosRow() - c.getChestRow()) + (h.getPosColumn() - c.getChestColumn());
        if(h.getClass().getSimpleName().equals("Knight") && range ==0){
            System.out.println("You have reached the treasure chest");
            return true;
        }else if(h.getClass().getSimpleName().equals("Goblin") && range ==0){
            System.out.println("The goblin has destroyed the chest!");
            return false;
        }
        return false;
    }
    public static void setPosition(String[][] gameBoard,Humanoid h){
        gameBoard[h.getPosRow()][h.getPosColumn()]=h.getDisplayValue();
    }

    public static void goblinMove(String[][]gameBoard,Goblin g,Knight k){
        int gobCol = g.getPosColumn();
        int gobRow = g.getPosRow();
        int kCol = k.getPosColumn();
        int kRow = k.getPosRow();
        boolean getMove = true;
        gameBoard[gobRow][gobCol] = "\u2F8B";

        while(getMove){
            if(gobCol>kCol){
                g.setPosColumn(gobCol-1);
                Board.setPosition(gameBoard,g);
                getMove = false;
                break;
            } else if (gobCol<kCol) {
                g.setPosColumn(gobCol+1);
                Board.setPosition(gameBoard,g);
                getMove = false;
                break;
            }else if(gobRow>kRow){
                g.setPosRow(gobRow-1);
                Board.setPosition(gameBoard,g);
                getMove = false;
                break;
            } else{
                g.setPosRow(gobRow+1);
                Board.setPosition(gameBoard,g);
                getMove = false;
            }
          //  getMove = false;
        }
    }

    public static void movePiece(String[][] gameBoard,Knight k){
        int tempRow = k.getPosRow();
        int tempColumn = k.getPosColumn();
        k.getPlayerMove();
        gameBoard[tempRow][tempColumn] = "\u2F8B";
        gameBoard[k.getPosRow()][k.getPosColumn()] = k.getDisplayValue();
    }

}

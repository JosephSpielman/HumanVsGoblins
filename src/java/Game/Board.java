package Game;

import Creatures.Goblin;
import Creatures.Humanoid;
import Creatures.Knight;

import java.util.Arrays;

public class Board {
    static int row;
    static int column;

    public Board(int row, int column) {
        Board.row = 8;
        Board.column =8;
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

public static void goblinMove(String[][]gameBoard,Goblin g,Knight k){
    int gobCol = g.getPosColumn();
    int gobRow = g.getPosRow();
    int kCol = k.getPosColumn();
    int kRow = k.getPosRow();
    if(gobCol>k.getPosColumn()){
        g.setPosColumn(gobCol+1);
    }
    if(gobCol<k.getPosColumn()){
        g.setPosColumn(gobCol+1);
    }
}
public static void movePiece(Humanoid h,String[][] gameBoard,int i){
        gameBoard[h.getPosColumn()][h.getPosRow()] = "\u2F8B";
        h.setPosColumn(h.getPosColumn()+i);
        gameBoard[h.getPosColumn()][h.getPosRow()] = h.getDisplayValue();
 }

}

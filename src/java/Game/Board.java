package Game;

import Creatures.Humanoid;

import java.util.Arrays;

public class Board {
    static int row;
    static int column;

    public Board(int row, int column) {
        Board.row = 8;
        Board.column =8;
    }

    public static String[][] generateBoard(Land l,int row, int column){
        String[][] out = new String[column][row];
        for(String[] land:out){
            Arrays.fill(land,l.getDisplayValue());
        }
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
public static void movePiece(Humanoid h,String[][] gameBoard,int i){
        gameBoard[h.getPosColumn()][h.getPosRow()] = "\u2F8B";
        h.setPosColumn(h.getPosColumn()+i);
        gameBoard[h.getPosColumn()][h.getPosRow()] = h.getDisplayValue();
 }
}

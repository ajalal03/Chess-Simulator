import java.util.*;
import java.lang.Math;

public class Knight extends Piece {
    public Knight(Color c) {
        if (!(c == Color.BLACK || c == Color.WHITE)) {
            throw new InvalidColor();
        }
        this.pieceColor = c;
    }
   

    public String toString() {
        if (this.pieceColor == Color.BLACK) {
            return "bn";
        }
        else {
            return "wn"; 
        }
    }

    public List<String> moves(Board b, String loc) {
        // create empty list
        List<String> list = new ArrayList<String>();

        // confirm location and get info
        BoardFunctions.confirmLoc(loc);
        int col = BoardFunctions.getCol(loc);
        int row = BoardFunctions.getRow(loc);

        // iterate over all possible moves 
        for (int possibleCol = col-2; possibleCol < col+3; possibleCol++) {
            for (int possibleRow = row-2; possibleRow < row+3; possibleRow++) {
                // confirm it is in bounds of board
                if (((possibleCol >= 0) && (possibleCol <= 7)) && ((possibleRow >= 0) && (possibleRow <= 7))) {
                    // confirm it is a possible move of a knight
                    if (((Math.abs(possibleCol - col) == 2) && (Math.abs(possibleRow - row) == 1)) || 
                        ((Math.abs(possibleCol - col) == 1) && (Math.abs(possibleRow - row) == 2))) {
                        String square = BoardFunctions.getColString(possibleCol) + BoardFunctions.getRowString(possibleRow);
                        if (b.getPiece(square) == null) {
                            list.add(square);
                        }
                        if (b.getPiece(square) != null) {
                            if (b.getPiece(square).color() != this.pieceColor) {
                                list.add(square);
                            }
                        }
                    }
                }
            }
        }

        return list;
    }
}


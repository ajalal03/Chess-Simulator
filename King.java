import java.util.*;

public class King extends Piece {
    public King(Color c) {
        if (!(c == Color.BLACK || c == Color.WHITE)) {
            throw new InvalidColor();
        }
        this.pieceColor = c;
    }
    

    public String toString() {
        if (this.pieceColor == Color.BLACK) {
            return "bk";
        }
        else {
            return "wk"; 
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
        for (int possibleCol = col-1; possibleCol < col+2; possibleCol++) {
            for (int possibleRow = row-1; possibleRow < row+2; possibleRow++) {
                // confirm it is in bounds of board
                if (((possibleCol >= 0) && (possibleCol <= 7)) && ((possibleRow >= 0) && (possibleRow <= 7))) {
                    // confirm it is not the current square
                    if (!((possibleCol == col) && (possibleRow == row))) {
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
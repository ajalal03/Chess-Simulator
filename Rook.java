import java.util.*;

public class Rook extends Piece {
    public Rook(Color c) {
        if (!(c == Color.BLACK || c == Color.WHITE)) {
            throw new InvalidColor();
        }
        this.pieceColor = c;
    }

    public String toString() {
        if (this.pieceColor == Color.BLACK) {
            return "br";
        }
        else {
            return "wr"; 
        }
    }

    public List<String> moves(Board b, String loc) {
        // create empty list
        List<String> list = new ArrayList<String>();

        // confirm location and get info
        BoardFunctions.confirmLoc(loc);
        int col = BoardFunctions.getCol(loc);
        int row = BoardFunctions.getRow(loc);

        for (int i = col+1; i <= 7; i++) {
            String square = BoardFunctions.getColString(i) + BoardFunctions.getRowString(row);
            if (b.getPiece(square) == null) {
                list.add(square);
            }
            else {
                if (b.getPiece(square).color() != this.pieceColor) {
                    list.add(square);
                }
                break;
            }
        }
        for (int i = col-1; i >= 0; i--) {
            String square = BoardFunctions.getColString(i) + BoardFunctions.getRowString(row);
            if (b.getPiece(square) == null) {
                list.add(square);
            }
            else {
                if (b.getPiece(square).color() != this.pieceColor) {
                    list.add(square);
                }
                break;
            }
        }
        for (int i = row+1; i <= 7; i++) {
            String square = BoardFunctions.getColString(col) + BoardFunctions.getRowString(i);
            if (b.getPiece(square) == null) {
                list.add(square);
            }
            else {
                if (b.getPiece(square).color() != this.pieceColor) {
                    list.add(square);
                }
                break;
            }
        }
        for (int i = row-1; i >= 0; i--) {
            String square = BoardFunctions.getColString(col) + BoardFunctions.getRowString(i);
            if (b.getPiece(square) == null) {
                list.add(square);
            }
            else {
                if (b.getPiece(square).color() != this.pieceColor) {
                    list.add(square);
                }
                break;
            }
        }

        return list;
    }
}
import java.util.*;

public class Queen extends Piece {
    public Queen(Color c) {
        if (!(c == Color.BLACK || c == Color.WHITE)) {
            throw new InvalidColor();
        }
        this.pieceColor = c;
    }

    public String toString() {
        if (this.pieceColor == Color.BLACK) {
            return "bq";
        }
        else {
            return "wq"; 
        }
    }

    public List<String> moves(Board b, String loc) {
        // create empty list
        List<String> list = new ArrayList<String>();

        // confirm location and get info
        BoardFunctions.confirmLoc(loc);
        int col = BoardFunctions.getCol(loc);
        int row = BoardFunctions.getRow(loc);

        int col1 = col + 1;
        int row1 = row + 1;
        while ((col1 <= 7) && (col1 >= 0) && (row1 <= 7) && (row1 >= 0)) {
            String square = BoardFunctions.getColString(col1) + BoardFunctions.getRowString(row1);
            if (b.getPiece(square) == null) {
                list.add(square);
            }
            else {
                if (b.getPiece(square).color() != this.pieceColor) {
                    list.add(square);
                }
                break;
            }
            col1++;
            row1++;
        }

        int col2 = col - 1;
        int row2 = row - 1;
        while ((col2 <= 7) && (col2 >= 0) && (row2 <= 7) && (row2 >= 0)) {
            String square = BoardFunctions.getColString(col2) + BoardFunctions.getRowString(row2);
            if (b.getPiece(square) == null) {
                list.add(square);
            }
            else {
                if (b.getPiece(square).color() != this.pieceColor) {
                    list.add(square);
                }
                break;
            }
            col2--;
            row2--;
        }

        int col3 = col + 1;
        int row3 = row - 1;
        while ((col3 <= 7) && (col3 >= 0) && (row3 <= 7) && (row3 >= 0)) {
            String square = BoardFunctions.getColString(col3) + BoardFunctions.getRowString(row3);
            if (b.getPiece(square) == null) {
                list.add(square);
            }
            else {
                if (b.getPiece(square).color() != this.pieceColor) {
                    list.add(square);
                }
                break;
            }
            col3++;
            row3--;
        }

        int col4 = col - 1;
        int row4 = row + 1;
        while ((col4 <= 7) && (col4 >= 0) && (row4 <= 7) && (row4 >= 0)) {
            String square = BoardFunctions.getColString(col4) + BoardFunctions.getRowString(row4);
            if (b.getPiece(square) == null) {
                list.add(square);
            }
            else {
                if (b.getPiece(square).color() != this.pieceColor) {
                    list.add(square);
                }
                break;
            }
            col4--;
            row4++;
        }


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
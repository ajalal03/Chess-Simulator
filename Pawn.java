import java.util.*;

public class Pawn extends Piece {
    public Pawn(Color c) {
        this.pieceColor = c;
        if (!(c == Color.BLACK || c == Color.WHITE)) {
            throw new InvalidColor();
        }
    }

    public String toString() {
        if (this.pieceColor == Color.BLACK) {
            return "bp";
        }
        else {
            return "wp"; 
        }
    }

    public List<String> moves(Board b, String loc) {

        // create empty list
        List<String> list = new ArrayList<String>();

        // confirm location and get info
        BoardFunctions.confirmLoc(loc);
        int col = BoardFunctions.getCol(loc);
        int row = BoardFunctions.getRow(loc);
      

        if (this.pieceColor == Color.BLACK) {
            // if at end of board, no possible moves
            if (row == 0) {
                return list;
            }
            // else can move forward one if square is empty
            // get that square as string
            String oneForward = BoardFunctions.getColString(col) + BoardFunctions.getRowString(row-1);
            if (b.getPiece(oneForward) == null) {
                list.add(oneForward);
            }          
            // check left diagonal
            if (col != 7) {
                String leftDiag = BoardFunctions.getColString(col+1) + BoardFunctions.getRowString(row-1);
                if (b.getPiece(leftDiag) != null) {
                    if (b.getPiece(leftDiag).color() == Color.WHITE) {
                        list.add(leftDiag);
                    }
                }
            }

            // check right diagonal
            if (col != 0) {
                String rightDiag = BoardFunctions.getColString(col-1) + BoardFunctions.getRowString(row-1);
                if (b.getPiece(rightDiag) != null) {
                    if (b.getPiece(rightDiag).color() == Color.WHITE) {
                        list.add(rightDiag);
                    }
                }
            }

            // check two moves forward
            if (row == 6) {
                String twoForward = BoardFunctions.getColString(col) + BoardFunctions.getRowString(row-2);
                if ((b.getPiece(oneForward) == null) && (b.getPiece(twoForward) == null)) {
                    list.add(twoForward);
                }
            }

            return list;
            
        }
        else {
            // if at end of board, no possible moves
            if (row == 7) {
                return list;
            }
            // else can move forward one if square is empty
            // get that square as string
            String oneForward = BoardFunctions.getColString(col) + BoardFunctions.getRowString(row+1);
            if (b.getPiece(oneForward) == null) {
                list.add(oneForward);
            }

            // check left diagonal
            if (col != 0) {
                String leftDiag = BoardFunctions.getColString(col-1) + BoardFunctions.getRowString(row+1);
                if (b.getPiece(leftDiag) != null) {
                    if (b.getPiece(leftDiag).color() == Color.BLACK) {
                        list.add(leftDiag);
                    }
                }
            }

            // check right diagonal
            if (col != 7) {
                String rightDiag = BoardFunctions.getColString(col+1) + BoardFunctions.getRowString(row+1);
                if (b.getPiece(rightDiag) != null) {
                    if (b.getPiece(rightDiag).color() == Color.BLACK) {
                        list.add(rightDiag);
                    }
                }
            }

            // check two moves forward
            if (row == 1) {
                String twoForward = BoardFunctions.getColString(col) + BoardFunctions.getRowString(row+2);
                if ((b.getPiece(oneForward) == null) && (b.getPiece(twoForward) == null)) {
                    list.add(twoForward);
                }
            }

            return list;

        }
    }

}
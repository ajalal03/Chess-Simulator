import java.util.*;

public class Board {

    private Piece[][] pieces = new Piece[8][8];

    // singleton
    private static Board one_instance = null;

    // observer
    List<BoardListener> observers = new ArrayList<BoardListener>();

    private Board() { }
    
    public static Board theBoard() {
        if (one_instance == null) {
            one_instance = new Board();
        }

        return one_instance;
    }

    // Returns piece at given loc or null if no such piece
    // exists
    public Piece getPiece(String loc) {
        BoardFunctions.confirmLoc(loc);

        int col = BoardFunctions.getCol(loc);
        int row = BoardFunctions.getRow(loc);

        return pieces[col][row];
    }

    public void addPiece(Piece p, String loc) {
        BoardFunctions.confirmLoc(loc);

        int col = BoardFunctions.getCol(loc);
        int row = BoardFunctions.getRow(loc);

        if (pieces[col][row] != null) {
            throw new InvalidLocation();
        }

        pieces[col][row] = p;

    }


// void movePiece(String from, String to) moves the piece at location from to location to. This method should 
// check that there is a piece at from (and throw an exception if not), and it should check that the move is 
// valid for that piece. If the move is valid, then location from becomes vacant and the piece is placed at position 
// to. It is possible there was another piece at to, in which case it has been captured; see below. If the move 
// is invalid or from or to are invalid locations, movePiece should raise an exception (any exception).
    public void movePiece(String from, String to) {
        // get pieces
        Piece fromPiece = getPiece(from);
        Piece toPiece = getPiece(to);
        if (fromPiece == null) {
            throw new InvalidMove();
        }
        // check that the move is possible
        if (!(fromPiece.moves(this, from).contains(to))) {
            throw new InvalidMove();
        }
       
        // now we are good to go
       
       // set "from" to null
        int fromCol = BoardFunctions.getCol(from);
        int fromRow = BoardFunctions.getRow(from);
        pieces[fromCol][fromRow] = null;

        // set "to" to fromPiece
        int toCol = BoardFunctions.getCol(to);
        int toRow = BoardFunctions.getRow(to);
        pieces[toCol][toRow] = fromPiece;

        // notify observers of move
        for(BoardListener b : observers) {  
            b.onMove(from, to, fromPiece);
        }
        // notify observers if capture
        if (toPiece != null) {
            for(BoardListener b : observers) {
                b.onCapture(fromPiece, toPiece);
            }
        }
    }

    public void clear() {
        pieces = new Piece[8][8];
    }


    public void registerListener(BoardListener bl) {
        observers.add(bl);
    }

    public void removeListener(BoardListener bl) {
        observers.remove(bl);
    }

    public void removeAllListeners() {
        observers.clear();
    }

    public void iterate(BoardInternalIterator bi) {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                bi.visit(BoardFunctions.getColString(i) + BoardFunctions.getRowString(j), pieces[i][j]);
            }
        }
    }

}
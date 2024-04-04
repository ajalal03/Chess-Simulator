public class Test {

    // Run "java -ea Test" to run with assertions enabled (If you run
    // with assertions disabled, the default, then assert statements
    // will not execute!)

    public static void test1() {
        Board b = Board.theBoard();
        Piece.registerPiece(new PawnFactory());
        Piece.registerPiece(new RookFactory());
        Piece p = Piece.createPiece("bp");
        b.addPiece(p, "a3");
        assert b.getPiece("a3") == p;
        Piece p2 = Piece.createPiece("wp");
        b.addPiece(p2, "b2");
        BoardInternalIterator bi = new BoardPrinter();
        b.iterate(bi);
        b.registerListener(new Logger());
        b.registerListener(new Logger());
        b.movePiece("a3", "b2");

    }
    
    public static void main(String[] args) {
	test1();
    }

}
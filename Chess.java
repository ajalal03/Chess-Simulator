import java.util.*;
import java.io.*;

public class Chess {
    public static void main(String[] args) {
	if (args.length != 2) {
	    System.out.println("Usage: java Chess layout moves");
	}
	Piece.registerPiece(new KingFactory());
	Piece.registerPiece(new QueenFactory());
	Piece.registerPiece(new KnightFactory());
	Piece.registerPiece(new BishopFactory());
	Piece.registerPiece(new RookFactory());
	Piece.registerPiece(new PawnFactory());
	Board.theBoard().registerListener(new Logger());
	// args[0] is the layout file name
	// args[1] is the moves file name
	// Put your code to read the layout file and moves files
	// here.
    

    // read layout file into ArrayList
    ArrayList<String> layout = new ArrayList<>();
    try (Scanner s1 = new Scanner(new FileReader(args[0]))) {
        while (s1.hasNextLine()) {
            layout.add(s1.nextLine());
        }
    }
    catch (FileNotFoundException e) {
		e.printStackTrace();
	}

    // read moves file into ArrayList
    ArrayList<String> moves = new ArrayList<>();
    try (Scanner s2 = new Scanner(new FileReader(args[1]))) {
    while (s2.hasNextLine()) {
        moves.add(s2.nextLine());
    }
    }
    catch (FileNotFoundException e) {
		e.printStackTrace();
	}

    for(String s : layout) { 
        if (!s.substring(0,1).equals("#")) {
            if ((!s.substring(2,3).equals("=")) || (s.length() != 5)) {
                throw new InvalidFile();
            }
            Piece p = Piece.createPiece(s.substring(3,5));
            Board.theBoard().addPiece(p, s.substring(0,2));
        }
    }

    for(String s : moves) { 
        if (!s.substring(0,1).equals("#")) {
            if ((!s.substring(2,3).equals("-")) || (s.length() != 5)) {
                throw new InvalidFile();
            }
            Board.theBoard().movePiece(s.substring(0,2), s.substring(3,5));
        }
    }

	// Leave the following code at the end of the simulation:
	System.out.println("Final board:");
	Board.theBoard().iterate(new BoardPrinter());
    }
}
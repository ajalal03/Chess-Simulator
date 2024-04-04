// done?
// should be tested more

import java.util.*;

abstract public class Piece {
    // map from symbol to PieceFactory object
    private static HashMap<String, PieceFactory> map = new HashMap<>();

    // store piece's color
    protected Color pieceColor;

    public static void registerPiece(PieceFactory pf) {
        map.put(String.valueOf(pf.symbol()), pf);
    }

    public static Piece createPiece(String name) {
        if (name.length() > 2) {
            throw new PieceNotRegistered();
        }

        String color = name.substring(0,1);
        String piece = name.substring(1,2);

        if (!(map.containsKey(piece))) {
            throw new PieceNotRegistered();
        }

        if (color.equals("w")) {
            return map.get(piece).create(Color.WHITE);
        }
        else if (color.equals("b")) {
            return map.get(piece).create(Color.BLACK);
        }
        else {
            throw new InvalidColor();
        }
    }


    public Color color() {
        return pieceColor;
    }

    abstract public String toString();

    abstract public List<String> moves(Board b, String loc);
}
// factory classes written for us

public class KnightFactory implements PieceFactory {
    public char symbol() { return 'n'; }
    public Piece create(Color c) { return new Knight(c); }
}
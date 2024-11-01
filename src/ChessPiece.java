abstract public class ChessPiece {

    String color;
    boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    abstract public String getColor();

    abstract public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    abstract public String getSymbol();

    public boolean checkPosition(int i) {
        if (0 <= i && i <= 7) {
            return true;
        } else return false;
    }
}

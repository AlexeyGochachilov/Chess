public class Bishop extends ChessPiece {

    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getSymbol() {
        return "B";
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toColumn >= 0 && toColumn <= 7 && toLine >= 0 && toLine <= 7) {
            if ((toLine - line == toColumn - column) || (toLine - line == -(toColumn - column)) || (-(toLine - line) == toColumn - column)) {
                return true;
            } else return false;
        } else return false;
    }
}

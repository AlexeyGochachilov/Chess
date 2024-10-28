public class King extends ChessPiece {

    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toColumn >= 0 && toColumn <= 7 && toLine >= 0 && toLine <= 7 && column == toColumn) {
            if ((toLine == (line + 1)) || toLine == (line - 1) || toColumn == (column + 1) || toColumn == (column - 1)) {
                return true;
            } else return false;
        } else return false;
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        return false;
    }
}

public class Queen extends ChessPiece {

    public Queen(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toColumn >= 0 && toColumn <= 7 && toLine >= 0 && toLine <= 7) {
            if (((line == toLine) && (column != toColumn)) || ((column == toColumn) && (line != toLine))) {
                return true;
            }
            if ((toLine - line == toColumn - column) || (toLine - line == -(toColumn - column)) || (-(toLine - line) == toColumn - column)) {
                return true;
            } else return false;
        } else return false;
    }
}

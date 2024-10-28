public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getSymbol() {
        return "H";
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPosition(line) && checkPosition(column) && checkPosition(toLine) && checkPosition(toColumn)) {
            if (chessBoard.board[line][column] != null) {
                if (((toColumn == (column - 1)) || (toColumn == (column + 1))) && ((toLine == (line + 2)) || (toLine == (line - 2)))) {
                    return true;
                }
                if (((toColumn == (column - 2)) || (toColumn == (column + 2))) && ((toLine == (line + 1)) || (toLine == (line - 1)))) {
                    return true;
                } else return false;
            } else return false;
        } else return true;
    }
}

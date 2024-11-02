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
        boolean b = false;
        if (positions4(line, column, toLine, toColumn)) {
            if (thisHorse(chessBoard, line, column)) {
                b = move(chessBoard, line, column, toLine, toColumn);
            }
        }
        return b;
    }

    public boolean thisHorse(ChessBoard chessBoard, int line, int column) {
        return (chessBoard.board[line][column] != null && chessBoard.board[line][column].getColor().equals(chessBoard.nowPlayer)
                && chessBoard.board[line][column].getSymbol().equals("H"));
    }

    public boolean move(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean b = false;
        for (int i = -2; i < 3; i += 4) {
            for (int j = -1; j < 2; j += 2) {
                if ((toColumn == (column + i) && toLine == (line + j)) ||
                        (toColumn == (column + j) && toLine == (line + i))) {
                    if (chessBoard.board[toLine][toColumn] != null) {
                        b = !chessBoard.board[toLine][toColumn].getColor().equals(color);
                    }
                    if (chessBoard.board[toLine][toColumn] == null){
                        b = true;
                    }
                }
            }
        }
        return b;
    }
}

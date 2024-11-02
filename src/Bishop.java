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
        boolean b = false;
        if (positions4(line, column, toLine, toColumn)) {
            if (thisBishop(chessBoard, line, column)) {
                b = (moveBishop(chessBoard, line, column, toLine, toColumn));
            }
        } return b;
    }

    public boolean moveBishop(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean b = false;
        if ((toLine - line == toColumn - column) ||
                (toLine - line == -(toColumn - column)) || (-(toLine - line) == toColumn - column)) {
            b = (checkPoint(chessBoard, line, column, toLine, toColumn));
        }
        return b;
    }

    public boolean checkPoint(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean b = false;
        if (chessBoard.board[toLine][toColumn] == null ||
                !chessBoard.board[toLine][toColumn].getColor().equals(chessBoard.nowPlayer)) {
            if (toColumn > column + 1 && toLine > line + 1) {
                int x = toColumn - column;
                for (int i = 1; i < x; i++) {
                    b = (chessBoard.board[line + i][column + i] == null);
                }
            }
            if (toColumn < column - 1 && toLine < line - 1) {
                int x = column - toColumn;
                for (int i = 1; i < x; i++) {
                    b = (chessBoard.board[line - i][column - i] == null);
                }
            }
            if (toColumn < column - 1 && toLine > line + 1) {
                int x = toLine - line;
                for (int i = 1; i < x; i++) {
                    b = (chessBoard.board[line + i][column - i] == null);
                }
            }
            if (toColumn > column + 1 && toLine < line - 1) {
                int x = line - toLine;
                for (int i = 1; i < x; i++) {
                    b = (chessBoard.board[line - i][column + i] == null);
                }
            }
            if ((toColumn == column + 1 && toLine == line + 1) || (toColumn == column - 1 && toLine == line - 1) ||
                    (toColumn == column - 1 && toLine == line + 1) || (toColumn == column + 1 && toLine == line - 1)) {
                b = true;
            }
        }
        return b;
    }

    public boolean thisBishop(ChessBoard chessBoard, int line, int column) {
        return (chessBoard.board[line][column] != null && chessBoard.board[line][column].getColor().equals(chessBoard.nowPlayer)
                && chessBoard.board[line][column].getSymbol().equals("B"));
    }
}

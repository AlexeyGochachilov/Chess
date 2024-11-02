public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getSymbol() {
        return "P";
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean b = false;
        if (positions4(line, column, toLine, toColumn)) {
            if (thisPawn(chessBoard, line, column)) {
                if (move(chessBoard, line, column, toLine, toColumn)) {
                    b = true;
                }
                if (atack(chessBoard, line, column, toLine, toColumn)) {
                    b = true;
                }
            }
        }
        return b;
    }

    public boolean thisPawn(ChessBoard chessBoard, int line, int column) {
        return (chessBoard.board[line][column] != null && chessBoard.board[line][column].getColor().equals(chessBoard.nowPlayer)
                && chessBoard.board[line][column].getSymbol().equals("P"));
    }

    public boolean move(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean b = false;
        if (toColumn == column && chessBoard.board[toLine][toColumn] == null) {
            if (chessBoard.nowPlayerColor().equals("White")) {
                if ((line == 1) && (toLine == (line + 2) || toLine == (line + 1))
                        && (chessBoard.board[line + 1][column] == null)) {
                    b = true;
                }
                if (line > 1 && toLine == (line + 1)) {
                    b = true;
                }
            }
            if (chessBoard.nowPlayerColor().equals("Black")) {
                if ((line == 6) && (toLine == (line - 2) || toLine == (line - 1))
                        && (chessBoard.board[line - 1][column] == null)) {
                    b = true;
                }
                if (line < 6 && toLine == (line - 1)) {
                    b = true;
                }
            }
        }
        return b;
    }

    public boolean atack(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean b = false;
        if (chessBoard.board[toLine][toColumn] != null && (column - toColumn == 1 || column - toColumn == -1)) {
            if ((chessBoard.nowPlayerColor().equals("White") && line - toLine == -1) ||
                    (chessBoard.nowPlayerColor().equals("Black") && line - toLine == 1)) {
                b = !chessBoard.board[toLine][toColumn].getColor().equals(color);
            }
        }
        return b;
    }

}
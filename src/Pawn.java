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
        if (checkPosition(line) && checkPosition(column) && checkPosition(toLine) && checkPosition(toColumn)) {
            if (chessBoard.board[line][column] != null) {
                if (moveWhite(chessBoard, line, column, toLine, toColumn)) {
                    return true;
                }
                if (atackWhite(chessBoard, line, column, toLine, toColumn)) {
                    return true;
                }
                if (moveBlack(chessBoard, line, column, toLine, toColumn)) {
                    return true;
                }
                if (atackBlack(chessBoard, line, column, toLine, toColumn)) {
                    return true;
                } else return false;
            } else return false;
        } else return false;
    }



    public boolean moveWhite(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean b = false;
        if ((chessBoard.nowPlayerColor().equals("White")) && (chessBoard.board[toLine][toColumn] == null)) {
            if ((line == 1) && (column == toColumn) && (toLine == (line + 2) || toLine == (line + 1))
                    && (chessBoard.board[line + 1][column] == null)) {
                b = true;
            }
            if ((line > 1) && (toLine == (line + 1)) && (column == toColumn)) {
                b = true;
            }
        }
        return b;
    }

    public boolean atackWhite(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean b = false;
        if ((chessBoard.nowPlayerColor().equals("White")) &&
                (column - toColumn == 1 || column - toColumn == -1) && (line - toLine == -1) &&
                chessBoard.board[toLine][toColumn] != null) {
            b = !chessBoard.board[toLine][toColumn].getColor().equals(color);
        }
        return b;
    }

    public boolean moveBlack(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean b = false;
        if ((chessBoard.nowPlayerColor().equals("Black")) && (chessBoard.board[toLine][toColumn] == null)) {
            if ((line == 6) && (column == toColumn) && (toLine == (line - 2) || toLine == (line - 1))
                    && (chessBoard.board[line - 1][column] == null)) {
                b = true;
            }
            if ((line < 6) && (column == toColumn) && (toLine == (line - 1))) {
                b = true;
            }
        }
        return b;
    }

    public boolean atackBlack(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean b = false;
        if ((chessBoard.nowPlayerColor().equals("Black")) &&
                (column - toColumn == 1 || column - toColumn == -1) && (line - toLine == 1) &&
                !chessBoard.board[toLine][toColumn].getColor().equals(chessBoard.nowPlayer)) {
            b = !chessBoard.board[toLine][toColumn].getColor().equals(color);
        }
        return b;
    }
}
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
        if (checkPosition(line) && checkPosition(column) && checkPosition(toLine) && checkPosition(toColumn)) {
            if (chessBoard.board[line][column] != null) {
                if (moveBishop(chessBoard, line, column, toLine, toColumn)) {
                    return true;
                }else return false;
            } else return false;
        } else return false;
    }

    public boolean moveBishop(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean b = false;
        if ((toLine - line == toColumn - column) ||
                (toLine - line == -(toColumn - column)) || (-(toLine - line) == toColumn - column)) {
            if (checkPoint(chessBoard, line, column, toLine, toColumn)) {
                b = true;
            }
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
                    if (chessBoard.board[line + i][column + i] == null) {
                        b = true;
                    } else {
                        b = false;
                        break;
                    }
                }
            }
            if (toColumn < column - 1 && toLine < line - 1) {
                int x = column - toColumn;
                for (int i = 1; i < x; i++) {
                    if (chessBoard.board[line - i][column - i] == null) {
                        b = true;
                    } else {
                        b = false;
                        break;
                    }
                }
            }
            if (toColumn < column - 1 && toLine > line + 1) {
                int x = toLine - line;
                for (int i = 1; i < x; i++) {
                    if (chessBoard.board[line + i][column - i] == null) {
                        b = true;
                    } else {
                        b = false;
                        break;
                    }
                }
            }
            if (toColumn > column + 1 && toLine < line - 1) {
                int x = line - toLine;
                for (int i = 1; i < x; i++) {
                    if (chessBoard.board[line - i][column + i] == null) {
                        b = true;
                    } else {
                        b = false;
                        break;
                    }
                }
            }
            if ((toColumn == column + 1 && toLine == line + 1) || (toColumn == column - 1 && toLine == line - 1) ||
                    (toColumn == column - 1 && toLine == line + 1) || (toColumn == column + 1 && toLine == line - 1)) {
                b = true;
            }
        }
        return b;
    }
}

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
        boolean b = false;
        if (positions4(line, column, toLine, toColumn)) {
            if (thisQueen(chessBoard, line, column)) {
                b = (moveRock(chessBoard, line, column, toLine, toColumn) ||
                        moveBishop(chessBoard, line, column, toLine, toColumn));
            }
        } return b;
    }

    public boolean thisQueen(ChessBoard chessBoard, int line, int column) {
        return (chessBoard.board[line][column] != null && chessBoard.board[line][column].getColor().equals(chessBoard.nowPlayer)
                && chessBoard.board[line][column].getSymbol().equals("Q"));
    }

    public boolean moveRock(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean b = false;
        if (((line == toLine) && (column != toColumn)) || ((column == toColumn) && (line != toLine))) {
            b = (checkPointRook(chessBoard, line, column, toLine, toColumn));
        }
        return b;
    }

    public boolean checkPointRook(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean b = false;
        if (chessBoard.board[toLine][toColumn] == null ||
                !chessBoard.board[toLine][toColumn].getColor().equals(chessBoard.nowPlayer)) {
            if (toColumn > column + 1) {
                int x = toColumn - column;
                for (int i = 1; i < x; i++) {
                    if (chessBoard.board[line][column + i] == null) {
                        b = true;
                    } else {
                        b = false;
                        break;
                    }
                }
            }
            if (toColumn < column - 1) {
                int x = column - toColumn;
                for (int i = 1; i < x; i++) {
                    if (chessBoard.board[line][column - i] == null) {
                        b = true;
                    } else {
                        b = false;
                        break;
                    }
                }
            }
            if (toLine > line + 1) {
                int x = toLine - line;
                for (int i = 1; i < x; i++) {
                    if (chessBoard.board[line + i][column] == null) {
                        b = true;
                    } else {
                        b = false;
                        break;
                    }
                }
            }
            if (toLine < line - 1) {
                int x = line - toLine;
                for (int i = 1; i < x; i++) {
                    if (chessBoard.board[line - i][column] == null) {
                        b = true;
                    } else {
                        b = false;
                        break;
                    }
                }
            }
            if (plusOne(line, column, toLine, toColumn)) {
                b = true;
            }
        }
        return b;
    }

    public boolean moveBishop(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean b = false;
        if ((toLine - line == toColumn - column) ||
                (toLine - line == -(toColumn - column)) || (-(toLine - line) == toColumn - column)) {
            b = (checkPointBishop(chessBoard, line, column, toLine, toColumn));
        }
        return b;
    }

    public boolean checkPointBishop(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
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
}

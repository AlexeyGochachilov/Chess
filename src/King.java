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
        if (checkPosition(line) && checkPosition(column) && checkPosition(toLine) && checkPosition(toColumn)) {
            if (chessBoard.board[line][column] != null) {
                if (moveKing(chessBoard, line, column, toLine, toColumn)) {
                    return true;
                } else return false;
            } else return false;
        } else return false;
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        boolean b = false;
        int raznost1 = column > line ? column : line;
        int raznost2 = line >= 7 - column ? 7 - line : column;
        int raznost3 = column >= 7 - line ? 7 - column : line;

        OUTER:
        for (int a = 0; a < 1; a++) {

            INNER1:
            for (int i = 1; i <= 7 - column; i++) {
                if (chessBoard.board[line][column + i] != null) {
                    if (!chessBoard.board[line][column + i].getColor().equals(chessBoard.nowPlayer) &&
                            (chessBoard.board[line][column + i].getSymbol().equals("Q") ||
                                    chessBoard.board[line][column + i].getSymbol().equals("R"))) {
                        b = true;
                    }
                    break OUTER;
                }
            }

            INNER2:
            for (int i = 1; i <= column; i++) {
                if (chessBoard.board[line][column - i] != null) {
                    if (!chessBoard.board[line][column - i].getColor().equals(chessBoard.nowPlayer) &&
                            (chessBoard.board[line][column - i].getSymbol().equals("Q") ||
                                    chessBoard.board[line][column - i].getSymbol().equals("R"))) {
                        b = true;
                    }
                    break OUTER;
                }
            }

            INNER3:
            for (int i = 1; i <= 7 - line; i++) {
                if (chessBoard.board[line + i][column] != null) {
                    if (!chessBoard.board[line + i][column].getColor().equals(chessBoard.nowPlayer) &&
                            (chessBoard.board[line + i][column].getSymbol().equals("Q") ||
                                    chessBoard.board[line + i][column].getSymbol().equals("R"))) {
                        b = true;
                    }
                    break OUTER;
                }
            }

            INNER4:
            for (int i = 1; i <= line; i++) {
                if (chessBoard.board[line - i][column] != null) {
                    if (!chessBoard.board[line - i][column].getColor().equals(chessBoard.nowPlayer) &&
                            (chessBoard.board[line - i][column].getSymbol().equals("Q") ||
                                    chessBoard.board[line - i][column].getSymbol().equals("R"))) {
                        b = true;
                    }
                    break OUTER;
                }
            }

            INNER5:
            for (int i = 1; i <= 7 - raznost1; i++) {
                if (chessBoard.board[line + i][column + i] != null) {
                    if (!chessBoard.board[line + i][column + i].getColor().equals(chessBoard.nowPlayer) &&
                            (chessBoard.board[line + i][column + i].getSymbol().equals("Q") ||
                                    chessBoard.board[line + i][column + i].getSymbol().equals("B"))) {
                        b = true;
                    }
                    break OUTER;
                }
            }

            INNER6:
            for (int i = 1; i <= raznost2; i++) {
                if (chessBoard.board[line + i][column - i] != null) {
                    if (!chessBoard.board[line + i][column - i].getColor().equals(chessBoard.nowPlayer) &&
                            (chessBoard.board[line + i][column - i].getSymbol().equals("Q") ||
                                    chessBoard.board[line + i][column - i].getSymbol().equals("B"))) {
                        b = true;
                    }
                    break OUTER;
                }
            }

            INNER7:
            for (int i = 1; i <= raznost3; i++) {
                if (chessBoard.board[line - i][column + i] != null) {
                    if (!chessBoard.board[line - i][column + i].getColor().equals(chessBoard.nowPlayer) &&
                            (chessBoard.board[line - i][column + i].getSymbol().equals("Q") ||
                                    chessBoard.board[line - i][column + i].getSymbol().equals("B"))) {
                        b = true;
                    }
                    break OUTER;
                }
            }

            INNER8:
            for (int i = 1; i <= raznost1; i++) {
                if (chessBoard.board[line - i][column - i] != null) {
                    if (!chessBoard.board[line - i][column - i].getColor().equals(chessBoard.nowPlayer) &&
                            (chessBoard.board[line - i][column - i].getSymbol().equals("Q") ||
                                    chessBoard.board[line - i][column - i].getSymbol().equals("B"))) {
                        b = true;
                    }
                    break OUTER;
                }
            }

            if (line - 2 >= 0 && line + 2 <= 7 && column - 1 >= 0 && column + 1 <= 7) {
                MIDEL1:
                for (int i = -2; i < 3; i += 4) {
                    INNER1:
                    for (int j = -1; j < 2; j += 2) {
                        if (!chessBoard.board[line + i][column + j].getColor().equals(chessBoard.nowPlayer) &&
                                chessBoard.board[line + i][column + j].getSymbol().equals("H")) {
                            b = true;
                            break MIDEL1;
                        }
                    }
                }
            }

            if (line - 1 >= 0 && line + 1 <= 7 && column - 2 >= 0 && column + 2 <= 7) {
                MIDEL2:
                for (int i = -2; i < 3; i += 4) {
                    INNER2:
                    for (int j = -1; j < 2; j += 2) {
                        if (!chessBoard.board[line + j][column + i].getColor().equals(chessBoard.nowPlayer) &&
                                chessBoard.board[line + j][column + i].getSymbol().equals("H")) {
                            b = true;
                            break MIDEL2;
                        }
                    }
                }
            }
        }
        return b;
    }

    public boolean moveKing(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean b = false;
        if (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(chessBoard.nowPlayer)) {
            if ((toLine == (line + 1)) || toLine == (line - 1) || toColumn == (column + 1) || toColumn == (column - 1)) {
                b = !isUnderAttack(chessBoard, toLine, toColumn);
            }
        }
        return b;
    }
}

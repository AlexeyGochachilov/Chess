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
        boolean b = false;
        if (positions4(line, column, toLine, toColumn)) {
            if (thisKing(chessBoard, line, column)) {
                b = (moveKing(chessBoard, line, column, toLine, toColumn));
            }
        }
        return b;
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        boolean b = false;
        int raznost1 = column > line ? column : line;
        int raznost2 = line >= 7 - column ? 7 - line : column;
        int raznost3 = column >= 7 - line ? 7 - column : line;

        for (int i = 1; i <= 7 - column; i++) {
            if (positions2(line, column + i)) {
                if (chessBoard.board[line][column + i] != null) {
                    if (!chessBoard.board[line][column + i].getColor().equals(chessBoard.nowPlayer) &&
                            (chessBoard.board[line][column + i].getSymbol().equals("Q") ||
                                    chessBoard.board[line][column + i].getSymbol().equals("R"))) {
                        b = true;
                    }
                    break;
                }
            }
        }

        for (int i = 1; i <= column; i++) {
            if (positions2(line, column - i)) {
                if (chessBoard.board[line][column - i] != null) {
                    if (!chessBoard.board[line][column - i].getColor().equals(chessBoard.nowPlayer) &&
                            (chessBoard.board[line][column - i].getSymbol().equals("Q") ||
                                    chessBoard.board[line][column - i].getSymbol().equals("R"))) {
                        b = true;
                    }
                    break;
                }
            }
        }

        for (int i = 1; i <= 7 - line; i++) {
            if (positions2(line + i, column)) {
                if (chessBoard.board[line + i][column] != null) {
                    if (!chessBoard.board[line + i][column].getColor().equals(chessBoard.nowPlayer) &&
                            (chessBoard.board[line + i][column].getSymbol().equals("Q") ||
                                    chessBoard.board[line + i][column].getSymbol().equals("R"))) {
                        b = true;
                    }
                    break;
                }
            }
        }

        for (int i = 1; i <= line; i++) {
            if (positions2(line - i, column)) {
                if (chessBoard.board[line - i][column] != null) {
                    if (!chessBoard.board[line - i][column].getColor().equals(chessBoard.nowPlayer) &&
                            (chessBoard.board[line - i][column].getSymbol().equals("Q") ||
                                    chessBoard.board[line - i][column].getSymbol().equals("R"))) {
                        b = true;
                    }
                    break;
                }
            }
        }

        for (int i = 1; i <= 7 - raznost1; i++) {
            if (positions2(line + i, column + i)) {
                if (chessBoard.board[line + i][column + i] != null) {
                    if (!chessBoard.board[line + i][column + i].getColor().equals(chessBoard.nowPlayer) &&
                            (chessBoard.board[line + i][column + i].getSymbol().equals("Q") ||
                                    chessBoard.board[line + i][column + i].getSymbol().equals("B"))) {
                        b = true;
                    }
                    break;
                }
            }
        }

        for (int i = 1; i <= raznost2; i++) {
            if (positions2(line + i, column - i)) {
                if (chessBoard.board[line + i][column - i] != null) {
                    if (!chessBoard.board[line + i][column - i].getColor().equals(chessBoard.nowPlayer) &&
                            (chessBoard.board[line + i][column - i].getSymbol().equals("Q") ||
                                    chessBoard.board[line + i][column - i].getSymbol().equals("B"))) {
                        b = true;
                    }
                    break;
                }
            }
        }

        for (int i = 1; i <= raznost3; i++) {
            if (positions2(line - i, column + i)) {
                if (chessBoard.board[line - i][column + i] != null) {
                    if (!chessBoard.board[line - i][column + i].getColor().equals(chessBoard.nowPlayer) &&
                            (chessBoard.board[line - i][column + i].getSymbol().equals("Q") ||
                                    chessBoard.board[line - i][column + i].getSymbol().equals("B"))) {
                        b = true;
                    }
                    break;
                }
            }
        }

        for (int i = 1; i <= raznost1; i++) {
            if (positions2(line - i, column - i)) {
                if (chessBoard.board[line - i][column - i] != null) {
                    if (!chessBoard.board[line - i][column - i].getColor().equals(chessBoard.nowPlayer) &&
                            (chessBoard.board[line - i][column - i].getSymbol().equals("Q") ||
                                    chessBoard.board[line - i][column - i].getSymbol().equals("B"))) {
                        b = true;
                    }
                    break;
                }
            }
        }

        for (int i = -2; i < 3; i += 4) {
            for (int j = -1; j < 2; j += 2) {
                if (positions2(line + i, column + j)) {
                    if (chessBoard.board[line + i][column + j] != null) {
                        if (!chessBoard.board[line + i][column + j].getColor().equals(color) &&
                                chessBoard.board[line + i][column + j].getSymbol().equals("H")) {
                            b = true;
                        }
                    }
                }
                if (positions2(line + j, column + i)) {
                    if (chessBoard.board[line + j][column + i] != null) {
                        if (!chessBoard.board[line + j][column + i].getColor().equals(color) &&
                                chessBoard.board[line + j][column + i].getSymbol().equals("H")) {
                            b = true;
                        }
                    }
                }
            }
        }

        for (int i = -1; i < 2; i += 2) {
            if (positions2(line + 1, column + i)) {
                if ((chessBoard.nowPlayer.equals("White")) && (chessBoard.board[line + 1][column + i] != null)) {
                    if (chessBoard.board[line + 1][column + i].getSymbol().equals("P") &&
                            !chessBoard.board[line + 1][column + i].getColor().equals(chessBoard.nowPlayer)) {
                        b = true;
                    }
                }
            }
            if (positions2(line - 1, column + i)) {
                if ((chessBoard.nowPlayer.equals("Black")) && (chessBoard.board[line - 1][column + i] != null)) {
                    if (chessBoard.board[line + 1][column + i].getSymbol().equals("P") &&
                            !chessBoard.board[line - 1][column + i].getColor().equals(chessBoard.nowPlayer)) {
                        b = true;
                    }
                }
            }
        }

        return b;
    }

    public boolean moveKing(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        boolean b = false;
        if (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(chessBoard.nowPlayer)) {
            if (plusOne(line, column, toLine, toColumn)) {
                b = !isUnderAttack(chessBoard, toLine, toColumn);
            }
        }
        return b;
    }

    public boolean thisKing(ChessBoard chessBoard, int line, int column) {
        return (chessBoard.board[line][column] != null && chessBoard.board[line][column].getColor().equals(chessBoard.nowPlayer)
                && chessBoard.board[line][column].getSymbol().equals("K"));
    }
}

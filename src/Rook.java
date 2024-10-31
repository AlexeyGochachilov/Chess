public class Rook extends ChessPiece {

    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getSymbol() {
        return "R";
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPosition(line) && checkPosition(column) && checkPosition(toLine) && checkPosition(toColumn)) {
            if (chessBoard.board[line][column] != null) {
                if (moveRock(chessBoard, line, column, toLine, toColumn)) {
                    return true;
                } else return false;
            } else return false;
        } else return false;
    }

    public boolean moveRock(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean b = false;
        if (((line == toLine) && (column != toColumn)) || ((column == toColumn) && (line != toLine))) {
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
            if (toColumn == column + 1 || toColumn == column - 1 || toLine == line + 1 || toLine == line - 1){
                b = true;
            }
        }
        return b;
    }
}
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
                //  if (((line == toLine) && (column != toColumn)) || ((column == toColumn) && (line != toLine))) {
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
        if (toColumn > column) {
            int x = toColumn - column;
            int i = 1;
            while (i <= x) {
                if (chessBoard.board[line][column + i] == null) {
                    b = true;
                    i++;
                }
            }
        }
        if (toColumn < column) {
            int x = column - toColumn;
            int i = 1;
            while (i <= x) {
                if (chessBoard.board[line][column - i] == null) {
                    b = true;
                    i++;
                }
            }
        }
        if (toLine > line) {
            int x = toLine - line;
            int i = 1;
            while (i <= x) {
                if (chessBoard.board[line + i][column] == null) {
                    b = true;
                    i++;
                }
            }
        }
        if (toLine < line) {
            int x = line - toLine;
            int i = 1;
            while (i <= x) {
                if (chessBoard.board[line - i][column] == null) {
                    b = true;
                    i++;
                }
            }
        }
        return b;
    }
}
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
            for (int i = 1; i <= x; i++) {
                if (chessBoard.board[line][column + i] == null)
                    b = true;
            }
        }
        if (toColumn < column) {
            int x = column - toColumn;
            for (int i = 1; i <= x; i++) {
                if (chessBoard.board[line][column - i] == null)
                    b = true;
            }
        }
        if (toLine > line) {
            int x = toLine - line;
            for (int i = 1; i <= x; i++) {
                if (chessBoard.board[line + i][column] == null)
                    b = true;
            }
        }
        if (toLine < line) {
            int x = line - toLine;
            for (int i = 1; i <= x; i++) {
                if (chessBoard.board[line - i][column] == null)
                    b = true;
            }
        }
        return b;
    }
}
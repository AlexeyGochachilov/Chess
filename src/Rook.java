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
        boolean b = false;
        if (positions4(line, column, toLine, toColumn)) {
            if (thisRook(chessBoard, line, column)) {
                b = (moveRock(chessBoard, line, column, toLine, toColumn));
            }
        }  return b;
    }

    public boolean thisRook(ChessBoard chessBoard, int line, int column) {
        return (chessBoard.board[line][column] != null && chessBoard.board[line][column].getColor().equals(chessBoard.nowPlayer)
                && chessBoard.board[line][column].getSymbol().equals("R"));
    }

    public boolean moveRock(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean b = false;
        if (((line == toLine) && (column != toColumn)) || ((column == toColumn) && (line != toLine))) {
            b = (checkPoint(chessBoard, line, column, toLine, toColumn));
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
                    b = (chessBoard.board[line][column + i] == null);
                }
            }
            if (toColumn < column - 1) {
                int x = column - toColumn;
                for (int i = 1; i < x; i++) {
                    b = (chessBoard.board[line][column - i] == null);
                }
            }
            if (toLine > line + 1) {
                int x = toLine - line;
                for (int i = 1; i < x; i++) {
                    b = (chessBoard.board[line + i][column] == null);
                }
            }
            if (toLine < line - 1) {
                int x = line - toLine;
                for (int i = 1; i < x; i++) {
                    b = (chessBoard.board[line - i][column] == null);
                }
            }
            if (plusOne(line, column, toLine, toColumn)){
                b =true;
            }
        }
        return b;
    }
}
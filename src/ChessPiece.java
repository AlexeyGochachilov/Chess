abstract public class ChessPiece {

    String color;
    boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    abstract public String getColor();

    abstract public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    abstract public String getSymbol();

    public boolean checkPosition(int i) {
        if (0 <= i && i <= 7) {
            return true;
        } else return false;
    }

    public boolean positions4(int line, int column, int toLine, int toColumn) {
        return (checkPosition(line) && checkPosition(column) && checkPosition(toLine) && checkPosition(toColumn));
    }

    public boolean positions2(int line, int column) {
        return positions4(line, column, 0, 0);
    }

    public boolean plusOne(int line, int column, int toLine, int toColumn){
        return (toLine == line + 1 || toLine == line - 1 || toColumn == column + 1 || toColumn == column - 1);
    }

}

package board;

import piece.Piece;

public class Square {
    int x;
    int y;
    int row;
    int col;
    String label;
    Piece currentPiece;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Piece getCurrentPiece() {
        return currentPiece;
    }

    public void setCurrentPiece(Piece currentPiece) {
        this.currentPiece = currentPiece;
    }

    public Square(int x, int y, int row, int col, String label, Piece currentPiece) {
        this.x = x;
        this.y = y;
        this.row = row;
        this.col = col;
        this.label = label;
        this.currentPiece = currentPiece;
    }
}

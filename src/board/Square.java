package board;

import piece.Piece;

public class Square {
    int x;
    int y;
    String label;
    Piece currentPiece;

    public Square(int x, int y, String label, Piece currentPiece) {
        this.x = x;
        this.y = y;
        this.label = label;
        this.currentPiece = currentPiece;
    }

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
}

package piece;

import board.Square;
import main.GamePanel;

public class Pawn extends Piece{

    public Pawn(int color, String position) {
        super(color, position);

        if(color == GamePanel.WHITE){
            image = getImage("/piece/w-pawn");
        }
        else{
            image = getImage("/piece/b-pawn");
        }
    }

    @Override
    public boolean validMove(String targetPos) {
        Square targetSquare = getSquare(targetPos);
        if(targetSquare.getCurrentPiece() == null || targetSquare.getCurrentPiece().color != this.color){
            return true;
        }
        return false;
    }
}

package piece;

import board.Square;
import main.GamePanel;

public class Pawn extends Piece{

    boolean firstMove = true;
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
        Square currentSquare = getSquare(this.position);
        Square targetSquare = getSquare(targetPos);

        // Pawn first move has different logic
        if(this.firstMove){
            // If target is not occupied or does not have a friendly piece on it
            if(targetSquare.getCurrentPiece() == null || targetSquare.getCurrentPiece().color != this.color){
                // If target col is the same and the row movement is 2 or less
                if(currentSquare.getCol() == targetSquare.getCol() && Math.abs(currentSquare.getRow() - targetSquare.getRow()) <= 2){
                    // Make sure pawn can only move forward, direction is different based on color
                    if(this.color == GamePanel.WHITE){
                        if(currentSquare.getRow() - targetSquare.getRow() <= 2){
                            this.firstMove = false;
                            return true;
                        }
                    }
                    else {
                        if(currentSquare.getRow() - targetSquare.getRow() >= -2){
                            this.firstMove = false;
                            return true;
                        }
                    }
                }
            }
        }
        else{
            // If target is not occupied or does not have a friendly piece on it
            if(targetSquare.getCurrentPiece() == null || targetSquare.getCurrentPiece().color != this.color){
                // If target col is the same and the row movement is 1
                if(currentSquare.getCol() == targetSquare.getCol() && Math.abs(currentSquare.getRow() - targetSquare.getRow()) == 1){
                    // Make sure pawn can only move forward, direction is different based on color
                    if(this.color == GamePanel.WHITE){
                        if(currentSquare.getRow() - targetSquare.getRow() == 1){
                            return true;
                        }
                    }
                    else {
                        if(currentSquare.getRow() - targetSquare.getRow() == -1){
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }


}

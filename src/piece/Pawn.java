package piece;

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
}

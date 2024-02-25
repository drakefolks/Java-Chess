package piece;

import main.GamePanel;

public class Rook extends Piece{
    public Rook(int color, String position) {
        super(color, position);

        if(color == GamePanel.WHITE){
            image = getImage("/piece/w-rook");
        }
        else{
            image = getImage("/piece/b-rook");
        }
    }
}

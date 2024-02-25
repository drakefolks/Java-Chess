package piece;

import main.GamePanel;

public class King extends Piece{
    public King(int color, String position) {
        super(color, position);

        if(color == GamePanel.WHITE){
            image = getImage("/piece/w-king");
        }
        else{
            image = getImage("/piece/b-king");
        }
    }
}

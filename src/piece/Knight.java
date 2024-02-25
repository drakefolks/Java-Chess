package piece;

import main.GamePanel;

public class Knight extends Piece{
    public Knight(int color, String position) {
        super(color, position);

        if(color == GamePanel.WHITE){
            image = getImage("/piece/w-knight");
        }
        else{
            image = getImage("/piece/b-knight");
        }
    }
}

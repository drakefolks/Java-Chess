package piece;

import main.GamePanel;

public class Queen extends Piece{
    public Queen(int color, String position) {
        super(color, position);

        if(color == GamePanel.WHITE){
            image = getImage("/piece/w-queen");
        }
        else{
            image = getImage("/piece/b-queen");
        }
    }
}

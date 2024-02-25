package piece;

import main.GamePanel;

public class Bishop extends Piece{
    public Bishop(int color, String position) {
        super(color, position);

        if(color == GamePanel.WHITE){
            image = getImage("/piece/w-bishop");
        }
        else{
            image = getImage("/piece/b-bishop");
        }
    }
}

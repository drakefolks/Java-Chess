package board;

import main.GamePanel;

import java.awt.*;
import java.util.ArrayList;

public class Board {
    static final int MAX_COL = 8;
    static final int MAX_ROW = 8;
    public static final int SQUARE_SIZE = 100;
    public static final int HALF_SQUARE_SIZE = SQUARE_SIZE/2;
    static int chessboardWidth = MAX_COL * SQUARE_SIZE;
    static int chessboardHeight = MAX_ROW * SQUARE_SIZE;
    public static ArrayList<Square> squares = new ArrayList<>();

    public static int getX(int col){
        int startX = (GamePanel.WIDTH - chessboardWidth) / 2;
        return startX + col * SQUARE_SIZE;
    }
    public static int getY(int row){
        if(row == 0){
            int startY = (GamePanel.HEIGHT - chessboardHeight) / 2;
            return startY + 1;
        }
        else{
            int startY = (GamePanel.HEIGHT - chessboardHeight) / 2;
            return startY + row * SQUARE_SIZE;
        }
    }

    public void draw(Graphics2D g2){
        int squareCNT = 0;

        char[] columnLabels = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};

        for(int row = 0; row < MAX_ROW; row++){
            for(int col = 0; col < MAX_COL; col++){
                if(squareCNT % 2 == 0){
                    g2.setColor(new Color(210,165,125));
                }
                else {
                    g2.setColor(new Color(175,115,70));
                }

                // Draw the square at the calculated position
                g2.fillRect(getX(col), getY(row), SQUARE_SIZE, SQUARE_SIZE);

                // Draw the notation string for each square
                int alpha = 80;
                g2.setColor(new Color(0,0,0,alpha));
                String notation = columnLabels[col] + String.valueOf(MAX_ROW - row);
                g2.drawString(notation, getX(col) + 5, getY(row) + 15);

                if(squares.size() < 64){
                    squares.add(new Square(getX(col), getY(row), row, col, notation, null));
                }

                squareCNT++;
            }
            squareCNT++;
        }
    }

}

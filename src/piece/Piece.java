package piece;

import board.Board;
import board.Square;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

// The super class for every piece
public class Piece {
    public BufferedImage image;
    public int color;
    public String position;

    public int x;
    public int y;

    public boolean simulating = false;

    public Piece(int color, String position){
        this.color = color;
        this.position = position;
    }

    public BufferedImage getImage(String imagePath){
        BufferedImage image = null;

        try{
            image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
        }catch (IOException e){
            e.printStackTrace();
        }
        return image;
    }

    private void getXY(){
        for(Square square: Board.squares){
            if(Objects.equals(square.getLabel(), this.position)){
                x = square.getX();
                y = square.getY();

                square.setCurrentPiece(this);
            }
        }
    }

    Square getSquare(String label){
        for(Square square: Board.squares){
            if(Objects.equals(square.getLabel(), label)){
                return square;
            }
        }
        return null;
    }

    public boolean validMove(String targetPos){
        return false;
    }

    public void draw(Graphics2D g2){
        if(simulating){
            if(x != 0 && y !=0){
                g2.drawImage(image, x,y,Board.SQUARE_SIZE, Board.SQUARE_SIZE, null);
            }
        }
        else{
            getXY();

            if(x != 0 && y !=0){
                g2.drawImage(image, x,y,Board.SQUARE_SIZE, Board.SQUARE_SIZE, null);
            }
        }
    }
}

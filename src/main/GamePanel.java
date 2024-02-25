package main;

import board.Board;
import board.Square;
import piece.*;

import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable{
    public static final int WIDTH = 1100;
    public static final int HEIGHT = 800;
    final int FPS = 60;
    Thread gameThread;
    Board board = new Board();
    Mouse mouse = new Mouse();
    // PIECES
    public static ArrayList<Piece> pieces = new ArrayList<>();
    public static ArrayList<Piece> simPieces = new ArrayList<>();
    Piece activeP;

    // COLOR
    public static final int WHITE = 0;
    public static final int BLACK = 1;
    int currentColor = WHITE;

    public GamePanel(){
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);

        addMouseMotionListener(mouse);
        addMouseListener(mouse);

        setPieces();
        copyPieces(pieces, simPieces);
    }

    public void launchGame(){
        gameThread = new Thread(this);
        gameThread.start(); // calls the run method below
    }

    public void setPieces(){
        // White team
        pieces.add(new Pawn(WHITE, "A2"));
        pieces.add(new Pawn(WHITE, "B2"));
        pieces.add(new Pawn(WHITE, "C2"));
        pieces.add(new Pawn(WHITE, "D2"));
        pieces.add(new Pawn(WHITE, "E2"));
        pieces.add(new Pawn(WHITE, "F2"));
        pieces.add(new Pawn(WHITE, "G2"));
        pieces.add(new Pawn(WHITE, "H2"));
        pieces.add(new Rook(WHITE, "A1"));
        pieces.add(new Knight(WHITE, "B1"));
        pieces.add(new Bishop(WHITE, "C1"));
        pieces.add(new Queen(WHITE, "D1"));
        pieces.add(new King(WHITE, "E1"));
        pieces.add(new Bishop(WHITE, "F1"));
        pieces.add(new Knight(WHITE, "G1"));
        pieces.add(new Rook(WHITE, "H1"));

        // Black team
        pieces.add(new Pawn(BLACK, "A7"));
        pieces.add(new Pawn(BLACK, "B7"));
        pieces.add(new Pawn(BLACK, "C7"));
        pieces.add(new Pawn(BLACK, "D7"));
        pieces.add(new Pawn(BLACK, "E7"));
        pieces.add(new Pawn(BLACK, "F7"));
        pieces.add(new Pawn(BLACK, "G7"));
        pieces.add(new Pawn(BLACK, "H7"));
        pieces.add(new Rook(BLACK, "A8"));
        pieces.add(new Knight(BLACK, "B8"));
        pieces.add(new Bishop(BLACK, "C8"));
        pieces.add(new Queen(BLACK, "D8"));
        pieces.add(new King(BLACK, "E8"));
        pieces.add(new Bishop(BLACK, "F8"));
        pieces.add(new Knight(BLACK, "G8"));
        pieces.add(new Rook(BLACK, "H8"));
    }

    private void copyPieces(ArrayList<Piece> source, ArrayList<Piece> target){
        target.clear();
        for(int i = 0; i< source.size(); i++){
            target.add(source.get(i));
        }
    }

    @Override
    public void run() {
        // GAME LOOP
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread != null){
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime)/drawInterval;
            lastTime = currentTime;

            if(delta >= 1){
                update();
                repaint();
                delta--;
            }
        }
    }

    private void update(){
        if(mouse.pressed){
            if(activeP == null){
                activeP = mouseOnPiece();
            }
            else {
                // If the player is holding a piece, simulate the move
                simulate();
            }
        }

        if(mouse.pressed == false){
            if(activeP != null){
                activeP.simulating = false;
                activeP.position = getHoveredLocation();
                activeP = null;
            }
        }
    }

    private void simulate(){
        // If a piece is being held, update its position
        activeP.simulating = true;
        activeP.x = mouse.x - Board.HALF_SQUARE_SIZE;
        activeP.y = mouse.y - Board.HALF_SQUARE_SIZE;
    }

    private Piece mouseOnPiece(){
        int mouseX = mouse.x;
        int mouseY = mouse.y;

        for(Square square : Board.squares){
            if(mouseX >= square.getX() && mouseX < (square.getX() + Board.SQUARE_SIZE) &&
                    mouseY >= square.getY() && mouseY < (square.getY() + Board.SQUARE_SIZE))
            {
                System.out.println("Mouse in: " + square.getLabel() + "\nOn piece: " + square.getCurrentPiece());
                return square.getCurrentPiece();
            }
        }
        return null;
    }

    private String getHoveredLocation(){
        int mouseX = mouse.x;
        int mouseY = mouse.y;

        for(Square square : Board.squares){
            if(mouseX >= square.getX() && mouseX < (square.getX() + Board.SQUARE_SIZE) &&
                    mouseY >= square.getY() && mouseY < (square.getY() + Board.SQUARE_SIZE))
            {
                System.out.println("Mouse in: " + square.getLabel());
                return square.getLabel();
            }
        }
        return null;
    }

    private Square getHoveredSquare(){
        int mouseX = mouse.x;
        int mouseY = mouse.y;

        for(Square square : Board.squares){
            if(mouseX >= square.getX() && mouseX < (square.getX() + Board.SQUARE_SIZE) &&
                    mouseY >= square.getY() && mouseY < (square.getY() + Board.SQUARE_SIZE))
            {
                System.out.println("Mouse in: " + square.getLabel());
                return square;
            }
        }
        return null;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // BOARD
        board.draw(g2);

        // PIECES
        for(Piece p: simPieces){
            p.draw(g2);
        }

        // Drawing simulated moves
        if(activeP != null){
            g2.setColor(Color.BLUE);
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f));
            Square square = getHoveredSquare();
            if(square != null){
                g2.fillRect(square.getX(), square.getY(), Board.SQUARE_SIZE, Board.SQUARE_SIZE);
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

                activeP.draw(g2);
            }
        }
    }
}

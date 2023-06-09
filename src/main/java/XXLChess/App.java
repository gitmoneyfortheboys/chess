package XXLChess;

//import org.reflections.Reflections;
//import org.reflections.scanners.Scanners;
//import processing.core.PApplet;
//import processing.core.PImage;
//import processing.data.JSONObject;
//import processing.data.JSONArray;
//import processing.core.PFont;
//import processing.event.MouseEvent;

//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.TimeUnit;
//import java.awt.Font;
//import java.io.*;
//mport java.util.*;

import processing.core.PApplet;
import processing.core.PImage;
import processing.event.MouseEvent;
import XXLChess.*;



public class App extends PApplet {

    public static final int SPRITESIZE = 480;
    public static final int CELLSIZE = 48;
    public static final int SIDEBAR = 120;
    public static final int BOARD_WIDTH = 14;

    public static int WIDTH = CELLSIZE*BOARD_WIDTH+SIDEBAR;
    public static int HEIGHT = BOARD_WIDTH*CELLSIZE;

    public static final int FPS = 60;

    public static final int WHITESQUARESCOLOUR = 0xFFF0D9B5;
    public static final int BLACKSQUARESCOLOUR = 0xFFB58863; 
	
    public String configPath;

    private Board board;
    private Game game;


    public App() {
        this.configPath = "config.json";
    }

    /**
     * Initialise the setting of the window size.
    */
    public void settings() {
        size(WIDTH, HEIGHT);
    }

    /**
     * Load all resources such as images. Initialise the elements such as the player, enemies and map elements.
    */
    public void setup() {
        frameRate(FPS);
                
        // Initialize the game instance variable
        this.game = new Game();
                
        // Create a new King piece and add it to the game
        Square kingSquare = game.getBoard().getSquare(7, 7);
        King king = new King(Color.WHITE, kingSquare, "src/main/resources/XXLChess/w-king.png");
        game.addPiece(king);
        
        board = new Board();
        
    }

    /**
     * Receive key pressed signal from the keyboard.
    */
    public void keyPressed(){


    }
    
    /**
     * Receive key released signal from the keyboard.
    */
    public void keyReleased(){

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }
    

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    /**
     * Draw all elements in the game by current frame. 
    */
    public void draw() {
        // Draw each square on the board
        for (int x = 0; x < BOARD_WIDTH; x++) {
            for (int y = 0; y < BOARD_WIDTH; y++) {
                // Set the color based on the square's coordinates
                if ((x + y) % 2 == 0) {
                    fill(WHITESQUARESCOLOUR);
                } else {
                    fill(BLACKSQUARESCOLOUR);
                }
            // Draw the square
            rect(x * CELLSIZE, y * CELLSIZE, CELLSIZE, CELLSIZE);

            // Draw piece if it exists on this square
            Square square = game.getBoard().getSquare(x, y);
            if (!square.isEmpty()) {
                Piece piece = square.getPiece();
                PImage img = loadImage(piece.getImgPath());
                image(img, x * CELLSIZE, y * CELLSIZE, CELLSIZE, CELLSIZE);
                }
            }
        }
    }
	

    public static void main(String[] args) {
        PApplet.main("XXLChess.App");
    }

}

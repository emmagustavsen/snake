package no.uib.inf101.sem2.snake.model.snake;

import java.awt.Color;
import java.util.LinkedList;

import no.uib.inf101.sem2.snake.model.Tile;

/**
 * Class representing the snake.
 * Represented as a linked list for easily adding length to the snake.
 * 
 * Only a single tile at the moment for testing purposes!!
 * 
 * @author Jasmine Næss
 */
public class Snake {

    public LinkedList<Tile> body;
    public Tile tile;
    public boolean[][] shape;

    public Snake(Tile tile, boolean[][] shape) {
        this.tile = tile;
        this.shape = shape;
    }

    /**
     * The shape of the piece.
     * 
     * @return shape
     */
    public boolean[][] getShape() {
        return shape;
    }

    /**
     * The width of the piece.
     * 
     * @return width
     */
    public int getWidth() {
        return shape[0].length;
    }
    
    /**
     * The height of the piece.
     * 
     * @return height
     */
    public int getHeight() {
        return shape.length;
    }

    /**
     * The tiles creating the snake
     * 
     * @return shape and color of Snake
     */
    public Tile getTile() {
        return tile;
    }

    // Custom colors for snake
    // default:
    public static final Color darkgreen = new Color(53, 79, 82);
    // options (from menu):
    public static final Color purple = new Color(94, 84, 142);
    public static final Color pink = new Color(255, 117, 143);
    public static final Color blue = new Color(144, 224, 239);

    // All snakes have the same starting position (or "shape")
    public static final Snake G = new Snake (new Tile(darkgreen, 'g'), new boolean[][] {
        {  true,  true,  true }});

    public static final Snake P = new Snake (new Tile(purple, 'p'), new boolean[][] {
        {  true,  true,  true }});
    
    public static final Snake R = new Snake (new Tile(pink, 'r'), new boolean[][] {
        {  true,  true,  true }});

    public static final Snake B = new Snake (new Tile(blue, 'b'), new boolean[][] {
        {  true,  true,  true }});
    
    // Array of all snake options
    public static final Snake[] SNAKEOPTIONS = {G, P, R, B};

}

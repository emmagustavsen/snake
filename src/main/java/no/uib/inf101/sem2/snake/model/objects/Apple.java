package no.uib.inf101.sem2.snake.model.objects;

import java.awt.Color;
import java.util.Random;

import no.uib.inf101.sem2.grid.Coordinate;
import no.uib.inf101.sem2.snake.model.Tile;

/**
 * Class representing the apple (or other fruit) that the snake eats.
 * Should appear on a random tile on the board.
 * Should be removed from the board when eaten, and a new apple should appear.
 * 
 * @author Jasmine Næss
 */
public class Apple {

    private final Color color;
    private Coordinate position;
    private final Random random;

    /**
     * Class constructor.
     * 
     * @param color
     * @param random
     */
    public Apple(Color color, Random random) {
        this.color = color;
        this.random = random;
        setRandomPosition();
    }

    public Color getColor() {
        return color;
    }

    public Coordinate getPosition() {
        return position;
    }
    
    public void setRandomPosition() {
        int row = random.nextInt(15); 
        int col = random.nextInt(15);
        position = new Coordinate(row, col);
    }

    public Tile getTile() {
        return new Tile(color, 'A');
    }

}

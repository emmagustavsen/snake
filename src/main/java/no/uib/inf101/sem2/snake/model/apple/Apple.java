package no.uib.inf101.sem2.snake.model.apple;

import no.uib.inf101.sem2.grid.Coordinate;

/**
 * Class representing the apple (or other fruit) that the snake eats.
 * In very simple terms;
 * other aspects of the Apple are defined in other classes.
 * 
 * @author Jasmine Næss
 */
public class Apple {

    public final char character;
    public final Coordinate position;

    /**
     * Class constructor.
     * Constructs a new Apple, defined by a character and a coordinate.
     * 
     * @param character
     * @param coordinate
     */
    public Apple(char character, Coordinate coordinate) {
        this.character = character;
        this.position = coordinate;
    }

    public Coordinate getApplePosition() {
        return position;
    }
}

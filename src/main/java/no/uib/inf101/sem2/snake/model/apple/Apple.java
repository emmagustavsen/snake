package no.uib.inf101.sem2.snake.model.apple;

import no.uib.inf101.sem2.grid.CellPosition;

/**
 * Class representing the apple (or other fruit) that the snake eats.
 * In very simple terms;
 * other aspects of the Apple are defined in other classes.
 * 
 * @author Jasmine Næss
 */
public class Apple {

    public final char character;
    public final CellPosition position;

    /**
     * Class constructor.
     * Constructs a new Apple, defined by a character and a coordinate.
     * 
     * @param character
     * @param position
     */
    public Apple(char character, CellPosition position) {
        this.character = character;
        this.position = position;
    }

    public CellPosition getApplePosition() {
        return position;
    }
}

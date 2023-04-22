package no.uib.inf101.sem2.snake.model.objects;

import java.util.Random;

import no.uib.inf101.sem2.grid.CellPosition;
import no.uib.inf101.sem2.snake.model.Board;

/**
 * Class representing the apple (or other fruit) that the snake eats.
 * Can also be used to represent other objects that can be obstacles.
 * 
 * @author Jasmine Næss
 */
public class Object {

    public char character;
    public CellPosition position;
    private final Random random;
    public Board board;

    private int boardRows;
    private int boardCols;

    /**
     * Class constructor.
     * Constructs a new Apple, defined by a character and a coordinate.
     * 
     * @param character
     * @param position
     */
    public Object(char character, CellPosition position) {
        this.character = character;
        this.position = position;
        random = new Random();
    }

    public CellPosition getObjectPosition() {
        return position;
    }

    /**
     * Spawns a new object on the board.
     * The new object is placed on a random empty tile.
     * The object is defined by a character.
     * 
     * @param objectChar 
     */
    public void spawnObject(char objectChar) {
        int x = random.nextInt(boardRows);
        int y = random.nextInt(boardCols);
        CellPosition objectPosition = new CellPosition(x, y);
    
        // If the fruit is not placed on an empty tile, generate a new position
        while (!board.get(objectPosition).equals('-')) {
            x = random.nextInt(boardRows);
            y = random.nextInt(boardCols);
            objectPosition = new CellPosition(x, y);
        }
        new Object(objectChar, objectPosition);
        board.set(objectPosition, objectChar);
    }
    
}

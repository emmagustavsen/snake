package no.uib.inf101.sem2.snake.model.apple;

import java.util.Random;
import java.util.Set;

import no.uib.inf101.sem2.grid.Coordinate;
import no.uib.inf101.sem2.snake.model.snake.Snake;

/**
 * Class representing a randomly positioned Apple on the board.
 * 
 * @author Jasmine Næss
 */
public class RandomApple implements AppleFactory {
    private final int boardRows;
    private final int boardCols;
    private final Random random;
    
    /**
     * Class constructor.
     * Generates a new Apple, which is randomly placed somewhere on the board.
     * 
     * @param boardRows
     * @param boardCols
     */
    public RandomApple(int boardRows, int boardCols) {
        this.boardRows = boardRows;
        this.boardCols = boardCols;
        random = new Random();
    }

    public Coordinate getRandomCoordinate(Set<Coordinate> snakeCoords) {
        Coordinate randomCoord;
        int row = random.nextInt(boardRows);
        int col = random.nextInt(boardCols);
        randomCoord = new Coordinate(row, col);

        // make sure the apple doesn't spawn on the snake
        while (!snakeCoords.contains(randomCoord));
        return randomCoord;
    }

    @Override
    public Apple getNextApple(Snake snake) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNextApple'");
    }
}

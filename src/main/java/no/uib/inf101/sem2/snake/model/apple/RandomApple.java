package no.uib.inf101.sem2.snake.model.apple;

import java.util.Random;
import java.util.Set;

import no.uib.inf101.sem2.grid.CellPosition;
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

    public CellPosition getRandomCoordinate(Set<CellPosition> snakePos) {
        CellPosition randomCoord;
        int row = random.nextInt(boardRows);
        int col = random.nextInt(boardCols);
        randomCoord = new CellPosition(row, col);

        // make sure the apple doesn't spawn on the snake
        while (!snakePos.contains(randomCoord));
        return randomCoord;
        
    }

    @Override
    public Apple getNextApple(Snake snake) {
       return null;
    }
}

package no.uib.inf101.sem2.snake.model.apple;

import no.uib.inf101.sem2.snake.model.snake.Snake;

/**
 * Interface representing a factory for creating apples.
 *
 * @author Jasmine Næss
 */
public interface AppleFactory {

    /**
     * Returns the next apple to be eaten.
     * It's placement should be random, but cannot overlap with the snake.
     * Thus, we need to keep track of the snake's position.
     * 
     * @param snake
     * @return the next apple
     */
    Apple getNextApple(Snake snake);
}

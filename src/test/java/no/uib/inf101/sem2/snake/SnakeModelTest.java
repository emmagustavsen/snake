package no.uib.inf101.sem2.snake;

import static org.junit.Assert.*;

import no.uib.inf101.sem2.grid.CellPosition;
import no.uib.inf101.sem2.snake.model.Board;
import no.uib.inf101.sem2.snake.model.Direction;
import no.uib.inf101.sem2.snake.model.GameState;
import no.uib.inf101.sem2.snake.model.SnakeModel;
import org.junit.Before;
import org.junit.Test;

import no.uib.inf101.sem2.grid.GridCell;
import no.uib.inf101.sem2.grid.GridDimension;
import no.uib.inf101.sem2.snake.model.objects.Object;
import no.uib.inf101.sem2.snake.model.snake.Snake;

public class SnakeModelTest {
    private SnakeModel model;
    private Board board;

    private Snake snake;

    @Test
    public void testMoveSnakeUp() {
        this.model = new SnakeModel(new Board(10,10),new Snake(new CellPosition(1,1)));
        Snake snake = model.moveSnake(Direction.UP);
        assertEquals( new CellPosition(0, 1), model.getSnakePosition());
    }

    @Test
    public void testMoveSnakeDown() {
        model.moveSnake(Direction.DOWN);
        assertEquals(model.getSnakePosition().get(0), new CellPosition(2, 1));
    }

    @Test
    public void testMoveSnakeLeft() {
        model.moveSnake(Direction.LEFT);
        assertEquals(model.getSnakePosition().get(0), new CellPosition(1, 0));
    }

    @Test
    public void testMoveSnakeRight() {
        model.moveSnake(Direction.RIGHT);
        assertEquals(model.getSnakePosition().get(0), new CellPosition(1, 2));
    }

    @Test
    public void testMoveSnakeInvalid() {
        model.getBoard().set(new CellPosition(0, 1), 'S'); // Set obstacle on the way
        model.moveSnake(Direction.UP);
        assertEquals(model.getGameScreen(), GameState.GAME_OVER);
    }
}

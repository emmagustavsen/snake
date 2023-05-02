package no.uib.inf101.sem2.snake;

import static org.junit.Assert.*;

import no.uib.inf101.sem2.grid.CellPosition;
import no.uib.inf101.sem2.snake.model.Board;
import no.uib.inf101.sem2.snake.model.Direction;

import no.uib.inf101.sem2.snake.model.GameState;
import no.uib.inf101.sem2.snake.model.SnakeModel;
import org.junit.jupiter.api.Test;

import no.uib.inf101.sem2.snake.model.objects.Object;
import no.uib.inf101.sem2.snake.model.snake.Snake;

import java.util.LinkedList;
import java.util.List;

public class SnakeModelTest {
    private SnakeModel model = new SnakeModel(new Board(10,10),new Snake(new CellPosition(1,1)));
    private Snake snake = new Snake(new CellPosition(1,1));

    @Test
    public void testGenerateObject() {
        this.model = new SnakeModel(new Board(10,10),new Snake(new CellPosition(1,1)));
        model.generateObject('A');
        Object object = model.getObject();
        assertTrue(object.getObjectPosition().row() >= 0 && object.getObjectPosition().row() < model.getBoard().rows());
        assertTrue(object.getObjectPosition().col() >= 0 && object.getObjectPosition().col() < model.getBoard().cols());
        assertEquals(model.getBoard().get(object.getObjectPosition()).charValue(), 'A');
    }

    @Test
    public void testGenerateObjectOnOccupiedTile() {
        this.model = new SnakeModel(new Board(10,10),new Snake(new CellPosition(1,1)));
        model.getBoard().set(new CellPosition(0, 0), 'A'); // Place apple at (0, 0)
        model.generateObject('A');
        Object object = model.getObject();
        assertNotEquals(object.getObjectPosition(), new CellPosition(0, 0));
    }

    @Test
    public void testSetDirectionUp() {
        this.model = new SnakeModel(new Board(10,10),new Snake(new CellPosition(1,1)));
       model.setDirection(Direction.UP);
       assertEquals(model.getDirection(), Direction.UP);
    }
    
    @Test
    public void testSetDirectionLeft() {
        this.model = new SnakeModel(new Board(10,10),new Snake(new CellPosition(1,1)));
        model.setDirection(Direction.LEFT);
        assertEquals(model.getDirection(), Direction.LEFT);
    }

    @Test
    public void testSetDirectionDown() {
        this.model = new SnakeModel(new Board(10,10),new Snake(new CellPosition(1,1)));
        model.setDirection(Direction.DOWN);
        assertEquals(model.getDirection(), Direction.DOWN);
    }

    @Test
    public void testSetDirectionCannotChange() {
        this.model = new SnakeModel(new Board(10,10),new Snake(new CellPosition(1,1)));
        model.setDirection(Direction.UP);
        model.setCanChangeDirection(false);
        model.setDirection(Direction.DOWN);
        assertEquals(model.getDirection(), Direction.UP);
    }

    @Test
    public void testUpdateSnake() {
        SnakeModel model3 = new SnakeModel(new Board(10,10),new Snake(new CellPosition(1,1)));

        model3.setDirection(Direction.UP);
        model3.setSnakeLength(3);
        model3.moveSnake(Direction.UP);
        model3.updateSnake();
        model3.setGameScreen(GameState.ACTIVE_GAME);


        // Create the expected snake state after updating
        List<CellPosition> expectedSnakePosition = new LinkedList<>(model3.snakePosition);
        expectedSnakePosition.add(new CellPosition(1, 2));
        expectedSnakePosition.add(new CellPosition(1, 3));
        expectedSnakePosition.add(new CellPosition(2, 3));

        // Assert that the actual snake state matches the expected state
        assertEquals(expectedSnakePosition, model3.getSnake().getSnakePosition());
    }

    @Test
    public void testUpdateSnake2() {
        Board board = new Board(10, 10);
        Snake snake = new Snake(new CellPosition(1, 1));
        SnakeModel model = new SnakeModel(board, snake);

        // Move the snake to a new position
        model.setDirection(Direction.RIGHT);
        model.moveSnake(Direction.RIGHT);

        // Save the position of the snake's head and tail
        CellPosition headPosition = snake.getSnake().pos();
        LinkedList<CellPosition> tailPositions = new LinkedList<>(model.snakePosition);

        // Update the snake
        model.updateSnake();

        // Check that the tail has been removed from the board
        for (CellPosition tailPosition : tailPositions) {
            assertEquals('-', board.get(tailPosition).charValue());
        }

        // Check that the snake's head is still on the board
        assertEquals('S', board.get(headPosition).charValue());
    }



    @Test
    public void testMoveSnake() {
        SnakeModel model2 = new SnakeModel(new Board(10,10),new Snake(new CellPosition(1,1)));
        // Set up the initial state
        model2.setDirection(Direction.RIGHT);
        model2.setSnakeLength(3);
        model2.setGameScreen(GameState.ACTIVE_GAME);

        // Move the snake
        model2.moveSnake(Direction.RIGHT);
        model2.getSnake().moveSnake(0, 1);

        // Create the expected snake state after moving
        List<CellPosition> expectedSnakePosition = new LinkedList<>();
        expectedSnakePosition.add(new CellPosition(1,2));


        // Assert that the actual snake state matches the expected state
        assertEquals(expectedSnakePosition, model2.getSnake().getSnakePosition());
        assertEquals(model2.getBoard().get(new CellPosition(1, 4)).charValue(), 'S');
    }

}

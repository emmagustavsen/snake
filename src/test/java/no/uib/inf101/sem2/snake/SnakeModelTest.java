package no.uib.inf101.sem2.snake;

import static org.junit.Assert.*;

import no.uib.inf101.sem2.grid.CellPosition;
import no.uib.inf101.sem2.snake.model.Board;
import no.uib.inf101.sem2.snake.model.Direction;

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
        this.model.setDirection(Direction.UP);
        this.model.setSnakeLength(3);
        this.model.moveSnake(Direction.UP);
        this.model.updateSnake();

        // Create the expected snake state after updating
        List<CellPosition> expectedSnakePosition = new LinkedList<>();
        expectedSnakePosition.add(new CellPosition(1, 2));
        expectedSnakePosition.add(new CellPosition(1, 3));
        expectedSnakePosition.add(new CellPosition(2, 3));

        // Assert that the actual snake state matches the expected state
        assertEquals(expectedSnakePosition.size(), model.getSnake().getSnakePosition().size());
    }

    @Test
    public void testMoveSnake() {
        // Set up the initial state
        model.setDirection(Direction.RIGHT);
        model.setSnakeLength(3);

        // Move the snake
        model.moveSnake((Direction) model.getDirection());

        // Create the expected snake state after moving
        List<CellPosition> expectedSnakePosition = new LinkedList<>();
        expectedSnakePosition.add(new CellPosition(1, 2));

        // Assert that the actual snake state matches the expected state
        assertEquals(expectedSnakePosition, model.getSnake().getSnakePosition());
        assertEquals(model.getBoard().get(new CellPosition(1, 4)).charValue(), 'S');
    }

}

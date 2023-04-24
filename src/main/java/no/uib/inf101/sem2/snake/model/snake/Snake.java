package no.uib.inf101.sem2.snake.model.snake;

import java.util.Iterator;
import java.util.LinkedList;

import no.uib.inf101.sem2.grid.CellPosition;
import no.uib.inf101.sem2.grid.GridCell;

public class Snake implements Iterable<GridCell<Character>> {

    private GridCell<Character> head;

    /**
     * Create a new snake with the given head position.
     *
     * @param headPos The position of the head of the snake
     */
    public Snake(CellPosition headPos) {
        head = new GridCell<Character>(headPos, 'S');
    }



    /**
     * Getter for the snake, which is only the head for now.
     * 
     * @return head
     */
    public GridCell<Character> getSnake() {
        return head;
    }

    @Override
    public Iterator<GridCell<Character>> iterator() {
        // The snake is a list of cells
        LinkedList<GridCell<Character>> snake = new LinkedList<>();
        snake.add(head);
        return snake.iterator();
    }

    /**
     * Move the snake in the given direction.
     *
     * @param deltaRow The change in row
     * @param deltaCol The change in column
     * @return A new snake with the new position
     */
    public Snake moveSnake(int deltaRow, int deltaCol) {
        int newRow = head.pos().row() + deltaRow;
        int newCol = head.pos().col() + deltaCol;
        return new Snake(new CellPosition(newRow, newCol));
    }
}

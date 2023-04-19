package no.uib.inf101.sem2.snake.model.snake;

import java.util.Iterator;
import java.util.LinkedList;

import no.uib.inf101.sem2.grid.Coordinate;
import no.uib.inf101.sem2.grid.CoordinateItem;
import no.uib.inf101.sem2.snake.model.Board;

/**
 * Class representing the snake.
 * Represented as a linked list for easily adding length to the snake.
 * 
 * @author Jasmine Næss
 */
public class Snake implements Iterable<CoordinateItem<Character>>{

    Coordinate position;
    public final char symbol = 'S';
    LinkedList<Coordinate> body = new LinkedList<>();

    /**
     * Class constructor.
     * 
     * @param position
     * @param length
     */
    public Snake(Coordinate position, int length) {
        this.position = position;
        body.add(position);
        for (int i = 0; i < length; i++) {
            body.add(new Coordinate(position.getRow(), position.getCol() - i));
        }
    }

    public int getLength() {
        return body.size();
    } 

    /**
     * Getter-method for the snake.
     * 
     * @return the snake
     */
    public Coordinate getPosition() {
        return position;
    }

    public Coordinate getTail() {
        return body.get(getLength() - 1);
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }

    public void grow() {
        body.add(getTail());
    }

    // sjekk om denne kan flyttes til Model senere
    public boolean moveSnake(Coordinate position, Board board) {
        if (position.equals(this.position)) {
            return false;
        }
        this.position = position;
        body.add(0, position);
        body.remove(getLength() - 1);
        return true;
    }

    public Coordinate nextHead(int deltaRow, int deltaCol) {
        return new Coordinate(position.getRow() + deltaRow, position.getCol() + deltaCol);
    }

    @Override
    public Iterator<CoordinateItem<Character>> iterator() {
        LinkedList<CoordinateItem<Character>> cells = new LinkedList<>();
        for (Coordinate coord : body) {
            cells.add(new CoordinateItem<>(position, symbol));
        }
        return cells.iterator();
    }

}

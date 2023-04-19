package no.uib.inf101.sem2.snake.model;

import java.awt.Color;
import java.util.Random;

import no.uib.inf101.sem2.grid.Coordinate;
import no.uib.inf101.sem2.grid.CoordinateItem;
import no.uib.inf101.sem2.snake.controller.SnakeControllable;
import no.uib.inf101.sem2.snake.model.snake.Snake;
import no.uib.inf101.sem2.snake.view.SnakeViewable;

/**
 * Class representing the model of the game.
 * 
 * @author Jasmine Næss
 */
public class SnakeModel implements SnakeViewable, SnakeControllable {

    public GameStates gameScreen = GameStates.START_GAME;
    public Random random = new Random();

    public int rows = 15;
    public int cols = 15;
    public int score = 0;

    // custom colors
    Color lightBoard = new Color(61, 61, 61);
    Color darkBoard = new Color(49, 49, 49);
    Color snakeColor = new Color(113, 131, 85);
    Color appleColor = new Color(188, 71, 73);

    public final Board board = new Board(rows, cols, new Tile(lightBoard, '-'));
    public final Snake snake = new Snake(new Coordinate(random.nextInt(15), random.nextInt(15)), 3);
    
     /**
     * Class constructor.
     * 
     */
    public SnakeModel() {
        // flytte dette til view?
        for (int row = 0; row < 15; row++) {
            for (int col = 0; col < 15; col++) {
    
                if ((row + col) % 2 == 0) {
                    this.board.set(new Coordinate(row, col), new Tile(lightBoard, '-'));
                }
                else {
                    this.board.set(new Coordinate(row, col), new Tile(darkBoard, '+'));
                }
            }
        }
    }

    public boolean move(Coordinate position) {
        if (!isLegalMove(position)) {
            gameScreen = GameStates.GAME_OVER;
            return false;
        }
        if (board.get(position).equals('A')) {
            // spis eplet
            snake.grow();
            score += 1;
        }
        else {
            board.set(snake.getTail(), (new Tile(snakeColor, 'T')));
        }
        snake.moveSnake(position, board);
        board.set(snake.getPosition(), (new Tile(snakeColor, 'S')));
        return true;
    }

    public Snake getSnake() {
        return snake;
    }
       
    @Override
    public int getRows() {
        return board.getRows();
    }

    @Override
    public int getCols() {
        return board.getCols();
    }

    @Override
    public Iterable<CoordinateItem<Tile>> iterableBoard() {
        return this.board;
    }

    @Override
    public void set(Coordinate tileCoordinate, Tile color) {
        board.set(tileCoordinate, color);
    }

    @Override
    public Tile get(Coordinate tileCoordinate) {
        return board.get(tileCoordinate);
    }

    @Override
    public GameStates getGameScreen() {
        return gameScreen;
    }

    @Override
    public void setGameScreen(GameStates gameScreen) {
        this.gameScreen = gameScreen;
    }

    @Override
    public int getScore() {
        return board.score;
    }

    @Override
    public void moveSnake(int deltaRow, int deltaCol) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'moveSnake'");
    }

    @Override
    public void exit() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exit'");
    }

    public boolean isLegalMove(Coordinate position) {
        return this.board.coordinateIsOnGrid(position)
        && !this.board.get(position).equals('S');
    }
}

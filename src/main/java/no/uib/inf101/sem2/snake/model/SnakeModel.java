package no.uib.inf101.sem2.snake.model;

import java.util.Random;

import no.uib.inf101.sem2.grid.Coordinate;
import no.uib.inf101.sem2.grid.CoordinateItem;
import no.uib.inf101.sem2.snake.controller.SnakeControllable;
import no.uib.inf101.sem2.snake.model.apple.Apple;
import no.uib.inf101.sem2.snake.model.snake.Snake;
import no.uib.inf101.sem2.snake.view.ColorTheme;
import no.uib.inf101.sem2.snake.view.SnakeViewable;

/**
 * Class representing the model of the game.
 * 
 * @author Jasmine Næss
 */
public class SnakeModel implements SnakeViewable, SnakeControllable {

    public GameStates gameScreen = GameStates.START_GAME;
    public Random random = new Random();
    public ColorTheme theme = new ColorTheme();

    public int rows = 15;
    public int cols = 15;
    public int score = 0;

    public final Board board = new Board(rows, cols, new Tile(theme.lightBoard, '-'));
    public final Snake snake = new Snake(new Coordinate(10, 10), 3);
    public final Apple apple = new Apple('A', new Coordinate(random.nextInt(15), random.nextInt(15)));
    
     /**
     * Class constructor.
     * 
     */
    public SnakeModel() {
        // Set the snake and apple on the board
        board.set(snake.getPosition(), (new Tile(theme.snakeColor, 'S')));
        board.set(apple.position, (new Tile(theme.appleColor, 'A')));
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
            board.set(snake.getTail(), (new Tile(theme.snakeColor, 'T')));
        }
        snake.moveSnake(position, board);
        board.set(snake.getPosition(), (new Tile(theme.snakeColor, 'S')));
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

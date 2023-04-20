package no.uib.inf101.sem2.snake.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

import no.uib.inf101.sem2.grid.Coordinate;
import no.uib.inf101.sem2.snake.midi.Song;
import no.uib.inf101.sem2.snake.model.GameStates;
import no.uib.inf101.sem2.snake.model.SnakeModel;
import no.uib.inf101.sem2.snake.model.snake.Snake;
import no.uib.inf101.sem2.snake.view.SnakeView;

/**
 * Controller for Snake, tracking the keys pressed by the user. Implements KeyListener and ActionListener.
 * 
 * @author Jasmine Næss - jasmine.ness@student.uib.no
 */
public class SnakeController implements KeyListener, ActionListener {
    SnakeModel model;
    SnakeControllable controllable;
    SnakeView viewer;

    Snake snake;
    Timer timer;
    Song song;
    
    /**
     * Class constructor.
     * 
     * @param controllable
     * @param viewer
     */
    public SnakeController(SnakeControllable controllable, SnakeView viewer) {
        this.controllable = controllable;
        this.viewer = viewer;
        viewer.addKeyListener(this);
        this.song = new Song();
    }

    // // se på implementasjonen av denne (brukes i screens)
    // public SnakeController(SnakeModel model, SnakeView view) {}


    @Override
    public void actionPerformed(ActionEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (controllable.getGameScreen() == GameStates.START_GAME) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                song.run();
                controllable.setGameScreen(GameStates.ACTIVE_GAME);
                viewer.repaint();
            }
        }

        if (controllable.getGameScreen() == GameStates.ACTIVE_GAME) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                controllable.moveSnake(-1, 0);
                viewer.repaint();

            }
            else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                controllable.moveSnake(1, 0);
                viewer.repaint();
            }
            else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                controllable.moveSnake(0, -1);
                viewer.repaint();
            }
            else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                controllable.moveSnake(0, 1);
                viewer.repaint();
            }
            else if (e.getKeyCode() == KeyEvent.VK_Q) {
                controllable.exit();
                viewer.repaint();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    public boolean snakeIsMoving (int x, int y) {
        Snake snake = model.getSnake();
        Coordinate newPos = new Coordinate(snake.getPosition().getRow() + x, snake.getPosition().col + y);
        return model.move(newPos);
    }


}

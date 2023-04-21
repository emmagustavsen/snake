package no.uib.inf101.sem2.snake.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import no.uib.inf101.sem2.snake.midi.Song;
import no.uib.inf101.sem2.snake.model.Direction;
import no.uib.inf101.sem2.snake.model.GameState;
import no.uib.inf101.sem2.snake.model.snake.Snake;
import no.uib.inf101.sem2.snake.view.SnakeView;
import no.uib.inf101.sem2.snake.model.SnakeModel;

/**
 * Controller for Snake, tracking the keys pressed by the user. Implements KeyListener and ActionListener.
 * 
 * @author Jasmine Næss - jasmine.ness@student.uib.no
 */
public class SnakeController implements KeyListener, ActionListener {
    SnakeControllable controllable;
    SnakeView viewer;

    Snake snake;
    Timer timer;
    Song song;

    SnakeModel snakeModel;
    
    /**
     * Class constructor.
     * 
     * @param model
     * @param viewer
     */
    public SnakeController(SnakeControllable model, SnakeView viewer) {
        // this.model = model;
        this.viewer = viewer;
        this.controllable = model;
        viewer.addKeyListener(this);
        this.song = new Song();
        this.timer = new Timer(model.getDelay(), this::clockTick);
        timer.start();
    }

    private void clockTick(ActionEvent action) {
        this.controllable.clockTick();
        viewer.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (controllable.getGameScreen() == GameState.START_GAME) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                song.run();
                controllable.setGameScreen(GameState.ACTIVE_GAME);
                viewer.repaint();
            }
        }
        if (controllable.getGameScreen() == GameState.ACTIVE_GAME) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                controllable.setDirection(Direction.UP);
                viewer.repaint();
            }
            else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                controllable.setDirection(Direction.DOWN);
                viewer.repaint();
            }
            else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                controllable.setDirection(Direction.LEFT);
                viewer.repaint();
            }
            else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                controllable.setDirection(Direction.RIGHT);
                viewer.repaint();
            }
            else if (e.getKeyCode() == KeyEvent.VK_Q) {
                System.exit(0);
                viewer.repaint();
            }
            else if (e.getKeyCode() == KeyEvent.VK_P) {
                controllable.setGameScreen(GameState.PAUSE);
                viewer.repaint();
            }
            else if (e.getKeyCode() == KeyEvent.VK_R){
                controllable.restart();
                viewer.repaint();
            }
        }
        if (controllable.getGameScreen() == GameState.PAUSE){
            if (e.getKeyCode() == KeyEvent.VK_ENTER){
                controllable.setGameScreen(GameState.ACTIVE_GAME);
                viewer.repaint();
            }
        }
        if (controllable.getGameScreen() == GameState.GAME_OVER) {
            if (e.getKeyCode() == KeyEvent.VK_R) {
                controllable.restart();
                viewer.repaint();
            }
            else if (e.getKeyCode() == KeyEvent.VK_Q) {
                System.exit(0);
                viewer.repaint();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

}

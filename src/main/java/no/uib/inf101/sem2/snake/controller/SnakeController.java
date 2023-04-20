package no.uib.inf101.sem2.snake.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

import no.uib.inf101.sem2.snake.midi.Song;
import no.uib.inf101.sem2.snake.model.GameStates;
import no.uib.inf101.sem2.snake.view.SnakeView;

/**
 * Controller for Snake, tracking the keys pressed by the user. Implements KeyListener and ActionListener.
 * 
 * @author Jasmine Næss - jasmine.ness@student.uib.no
 */
public class SnakeController implements KeyListener, ActionListener {

    SnakeControllable controller;
    SnakeView viewer;
    Timer timer;
    Song song;
    
    /**
     * Class constructor.
     * 
     * @param controller
     * @param viewer
     */
    public SnakeController(SnakeControllable controller, SnakeView viewer) {
        this.controller = controller;
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
        if (controller.getGameScreen() == GameStates.START_GAME) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                song.run();
                controller.setGameScreen(GameStates.ACTIVE_GAME);
                viewer.repaint();
            }
        }

        if (controller.getGameScreen() == GameStates.ACTIVE_GAME) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                controller.moveSnake(-1, 0);
                viewer.repaint();

            }
            else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                controller.moveSnake(1, 0);
                viewer.repaint();
            }
            else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                controller.moveSnake(0, -1);
                viewer.repaint();
            }
            else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                controller.moveSnake(0, 1);
                viewer.repaint();
            }
            else if (e.getKeyCode() == KeyEvent.VK_Q) {
                controller.exit();
                viewer.repaint();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

}

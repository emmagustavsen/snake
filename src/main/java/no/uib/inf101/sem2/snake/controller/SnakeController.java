package no.uib.inf101.sem2.snake.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

import no.uib.inf101.sem2.snake.midi.Song;
import no.uib.inf101.sem2.snake.model.SnakeModel;
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


    public SnakeController(SnakeModel model, SnakeView view) {
    }


    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            song.run();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}

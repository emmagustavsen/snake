package no.uib.inf101.sem2.snake.view.Screens;

import java.util.Stack;
import javax.swing.JFrame;


/**
 * A class for managing the screens in the game.
 * Makes it easier to switch between screens (main menu, options, about and the game itself).
 * Chose to use a stack to represent the screens, so that we can easily go back to the previous screen.
 * 
 * @author Jasmine Næss
 */
public class ScreenManager {

    private final JFrame frame;
    private final Stack<JFrame> screens;

    public ScreenManager(JFrame frame) {
        this.frame = frame;
        this.screens = new Stack<>();
    }

    public void pushScreen(JFrame screen) {
        // Hide the current screen, if there is one
        if (!screens.empty()) {
            JFrame currentScreen = screens.peek();
            currentScreen.setVisible(false);
        }

        // Add the new screen to the stack and show it
        screens.push(screen);
        screen.setVisible(true);
        screen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        screen.setLocationRelativeTo(null); // Center the screen on the screen
    }

    public void popScreen() {
        // Remove the current screen from the stack and dispose it
        JFrame currentScreen = screens.pop();
        currentScreen.dispose();

        // Show the previous screen, if there is one
        if (!screens.empty()) {
            JFrame previousScreen = screens.peek();
            previousScreen.setVisible(true);
        }
    }

}

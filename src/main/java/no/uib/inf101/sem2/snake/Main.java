package no.uib.inf101.sem2.snake;

import javax.swing.JFrame;

import no.uib.inf101.sem2.snake.controller.SnakeController;
import no.uib.inf101.sem2.snake.model.SnakeModel;
import no.uib.inf101.sem2.snake.view.SnakeView;

public class Main {
  public static void main(String[] args) {
    SnakeModel model = new SnakeModel();
    SnakeView view = new SnakeView(model);
    SnakeController controller = new SnakeController(model, view);

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Sssssnake");
    frame.setContentPane(view);
    frame.pack();
    frame.setVisible(true);
  }
}

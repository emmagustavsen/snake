package no.uib.inf101.sem2.snake;

import javax.swing.JFrame;

import no.uib.inf101.sem2.snake.view.SampleView;

public class Main {
  public static void main(String[] args) {
    SampleView view = new SampleView();

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Sssssnake");
    frame.setContentPane(view);
    frame.pack();
    frame.setVisible(true);
  }
}

package no.uib.inf101.sem2.snake.view.Screens;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.Color;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import no.uib.inf101.sem2.snake.controller.SnakeController;
import no.uib.inf101.sem2.snake.model.SnakeModel;
import no.uib.inf101.sem2.snake.view.GraphicHelperMethods;
import no.uib.inf101.sem2.snake.view.SnakeView;

/**
 * Main menu screen.
 * 
 * @author Jasmine Næss
 */
public class MainMenu extends JFrame implements ActionListener {

    private final JButton play;
    private final JButton options;
    private final JButton about;
    private final JFrame frame;

    public MainMenu() {
		frame = new JFrame();
		frame.setTitle("Welcome to Snake!");

		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		contentPane.setBorder(new EmptyBorder(10, 10, 30, 10)); 

		Color bcg = new Color(181, 201, 154);
		contentPane.setBackground(bcg);

		// buttons
		play = addButton(contentPane, "Start game");
		options = addButton(contentPane, "Options");
		about = addButton(contentPane, "About");

		// spacing
		contentPane.add(Box.createRigidArea(new Dimension(0, 40)));

		// image
		ImageIcon imageIcon = new ImageIcon(GraphicHelperMethods.loadImageFromResources("/snake.png"));
		JLabel imageLabel = new JLabel(imageIcon);
		imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPane.add(imageLabel);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(contentPane);
		frame.setPreferredSize(new Dimension(400, 400));
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Adds buttons with a fixed style
	 * 
	 * @param buttons - The JPanel containing all the buttons.
	 * @param name    - The name to be displayed on the button.
	 * @return
	 */
	JButton addButton(JPanel buttons, String name) {
		JButton button = new JButton();
		button.setText(name);
		button.setFont(new Font("Monospaced", Font.PLAIN, 25));
		button.addActionListener(this);
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		buttons.add(button);
		return button;
	}

    @Override
    public void actionPerformed(ActionEvent e) {
		if (e.getSource() == play) {
			frame.dispose();
            SnakeModel model = new SnakeModel();
            SnakeView view = new SnakeView(model);
            SnakeController controller = new SnakeController(model, view);
            view.getFrame();
        } 
		if (e.getSource() == options) {
			frame.dispose();
            OptionsMenu optionsMenu = new OptionsMenu();
			optionsMenu.show();
        } 
		if (e.getSource() == about) {
			frame.dispose();
            AboutScreen aboutScreen = new AboutScreen();
			aboutScreen.show();
        }
	}

	public void show() {
		// Set the frame properties
		setTitle("Welcome to Snake!");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(400, 400);
		setLocationRelativeTo(null); // Center the frame on the screen
		setVisible(true);
	}
}

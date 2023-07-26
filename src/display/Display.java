package display;

import javax.swing.*;
import java.awt.*;

/**
 * Class Display to create a frame for the menu
 *
 * @author Iván Torrijos
 *
 */
public class Display {
    /**
     * Frame used to visualize the current state
     */
    private JFrame frame;

    private Canvas canvas;
    /**
     * title of the window
     */
    private String title;
    /**
     * width and height the jframe
     */
    private int width, height;
    /**
     * Constructor of the Display class
     * @param title Title of the window
     * @param width Width of the window
     * @param height Height of the window
     */
    public Display(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;

        createDisplay();
    }

    /**
     * Create the JFrame of the game and the canvas to draw
     */
    private void createDisplay() {
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas= new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));
        canvas.setFocusable(false);

        frame.add(canvas);
        frame.pack();


    }

    /**
     * Getter of the game canvas
     * @return the main canvas object of the game to draw inside
     */
    public Canvas getCanvas() {
        return canvas;
    }

    /**
     * Getter of the game JFrame
     * @return the JFrame of the game
     */
    public JFrame getFrame(){
        return frame;
    }

}

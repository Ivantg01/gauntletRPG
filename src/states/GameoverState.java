package states;

import handler.Handler;

import java.awt.*;

public class GameoverState extends State{

    private int width, height;


    /**
     * Ends the game
     * @param handler
     */
    public GameoverState(Handler handler) {
        super(handler);
        width = handler.getWidth();
        height = handler.getHeight();
    }

    /**
     * Init the menuState and display the menu to select the player
     */
   @Override
    public void initState() {

    }

    /**
     * time process to make any process before drawing
     */
    @Override
    public void tick() {
    }

    /**
     * time process to draw anything needed
     */
    @Override
    public void render(Graphics g) {
        drawScenario(g);
    }

    private void drawScenario(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(0, 0,width, height);
        g.fillRect(0, 0,width, height);

        g.setColor(Color.white);
        g.setFont(new Font("Fixedsys", Font.PLAIN, 64));
        g.drawString("GAME OVER", 150, 250);
    }
}

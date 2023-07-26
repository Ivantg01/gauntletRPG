package states;

import handler.Handler;

import java.awt.*;
/**
 * Abstract class to define possible states of the game: menuState, gameState
 *
 * @author Iván Torrijos
 *
 */
public abstract class State {

    /**
     * static attribute with the current state of the game: menuState or gameState
     */
    //DELETE private static State currentState = null;
    protected Handler handler;

    /**
     * Constructor of the State class
     * @param handler
     */
    public State(Handler handler){
        this.handler = handler;
    }

    public abstract void initState();
    public abstract void tick();
    public abstract void render(Graphics g);

    //GETTERS and SETTERS

    /**
     * Set the game handler to access the game object later if needed
     * @param handler
     */
    public void setGameHandler(Handler handler) {this.handler = handler;}

}

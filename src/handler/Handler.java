package handler;

import display.Display;
import entities.Player;
import input.KeyManager;
import worlds.World;

/**
 * Class to access main objects of the game. A handlers is stored in the game class and
 * it is passed to other classes
 *
 * @author Iván Torrijos
 *
 */
public class Handler {

    private Game game;
    private World world;
    private Player player;

    /**
     * Constructor of the Handler class
     * @param game game object
     */
    public Handler(Game game){
        this.game = game;
    }

    //GETTER and SETTERS

    /**
     * Get the keyManager object used in the game
     * @return the keyManager
     */
    public KeyManager getKeyManager() {
        return game.getKeyManager();
    }

    /**
     * Get the width of the window of the game
     * @return the width
     */
    public int getWidth () {
        return game.getWidth();
    }

    /**
     * Get the height of the window of the game
     * @return the height
     */
    public int getHeight () {
        return game.getHeight();
    }

    /**
     * Get the game object of the game
     * @return the game object
     */
    public Game getGame() {
        return game;
    }

    /**
     * Set the value of the game object inside the handler to be used by other objects
     * @param game the game object
     */
    public void setGame(Game game) {
        this.game = game;
    }

    /**
     * Get the current world object where the player is
     * @return the world object
     */
    public World getWorld() {
        return world;
    }

    /**
     * Set the value of the world object inside the handler to be used by other objects
     * @param world the game object
     */
    public void setWorld(World world) {
        this.world = world;
    }

    /**
     * Get the value of the player object
     * @return
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Set the value of the player object
     * @param player object
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Get the display object of the game used to draw
     * @return the display
     */
    public Display getDisplay() {
        return game.getDisplay();
    }
}

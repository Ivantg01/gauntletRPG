package handler;

import display.Display;
import gfx.Asset;
import input.KeyManager;
import states.GameState;
import states.MenuState;
import states.State;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Class for the Game main loop with threads
 *
 * @author Iván Torrijos
 *
 */
public class Game implements Runnable{
    private Display display;
    private String title;
    private int width, height;

    private boolean running =  false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    public Graphics getG() {
        return g;
    }

    //States
    private State currentState;
    private State gameState;

    //Input
    private KeyManager keyManager;

    //game player 0 Archer; player 1 Knight; player 2 Mage
    private int playerSelected;

    //Handler of main parameters of the game
    private Handler handler;

    /**
     * Constructor of the Game class
     * @param title Title of the window
     * @param width Width of the window
     * @param height Height of the window
     */
    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        keyManager = new KeyManager();
    }


    /**
     * Creates the Display, load Assets, and change to the first state
     */
    private void init() {
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager); //read from keyboard
        display.getCanvas().setVisible(false);
        Asset.init();

        handler = new Handler(this);
        gameState = new GameState(handler);

        //menu state is the first state
        currentState = new MenuState(handler);
        currentState.initState();
    }

    /**
     * time process to make any process before drawing
     */
    private void tick() {
        if (currentState == null)
            return;

        keyManager.tick();
        currentState.tick();
    }

    /**
     * time process to draw anything needed
     */
    private void render(){
        if (currentState == null)
            return;

        bs = display.getCanvas().getBufferStrategy();
        if (bs == null){
           display.getCanvas().createBufferStrategy(3);
           return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0,0,width,height);  //clear screen

        //some drawing tests
        //g.fillRect(0,0, width, height);
        //g.drawRect(10,20,50,70);   //draw rectangle line
        //g.setColor(Color.orange);
        //g.fillRect(10,20,50,70);
        //BufferedImage testImage;
        //testImage=ImageLoader.loadImage("/textures/RPG Maker VX - Characters.png");
        //g.drawImage(testImage, 20, 20, null);
        //g.drawImage(Assets.walk1, 0, 20, null);
        currentState.render(g);

        //stop draw
        bs.show();
        g.dispose();
    }

    //needed by runnable
    /**
     * Start the game as a new thread
     */
    public synchronized void start() {
        if (running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    //needed by runnable
    /**
     * run method of the Thread class.
     * Init the game and call tick() and render() 60 times per second
     */
    public void run(){
        init();

        //control the speed of tick(). One tick per frame and 60 fps.
        int fps=60;
        double timePerTick = 1000000000 / fps; //in nanoseconds
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (running){
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }

            if (timer >= 1000000000) {
                System.out.println("Ticks and Frames: "+ ticks);
                ticks = 0;
                timer = 0;
            }
        }
        stop();
    }

    //needed by runnable
    /**
     * Stop the game thread
     */
    public synchronized void stop() {
        if (!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //SETTERS and GETTERS

    /**
     * Get the keyManager object used in the game
     * @return the keyManager
     */
    public KeyManager getKeyManager(){
        return keyManager;
    }

    /**
     * Get the width of the window of the game
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Get the height of the window of the game
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Get the display object of the game used to draw
     * @return the display
     */
    public Display getDisplay() {
        return display;
    }

    /**
     * Get the current player selected in the menu
     * @return 0 is the Archer, 1 is the Knight and 2 is the Mage
     */
    public int getPlayerSelected() {
        return playerSelected;
    }

    /**
     * Set the value of the player selected in the menu
     * @param playerSelected 0 is the Archer, 1 is the Knight and 2 is the Mage
     */
    public void setPlayerSelected(int playerSelected) {
        this.playerSelected = playerSelected;
    }

    /**
     * Get the current state of the Game: gameState, menuState, etc
     * @return the current state
     */
    public State getCurrentState() { return currentState; }

    /**
     * Set the current state of the Game: gameState, menuState, etc
     * @param currentState the current state running
     */
    public void setCurrentState(State currentState) { this.currentState = currentState; }

    /**
     * Get the gameState in case we want to come back after a battle
     * @return gameState object
     */
    public State getGameState() { return gameState; }

}


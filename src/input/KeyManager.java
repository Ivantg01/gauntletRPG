package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * class for reading the keyboard to move the player and select options
 *
 * @author Iván Torrijos
 *
 */
public class KeyManager implements KeyListener {
    /**
     * keys to check if pressed when the game is running
      */
    public boolean up, down, left, right, open, close, kill;
    /**
     * keys to attack in a battle
     */
    public boolean key1, key2, key3;
    /**
     * array of all possible keys indicating if any of them is pressed or not
     */
    private boolean[] keys;

    /**
     * Array with a position for each possible key pressed. 0 = key is not pressed, 1 = key is pressed
     */
    public KeyManager(){
        keys = new boolean[256];
    }


    /**
     * time process to make any process before drawing
     * Register the keys pressed
     */
    public void tick(){
        up = keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];
        open = keys[KeyEvent.VK_O];
        close = keys[KeyEvent.VK_C];
        kill = keys[KeyEvent.VK_K];
        key1 = keys[KeyEvent.VK_1];
        key2 = keys[KeyEvent.VK_2];
        key3 = keys[KeyEvent.VK_3];
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    /**
     * Method called when a key is pressed
     */
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
        System.out.println("key pressed:"+e.getKeyChar());
    }

    @Override
    /**
     * Method called when a key is released
     */
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
}

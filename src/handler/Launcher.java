package handler;
import utils.Utils;

/**
 * Main Class for the RPG game
 *
 * @author Iván Torrijos
 *
 */
public class
Launcher  {

    public static void main(String[] args) {
        Utils.writeLog("--- Game Start");
        Game game = new Game("Gauntlet RPG", 640, 512);
        game.start();
    }
}

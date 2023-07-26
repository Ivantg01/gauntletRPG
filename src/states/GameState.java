package states;

import entities.*;
import handler.Handler;
import tiles.Tile;
import worlds.World;

import java.awt.*;
import java.util.ArrayList;

/**
 * state when the game is running
 *
 * @author Iván Torrijos
 *
 */
public class GameState extends State{

    private World world;
    private Player player;

    /**
     * Constructor create the world and place the enemies
     * @param handler handler to access game objects
     */
    public GameState(Handler handler) {
        super(handler);
        world = new World(handler);
        world.loadWorld(1,0);
        handler.setWorld(world);
    }

    /**
     * Init the gameState and create the selected player
     */
    @Override
    public void initState() {
        int xSpawn = 4 * Tile.TILEWIDTH;
        int ySpawn = 3 * Tile.TILEHEIGHT;

        if (handler.getGame().getPlayerSelected() == 0) {
            player = new Archer(handler, xSpawn, ySpawn);
        } else if (handler.getGame().getPlayerSelected() == 1) {
            player = new Knight(handler, xSpawn, ySpawn);
        } else {
            player = new Mage(handler, xSpawn, ySpawn);
        }
        handler.setPlayer(player);

        System.out.println("Player="+ player.getName() + " speed="+player.getSpeed());
    }

    /**
     * time process to make any process before drawing
     */
    @Override
    public void tick() {
        checkChangeMap();
        world.tick();
        player.tick();
    }

    /**
     * time process to draw anything needed
     */
    @Override
    public void render(Graphics g) {
        world.render(g);
        player.render(g);
        for (Entity e : handler.getWorld().getWorldActiveEntities()) {
            e.render(g);
        }
    }

    @SuppressWarnings("ReassignedVariable")
    /**
     * Check if the player is next to the border of the window to load a new World map
     */
    private void checkChangeMap() {
        int moveMapHorizontally = 0;
        int moveMapVertically = 0;

        //System.out.println("x="+ player.getX()+ " y="+player.getY());
        //move to the map cell left/right
        if (player.getX() < 0) {
            moveMapHorizontally = -1;
            player.setX(world.getWidth()*Tile.TILEWIDTH);
        } else if ((int) player.getX() > (world.getWidth()*Tile.TILEWIDTH)) {
            moveMapHorizontally = 1;
            player.setX(0f);
        }

        //move to the map cell up/down
        if (player.getY() < 0) {
            moveMapVertically = -1;
            player.setY(world.getHeight()*Tile.TILEHEIGHT);
        } else if ((int) player.getY() > world.getHeight()*Tile.TILEHEIGHT) {
            moveMapVertically = 1;
            player.setY(0f);
        }

        if (moveMapHorizontally != 0 || moveMapVertically != 0) {
            //System.out.println("world.Width="+world.getWidth()*Tile.TILEWIDTH+", Height="+ world.getHeight()*Tile.TILEHEIGHT);
            //System.out.println("world.GetX="+world.getX()+", GetY="+ world.getY());
            //System.out.println("player.GetX="+(int)player.getX()+", GetY="+ (int)player.getY());
            //System.out.println("MovemapH="+moveMapHorizontally+", MovemapV="+ moveMapVertically);
            //System.out.println("Moviendo a world=("+ (world.getX() + moveMapVertically)+","+(world.getY() + moveMapHorizontally)+")");
            world.loadWorld(world.getX() + moveMapVertically, world.getY() + moveMapHorizontally);
        }

    }

}

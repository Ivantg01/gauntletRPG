package entities;
import handler.Handler;
import java.awt.*;

/**
 * Class Player is used to manage the non-playable characters
 *
 * @author Iván Torrijos
 *
 */
public abstract class Enemy extends Creature {

    /**
     * Coordinate X of the world universe to place the enemy
     */
    private int worldTileX;  //World Tile (x,y) where the enemy is
    /**
     * Coordinate Y of the world universe to place the enemy
     */
    private int worldTileY;
    /**
     * if true the creature will appear in the map
     */
    protected boolean active;

    /**
     * Constructor of the Enemy class
     * @param handler handler class to access game data
     * @param x Coordinate x
     * @param y Coordinate y
     * @param worldTileX coordinate X of the universe of worlds where the enemy is
     * @param worldTileY coordinate Y of the universe of worlds where the enemy is
     */
    public Enemy(Handler handler, float x, float y, int worldTileX, int worldTileY) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT );

        boundsOfCollision.x = Creature.DEFAULT_CREATURE_WIDTH/2;
        boundsOfCollision.y = Creature.DEFAULT_CREATURE_HEIGHT;
        boundsOfCollision.width = Creature.DEFAULT_CREATURE_WIDTH;
        boundsOfCollision.height = Creature.DEFAULT_CREATURE_HEIGHT;
        this.worldTileX = worldTileX;
        this.worldTileY = worldTileY;
        this.active= true;
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
        if (!active)
            return;
        //draw enemy if player world = enemy world
        //if (handler.getWorld().getX() == worldTileX && handler.getWorld().getY() == worldTileY)
            g.drawImage(sprites[5], (int) x, (int) y, width*2, height*2,null);
    }

    /**
     * Get the x coordinate of this world in the universe of worlds
     * @return the x coordinate
     */
    public int getWorldTileX() {
        return worldTileX;
    }

    /**
     * Get the y coordinate of this world in the universe of worlds
     * @return the y coordinate
     */
    public int getWorldTileY() {
        return worldTileY;
    }

    /**
     * Check if the enemy is active of not (dead)
     * @return true if the enemy is active and false if the enemy is dead
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Set the active status of an enemy
     * @param active true if active or false if dead
     */
    public void setActive(boolean active) {
        this.active = active;
    }
}

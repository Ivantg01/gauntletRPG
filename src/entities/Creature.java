package entities;

import handler.Handler;
import states.BattleState;
import tiles.Tile;
import java.awt.image.BufferedImage;

/**
 * Class Creature is an abstract class to represent all types of players and enemies
 *
 * @author Iván Torrijos
 *
 */
public abstract class Creature  extends Entity implements Action{
    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 32,
                             DEFAULT_CREATURE_HEIGHT = 32;

    protected String name;
    protected BufferedImage[] sprites;
    protected int hp;
    protected int dmg;
    protected int mp;
    protected float speed;

    protected float xMove, yMove;
    protected int currentSprite;

    /**
     * Constructor of the Creature Class
     * @param handler handler class to access game data
     * @param x Coordinate x
     * @param y Coordinate y
     * @param width width of the picture
     * @param height height of the picture
     */
    public Creature(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
        currentSprite = 0;
    }

    /**
     * Move the creature according to the keys
     */
    public void move() {
        if (!checkEntityCollisions(xMove, 0f))
            moveX();
        if (!checkEntityCollisions(0f, yMove))
            moveY();

        if (checkEnemyCollision()) {
            BattleState battleState = new BattleState(handler);
            battleState.setEnemy( (Enemy) getEntityCollision(xMove, yMove));
            handler.getGame().setCurrentState(battleState);
            battleState.initState();
        };
    }

    /**
     * move the creature in the X axis
     */
    public void moveX() {
        //moves only when destination tile is not solid
        if (xMove > 0) { //is moving right, check upper right and lower right red collision corners
            int tx = (int) (x + xMove +  boundsOfCollision.x + boundsOfCollision.width)/ Tile.TILEWIDTH;
            if (!collisionWithTile(tx, (int) (y + boundsOfCollision.y) / Tile.TILEHEIGHT) &&
                    !collisionWithTile(tx, (int) (y + boundsOfCollision.y + boundsOfCollision.height) / Tile.TILEHEIGHT)) {
                x += xMove;
            }
        } else if (xMove < 0) { //is moving left, check upper left and lower left collision corners
            int tx = (int) (x + xMove +  boundsOfCollision.x)/ Tile.TILEWIDTH;
            if (!collisionWithTile(tx, (int) (y + boundsOfCollision.y) / Tile.TILEHEIGHT) &&
                    !collisionWithTile(tx, (int) (y + boundsOfCollision.y + boundsOfCollision.height) / Tile.TILEHEIGHT)) {
                x += xMove;
            }
        }
    }

    /**
     * move the creature in the Y axis
     */
    public void moveY() {
        //moves only when destination tile is not solid
        if (yMove < 0) { //is moving top, check upper left and upper right red collision corners
            int ty = (int) (y + yMove +  boundsOfCollision.y)/ Tile.TILEHEIGHT;
            if (!collisionWithTile((int) (x + boundsOfCollision.x) / Tile.TILEWIDTH, ty) &&
                    !collisionWithTile((int) (x + boundsOfCollision.x + boundsOfCollision.width) / Tile.TILEWIDTH, ty)) {
                y += yMove;
            }
        } else if (yMove > 0) { //is moving down, check lower left and lower right collision corners
            int ty = (int) (y + yMove +  boundsOfCollision.y + boundsOfCollision.width)/ Tile.TILEHEIGHT;
            if (!collisionWithTile((int) (x + boundsOfCollision.x) / Tile.TILEWIDTH, ty) &&
                    !collisionWithTile((int) (x + boundsOfCollision.x + boundsOfCollision.width) / Tile.TILEWIDTH, ty)) {
                y += yMove;
            }
        }
    }

    /**
     * Check if a tile in the coordinate x,y is solid
     * @param y coordinate in the y axis to check
     * @return true is is solid and false if it is not solid
     */
    protected boolean collisionWithTile(int x, int y){
        return handler.getWorld().getTile(x,y).isSolid();
    }

    /**
     * Check if there is a collision player and any enemy
     * @return true if collision and false if no collision
     */
    private boolean checkEnemyCollision() {
        if (getEntityCollision(xMove, yMove) instanceof Enemy)
            return true;
        return false;
    }

    //GETTERS and SETTERS

    /**
     * Get the name of the creature
     * @return the name of the creature
     */
     public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    /**
     * Get the amount of speed of a creature, higher values are faster
     * @return the speed of the creature
     */
    public float getSpeed() {
        return speed;
    }

    /**
     * Set the amount of speed of a creature, higher values are faster
     * @param speed the speed of the creature
     */
    public void setSpeed(float speed) {
        this.speed = speed;
    }

    /**
     * Get the array of sprites of the creature
     * @return the array of BufferedImage
     */
    public BufferedImage[] getSprites() {
        return sprites;
    }

}

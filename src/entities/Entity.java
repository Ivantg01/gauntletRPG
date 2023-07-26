package entities;
import handler.Handler;
import java.awt.*;

/**
 * Class Entity is abstract to represent players and enemies
 *
 * @author Iván Torrijos
 *
 */
public abstract class Entity {

    protected Handler handler;
    protected float x,y;
    protected int width, height;
    protected Rectangle boundsOfCollision;

    /**
     * Constructor of the Entity Class
     * @param handler handler class to access game data
     * @param x Coordinate x
     * @param y Coordinate y
     * @param width width of the picture
     * @param height height of the picture
     */
    public Entity(Handler handler, float x, float y, int width, int height){
        this.handler = handler;
        this.x= x;
        this.y= y;
        this.width = width;
        this.height = height;

        boundsOfCollision = new Rectangle(0,0, width, height);
    }

    /**
     * time process to make any process before drawing
     */
    public abstract void tick();

    /**
     * time process to draw anything needed
     */
    public abstract void render(Graphics g);

    /**
     * check if player touch any entity
     * @param xOffset x axis offset to check if there is any entity there
     * @param yOffset y axis offset to check if there is any entity there
     * @return true is player is overlaping any other entity
     */
    public boolean checkEntityCollisions(float xOffset, float yOffset) {
        for (Entity e: handler.getWorld().getWorldActiveEntities()) {
            if (e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset)))
                return true;
        }
        return false;
    }

    /**
     * Get the first entity which a collision with the player
     * @param xOffset x axis offset to check if there is any entity there
     * @param yOffset y axis offset to check if there is any entity there
     * @return the fisrt entity found overlaping the player other entity; null in other case
     */
    public Entity getEntityCollision(float xOffset, float yOffset) {
        for (Entity e: handler.getWorld().getWorldActiveEntities()) {
            if (e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset)))
                return e;
        }
        return null;
    }

    /**
     * Get the bounds of the collision of an entity including the entity and the offset a rectangle
     * @param xOffset coordinate X of the offset
     * @param yOffset coordiante Y of the offset
     * @return the rectangle including the entity and the offset
     */
    public Rectangle getCollisionBounds(float xOffset, float yOffset){
        return new Rectangle( (int) (x + boundsOfCollision.x + xOffset),
                (int) (y + boundsOfCollision.y + yOffset), boundsOfCollision.width, boundsOfCollision.height);
    }

    //SETTERS AND GETTERS
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Get the X position of the entity (upper left of the image)
     * @return the x position
     */
    public float getX() { return x; }

    /**
     * Get the Y position of the entity (upper left of the image)
     * @return the y position
     */
    public float getY() { return y; }

    /**
     * Set the X position of the entity
     * @param x the x position
     */
    public void setX(float x) { this.x = x; }

    /**
     * Set the X position of the entity
     * @param y the x position
     */
    public void setY(float y) { this.y = y; }
}

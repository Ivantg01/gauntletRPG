package entities;

import handler.Handler;
import java.awt.*;

/**
 * Class Player is used to manage the playable characters
 *
 * @author Iván Torrijos
 *
 */
public abstract class Player extends Creature {

    private int skinRotation=0;
    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT );

        boundsOfCollision.x = Creature.DEFAULT_CREATURE_WIDTH/2;
        boundsOfCollision.y = Creature.DEFAULT_CREATURE_HEIGHT;
        boundsOfCollision.width = Creature.DEFAULT_CREATURE_WIDTH;
        boundsOfCollision.height = Creature.DEFAULT_CREATURE_HEIGHT;
    }

    /**
     * time process to make any process before drawing
     */
    @Override
    public void tick() {
        getInput();
        move();
    }

    /**
     * Check the key pressed and calculate the new x,y position of the player
     */
    private void getInput(){
        xMove = 0;
        yMove = 0;

        if(handler.getKeyManager().up) {
            yMove = -speed;
            if(skinRotation==5) {
                currentSprite = 9 + (currentSprite + 1) % 3;
                skinRotation=0;
            }else{
                skinRotation++;
            }
        }
        if(handler.getKeyManager().down) {
            yMove = speed;
            if(skinRotation==5) {
                currentSprite = 0 + (currentSprite + 1) % 3;
                skinRotation=0;
            }else{
                skinRotation++;
            }
        }
        if(handler.getKeyManager().left){
            xMove = -speed;
            if(skinRotation==5) {
                currentSprite = 3 + (currentSprite + 1) % 3;
                skinRotation=0;
            }else{
                skinRotation++;
            }
        }
        if(handler.getKeyManager().right){
            xMove = speed;
            if(skinRotation==5) {
                currentSprite = 6 + (currentSprite + 1) % 3;
                skinRotation=0;
            }else{
                skinRotation++;
            }
        }
        //only for tests
        if(handler.getKeyManager().open){
            handler.getWorld().openSecretDoor();
        }
        if(handler.getKeyManager().close){
            handler.getWorld().closeSecretDoor();
        }
        if(handler.getKeyManager().kill){
            boolean active;
            for (Entity e: handler.getWorld().getWorldEntities()) {
                if (e instanceof Enemy) {
                    active = ((Enemy) e).isActive();
                    ((Enemy) e).setActive(!active);
                }
            }
        }
    }

    /**
     * time process to draw anything needed
     */
    @Override
    public void render(Graphics g) {

        g.drawImage(sprites[currentSprite], (int) x, (int) y, width*2, height*2,null);

        //descomentar para ver el cuadrado de colision
        //g.setColor(Color.red);
        //g.fillRect( (int) (x + boundsOfCollision.x), (int) (y + boundsOfCollision.y),
        //    boundsOfCollision.width, boundsOfCollision.height);
    }


    public abstract Ability action1();
    public abstract Ability action2();
    public abstract Ability action3();
}

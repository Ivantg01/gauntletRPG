package entities;

import gfx.Asset;
import handler.Handler;
import java.awt.*;

/**
 * Class Goblin is used to manage the goblin type settings
 *
 * @author Iván Torrijos
 *
 */
public class Goblin extends Enemy {
    public static final String DEFAULT_NAME = "Goblin";
    public static final int DEFAULT_HP = 50;
    public static final int DEFAULT_DMG = 12;
    public static final int DEFAULT_MP = 40;
    public static final float DEFAULT_SPEED = 2.0f;
    /**
     * Constructor of the Goblin class
     * @param handler handler to access game objects
     * @param x coordinate X where the player is
     * @param y coordinate Y where the player is
     * @param worldTileX coordinate X of the universe of worlds where the enemy is
     * @param worldTileY coordinate Y of the universe of worlds where the enemy is
     */
    public Goblin(Handler handler, float x, float y, int worldTileX, int worldTileY) {
        super(handler, x, y, worldTileX, worldTileY);
        name = DEFAULT_NAME;
        hp = DEFAULT_HP;
        dmg = DEFAULT_DMG;
        mp = DEFAULT_MP;
        speed = DEFAULT_SPEED;
        sprites = Asset.goblin;
    }

    /**
     * time process to make any process before drawing
     */
    @Override
    public void tick() {
        super.tick();
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
    }

    /**
     * Action number 1 that can be used by the enemy
     */
    @Override
    public Ability action1(){
        Ability a=new Ability();
        a.setSprite(Asset.goblinAttack);
        a.setName("Axe twist (1)");
        a.setDmg(0.5f);
        a.setMpCost(0);
        a.setAccuracy(0.9f);
        return a;
    }

    /**
     * Action number 2 that can be used by the enemy
     */
    @Override
    public Ability action2(){
        Ability a=new Ability();
        a.setSprite(Asset.goblinAttack);
        a.setName("Axe storm (2)");
        a.setDmg(1.0f);
        a.setMpCost(10);
        a.setAccuracy(0.8f);
        return a;
    }

    /**
     * Action number 3 that can be used by the enemy
     */
    @Override
    public Ability action3() {
        Ability a=new Ability();
        a.setSprite(Asset.goblinAttack);
        a.setName("Critical chop (3)");
        a.setDmg(2.0f);
        a.setMpCost(15);
        a.setAccuracy(0.7f);
        return a;
    }

    /**
     * Recover the initial stats
     */
    public void recoverStats () {
        hp = DEFAULT_HP;
        mp = DEFAULT_MP;
    }
}
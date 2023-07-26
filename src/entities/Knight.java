package entities;

import gfx.Asset;
import handler.Handler;

/**
 * Class Knight is used to manage the knight type settings
 *
 * @author Iván Torrijos
 *
 */
public class Knight extends Player {
    public static final String DEFAULT_NAME = "Knight";
    public static final int DEFAULT_HP = 50;
    public static final int DEFAULT_DMG = 12;
    public static final int DEFAULT_MP = 40;
    public static final float DEFAULT_SPEED = 2.5f;

    /**
     * Constructor of the Knight class
     * @param handler handler to access game objects
     * @param x coordinate X where the player is
     * @param y coordinate Y where the player is
     */
    public Knight(Handler handler, float x, float y) {
        super(handler, x, y);
        name = DEFAULT_NAME;
        hp= DEFAULT_HP;
        dmg=DEFAULT_DMG;
        mp=DEFAULT_MP;
        speed=DEFAULT_SPEED;
        sprites = Asset.knight;
    }

    /**
     * Action number 1 that can be used by the player
     */
    @Override
    public Ability action1(){
        Ability a=new Ability();
        a.setSprite(Asset.knightAttack);
        a.setName("Sword stroke (2)");
        a.setDmg(0.5f);
        a.setMpCost(0);
        a.setAccuracy(0.9f);
        return a;
    }

    /**
     * Action number 2 that can be used by the player
     */
    @Override
    public Ability action2(){
        Ability a=new Ability();
        a.setSprite(Asset.knightAttack);
        a.setName("Holy Spear (2)");
        a.setDmg(1.0f);
        a.setMpCost(10);
        a.setAccuracy(0.8f);
        return a;
    }

    /**
     * Action number 3 that can be used by the player
     */
    @Override
    public Ability action3() {
        Ability a=new Ability();
        a.setSprite(Asset.knightAttack);
        a.setName("Sword Finisher (3)");
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

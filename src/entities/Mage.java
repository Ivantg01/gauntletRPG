package entities;

import gfx.Asset;
import handler.Handler;

/**
 * Class Mage is used to manage the Mage type settings
 *
 * @author Iván Torrijos
 *
 */
public class Mage extends Player {
    public static final String DEFAULT_NAME = "Mage";
    public static final int DEFAULT_HP = 35;
    public static final int DEFAULT_DMG = 8;
    public static final int DEFAULT_MP = 100;
    public static final float DEFAULT_SPEED = 3.0f;

    /**
     * Constructor of the Mage class
     * @param handler handler to access game objects
     * @param x coordinate X where the player is
     * @param y coordinate Y where the player is
     */
    public Mage(Handler handler, float x, float y) {
        super(handler, x, y);
        name = DEFAULT_NAME;
        hp= DEFAULT_HP;
        dmg=DEFAULT_DMG;
        mp=DEFAULT_MP;
        speed=DEFAULT_SPEED;
        sprites = Asset.mage;
    }

    /**
     * Action number 1 that can be used by the player
     */
    @Override
    public Ability action1(){
        Ability a=new Ability();
        a.setSprite(Asset.mageAttack);
        a.setName("Quick Spell (1)");
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
        a.setSprite(Asset.mageAttack);
        a.setName("Fire Ball (2)");
        a.setDmg(1.0f);
        a.setMpCost(5);
        a.setAccuracy(0.8f);
        return a;
    }

    /**
     * Action number 3 that can be used by the player
     */
    @Override
    public Ability action3() {
        Ability a=new Ability();
        a.setSprite(Asset.mageAttack);
        a.setName("Ice Spell (3)");
        a.setDmg(2.0f);
        a.setMpCost(10);
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

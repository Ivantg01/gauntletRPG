package entities;

import gfx.Asset;
import handler.Handler;

/**
 * Class Archer is used to manage the archer type settings
 *
 * @author Iván Torrijos
 *
 */
public class Archer extends Player {
    public static final String DEFAULT_NAME = "Archer";
    public static final int DEFAULT_HP = 40;
    public static final int DEFAULT_DMG = 10;
    public static final int DEFAULT_MP = 60;
    public static final float DEFAULT_SPEED = 5.0f;

    /**
     * Constructor of the Archer class
     * @param handler handler to access game objects
     * @param x coordinate X where the player is
     * @param y coordinate Y where the player is
     */
    public Archer(Handler handler, float x, float y) {
        super(handler, x, y);
        name = DEFAULT_NAME;
        hp= DEFAULT_HP;
        dmg=DEFAULT_DMG;
        mp=DEFAULT_MP;
        speed=DEFAULT_SPEED;
        sprites = Asset.archer;
    }

    /**
     * Action number 1 that can be used by the player
     */
    @Override
    public Ability action1(){
        Ability a=new Ability();
        a.setSprite(Asset.archerAttack);
        a.setName("Steady Shoot (2)");
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
        a.setSprite(Asset.archerAttack);
        a.setName("Deadly Shoot (1)");
        a.setDmg(1.0f);
        a.setMpCost(7);
        a.setAccuracy(0.8f);
        return a;
    }

    /**
     * Action number 3 that can be used by the player
     */
    @Override
    public Ability action3() {
        Ability a=new Ability();
        a.setSprite(Asset.archerAttack);
        a.setName("Charged Shoot (3)");
        a.setDmg(2.0f);
        a.setMpCost(17);
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

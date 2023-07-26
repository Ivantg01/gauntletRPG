package entities;

import java.awt.image.BufferedImage;

/**
 * Class Ability with the possible actions a player can use in the battle
 *
 * @author Iván Torrijos
 *
 */
public class Ability {
    BufferedImage sprite;
    private String name;
    private float dmg;
    private int mpCost;
    private float accuracy;

    /**
     * Get the image of the sprite of the ability when is used in the battle
     * @return the image of the ability
     */
    public BufferedImage getSprite() { return sprite; }

    /**
     * Set the image of the sprite of the ability when is used in the battle
     * @param sprite the image of the ability
     */
    public void setSprite(BufferedImage sprite) { this.sprite = sprite; }

    /**
     * Get the name of the ability
     * @return the name of the ability
     */
    public String getName() { return name; }

    /**
     * Set the name of the ability
     * @param name the name of the ability
     */
    public void setName(String name) { this.name = name; }

    /**
     * Get the amount of damage to the enemy
     * @return the amount of damage to the enemy
     */
    public float getDmg() {
        return dmg;
    }

    /**
     * Set the amount of damage to the enemy
     * @param dmg is the amount of damage to the enemy
     */
    public void setDmg(float dmg) {
        this.dmg = dmg;
    }

    /**
     * Get the Magic Point amount to substract to the player when the ability is used
     * @return the amount of magic points to use the ability
     */
    public int getMpCost() {
        return mpCost;
    }

    /**
     * Set the Magic Point amount to substract to the player when the ability is used
     * @param mpCost the amount of magic points to use the ability
     */
    public void setMpCost(int mpCost) {
        this.mpCost = mpCost;
    }

    /**
     * Get the percentage of accuracy that the ability has when it is used
     * @return the percentage of accuracy of the ability
     */
    public double getAccuracy() {
        return accuracy;
    }

    /**
     * Set the percentage of accuracy that the ability has when it is used
     * @param accuracy the percentage of accuracy of the ability
     */
    public void setAccuracy(float accuracy) {
        this.accuracy = accuracy;
    }
}

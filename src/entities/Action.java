package entities;

/**
 * Interface Action with the set of abilities a player or creature can use in the combat
 * Power of action1 < power of action2 < power of action3
 *
 * @author Iván Torrijos
 *
 */
public interface Action {
    /**
     * Ability of the option 1 a player or a creature can use
     * @return an ability
     */
    public Ability action1();
    /**
     * Ability of the option 2 a player or a creature can use
     * @return an ability
     */
    public Ability action2();
    /**
     * Ability of the option 3 a player or a creature can use
     * @return an ability
     */
    public Ability action3();

    /**
     * Recover the MP/HP of a creature
     */
    public void recoverStats();
}

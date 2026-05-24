package com.gamingroom;

/**
 * A simple class to hold information about a player.
 * 
 * <p>
 * Player extends Entity, inheriting the id and name attributes
 * as well as the getter methods defined in the base class.
 * No mutators (setters) are defined, so these values cannot be
 * changed once a player is created.
 * </p>
 * 
 * @author coce@snhu.edu
 */
public class Player extends Entity {

    /**
     * Constructor with an identifier and name.
     * 
     * @param id   the unique identifier for this player
     * @param name the name of this player
     */
    public Player(long id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "Player [id=" + getId() + ", name=" + getName() + "]";
    }
}

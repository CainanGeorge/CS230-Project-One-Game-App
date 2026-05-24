package com.gamingroom;

/**
 * A base class to hold common attributes and behaviors for all entities.
 * 
 * <p>
 * All entities in the application (Game, Team, Player) share a common
 * identifier (id) and name. By placing these in a base class, we avoid
 * duplicating this code in each subclass. This demonstrates the
 * object-oriented principle of inheritance.
 * </p>
 * 
 * @author coce@snhu.edu
 */
public abstract class Entity {

    // Unique identifier for this entity
    private long id;

    // Name of this entity
    private String name;

    /**
     * Hide the default constructor to prevent creating empty instances.
     */
    private Entity() {
    }

    /**
     * Constructor with an identifier and name.
     * 
     * @param id   the unique identifier
     * @param name the name of the entity
     */
    public Entity(long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Entity [id=" + id + ", name=" + name + "]";
    }
}

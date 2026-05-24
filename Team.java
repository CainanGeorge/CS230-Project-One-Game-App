package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a team.
 * 
 * <p>
 * Team extends Entity, inheriting the id and name attributes.
 * Each team maintains a list of players. The addPlayer() method
 * uses the iterator pattern to ensure each player name is unique
 * before adding a new player instance.
 * </p>
 * 
 * @author coce@snhu.edu
 */
public class Team extends Entity {

    // List of players belonging to this team
    private List<Player> players = new ArrayList<Player>();

    /**
     * Constructor with an identifier and name.
     * 
     * @param id   the unique identifier for this team
     * @param name the name of this team
     */
    public Team(long id, String name) {
        super(id, name);
    }

    /**
     * Adds a player to this team, or returns the existing player if the name
     * is already in use.
     * 
     * <p>
     * ITERATOR PATTERN: Uses an iterator to traverse the players list and
     * check whether a player with the given name already exists. This enforces
     * the requirement that every player name must be unique within a team.
     * </p>
     * 
     * @param name the unique name of the player
     * @return the player instance (new or existing)
     */
    public Player addPlayer(String name) {

        // local player instance
        Player player = null;

        // Use iterator to check for existing player with the same name
        Iterator<Player> playersIterator = players.iterator();
        while (playersIterator.hasNext()) {
            Player existingPlayer = playersIterator.next();
            if (existingPlayer.getName().equals(name)) {
                // found a match - return existing player instead of creating a duplicate
                player = existingPlayer;
                break;
            }
        }

        // if no match found, create a new player and add to the list
        if (player == null) {
            player = new Player(GameService.getInstance().getNextPlayerId(), name);
            players.add(player);
        }

        return player;
    }

    @Override
    public String toString() {
        return "Team [id=" + getId() + ", name=" + getName() + "]";
    }
}

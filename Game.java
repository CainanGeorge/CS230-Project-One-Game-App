package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a game.
 * 
 * <p>
 * Game extends Entity, inheriting the id and name attributes.
 * Each game maintains a list of teams. The addTeam() method uses
 * the iterator pattern to ensure each team name is unique before
 * adding a new team instance.
 * </p>
 * 
 * @author coce@snhu.edu
 */
public class Game extends Entity {

    // List of teams participating in this game
    private List<Team> teams = new ArrayList<Team>();

    /**
     * Constructor with an identifier and name.
     * 
     * @param id   the unique identifier for this game
     * @param name the name of this game
     */
    public Game(long id, String name) {
        super(id, name);
    }

    /**
     * Adds a team to this game, or returns the existing team if the name
     * is already in use.
     * 
     * <p>
     * ITERATOR PATTERN: Uses an iterator to traverse the teams list and check
     * whether a team with the given name already exists. This enforces the
     * requirement that every team name must be unique within a game.
     * </p>
     * 
     * @param name the unique name of the team
     * @return the team instance (new or existing)
     */
    public Team addTeam(String name) {

        // local team instance
        Team team = null;

        // Use iterator to check for existing team with the same name
        Iterator<Team> teamsIterator = teams.iterator();
        while (teamsIterator.hasNext()) {
            Team existingTeam = teamsIterator.next();
            if (existingTeam.getName().equals(name)) {
                // found a match - return existing team instead of creating a duplicate
                team = existingTeam;
                break;
            }
        }

        // if no match found, create a new team and add to the list
        if (team == null) {
            team = new Team(GameService.getInstance().getNextTeamId(), name);
            teams.add(team);
        }

        return team;
    }

    @Override
    public String toString() {
        return "Game [id=" + getId() + ", name=" + getName() + "]";
    }
}

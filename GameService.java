package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A singleton service for the game engine.
 * 
 * <p>
 * SINGLETON PATTERN: The singleton pattern ensures that only one instance of
 * GameService can exist in memory at any given time. This is accomplished by:
 *   1. Making the constructor private so no outside class can call "new GameService()".
 *   2. Storing the single instance in a private static variable (instance).
 *   3. Providing a public static getInstance() method that returns the one instance,
 *      creating it only if it does not already exist.
 * This ensures all parts of the application share the same game list and counters.
 * </p>
 * 
 * @author coce@snhu.edu
 */
public class GameService {

    // A list of the active games
    private static List<Game> games = new ArrayList<Game>();

    // Holds the next available game identifier
    private static long nextGameId = 1;

    // Holds the next available team identifier
    private static long nextTeamId = 1;

    // Holds the next available player identifier
    private static long nextPlayerId = 1;

    // The single static instance of GameService (singleton pattern)
    private static GameService instance = null;

    /**
     * Private constructor prevents any other class from instantiating GameService.
     * This is a key requirement of the singleton pattern.
     */
    private GameService() {
    }

    /**
     * Returns the single instance of GameService, creating it if it does not exist.
     * This is the global access point required by the singleton pattern.
     * 
     * @return the one and only GameService instance
     */
    public static GameService getInstance() {
        if (instance == null) {
            instance = new GameService();
        }
        return instance;
    }

    /**
     * Adds a new game or returns the existing game if the name is already in use.
     * 
     * <p>
     * ITERATOR PATTERN: Uses an iterator to traverse the games list and check
     * whether a game with the given name already exists. This enforces the
     * requirement that all game names must be unique.
     * </p>
     * 
     * @param name the unique name of the game
     * @return the game instance (new or existing)
     */
    public Game addGame(String name) {

        // local game instance
        Game game = null;

        // Use iterator to look for an existing game with the same name
        Iterator<Game> gamesIterator = games.iterator();
        while (gamesIterator.hasNext()) {
            Game existingGame = gamesIterator.next();
            if (existingGame.getName().equals(name)) {
                // found a match - return existing instance instead of creating a duplicate
                game = existingGame;
                break;
            }
        }

        // if not found, create a new game and add to the list
        if (game == null) {
            game = new Game(nextGameId++, name);
            games.add(game);
        }

        return game;
    }

    /**
     * Returns the game instance at the specified index.
     * Scope is package/local for testing purposes.
     * 
     * @param index index position in the list
     * @return requested game instance
     */
    Game getGame(int index) {
        return games.get(index);
    }

    /**
     * Returns the game instance with the specified id.
     * Uses the iterator pattern to traverse the games list.
     * 
     * @param id unique identifier of the game to search for
     * @return requested game instance, or null if not found
     */
    public Game getGame(long id) {

        Game game = null;

        // Use iterator to find the game with the matching id
        Iterator<Game> gamesIterator = games.iterator();
        while (gamesIterator.hasNext()) {
            Game existingGame = gamesIterator.next();
            if (existingGame.getId() == id) {
                game = existingGame;
                break;
            }
        }

        return game;
    }

    /**
     * Returns the game instance with the specified name.
     * Uses the iterator pattern to traverse the games list.
     * 
     * @param name unique name of the game to search for
     * @return requested game instance, or null if not found
     */
    public Game getGame(String name) {

        Game game = null;

        // Use iterator to find the game with the matching name
        Iterator<Game> gamesIterator = games.iterator();
        while (gamesIterator.hasNext()) {
            Game existingGame = gamesIterator.next();
            if (existingGame.getName().equals(name)) {
                game = existingGame;
                break;
            }
        }

        return game;
    }

    /**
     * Returns the number of games currently active.
     * 
     * @return the number of active games
     */
    public int getGameCount() {
        return games.size();
    }

    /**
     * Returns and increments the next available team identifier.
     * 
     * @return the next team id
     */
    public long getNextTeamId() {
        return nextTeamId++;
    }

    /**
     * Returns and increments the next available player identifier.
     * 
     * @return the next player id
     */
    public long getNextPlayerId() {
        return nextPlayerId++;
    }
}

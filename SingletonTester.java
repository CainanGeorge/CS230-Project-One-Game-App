package com.gamingroom;

/**
 * A class to test a singleton's behavior.
 * 
 * @author coce@snhu.edu
 */
public class SingletonTester {

    public void testSingleton() {

        System.out.println("\nAbout to test the singleton...");

        // Obtain local reference to the singleton instance.
        // If the singleton pattern is working correctly, this will be the same
        // instance that was created in ProgramDriver, and the games list will
        // already contain the games added there.
        GameService service = GameService.getInstance();

        // Print all active games using a simple for loop
        for (int i = 0; i < service.getGameCount(); i++) {
            System.out.println(service.getGame(i));
        }
    }
}

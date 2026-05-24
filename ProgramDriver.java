package com.gamingroom;

/**
 * Application start-up program.
 * 
 * @author coce@snhu.edu
 */
public class ProgramDriver {

    /**
     * The one-and-only main() method.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {

        // Obtain reference to the singleton instance of GameService
        GameService service = GameService.getInstance();

        System.out.println("\nAbout to test initializing game data...");

        // Initialize with some game data
        Game game1 = service.addGame("Game #1");
        System.out.println(game1);
        Game game2 = service.addGame("Game #2");
        System.out.println(game2);

        // Add teams to game1
        Team team1 = game1.addTeam("Team #1");
        System.out.println(team1);
        Team team2 = game1.addTeam("Team #2");
        System.out.println(team2);

        // Add players to team1
        Player player1 = team1.addPlayer("Player #1");
        System.out.println(player1);
        Player player2 = team1.addPlayer("Player #2");
        System.out.println(player2);

        // Use another class to prove there is only one instance
        SingletonTester tester = new SingletonTester();
        tester.testSingleton();
    }
}

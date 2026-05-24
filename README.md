# CS230-Project-One-Game-App
Draw It or Lose It – Web-Based Game App
A Java application built for CS 230 at SNHU. The goal was to take an existing Android game called Draw It or Lose It and start laying the groundwork for a web-based version that can run on any platform.
What it does
The app manages the backend logic for a multiplayer drawing game. Teams compete to guess what's being drawn before time runs out. This version handles the game structure — creating games, adding teams, and assigning players — while making sure everything stays organized and nothing gets duplicated.
How it's built
The project uses a few key design patterns to keep things clean:

Singleton – Only one instance of the game service can exist at a time. This keeps all the game data in one place instead of scattered across multiple objects.
Iterator – Before adding a new game, team, or player, the app checks if that name is already taken. No duplicates allowed.
Inheritance – Game, Team, and Player all share common attributes (id and name) through a base Entity class, so that code doesn't have to be rewritten three times.

How to run it

Import the project into Eclipse
Run ProgramDriver.java as a Java application
Check the console output to see games, teams, and players being created and the singleton being tested

Built with

Java
Eclipse IDE

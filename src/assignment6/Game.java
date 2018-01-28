/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment6;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Kareem
 */
public class Game {

    // Array of the locations
    private ArrayList<Location> locations = new ArrayList<>();

    // Initializing the variables
    private String currentDirection;
    private String currentLocation;
    private Interface gui;

    // Constructor
    public Game() {

        //File reader
        FileReader file = null;

        try {
            // The txt file
            file = new FileReader("images/pics.txt");

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Scanner to read the txt file
        Scanner input = new Scanner(file);

        // Starting location and direction of the player
        currentLocation = input.nextLine();
        currentDirection = input.nextLine();

        // Adding the locations into the array
        while (input.hasNext()) {
            
            Location l = new Location(input);
            // Add location to the array
            locations.add(l);
        }

        // Interface set up
        gui = new Interface(this);
        gui.setVisible(true);

        // Drawing the starting image
        for (Location l : locations) {
            if (l.getName().equals(currentLocation)) {
                gui.setImage(l.getImage(currentDirection));
            }
        }
    }

    // Method to turn left
    public void turnLeft() {

        // Looping through the entire locations array 
        for (Location l : locations) {

            // When the image is found
            if (l.getName().equals(currentLocation)) {
                
                // Changing the directions to turn left
                if (currentDirection.equals("N")) {
                    currentDirection = "W";
                    gui.setImage(l.getImage(currentDirection));
                    
                } else if (currentDirection.equals("W")) {
                    currentDirection = "S";
                    gui.setImage(l.getImage(currentDirection));
                    
                } else if (currentDirection.equals("S")) {
                    currentDirection = "E";
                    gui.setImage(l.getImage(currentDirection));
                    
                } else if (currentDirection.equals("E")) {
                    currentDirection = "N";
                    gui.setImage(l.getImage(currentDirection));
                }
            }
        }
    }

    // Method to turn right
    public void turnRight() {
        
        // Looping through the entire locations array 
        for (Location l : locations) {
            
            // When the image is found
            if (l.getName().equals(currentLocation)) {
                
                // Changing the directions to turn right
                if (currentDirection.equals("N")) {
                    currentDirection = "E";
                    gui.setImage(l.getImage(currentDirection));
                    
                } else if (currentDirection.equals("E")) {
                    currentDirection = "S";
                    gui.setImage(l.getImage(currentDirection));
                    
                } else if (currentDirection.equals("S")) {
                    currentDirection = "W";
                    gui.setImage(l.getImage(currentDirection));
                    
                } else if (currentDirection.equals("W")) {
                    currentDirection = "N";
                    gui.setImage(l.getImage(currentDirection));
                }
            }
        }
    }

    // Method to move forward
    public void moveForward() {
        
        // Looping through the entire locations array
        for (Location l : locations) {
            
            // When the image is found
            if (l.getName().equals(currentLocation)) {
                
                // Checking if the next direction is blocked
                if (l.isFrontBlocked(currentDirection) == false) {
                    
                    // Move forward if it is not blocked
                    currentLocation = l.getNextLocation(currentDirection);
                }
            }
        }
        
        // Looping through the entire locations array
        for (Location l : locations) {
            
            // When the image is found
            if (l.getName().equals(currentLocation)) {
                // Set the image
                gui.setImage(l.getImage(currentDirection));
            }
        }
    }

    public static void main(String[] args) {
        
        // Creaating an object to run the game
        Game game = new Game();
    }
}

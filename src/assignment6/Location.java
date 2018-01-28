    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment6;

import java.awt.image.BufferedImage;
import java.util.Scanner;

/**
 *
 * @author Kareem
 */
public class Location {

    // Initializing the variables
    private final Scene[] scenes;
    private final String name;

    public Location(Scanner input) {

        // A scene for each direction
        scenes = new Scene[4];

        // Getting the name from txt file
        name = input.nextLine();

        // Making the scenes
        for (int i = 0; i < 4; i++) {
            Scene s = new Scene(input);
            scenes[i] = s;
        }
    }

    // Method that checks if the front is blocked
    public boolean isFrontBlocked(String dir) {

        // Checking each direction
        for (int i = 0; i < 4; i++) {
            // Checking if the scene is equal to a wall
            if (scenes[i].getDirection().equals(dir)) {
                return scenes[i].isBlocked();
            }
        }
        return true;
    }

    // Method that gets the next location
    public String getNextLocation(String dir) {
        // Checking each direction
        for (int i = 0; i < 4; i++) {
            // Checking if the direction is equal to the previous one
            if (scenes[i].getDirection().equals(dir)) {
                return scenes[i].getNextLocation();
            }
        }
        return null;
    }

    // Getting the image
    public BufferedImage getImage(String dir) {
        // Checking each direction
        for (int i = 0; i < 4; i++) {
            // Checking if the direction on the image and getting it
            if (scenes[i].getDirection().equals(dir)) {
                return scenes[i].getImage();
            }
        }
        return null;
    }

    // Getting the name of the image
    public String getName() {
        return this.name;
    }
}

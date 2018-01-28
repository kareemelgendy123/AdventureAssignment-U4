/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment6;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;
import javax.imageio.ImageIO;

/**
 *
 * @author Kareem
 */
public class Scene {

    // Initializing variables
    private String direction;
    private BufferedImage image;
    private final String isBlocked;
    private boolean blocked;
    private String nextLocation;
    private String nextDirection;

    public Scene(Scanner input) {

        // Getting the direction from the txt file
        direction = input.next();

        // Getting the image name from the txt file
        String img = input.next();

        image = null;

        try {
            image = ImageIO.read(new File("images/" + img));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }

        // Checking boolean column in txt file
        isBlocked = input.next();

        // Setting walls
        if (isBlocked.equals("true")) {
            blocked = true;
            input.nextLine();

        } else {
            // Getting the next location from txt file
            nextLocation = input.next();

            // Getting the next direction from txt file
            nextDirection = input.next();

            // Going to the next line
            input.nextLine();
        }

    }

    // Getting the direction
    public String getDirection() {
        return this.direction;
    }

    // Getting the image
    public BufferedImage getImage() {
        return this.image;
    }

    // Checking if the way is blocked
    public boolean isBlocked() {
        return this.blocked;
    }

    // Getting the next location
    public String getNextLocation() {
        return this.nextLocation;
    }

    // Getting the next direction
    public String getNextDirection() {
        return this.nextDirection;
    }
}

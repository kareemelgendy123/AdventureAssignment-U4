package assignment6;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

/**
 *
 * @author Kareem
 */
public class PicturePanel extends JComponent {

    // Storing the image
    private BufferedImage image;

    @Override
    public void paintComponent(Graphics g) {
        // Checking for image
        if (image != null) {
            // Draw the image
            g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
        }
    }

    public void setImage(BufferedImage img) {
        // Storing the image
        this.image = img;
        // Drawing the image
        repaint();
    }
}

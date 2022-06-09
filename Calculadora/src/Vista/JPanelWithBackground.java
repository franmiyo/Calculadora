package Vista;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;

public class JPanelWithBackground extends JPanel {
	
	private static final long serialVersionUID = -7585315925768773350L;
	private Image backgroundImage;

	  // Some code to initialize the background image.
	  // Here, we use the constructor to load the image. This
	  // can vary depending on the use case of the panel.
	  public JPanelWithBackground(String fileName) throws IOException {
	    backgroundImage = ImageIO.read(new File(fileName));
	  }

	  public void paintComponent(Graphics g) {
	    super.paintComponent(g);

	    // Draw the background image.
	    g.drawImage(backgroundImage, 0, 0, this);
	  }

	public JPanelWithBackground() {
		super();
	}
	  
	  
	
	

}

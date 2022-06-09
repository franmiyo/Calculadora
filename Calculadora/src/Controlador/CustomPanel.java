package Controlador;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Graphics;

public class CustomPanel extends JPanel {

	private URL url = getClass().getResource("Images/bruja.jpg");
	Image img = new ImageIcon(url).getImage();

	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		// g.setOpaque(false);
		super.paint(g);

	}
}

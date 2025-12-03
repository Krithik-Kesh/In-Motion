package main;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
	
	// Screen Settings
	final int originalTileSize = 16;// 16x16 title
	final int scale = 3;
	
	final int titleSize = originalTileSize * scale; //48x48 tile
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	final int screenWidth = titleSize * maxScreenCol;
	final int screenHeight = titleSize * maxScreenRow;

	
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		
		
		
	}
	
}

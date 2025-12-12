package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;


public class GamePanel extends JPanel implements Runnable {
	
	// Screen Settings
	final int originalTileSize = 16;// 16x16 title
	final int scale = 3;
	
	final int tileSize = originalTileSize * scale; //48x48 tile
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	final int screenWidth = tileSize * maxScreenCol;
	final int screenHeight = tileSize * maxScreenRow;

	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	
	//Player initializers 
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4;
	
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	@Override
	public void run() {
		
		while(gameThread != null) {
			
			//Updates the program every 60 seconds
			update();
			
			
			//Updates the screen with draw
			repaint();
		}		
	}
		
	public void update() {
		
		//Player speed update, connected with KeyHandler
		if (keyH.uP == true) {
			playerY -= playerSpeed;
		}
		if (keyH.dP == true) {
			playerY += playerSpeed;
		}
		if (keyH.lP == true) {
			playerX -= playerSpeed;
		}
		if (keyH.rP == true) {
			playerX += playerSpeed;
		}
	}
	
	public void paintComponent(Graphics g) {
		
		//Paint component (Renders the character)
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setColor(Color.white);
		
		g2.fillRect(playerX, playerY, tileSize, tileSize);
		
		g2.dispose();
	}
}

package main;

import entity.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;


public class GamePanel extends JPanel implements Runnable {
	
	// Screen Settings
	final int originalTileSize = 16;// 16x16 title
	final int scale = 3;
	
	public final int tileSize = originalTileSize * scale; //48x48 tile
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	final int screenWidth = tileSize * maxScreenCol;
	final int screenHeight = tileSize * maxScreenRow;
	
	//FPS
	int FPS = 60;

	//keyHandler
	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	Player player = new Player(this, keyH);
	
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
		
		//initialize our 'Sleep Method' draw interval
		double drawInterval = 1000000000/FPS; //draw the screen every this time
		double drawTime = System.nanoTime() + drawInterval; //Everytime we hit the interval we draw another screen
		
		while(gameThread != null) {
			
			//Updates the program every 60 seconds
			update();
			
			
			//Updates the screen with draw
			repaint();
			

			//Sleep Method: Thread sleeps for the remaining time the screen is not updating
			try {
				double remainingTime = drawTime - System.nanoTime(); //Finds the time after the drawTime reset and uses this to sleep
				remainingTime = remainingTime/ 1000000; //Convert to Milliseconds
				
				if (remainingTime < 0) {
					remainingTime = 0;
				}
				Thread.sleep((long) remainingTime);
				
				drawTime += drawInterval;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}		
	}
		
	public void update() {

		player.update();
	}
	
	public void paintComponent(Graphics g) {
		
		//Paint component (Renders the character)
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		player.draw(g2);
		
		g2.dispose();
	}
}

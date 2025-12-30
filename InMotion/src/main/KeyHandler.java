package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyHandler implements KeyListener{

	public boolean uP, dP, lP, rP;
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		int code = e.getExtendedKeyCode();
		
		if (code == KeyEvent.VK_W) {
			uP = true;
			
		}
		if (code == KeyEvent.VK_S) {
			dP = true;
			
		}
		if (code == KeyEvent.VK_A) {
			lP = true;
			
		}
		if (code == KeyEvent.VK_D) {
			rP = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_W) {
			uP =  false;
			
		}
		if (code == KeyEvent.VK_S) {
			dP = false;
			
		}
		if (code == KeyEvent.VK_A) {
			lP = false;
			
		}
		if (code == KeyEvent.VK_D) {
			rP = false;
			
		}
		
	}
	

}

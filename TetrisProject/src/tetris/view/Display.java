package tetris.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import tetris.view.containers.HomeMenu;

public class Display implements Runnable{

	private JFrame frame;
	private JPanel homeMenu;
	
	
	
	@Override
	public void run() {
		this.frame = new JFrame();
		this.homeMenu = new HomeMenu(this);
		
		
		frame.setVisible(true);
		
	}
	
	
	public JFrame getFrame() {
		return frame;
	}

}

package tetris.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import tetris.controller.SwingController;
import tetris.view.containers.Game;
import tetris.view.containers.HomeMenu;

public class Display implements Runnable{

	private JFrame frame;
	private JPanel homeMenu;
	private Game game;
	private SwingController controller;
	
	public Display(SwingController controller) {
		this.controller = controller;
	}
	
	@Override
	public void run() {
		this.frame = new JFrame();
		this.homeMenu = new HomeMenu(this);
		
		frame.setContentPane(homeMenu);
		frame.setTitle("Tetris");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	public JFrame getFrame() {
		return frame;
	}
	
	public Game getGame() {
		return game;
	}
	
	public void setGame(Game game) {
		this.game = game;
	}
	
	public void refreshGame(){
		game.refresh();
	}
	
	public SwingController getController() {
		return controller;
	}

}

package tetris.view;

import java.awt.Color;
import java.io.IOException;

import javax.swing.JFrame;

import tetris.controller.ConfigManager;
import tetris.controller.SwingController;
import tetris.view.containers.Game;
import tetris.view.containers.HighScores;
import tetris.view.containers.HomeMenu;

/**
 * Class that's used to monitor the display on the Swing interface.
 * @author Sedara
 *
 */
public class Display implements Runnable{

	private JFrame frame;
	private final HomeMenu homeMenu;
	private Game game;
	private HighScores scores;
	private SwingController controller;
	private TetrisKeyListener keyListener;
	
	public Display(SwingController controller) {
		this.controller = controller;
		this.homeMenu = new HomeMenu(this);
		this.keyListener = null;
	}
	
	@Override
	public void run() {
		this.frame = new JFrame();		
		
		frame.setContentPane(homeMenu);
		frame.setTitle("Tetris");
		frame.setSize(430, 675);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void setBoxesColor(){
		for(BoxesColors b : BoxesColors.values()){
			try {
				b.setColor(new Color(Integer.parseInt(controller.getConfig().getDataInSection(ConfigManager.SECTION_BOXES_COLORS, b.toString()))));
			} catch (NumberFormatException  | IOException e) {}
		}
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
	
	public HomeMenu getHomeMenu() {
		return homeMenu;
	}
	
	public HighScores getScores() {
		return scores;
	}
	
	public void setScores(HighScores scores) {
		this.scores = scores;
	}
	
	public void refreshGame(){
		game.refresh();
	}
	
	public SwingController getController() {
		return controller;
	}
	
	public void setKeyListener(TetrisKeyListener keyListener) {
		if(this.keyListener != null)
			frame.removeKeyListener(this.keyListener);
		this.keyListener = keyListener;
		frame.addKeyListener(keyListener);
	}
	

}

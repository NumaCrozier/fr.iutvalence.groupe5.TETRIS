package tetris.controller;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.SwingUtilities;

import tetris.model.Game;
import tetris.model.Types;
import tetris.view.Display;

/**
 * Class that redefines the methods required by the Controller interface. It is implemented from the Controller interface.
 * @author Sedara
 *
 */
public class SwingController implements Controller{
	
	
	private Game game;
	
	private Display display;
	
	private ConfigManager config;
	
	private Locale locale;
	
	private ResourceBundle bundle;
	
	/**
	 * Method that allows to monitor the swing window.
	 */
	public SwingController(ConfigManager config) {
		this.config = config;
		String lang = "";
		try {
			lang = config.getDataInSection(ConfigManager.SECTION_LANG, "current");
		} catch (IOException e) {}
		locale = new Locale(lang.toLowerCase(), lang.toUpperCase());
		bundle = ResourceBundle.getBundle("TetrisLang", locale);
	}
	
	
	public void createNewGame(){
		game = new Game();
	}
	
	public String getString(String key){
		return bundle.getString(key);
	}
	
	public void setLanguage(String lang) {
		locale = new Locale(lang.toLowerCase(), lang.toUpperCase());
		bundle = ResourceBundle.getBundle("TetrisLang", locale);
	}


	public void startDisplay() {
		display = new Display(this);
		SwingUtilities.invokeLater(display);
		
	}
	
	/**
	 * Method returning the board dimensions (speaking in Boxes), into an int grid.
	 * @return int[]
	 */
	public int[] getBoardDimensions(){
		int i = game.getBoard().getRows();
		int j = game.getBoard().getColumns();
		int dim[] = {i,j};
		return dim;
	}
	
	/**
	 * Method that returns the type of a grid by giving it the row and the column.
	 * @param row
	 * @param col
	 * @return Types
	 */
	public Types getTypeFromBox(int row, int col){
		try{
		return game.getBoard().getBox(row, col).getTetrimino().getType();
		}catch(NullPointerException e){return null;}
	}


	@Override
	public void refreshDisplay() {
		display.refreshGame();
		
		
	}


	@Override
	public void rotateTetrimino() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void moveTetriminoForward() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void moveTetriminoRight() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void moveTetriminoLeft() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}
	
	public ConfigManager getConfig() {
		return config;
	}
	

}

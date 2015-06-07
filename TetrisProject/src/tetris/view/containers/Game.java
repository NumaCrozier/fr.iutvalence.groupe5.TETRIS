package tetris.view.containers;

import javax.swing.JPanel;

import tetris.view.Display;

/**
 * Class that represents the game class from model to Swing interface.
 * @author Numa
 *
 */
public class Game extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Board board;
	
	/**
	 * Constructor that sets up a game before its launching.
	 * @param display
	 */
	public Game(Display display) {
		super();
		int tab[] = display.getController().getBoardDimensions();
		board = new Board(display, tab[0], tab[1]);
		add(board);
		
	}
	
	/**
	 * Call to the method used to refresh the board on the Swing interface.
	 */
	public void refresh(){
		board.refreshPanel();
	}
	

}

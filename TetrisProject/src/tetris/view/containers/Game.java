package tetris.view.containers;

import javax.swing.JPanel;

import tetris.view.Display;

public class Game extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Board board;
	
	public Game(Display display) {
		super();
		int tab[] = display.getController().getBoardDimensions();
		board = new Board(display, tab[0], tab[1]);
		add(board);
		
	}
	
	public void refresh(){
		board.refreshPanel();
	}
	

}

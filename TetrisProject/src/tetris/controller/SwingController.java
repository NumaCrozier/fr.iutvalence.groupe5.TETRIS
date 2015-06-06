package tetris.controller;

import javax.swing.SwingUtilities;

import tetris.model.Game;
import tetris.model.Types;
import tetris.view.Display;

public class SwingController implements Controller{
	
	
	private Game game;
	
	private Display display;
	
	public SwingController() {
		
	}
	
	
	public void createNewGame(){
		game = new Game();
	}


	@Override
	public void startDisplay() {
		display = new Display(this);
		SwingUtilities.invokeLater(display);
		
	}
	
	public int[] getBoardDimensions(){
		int i = game.getBoard().getRows();
		int j = game.getBoard().getColumns();
		int dim[] = {i,j};
		return dim;
	}
	
	public Types getTypeFromBox(int row, int col){
		try{
		return game.getBoard().getBox(row, col).getTetrimino().getType();
		}catch(NullPointerException e){return null;}
	}


	@Override
	public void refreshDisplay() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void rotateTetrimino() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void moveTetriminoForward() {
		// TODO Auto-generated method stub
		
	}
	
	

}

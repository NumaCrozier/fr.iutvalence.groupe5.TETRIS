package tetris.controller;

import tetris.model.Game;

/**
 * Class that's implemented from Controller. It's used as a link between the model and the view.
 * @author Sedara
 *
 */
public class ConsoleController implements Controller{
	
	private Game game;
		
	/**
	 * Basic constructor for ConsoleController.
	 */
	public ConsoleController() {
	}

	@Override
	public void createNewGame() {
		game = new Game();
		
	}

	@Override
	public void startDisplay() {
		System.out.println(game.getBoard().toString());
		
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
	
	

}

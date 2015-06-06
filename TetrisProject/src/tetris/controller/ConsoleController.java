package tetris.controller;

import tetris.model.Game;

public class ConsoleController implements Controller{
	
	private Game game;
	
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
	
	

}

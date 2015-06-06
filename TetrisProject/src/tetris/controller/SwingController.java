package tetris.controller;

import tetris.model.Game;

public class SwingController implements Controller{
	
	
	private Game game;
	
	public SwingController() {
		
	}
	
	
	public void createNewGame(){
		game = new Game();
	}


	@Override
	public void startDisplay() {
		// TODO Auto-generated method stub
		
	}
	
	

}

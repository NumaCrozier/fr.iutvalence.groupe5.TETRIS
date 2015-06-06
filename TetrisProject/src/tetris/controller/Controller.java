package tetris.controller;

public interface Controller {
	
	public void createNewGame();
	
	public void startDisplay();
	
	public void refreshDisplay();
	
	public void rotateTetrimino();
	
	public void moveTetriminoForward();

}

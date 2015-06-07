package tetris.model;

import java.util.TimerTask;

/**
 * Class that represents the game launched in itself.
 * @author Sedara
 *
 */
public class Game {

	private Player player;
	
	private Board board;
	
	
	public Board getBoard() {
		return board;
	}


	public void setBoard(Board board) {
		this.board = board;
	}


	/**
	 * Method that "starts" the game by creating its new player and its game Board.
	 */
	public Game()
	{
		this.player = new Player();
		this.board = new Board();
		this.board.setTetrimino(new Tetriminos(Types.J, new Location(5, 5)));
	}
	
	public boolean play(){
		
		
		return false;
	}
	
	
	/**
	 * Method that creates the timer for the current game.
	 * @return TimerTask
	 */
	private TimerTask createTimer(){
		TimerTask timer = new TimerTask() {
			
			@Override
			public void run() {
				
				
			}
		};
		
		return timer;
	}
	
	private boolean forward(){
		
		
		
		
		return true;
	}
	
	
}

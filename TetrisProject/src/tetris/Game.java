package tetris;

public class Game 
{

	private Player player;
	
	private Board board;
	
	
	/**
	 * Method that "starts" the game by creating it's new player and it's game Board.
	 */
	public Game()
	{
		this.player = new Player();
		this.board = new Board();
	}
}

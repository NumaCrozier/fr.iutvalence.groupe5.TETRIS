package tetris;

public class Game 
{

	private Player player;
	
	private Board board;
	
	
	public Board getBoard() {
		return board;
	}


	public void setBoard(Board board) {
		this.board = board;
	}


	/**
	 * Method that "starts" the game by creating it's new player and it's game Board.
	 */
	public Game()
	{
		this.player = new Player();
		this.board = new Board();
		this.board.setTetrimino(new Tetriminos(Types.J, new Position(5, 5)));
	}
	
	
}

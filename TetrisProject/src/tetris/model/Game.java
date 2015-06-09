package tetris.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Class that represents the game launched in itself.
 * @author t3hr1s
 *
 */
public class Game {

	private Player player;

	private Board board;


	public Board getBoard() 
	{
		return board;
	}


	public void setBoard(Board board) 
	{
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
		Timer timer = new Timer();
		timer.schedule(createTimer(), 0, 500);

		return false;
	}


	/**
	 * Method that creates the timer for the current game.
	 * @return TimerTask
	 */
	private TimerTask createTimer()
	{
		TimerTask timer = new TimerTask() 
		{

			@Override
			public void run() {


			}
		};

		return timer;
	}

	public void moveTetriminoForward()
	{
		try{
			List<Box> oldBoxesList = new ArrayList<Box>();
			for(int counter = 0 ; counter < 4 ; counter++)
			{
				oldBoxesList.add(this.getBoard().getPlayedBoxes().get(counter));
				this.board.setTetrimino(new Tetriminos(null, oldBoxesList.get(counter).getBoxLocation()));
				this.board.setTetrimino(new Tetriminos(oldBoxesList.get(0).getTetrimino().getType(), this.board.getNextBox("bottom", oldBoxesList.get(counter)).getBoxLocation()));
			}
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			return;
		}

	}

	public void moveTetriminoRight()
	{
		try{
			List<Box> oldBoxesList = new ArrayList<Box>();
			for(int counter = 0 ; counter < 4 ; counter++)
			{
				oldBoxesList.add(this.getBoard().getPlayedBoxes().get(counter));
				this.board.setTetrimino(new Tetriminos(null, oldBoxesList.get(counter).getBoxLocation()));
				this.board.setTetrimino(new Tetriminos(oldBoxesList.get(0).getTetrimino().getType(), this.board.getNextBox("right", oldBoxesList.get(counter)).getBoxLocation()));
			}
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			return;
		}
	}

	public void moveTetriminoLeft()
	{
		try{
			List<Box> oldBoxesList = new ArrayList<Box>();
			for(int counter = 0 ; counter < 4 ; counter++)
			{
				oldBoxesList.add(this.getBoard().getPlayedBoxes().get(counter));
				this.board.setTetrimino(new Tetriminos(null, oldBoxesList.get(counter).getBoxLocation()));
				this.board.setTetrimino(new Tetriminos(oldBoxesList.get(0).getTetrimino().getType(), this.board.getNextBox("left", oldBoxesList.get(counter)).getBoxLocation()));
			}
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			return;
		}
	}
	
	private boolean forward()
	{




		return true;
	}


}

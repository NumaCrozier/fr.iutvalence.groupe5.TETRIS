package tetris.model;

import java.io.IOException;
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
				moveTetriminoForward();
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
		try
		{
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

	public void rotateTetrimino() throws IOException{

		ArrayList<Box> temporaryList = new ArrayList<Box>();
		ArrayList<Box> temporaryTetriminosList = new ArrayList<Box>();

		Location originalLocation = this.board.getPlayedBoxes().get(0).getBoxLocation();
		Location newLocation;
		int x;
		int y;
		temporaryList.add(this.board.getPlayedBoxes().get(0));

		for(int counter = 0 ; counter < 4 ; counter++)
		{
			try
			{
				newLocation = this.getBoard().getPlayedBoxes().get(counter).getBoxLocation();
				x = newLocation.getRow()-originalLocation.getRow();
				y = newLocation.getColumn()-originalLocation.getColumn();
				temporaryList.add(board.getBox(originalLocation.getRow()+y, originalLocation.getColumn()-x));
				if(temporaryList.get(counter).getTetrimino().getType()!= null && (temporaryList.get(counter).getState() != States.PLAYED))
					return;
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				return;
			}
			}
		
			for(int counter = 0; counter < 4; counter++)
			{
			temporaryTetriminosList.add(this.board.getPlayedBoxes().get(counter));
			this.board.getPlayedBoxes().get(counter).setTetrimino(null);
			this.board.getPlayedBoxes().get(counter).setState(States.EMPTY);
			}
			
			for(int counter = 0; counter < 4; counter++)
			{
				
				temporaryList.get(counter).setTetrimino(temporaryTetriminosList.get(counter).getTetrimino());
				temporaryList.get(counter).setState(States.PLAYED);
			}

		}
	

	private boolean forward()
	{
		return true;
	}


}

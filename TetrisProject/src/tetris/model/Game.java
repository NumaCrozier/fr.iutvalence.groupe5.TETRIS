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
			this.board.getPlayedBoxes().get(counter).setTetrimino(null);
			this.board.getPlayedBoxes().get(counter).setState(States.EMPTY);
			}
			for(int counter = 0; counter < 4; counter++)
			{
				temporaryList.get(counter).setTetrimino(tetrimino);;
				temporaryList.get(counter).setState(States.PLAYED);
			}

		}
	

	 public static void rotateBlock() throws IOException{
		  // rot90 (0  -1)
		  //       (1   0)
		  
		   ArrayList<Case> tempList = new ArrayList<Case>();
		   Position positionBase = list.get(0).getPosition();
		   Position position;
		   int x,y;
		   tempList.add(list.get(o));
		   for(int i=1;i<4;i++){   
		    try{
		    position = list.get(i).getPosition();
		    x = position.getX()-positionBase.getX();
		    y = position.getY()-positionBase.getY();
		    tempList.add(champs.getCase(positionBase.getX()+y,positionBase.getY()-x));
		    if(tempList.get(i).getType() != null && !tempList.get(i).isPlaying())
		     return;
		    }catch(ArrayIndexOutOfBoundsException e){return;};
		   }
		   
		   for(int i=0;i<4;i++){
		    list.get(i).setType(null);
		    list.get(i).setPlaying(false);
		   }
		   for(int i=0;i<4;i++){
		    tempList.get(i).setType(type);
		    tempList.get(i).setPlaying(true);
		   }
		   list = tempList;
		   TaskDisplay.gamePanel.setCasesColor(TaskDisplay.gamePanel.getTableau(),champs.getX(),champs.getY());
		  
		  
		 }

	private boolean forward()
	{
		return true;
	}


}

package tetris.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing the game board.
 * @author th3r1s
 *
 */
public class Board {

	private final static int NB_ROWS = 22;

	private final static int NB_COLUMNS = 10;

	private final int rows;

	private final int columns;

	private Box[][] box;


	/**
	 * Constructor with parameters for Board class.
	 * @param rows
	 * @param columns
	 */
	public Board(int rows, int columns) 
	{
		
		this.rows=rows;
		this.columns=columns;
		this.box = new Box[rows][columns];
		InitBox();
	}
	
	/**
	 * Constructor for Board class.
	 */
	public Board()
	{
		this(NB_ROWS,NB_COLUMNS);
	}
	
	/**
	 * Collection that returns the played boxes into a list.
	 * @return List<Box>
	 */
	public List<Box> getPlayedBoxes(){
		List<Box> list = new ArrayList<Box>();
		for(int counterRows = 0 ; counterRows < NB_ROWS; counterRows++)
		{
			for(int counterColumns = 0 ; counterColumns < NB_COLUMNS; counterColumns++)
			{
				if(this.box[counterRows][counterColumns].getState()==States.PLAYED){
					list.add(this.box[counterRows][counterColumns]);
				}
			}
		}
		return list;
	}
	
	
	/**
	 * Method allowing to set a tetrimino on the board by making the relatives Box around the first box having a tetrimino on it, depending on the tetrimino wanted.
	 * @param tetrimino
	 */
	public void setTetrimino(Tetriminos tetrimino)
	{
		this.box[tetrimino.getRelativesBox(0).getBoxLocation().getRow()][tetrimino.getRelativesBox(0).getBoxLocation().getColumn()].setTetrimino(tetrimino);
		this.box[tetrimino.getRelativesBox(1).getBoxLocation().getRow()][tetrimino.getRelativesBox(1).getBoxLocation().getColumn()].setTetrimino(tetrimino);
		this.box[tetrimino.getRelativesBox(2).getBoxLocation().getRow()][tetrimino.getRelativesBox(2).getBoxLocation().getColumn()].setTetrimino(tetrimino);
		this.box[tetrimino.getRelativesBox(3).getBoxLocation().getRow()][tetrimino.getRelativesBox(3).getBoxLocation().getColumn()].setTetrimino(tetrimino);
	}
	
	/**
	 * Method that initializes the Box grid.
	 */
	public void InitBox()
	{
		for(int counterRows = 0 ; counterRows < NB_ROWS; counterRows++)
		{
			for(int counterColumns = 0 ; counterColumns < NB_COLUMNS; counterColumns++)
			{
				//Box emptyBox = new Box(new Position(counterBoxRows , counterBoxColumns));
				this.box[counterRows][counterColumns] = new Box(new Location(counterRows, counterColumns));
			}
		}
	}
	
	/**
	 * Method returning the box which is the next on the board (to make the tetrimino fall from the top of the board to the bottom of it).
	 * @param direction
	 * @param initialBox
	 * @return Box
	 */
	public Box getNextBox(String direction, Box initialBox){
		switch(direction){
		case "bottom" : return getBottomBox(initialBox.getBoxLocation());
		case "upper" : return getUpperBox(initialBox.getBoxLocation());
		case "left" : return getLeftBox(initialBox.getBoxLocation());
		case "right" : return getRightBox(initialBox.getBoxLocation());
		default:
			return null;
		}
	}
	
	/**
	 * allow to get the bottom box of the location.
	 * @param location from the method is used
	 * @return the box we need to get
	 */
	private Box getBottomBox(Location position){
		return this.box[position.getRow()+1][position.getColumn()];
	}
	
	/**
	 * allow to get the upper box of the location.
	 * @param location from the method is used
	 * @return the box we need to get
	 */
	private Box getUpperBox(Location position){
		return this.box[position.getRow()-1][position.getColumn()];
	}
	
	/**
	 * allow to get the left box of the location.
	 * @param location from the method is used
	 * @return the box we need to get
	 */
	private Box getLeftBox(Location position){
		return this.box[position.getRow()][position.getColumn()-1];
	}
	
	/**
	 * allow to get the right box of the location.
	 * @param location from the method is used
	 * @return the box we need to get
	 */
	private Box getRightBox(Location position){
		return this.box[position.getRow()][position.getColumn()+1];
	}

	/**
	 * Method that displays the game board.
	 */
	public Box getBox(int row, int column)
	{
		return this.box[row][column];
	}
	
	public String toString()
	{
		String str="---------------------------------------------\n"
				+ "|   | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |\n---------------------------------------------\n";
		for(int counterRows = 0; counterRows < this.rows ; counterRows++)
		{
        	str += "| "+counterRows+ (counterRows < 10 ? " ": "" );
			for(int counterColumns = 0; counterColumns < this.columns; counterColumns++)
			{
				str += this.box[counterRows][counterColumns].toString();
			}
            str += "|\n---------------------------------------------\n";
		}	
		return str;
	}
	
	/**
	 * Getter that returns the number of row.
	 * @return int
	 */
	public int getRows() {
		return rows;
	}
	
	/**
	 * Method that returns the number of columns.
	 * @return int
	 */
	public int getColumns() {
		return columns;
	}

}

package tetris.model;

import java.util.ArrayList;
import java.util.List;

public class Board {

	private final static int NB_ROWS = 22;

	private final static int NB_COLUMNS = 10;

	private int rows;

	private int columns;

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
	
	private Box getNextBox(String direction, Box initialBox){
		switch(direction){
		case "bottom" : return getBottomBox(initialBox.getBoxPosition());
		case "upper" : return getUpperBox(initialBox.getBoxPosition());
		case "left" : return getLeftBox(initialBox.getBoxPosition());
		case "right" : return getRightBox(initialBox.getBoxPosition());
		default:
			return null;
		}
	}
	
	/**
	 * allow to get the bottom box of the location.
	 * @param location from the method is used
	 * @return the box we need to get
	 */
	public Box getBottomBox(Position position){
		return this.box[position.getRow()+1][position.getColumn()];
	}
	
	/**
	 * allow to get the upper box of the location.
	 * @param location from the method is used
	 * @return the box we need to get
	 */
	public Box getUpperBox(Position position){
		return this.box[position.getRow()-1][position.getColumn()];
	}
	
	/**
	 * allow to get the left box of the location.
	 * @param location from the method is used
	 * @return the box we need to get
	 */
	public Box getLeftBox(Position position){
		return this.box[position.getRow()][position.getColumn()-1];
	}
	
	/**
	 * allow to get the right box of the location.
	 * @param location from the method is used
	 * @return the box we need to get
	 */
	public Box getRightBox(Position position){
		return this.box[position.getRow()][position.getColumn()+1];
	}
	
	public void setTetrimino(Tetriminos tetrimino){
		this.box[tetrimino.getRelativesBox(0).getBoxPosition().getRow()][tetrimino.getRelativesBox(0).getBoxPosition().getColumn()].setTetrimino(tetrimino);
		this.box[tetrimino.getRelativesBox(1).getBoxPosition().getRow()][tetrimino.getRelativesBox(1).getBoxPosition().getColumn()].setTetrimino(tetrimino);
		this.box[tetrimino.getRelativesBox(2).getBoxPosition().getRow()][tetrimino.getRelativesBox(2).getBoxPosition().getColumn()].setTetrimino(tetrimino);
		this.box[tetrimino.getRelativesBox(3).getBoxPosition().getRow()][tetrimino.getRelativesBox(3).getBoxPosition().getColumn()].setTetrimino(tetrimino);
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
				this.box[counterRows][counterColumns] = new Box(new Position(counterRows, counterColumns));
			}
		}
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

}

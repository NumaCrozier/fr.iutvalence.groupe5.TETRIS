package tetris;

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
		new Board();
		this.box = new Box[NB_ROWS][NB_COLUMNS];
	}


	/**
	 * Constructor for Board class.
	 */
	public Board()
	{
		this.rows=NB_ROWS;
		this.columns=NB_COLUMNS;
		InitBox();
	}
	
	/**
	 * Method that initializes the Box grid.
	 */
	public void InitBox()
	{
		for(int counterBoxRows = 0 ; counterBoxRows < NB_ROWS; counterBoxRows++)
		{
			for(int counterBoxColumns = 0 ; counterBoxColumns < NB_COLUMNS; counterBoxColumns++)
			{
				Box emptyBox = new Box(new Position(counterBoxRows , counterBoxColumns));
				this.box[counterBoxColumns][counterBoxRows] = emptyBox;
			}
		}
	}

	/**
	 * Method that displays the game board.
	 */
	public void DisplayBoard()
	{
		for(int counterToDisplayBoardColumns = 0; counterToDisplayBoardColumns < NB_COLUMNS ; counterToDisplayBoardColumns++)
		{
			for(int counterToDisplayBoardRows = 0; counterToDisplayBoardRows < this.NB_ROWS; counterToDisplayBoardRows++)
			{
				System.out.println(this.box[counterToDisplayBoardColumns][counterToDisplayBoardRows]);
			}
		}	
	}

}

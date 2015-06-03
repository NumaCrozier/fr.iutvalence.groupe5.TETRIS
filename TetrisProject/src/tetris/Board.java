package tetris;

public class Board {

	private final static int NB_ROWS = 22;

	private final static int NB_COLUMNS = 10;

	private int rows;

	private int columns;

	private Box[][] box;


	public Board(int rows, int columns) 
	{
		new Board();
		this.box = new Box[NB_ROWS][NB_COLUMNS];
	}


	public Board()
	{
		this.rows=NB_ROWS;
		this.columns=NB_COLUMNS;
		InitBox(NB_COLUMNS, NB_ROWS);
	}


	public void InitBox(int numberOfColumns, int numberOfRows)
	{
		for(int counterBoxColumns = 0 ; counterBoxColumns < numberOfColumns ; counterBoxColumns++)
		{
			for(int counterBoxRows = 0 ; counterBoxRows < numberOfRows ; counterBoxRows++)
			{
				Box emptyBox = new Box(new Position(counterBoxRows , counterBoxColumns));
				this.box[counterBoxRows][counterBoxColumns] = emptyBox; 
			}
		}
	}

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

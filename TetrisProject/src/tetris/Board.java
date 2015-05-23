package tetris;

public class Board {
	
	private final static int NB_ROWS = 22;
	
	private final static int NB_COLUMNS = 10;
	
	private int rows;
	
	private int colums;
	
	private Box[][] box;
	
	public Board(int rows, int columns) {
		
		new Board();
		this.box = new Box[NB_ROWS][NB_COLUMNS];
		
	}
	
	public Board(){
		this.rows=NB_ROWS;
		this.colums=NB_COLUMNS;
	}

}

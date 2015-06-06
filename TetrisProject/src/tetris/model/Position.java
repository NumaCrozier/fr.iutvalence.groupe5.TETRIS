package tetris.model;

public class Position {

	private final int row;
	
	private final int column;
	
	/**
	 * Constructor parametered that creates a position.
	 * @param row
	 * @param column
	 */
	public Position(int row, int column) {
		this.row=row;
		this.column=column;
	}

	/**
	 * Method allowing to get the column from a position.
	 * @return
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * Method allowing to get the row from a position.
	 * @return
	 */
	public int getRow() {
		return row;
	}

}

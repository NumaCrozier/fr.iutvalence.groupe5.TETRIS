package tetris;

public class Box {

	private final Position boxPosition;

	private States state;

	private Tetriminos tetrimino;

	/**
	 * Constructor parametered for Box class.
	 * @param position
	 */
	public Box(Position position) {
		this.boxPosition=position;
		this.state=States.EMPTY;
		this.setTetrimino(new Tetriminos(Types.NONE,new Position(0,0)));
	}


	/**
	 * Method allowing to get a Box position.
	 * @return
	 */
	public Position getBoxPosition() 
	{
		return boxPosition;
	}

	/**
	 * Method allowing to get the tetrimino assigned to a box.
	 * @return
	 */
	public Tetriminos getTetrimino()
	{
		return tetrimino;
	}

	/**
	 * Method allowing to modify the tetrimino assigned to a box.
	 * @param tetrimino
	 */
	public void setTetrimino(Tetriminos tetrimino) 
	{
		this.tetrimino = tetrimino;
	}

	/**
	 * Method allowing to modify the state of a Box.
	 * @param state
	 */
	public void setState(States state)
	{
		this.state = state;
	}


	@Override
	public String toString() 
	{
		return "[ "+this.boxPosition+" ]"+"( "+this.state+" )"+"( "+this.tetrimino+" )";
	}
}

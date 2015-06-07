package tetris.model;

public class Box {

	private final Location boxLocation;

	private States state;

	private Tetriminos tetrimino;

	/**
	 * Constructor parametered for Box class.
	 * @param position
	 */
	public Box(Location position) {
		this.boxLocation=position;
		this.state=States.EMPTY;
		this.tetrimino = null;
	//	this.setTetrimino(new Tetriminos(Types.NONE,new Position(0,0)));
	}


	/**
	 * Method allowing to get a Box position.
	 * @return
	 */
	public Location getBoxLocation() 
	{
		return boxLocation;
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
		this.state = States.PLAYED;  //TODO : Remettre PLACED � la place de PLAYED
	}

	/**
	 * Method allowing to modify the state of a Box.
	 * @param state
	 */
	public void setState(States state)
	{
		this.state = state;
	}

	/**
	 * Getter returning the state of the selected box.
	 * @return States
	 */
	public States getState()
	{
		return this.state;
	}
	
	@Override
	public String toString() 
	{
		return "| "+this.state.toChar()+" ";
		
	}
}

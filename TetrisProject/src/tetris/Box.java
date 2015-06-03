package tetris;

public class Box {

	private final Position boxPosition;
	
	private States state;
	
	private int row;
	
	private int column;
	
	private Tetriminos tetrimino;

	public Box(Position position) {
		this.boxPosition=position;
		this.state=States.EMPTY;
		this.setTetrimino(null);
	}


	public Position getBoxPosition() {
		return boxPosition;
	}

	public Tetriminos getTetrimino() {
		return tetrimino;
	}

	public void setTetrimino(Tetriminos tetrimino) {
		this.tetrimino = tetrimino;
	}

	@Override
	public String toString() 
	{
		return "[ "+this.boxPosition+" ]"+"( "+this.state+" )"+"( "+this.tetrimino+" )";
	}
}

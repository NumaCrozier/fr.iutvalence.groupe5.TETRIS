package tetris.model;

/**
 * Class that represents a tetrimino.
 * @author Sedara
 *
 */
public class Tetriminos {
	
	private final Types type;
	
	private Location position;
	
	private Box[] relativesBox;
	
	/**
	 * Constructor for our tetriminos, including the box the tetrimino will take.
	 * @param type
	 * @param location
	 */
	public Tetriminos(Types type, Location location) 
	{
		this.relativesBox = new Box[4];
		this.type=type;
		this.position=location;
		switch (this.type){
		case I:
			relativesBox[0]= new Box(new Location(location.getRow(),location.getColumn()));
			relativesBox[1]= new Box(new Location(location.getRow()-1,location.getColumn()));
			relativesBox[2]= new Box(new Location(location.getRow()-2,location.getColumn()));
			relativesBox[3]= new Box(new Location(location.getRow()-3,location.getColumn()));
			break;
		case O:
			relativesBox[0]= new Box(new Location(location.getRow(),location.getColumn()));
			relativesBox[1]= new Box(new Location(location.getRow()-1,location.getColumn()));
			relativesBox[2]= new Box(new Location(location.getRow()-1,location.getColumn()+1));
			relativesBox[3]= new Box(new Location(location.getRow(),location.getColumn()+1));
			break;
		case L:
			relativesBox[0]= new Box(new Location(location.getRow(),location.getColumn()));
			relativesBox[1]= new Box(new Location(location.getRow()-1,location.getColumn()));
			relativesBox[2]= new Box(new Location(location.getRow()-2,location.getColumn()));
			relativesBox[3]= new Box(new Location(location.getRow(),location.getColumn()+1));
			break;
		case Z:
			relativesBox[0]= new Box(new Location(location.getRow(),location.getColumn()));
			relativesBox[1]= new Box(new Location(location.getRow(),location.getColumn()+1));
			relativesBox[2]= new Box(new Location(location.getRow()-1,location.getColumn()));
			relativesBox[3]= new Box(new Location(location.getRow()-1,location.getColumn()-1));
			break;
		case S:
			relativesBox[0]= new Box(new Location(location.getRow(),location.getColumn()));
			relativesBox[1]= new Box(new Location(location.getRow(),location.getColumn()-1));
			relativesBox[2]= new Box(new Location(location.getRow()-1,location.getColumn()));
			relativesBox[3]= new Box(new Location(location.getRow()-1,location.getColumn()+1));
			break;
		case T:
			relativesBox[0]= new Box(new Location(location.getRow(),location.getColumn()));
			relativesBox[1]= new Box(new Location(location.getRow()-1,location.getColumn()));
			relativesBox[2]= new Box(new Location(location.getRow()-1,location.getColumn()-1));
			relativesBox[3]= new Box(new Location(location.getRow()-1,location.getColumn()+1));
			break;
		case J:
			relativesBox[0]= new Box(new Location(location.getRow(),location.getColumn()));
			relativesBox[1]= new Box(new Location(location.getRow(),location.getColumn()-1));
			relativesBox[2]= new Box(new Location(location.getRow()-1,location.getColumn()));
			relativesBox[3]= new Box(new Location(location.getRow()-2,location.getColumn()));
			break;
		//				The NONE is for tests.
		//case NONE:
		//	relativesBox[0]= new Box(new Position(position.getRow(),position.getColumn()));
		//	relativesBox[1]= new Box(new Position(position.getRow(),position.getColumn()));
		//	relativesBox[2]= new Box(new Position(position.getRow(),position.getColumn()));
		//	relativesBox[3]= new Box(new Position(position.getRow(),position.getColumn()));
		//	break;
		default : System.err.println("Le type de Tetriminos ne correspond à aucun connu.");
		break;
		}
	}
	
	/**
	 * Getter that returns the boxes that are relatives to a box.
	 * @param boxNumero
	 * @return Box
	 */
	public Box getRelativesBox(int boxNumero){
		return this.relativesBox[boxNumero];
	}
	
	/**
	 * Getter that returns the type (the tetrimino) of the current box.
	 * @return Types
	 */
	public Types getType() {
		return type;
	}
	
	@Override
	public String toString() {
		switch (this.type)
		{
		case I : return "I";
		case O : return "O";
		case L : return "L";
		case Z : return "Z";
		case S : return "S";
		case T : return "T";
		default : return "Unknown";
		}
	}
}

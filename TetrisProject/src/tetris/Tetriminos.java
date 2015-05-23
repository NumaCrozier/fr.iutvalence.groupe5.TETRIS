package tetris;

public class Tetriminos {
	
	private final Types type;
	
	private Position position;
	
	private Box[] relativesBox;
	
	public Tetriminos(Types type, Position position) {
		this.type=type;
		switch (this.type){
		case I:
			relativesBox[0]= new Box(new Position(position.getRow(),position.getColumn()));
			relativesBox[1]= new Box(new Position(position.getRow()-1,position.getColumn()));
			relativesBox[2]= new Box(new Position(position.getRow()-2,position.getColumn()));
			relativesBox[3]= new Box(new Position(position.getRow()-3,position.getColumn()));
			break;
		case O:
			relativesBox[0]= new Box(new Position(position.getRow(),position.getColumn()));
			relativesBox[1]= new Box(new Position(position.getRow()-1,position.getColumn()));
			relativesBox[2]= new Box(new Position(position.getRow()-1,position.getColumn()+1));
			relativesBox[3]= new Box(new Position(position.getRow(),position.getColumn()+1));
			break;
		case L:
			relativesBox[0]= new Box(new Position(position.getRow(),position.getColumn()));
			relativesBox[1]= new Box(new Position(position.getRow()-1,position.getColumn()));
			relativesBox[2]= new Box(new Position(position.getRow()-2,position.getColumn()));
			relativesBox[3]= new Box(new Position(position.getRow(),position.getColumn()+1));
			break;
		case Z:
			relativesBox[0]= new Box(new Position(position.getRow(),position.getColumn()));
			relativesBox[1]= new Box(new Position(position.getRow(),position.getColumn()+1));
			relativesBox[2]= new Box(new Position(position.getRow()-1,position.getColumn()));
			relativesBox[3]= new Box(new Position(position.getRow()-1,position.getColumn()-1));
			break;
		case S:
			relativesBox[0]= new Box(new Position(position.getRow(),position.getColumn()));
			relativesBox[1]= new Box(new Position(position.getRow(),position.getColumn()-1));
			relativesBox[2]= new Box(new Position(position.getRow()-1,position.getColumn()));
			relativesBox[3]= new Box(new Position(position.getRow()-1,position.getColumn()+1));
			break;
		case T:
			relativesBox[0]= new Box(new Position(position.getRow(),position.getColumn()));
			relativesBox[1]= new Box(new Position(position.getRow()-1,position.getColumn()));
			relativesBox[2]= new Box(new Position(position.getRow()-1,position.getColumn()-1));
			relativesBox[3]= new Box(new Position(position.getRow()-1,position.getColumn()+1));
			break;
		case J:
			relativesBox[0]= new Box(new Position(position.getRow(),position.getColumn()));
			relativesBox[1]= new Box(new Position(position.getRow(),position.getColumn()-1));
			relativesBox[2]= new Box(new Position(position.getRow()-1,position.getColumn()));
			relativesBox[3]= new Box(new Position(position.getRow()-2,position.getColumn()));
			break;
		default : System.err.println("Le type de Tetriminos ne correspond à aucun connu.");
		break;
		}
	}

}

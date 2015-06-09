package tetris.model;

/**
 * Class that represents the current player.
 * @author Numa
 *
 */
public class Player {

	private final String nickname;
	
	/**
	 * Constructor not parametered that creates a new player.
	 */
	public Player()
	{
		this.nickname = "Hodor";
	}
	
	/**
	 * Constructor parametered that creates a new player.
	 * @param nickname
	 */
	public Player(String nickname) 
	{
		this.nickname = nickname;
	}
	
}

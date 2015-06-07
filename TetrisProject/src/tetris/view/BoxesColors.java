package tetris.view;

import java.awt.Color;

/**
 * Enumeration that contains the colors the tetriminos will get on the Swing interface.
 * @author Numa
 *
 */
public enum BoxesColors {
	
	I,
	O,
	T,
	L,
	J,
	Z,
	S,
	EMPTY;
	
	private Color color;
	
	private BoxesColors() {
		this.color = null;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}

}

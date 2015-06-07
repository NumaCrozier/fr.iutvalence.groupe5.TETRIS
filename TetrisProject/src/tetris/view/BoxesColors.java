package tetris.view;

import java.awt.Color;

/**
 * @author Sedara
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

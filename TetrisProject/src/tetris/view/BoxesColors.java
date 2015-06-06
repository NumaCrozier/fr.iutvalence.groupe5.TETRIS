package tetris.view;

import java.awt.Color;

public enum BoxesColors {
	
	I(Color.RED),
	O(Color.BLUE),
	T(Color.GRAY),
	L(Color.WHITE),
	J(Color.MAGENTA),
	Z(Color.GREEN),
	S(Color.CYAN),
	EMPTY(Color.BLACK);
	
	private Color color;
	
	private BoxesColors(Color color) {
		this.color = color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}

}

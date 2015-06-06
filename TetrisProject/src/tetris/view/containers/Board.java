package tetris.view.containers;

import java.awt.GridLayout;

import javax.swing.JPanel;

import tetris.view.Display;

public class Board extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Box[][] boxes;
	private int rows;
	private int columns;
	
	private Display display;
	
	public Board(Display display, int rows, int columns) {
		super();
		boxes = new Box[rows][columns];
		this.rows = rows;
		this.columns = columns;
		this.display = display;
		
		setLayout(new GridLayout(rows, columns));
		
		for(int i=0;i<rows;i++){
			for(int j=0;j<columns;j++){
				boxes[i][j] = new Box();
				add(boxes[i][j]);
			}
		}
		
	}
	
	public void refreshPanel(){
		for(int i=0;i<rows;i++){
			for(int j=0;j<columns;j++){
				boxes[i][j].setColor(display.getController().getTypeFromBox(i, j));
			}
		}
	}

}
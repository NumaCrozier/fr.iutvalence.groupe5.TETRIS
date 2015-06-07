package tetris.view.buttons;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import tetris.view.Display;

public class ButtonDefault extends TetrisButton implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	public ButtonDefault(Display display) {
		super(display, "default");
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

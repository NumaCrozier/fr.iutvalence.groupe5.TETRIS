package tetris.view.buttons;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tetris.view.Display;

public class ButtonControls extends TetrisButton implements ActionListener{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ButtonControls(Display display) {
		super(display, "controls");
		setPreferredSize(new Dimension(300, 100));
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

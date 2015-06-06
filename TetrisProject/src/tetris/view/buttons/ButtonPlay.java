package tetris.view.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import tetris.view.Display;

public class ButtonPlay extends JButton implements ActionListener{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Display display;

	public ButtonPlay(Display display) {
		super("Play");
		this.display = display;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO play
		
	}

}

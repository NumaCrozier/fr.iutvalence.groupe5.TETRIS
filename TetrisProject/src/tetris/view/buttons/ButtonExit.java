package tetris.view.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import tetris.view.Display;

public class ButtonExit extends JButton implements ActionListener{
	
	private Display display;

	public ButtonExit(Display display) {
		super("Exit");
		this.display = display;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

package tetris.view.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import tetris.view.Display;

public class ButtonCancel extends TetrisButton implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private JFrame frameToClose;

	public ButtonCancel(Display display, JFrame frameToClose) {
		super(display, "cancel");
		this.frameToClose = frameToClose;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frameToClose.dispose();
	}

}

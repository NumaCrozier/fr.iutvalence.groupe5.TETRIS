package tetris.view.buttons;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import tetris.view.Display;

/**
 * @author Sedara
 *
 */
public class ButtonColors extends TetrisButton implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ButtonColors(Display display) {
		super(display, "colors");
		addActionListener(this);
		setPreferredSize(new Dimension(300, 100));
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

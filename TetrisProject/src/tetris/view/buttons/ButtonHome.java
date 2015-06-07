package tetris.view.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import tetris.view.Display;

/**
 * @author Sedara
 *
 */
public class ButtonHome extends TetrisButton implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ButtonHome(Display display) {
		super(display, "home");
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		display.getFrame().setContentPane(display.getHomeMenu());
		display.setKeyListener(null);
		display.getFrame().revalidate();
		
	}

}

package tetris.view.buttons;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tetris.view.Display;
import tetris.view.TetrisKeyListener;
import tetris.view.containers.Game;

/**
 * @author Th3r1s
 *
 */
public class ButtonMusic extends TetrisButton implements ActionListener{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean listening = true;
	
	public ButtonMusic(Display display) {
		super(display, "music");
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.listening == true){
			display.getController().stopMusic();
			this.listening = false;
		}
		else{
			display.getController().playMusic();
			this.listening = true;
		}
	}

}

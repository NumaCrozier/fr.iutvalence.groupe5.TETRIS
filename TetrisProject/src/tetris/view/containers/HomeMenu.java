package tetris.view.containers;

import javax.swing.JPanel;

import tetris.view.Display;
import tetris.view.buttons.ButtonColors;
import tetris.view.buttons.ButtonExit;
import tetris.view.buttons.ButtonPlay;
import tetris.view.buttons.ButtonScores;

public class HomeMenu extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public HomeMenu(Display display) {
		super();
		add(new ButtonPlay(display));
		add(new ButtonScores(display));
		add(new ButtonColors(display));
		add(new ButtonExit(display));	
	}

}

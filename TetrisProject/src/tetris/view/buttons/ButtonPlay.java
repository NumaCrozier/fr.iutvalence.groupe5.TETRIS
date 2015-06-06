package tetris.view.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import tetris.view.Display;
import tetris.view.TetrisKeyListener;
import tetris.view.containers.Game;

public class ButtonPlay extends JButton implements ActionListener{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Display display;

	public ButtonPlay(Display display) {
		super("Play");
		this.display = display;
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		display.setGame(new Game(display));
		display.getFrame().setContentPane(display.getGame());
		int tab[] = display.getController().getBoardDimensions();
		display.getFrame().setSize(tab[1]*40, tab[0]*40);
		display.getFrame().revalidate();
		display.getFrame().addKeyListener(new TetrisKeyListener(display));
	}

}

package tetris.view.containers;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

import tetris.model.Types;
import tetris.view.Display;
import tetris.view.buttons.ButtonDefault;
import tetris.view.buttons.ButtonHome;

/**
 * @author Sedara
 *
 */
public class ColorsMenu extends JPanel{
	
	private static final long serialVersionUID = 1L;
		
	private Board[] boards;
	
	public ColorsMenu(Display display) {
		super();
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx = 2;
		gbc.weighty = 4;
		
		this.boards = new Board[7];
		
		for(int i = 0; i<boards.length; i++){
			boards[i] = new Board(display, 5, 5, true);
			boards[i].setTetrimino(Types.values()[i], 3, 2);
			gbc.gridx = (i >= 4 ? 1 : 0);
			gbc.gridy = (i)%4;
			add(boards[i], gbc);
		}
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		JSplitPane jSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		ButtonDefault default1 = new ButtonDefault(display);
		ButtonHome home = new ButtonHome(display);
		jSplitPane.add(default1);
		jSplitPane.add(home);
		jSplitPane.setDividerSize(0);
		add(jSplitPane, gbc);
		
	}
	
	

}

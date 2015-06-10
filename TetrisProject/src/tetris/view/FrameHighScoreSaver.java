package tetris.view;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tetris.view.buttons.ButtonCancel;
import tetris.view.buttons.ButtonValidateHighScoreSave;

/**
 * @author Sedara
 *
 */
public class FrameHighScoreSaver extends JFrame{

	private static final long serialVersionUID = 1L;
	private JLabel label;
	private JPanel jPanel;
	private JTextField jTextField;
	private ButtonCancel jButtonCancel;
	private ButtonValidateHighScoreSave validate;
	
	
	public FrameHighScoreSaver(Display display, JFrame endgame, int rank) {
		super();
		jPanel = new JPanel();
		label = new JLabel("<html>Vous �tes arriv�(e) � la "+(rank == 1 ? rank+"�re" : rank+"�me")+" place!<br>Si vous souhaitez enregistrer votre score, saisissez votre nom!</html>");
		label.setPreferredSize(new Dimension(250,50));
		jPanel.add(label);
		jTextField = new JTextField();
		jTextField.setPreferredSize(new Dimension(250,30));
		jPanel.add(jTextField);
		validate = new ButtonValidateHighScoreSave(display, jTextField, this, endgame, rank);
		jPanel.add(validate);
		jButtonCancel = new ButtonCancel(display, this, endgame);
		jPanel.add(jButtonCancel);
		add(jPanel);
		setLocationRelativeTo(null);
		setSize(300, 200);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}
	
}

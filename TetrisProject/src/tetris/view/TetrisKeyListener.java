package tetris.view;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author Sedara
 *
 */
public class TetrisKeyListener extends KeyAdapter{

	private Display display;
	
	public TetrisKeyListener(Display display) {
		this.display = display;
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			display.getController().moveTetriminoForward();
		}
		if(e.getKeyCode() == KeyEvent.VK_UP){
			display.getController().rotateTetrimino();
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			display.getController().moveTetriminoRight();
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			display.getController().moveTetriminoLeft();
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE){
			display.getController().pause();
		}
		
	}

}

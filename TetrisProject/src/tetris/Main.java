package tetris;

import tetris.controller.ConsoleController;
import tetris.controller.Controller;
import tetris.controller.SwingController;

/**
 * Main class where thet program is launched.
 * @author Numa
 *
 */
public class Main 
{
	public static void main(String[] args) 
	{
		Controller controller;
		
		controller = new SwingController();

		
		controller.createNewGame();
		controller.startDisplay();
		
	}
}

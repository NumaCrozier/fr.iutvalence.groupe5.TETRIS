package tetris;

import tetris.controller.ConsoleController;
import tetris.controller.Controller;
import tetris.controller.SwingController;

public class Main 
{
	public static void main(String[] args) 
	{
		Controller controller;
		
		controller = new ConsoleController();

		
		controller.createNewGame();
		controller.startDisplay();
		
	}
}

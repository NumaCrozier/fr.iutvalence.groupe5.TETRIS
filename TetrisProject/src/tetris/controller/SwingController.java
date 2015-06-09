package tetris.controller;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.SwingUtilities;

import tetris.model.Box;
import tetris.model.Game;
import tetris.model.Location;
import tetris.model.Tetriminos;
import tetris.model.Types;
import tetris.view.Display;
import tetris.view.containers.Board;

/**
 * Class that redefines the methods required by the Controller interface. It is implemented from the Controller interface.
 * @author Sedara
 *
 */
public class SwingController implements Controller{


	private Game game;

	private Display display;

	private ConfigManager config;

	private Locale locale;

	private ResourceBundle bundle;

	/**
	 * Method that allows to monitor the swing window.
	 */
	public SwingController(ConfigManager config) {
		this.config = config;
		String lang = "";
		try {
			lang = config.getDataInSection(ConfigManager.SECTION_LANG, "current");
		} catch (IOException e) {}
		locale = new Locale(lang.toLowerCase(), lang.toUpperCase());
		bundle = ResourceBundle.getBundle("TetrisLang", locale);
		this.playMusic();
	}

	/**
	 * Method that allows to launch the music
	 */
	public void playMusic() {
	    try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("musics/tetris_themeA_loop.wav").getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	        clip.loop(clip.LOOP_CONTINUOUSLY);
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
	
	public void horizontalSoundEffect() {
	    try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("soundEffects/horizontalSoundEffect.wav").getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}

	public void verticalSoundEffect() {
	    try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("musics/verticalSoundEffect.wav").getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
	
	public void tetrisSoundEffect() {
	    try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("musics/tetrisSoundEffect.wav").getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
	
	public void createNewGame(){
		game = new Game();
	}

	public String getString(String key){
		return bundle.getString(key);
	}

	public void setLanguage(String lang) {
		locale = new Locale(lang.toLowerCase(), lang.toUpperCase());
		bundle = ResourceBundle.getBundle("TetrisLang", locale);
	}


	public void startDisplay() {
		display = new Display(this);
		SwingUtilities.invokeLater(display);

	}

	/**
	 * Method returning the board dimensions (speaking in Boxes), into an int grid.
	 * @return int[]
	 */
	public int[] getBoardDimensions(){
		int i = game.getBoard().getRows();
		int j = game.getBoard().getColumns();
		int dim[] = {i,j};
		return dim;
	}

	/**
	 * Method that returns the type of a grid by giving it the row and the column.
	 * @param row
	 * @param col
	 * @return Types
	 */
	public Types getTypeFromBox(int row, int col){
		try{
			return game.getBoard().getBox(row, col).getTetrimino().getType();
		}catch(NullPointerException e){return null;}
	}


	@Override
	public void refreshDisplay() 
	{
		display.refreshGame();


	}


	@Override
	public void rotateTetrimino() 
	{

	}


	@Override
	public void moveTetriminoForward() 
	{
		
	}


	@Override
	public void moveTetriminoRight() 
	{

	}



	@Override
	public void moveTetriminoLeft() 
	{
		
	}


	@Override
	public void pause() 
	{
		// TODO Auto-generated method stub

	}

	public ConfigManager getConfig() 
	{
		return config;
	}

}

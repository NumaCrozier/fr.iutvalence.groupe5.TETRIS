package tetris.controller;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @author Sedara
 *
 */
public class ConfigManager{
	
	
	private static File config;
	private static final String[] defaultControls = {"moveleft:"+KeyEvent.VK_LEFT,"moveright:"+KeyEvent.VK_RIGHT,"rotate:"+KeyEvent.VK_UP,
													 "forward:"+KeyEvent.VK_DOWN,"pause:"+KeyEvent.VK_ESCAPE};
	private static final String[] defaultHighScores = {"1: - - ","2: - - ","3: - - ","4: - - ","5: - - ","6: - - ","7: - - ","8: - - ","9: - - ","10: - - "};
	private static final String[] defaultBoxesColors = {"I:"+Integer.toString(Color.RED.getRGB()),"O:"+Integer.toString(Color.BLUE.getRGB()),"T:"+Integer.toString(Color.GRAY.getRGB()),
														"L:"+Integer.toString(Color.MAGENTA.getRGB()),"J:"+Integer.toString(Color.WHITE.getRGB()),"Z:"+Integer.toString(Color.CYAN.getRGB()),
														"S:"+Integer.toString(Color.GREEN.getRGB()),"EMPTY:"+Integer.toString(Color.BLACK.getRGB())};
	private static final String[] defaultLang = {"English:en","Français:fr","current:en"};
	public static final String SECTION_BOXES_COLORS = "boxescolors";
	public static final String SECTION_CONTROLS = "controls";
	public static final String SECTION_HIGHSCORES = "highscores";
	public static final String SECTION_LANG = "lang";
	public static final String CONTROL_MOVE_LEFT = "moveleft";
	public static final String CONTROL_MOVE_RIGHT = "moveright";
	public static final String CONTROL_FORWARD = "forward";
	public static final String CONTROL_ROTATE = "rotate";
	public static final String CONTROL_PAUSE = "pause";

	
	
	// TODO Traduire

	/**
	 * Créer ou charge le fichier de configuration s'il est existant ou non.
	 * @param fileName : le nom du fichier de configuration. Il sera nommé <i>fileName</i>.ini
	 * @throws IOException
	 */
	public ConfigManager(String fileName) throws IOException {
		
		config = new File(fileName+".ini");
		if(!config.exists())
			createDefaultConfig();
		
		
	}
	
	/**
	 * @param sectionName : Section recherchée.
	 * @param searched : Ligne recherchée.
	 * @return La donnée à la ligne <i>searched</i>.
	 * @throws IOException
	 */
	public String getDataInSection(String sectionName, String searched) throws IOException{
		return ConfigSection.getDataFromSection(new BufferedReader(new FileReader(config)), sectionName, searched);
	}
	
	/**
	 * @param sectionName : Section recherchée.
	 * @param searched : Ligne recherchée.
	 * @return La clé à la ligne <i>searched</i>.
	 * @throws IOException
	 */
	public String getKeyFromDataInSection(String sectionName, String searched) throws IOException{
		return ConfigSection.getKeyFromDataFromSection(new BufferedReader(new FileReader(config)), sectionName, searched);
	}
	
	/**
	 * @param sectionName : Le nom de la section recherchée.
	 * @return Une liste des lignes de cette section.
	 * @throws IOException
	 */
	public ArrayList<String> getDataFromEntiereSection(String sectionName) throws IOException{
		return  ConfigSection.getDatasFromEntiereSection(new BufferedReader(new FileReader(config)), sectionName);
	}
	
	/** Enregistre des données en décalant les lignes suivantes.
	 * @param sectionName : Section recherchée.
	 * @param searched : Ligne à remplacée.
	 * @param newString : La donnée à enregistrer à la ligne <i>searched</i>.
	 * @throws IOException
	 */
	public void saveWithShift(String sectionName, String searched, String newString) throws IOException{
		ConfigSection.writeDataAndShift(config, sectionName, searched, newString);
	}

	
	/**
	 * Enregistre des données dans le fichier de configuration.
	 * @param sectionName : Le nom de la section dans laquelle se trouve les données.
	 * @param searched : La ligne recherché où l'enregistrement sera effectué (Traduit en String). Celle ci ne sera pas écrasé, l'enregistrement s'effectura après.
	 * @param newString : L'objet à enregistrer (Taduit en String) à la ligne <i>searched</i>.
	 * @throws IOException
	 */
	public void saveDate(String sectionName, Object searched, Object newString) throws IOException{
		ConfigSection.writeDataInSection( config , sectionName , searched.toString() , newString.toString());	
	}
	
	/** Remet/met une section avec ses valeurs par defauts
	 * @param sectionName : Le nom de la section à écrire.
	 * @throws IOException
	 */
	public void setDefaultSection(String sectionName) throws IOException{
		ConfigSection.setDefaultSection(config, sectionName);
	}
	
	
	/**
	 * Créer un fichier de configuration par défaut.
	 * @throws IOException
	 */
	private void createDefaultConfig() throws IOException{
		config.createNewFile();
		PrintWriter fw = new PrintWriter(new FileWriter(config));
		ConfigSection.createConfigSection(fw, SECTION_CONTROLS , defaultControls);
		ConfigSection.createConfigSection(fw, SECTION_HIGHSCORES , defaultHighScores);
		ConfigSection.createConfigSection(fw, SECTION_BOXES_COLORS, defaultBoxesColors);
		ConfigSection.createConfigSection(fw, SECTION_LANG, defaultLang);
		fw.close();
		
	}
	
	
	
	
	
	/**
	 * Gestion des sections.
	 */
	private static class ConfigSection {
		
		
		/**
		 * Créer d'une section.
		 * @param file : Fichier cible.
		 * @param sectionName : Nom de la section à créer.
		 * @param content : Contenu à mettre à l'intérieur.
		 */
		public static void createConfigSection(PrintWriter file, String sectionName, String[] content){
			
			file.println("SECTION:"+sectionName+"");
			for(int i=0;i<content.length;i++){
				file.println(content[i]);
			}
			file.println("*");
		}
		
		
		/**
		 * @param file : Fichier source.
		 * @param sectionName : Section recherchée.
		 * @param searched : Ligne recherchée.
		 * @return La ligne complète.
		 * @throws IOException
		 */
		public static String getDataFromSection(BufferedReader file, String sectionName, String searched) throws IOException{
			String line;	
			String str = "";
			while(!(line = file.readLine()).equalsIgnoreCase("SECTION:"+sectionName));			
			while(!(line = file.readLine()).equalsIgnoreCase("*")){
				str = line.split(":")[0];
				if(str.equalsIgnoreCase(searched)){
					str = line.split(":")[1];
					break;
				}
							
			}
			file.close();
			return str;
		}
		
		public static String getKeyFromDataFromSection(BufferedReader file, String sectionName, String searched) throws IOException{
			String line;	
			String str = "";
			while(!(line = file.readLine()).equalsIgnoreCase("SECTION:"+sectionName));			
			while(!(line = file.readLine()).equalsIgnoreCase("*")){
				str = line.split(":")[1];
				if(str.equalsIgnoreCase(searched)){
					str = line.split(":")[0];
					break;
				}
							
			}
			file.close();
			return str;
		}
		
		/**
		 * @param file : Fichier source.
		 * @param sectionName : Le nom de la section recherchée.
		 * @return Une liste des lignes de cette section.
		 * @throws IOException
		 */
		public static ArrayList<String> getDatasFromEntiereSection(BufferedReader file, String sectionName) throws IOException{
			String line;	
			ArrayList<String> str = new ArrayList<String>();
			while(!(line = file.readLine()).equalsIgnoreCase("SECTION:"+sectionName));			
			while(!(line = file.readLine()).equalsIgnoreCase("*")){
				str.add(line);
							
			}
			file.close();
			return str;
			
		}
		
		/** Ecrit dans une section et décale celle qui suivent (ici utilisé pour les scores).
		 * @param file : Le fichier cible
		 * @param sectionName : Le nom de la section
		 * @param searched : La ligne recherchée.
		 * @param newString : La donnée à enregistrer à la ligne <i>searched</i>.
		 * @throws IOException
		 */
		public static void writeDataAndShift(File file, String sectionName, String searched, String newString) throws IOException{
			String line;
			File f = new File("file.temp");
			PrintWriter pw = new PrintWriter(new FileWriter(f));
			BufferedReader br = new BufferedReader(new FileReader(file));
			while(!(line = br.readLine()).equalsIgnoreCase("SECTION:"+sectionName)){
				pw.println(line);
			}
			
			pw.println(line);
			
			String[] words;
			String lastLine = "";
						
			while(!(line = br.readLine()).equalsIgnoreCase("*")){
				words = line.split(":");
				if(searched.equalsIgnoreCase(words[0])){
					pw.println(words[0]+":"+newString);
					lastLine = line;
					break;
				}else
					pw.println(line);
					
			}
			
			if(!lastLine.equalsIgnoreCase("")){

				while(!(line = br.readLine()).equalsIgnoreCase("*")){
					words = lastLine.split(":");
					if(Integer.valueOf(words[0])+1 < 11){
						pw.print(Integer.valueOf(words[0])+1);
						pw.println(":"+words[1]);
					}
					lastLine = line;

				}
			}
			
			pw.println(line);
			
			while((line = br.readLine()) != null){
				pw.println(line);
			}
			
			pw.close();
			br.close();
			file.delete();
			f.renameTo(file);
		}
		
		
		/**
		 * Ecriture de données.
		 * @param file : Fichier source et cible.
		 * @param sectionName : Nom de la section dans laquelle sera enregistré les données.
		 * @param searched : La ligne recherché.
		 * @param newString : La donnée à enregistrer à la ligne <i>searched</i>.
		 * @throws IOException
		 */
		public static void writeDataInSection(File file, String sectionName, String searched, String newString) throws IOException{
			String line;
			File f = new File("file.temp");
			PrintWriter pw = new PrintWriter(new FileWriter(f));
			BufferedReader br = new BufferedReader(new FileReader(file));
			while(!(line = br.readLine()).equalsIgnoreCase("SECTION:"+sectionName)){
				pw.println(line);
			}
			
			pw.println(line);
			
			String[] words;
						
			while(!(line = br.readLine()).equalsIgnoreCase("*")){
				words = line.split(":");
				if(searched.equalsIgnoreCase(words[0]))
					pw.println(words[0]+":"+newString);
				else
					pw.println(line);
					
			}
			
			pw.println(line);
			
			while((line = br.readLine()) != null){
				pw.println(line);
			}
			
			pw.close();
			br.close();
			file.delete();
			f.renameTo(file);

			
		}
		

		/** Remet/met une section avec ses valeurs par defauts
		 * @param file : Le fichier cible.
		 * @param sectionName : Le nom de la section à écrire.
		 * @throws IOException
		 */
		public static void setDefaultSection(File file, String sectionName) throws IOException{
			BufferedReader br = new BufferedReader(new FileReader(file));
			File f = new File("file.temp");
			PrintWriter pw = new PrintWriter(new FileWriter(f));
			String line;
			while(!(line = br.readLine()).equalsIgnoreCase("SECTION:"+sectionName)){
				pw.println(line);
			}
			String[] content = null;
			switch(sectionName){
			case SECTION_CONTROLS : content = defaultControls; break;
			case SECTION_HIGHSCORES : content = defaultHighScores; break;
			case SECTION_BOXES_COLORS : content = defaultBoxesColors; break;
			}
			createConfigSection(pw, sectionName, content);
			while(!(line = br.readLine()).equalsIgnoreCase("*"));
			while((line = br.readLine()) != null){
				pw.println(line);
			}
			pw.close();
			br.close();
			file.delete();
			f.renameTo(file);
			
		}
		
		

	}
	
	
	

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Puppert
 *
 */
public class Utils_properties {

	private static Properties lexical_pro = new Properties();
	/**
	 * get lexical properties
	 * 
	 * @return Properties lexical_pro
	 */
	public static Properties getLexicalProperties() {
		if(lexical_pro.isEmpty()) {
			loadLexicalProperties();
		}
		return lexical_pro;
	}
	
	private static void loadLexicalProperties() {
		try {
			FileInputStream fis = new FileInputStream("Lexical.properties");
			lexical_pro.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
}

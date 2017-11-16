package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import compiler.grammatical_analysis.pojo.Rule;
import compiler.lexical_analysis.Analysis;
import compiler.pojo.word.Word;
import compiler.pojo.word.Vn.Vn_word;

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
	
	private static List<Rule> grammer_pro = new ArrayList<>();
	
	public static List<Rule> getRules(){
		if(grammer_pro.isEmpty()) {
			loadRule();
		}
		return grammer_pro;
	}
	
	private static void loadRule() {
		Analysis a = new Analysis();
		try {
			 BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("rule.txt"))));
			 String line = null;
			 while((line = br.readLine()) != null) {
				 Rule r = new Rule();
				 String[] str = line.split("->");
				 Vn_word left = new Vn_word();
				 left.setWord(str[0]);
				 r.setLeft(left);
				 Map<String, String> m = a.getAllContants(str[1]);
				 Map<String, String> resultMap = Myutils.sortMapByKey(m); 
				 List<Word> list = new ArrayList<>();
				 for(Map.Entry<String, String> entry : resultMap.entrySet()) {
					 Word w = new Word();
					 w.setWord(entry.getValue());
					 list.add(w);
				 }
				 r.setRight(list);
				 grammer_pro.add(r);
			 }
			 br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

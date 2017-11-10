package compiler.lexical_analysis.constructor;

import java.util.ArrayList;
import java.util.List;

import compiler.lexical_analysis.word.Basic_word;
import compiler.lexical_analysis.word.Delimiter;
import utils.Utils_properties;
import utils.Utils_string;


/**
 * Constructor of Delimiter list
 * 
 * @author Puppert
 *
 */
public class DelimiterConstructor implements Constructor {

	@Override
	public List<Basic_word> construct() {
		String delimiters = Utils_properties.getLexicalProperties().getProperty("delimiter");
		List<String> list = Utils_string.getSimpleRule(delimiters);
		List<Basic_word> dlist = new ArrayList<Basic_word>();
		for(String str:list) {
			Delimiter bw = new Delimiter();
			bw.setWords(str);
			dlist.add(bw);
		}
		return dlist;
	}

	@Override
	public List<Basic_word> add(Basic_word b, List<Basic_word> wordlist) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Basic_word> remove(Basic_word b, List<Basic_word> wordlist) {
		// TODO Auto-generated method stub
		return null;
	}

}

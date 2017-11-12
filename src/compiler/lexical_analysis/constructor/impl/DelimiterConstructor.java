package compiler.lexical_analysis.constructor.impl;

import java.util.ArrayList;
import java.util.List;

import compiler.lexical_analysis.constructor.Constructor;
import compiler.lexical_analysis.word.Basic_word;
import compiler.lexical_analysis.word.Delimiter;
import utils.Utils_properties;
import utils.Myutils;


/**
 * Constructor of Delimiter list
 * 
 * @author Puppert
 *
 */
public class DelimiterConstructor implements Constructor {

	public static List<Basic_word> wordlist = new ArrayList<>();
	
	@Override
	public List<Basic_word> construct() {
		String delimiters = Utils_properties.getLexicalProperties().getProperty("delimiter");
		List<String> list = Myutils.getSimpleRule(delimiters,"|");
		for(String str:list) {
			Basic_word bw = new Delimiter();
			bw.setWords(str);
			bw.setType();
			wordlist.add(bw);
		}
		return wordlist;
	}

	@Override
	public List<Basic_word> add(String word) {
		Basic_word bw = new Delimiter();
		bw.setWords(word);
		bw.setType();
		wordlist.add(bw);
		return wordlist;
	}

	@Override
	public List<Basic_word> remove(String word) {
		Basic_word bw = new Delimiter();
		bw.setWords(word);
		bw.setType();
		if(wordlist.contains(bw)) {
			wordlist.remove(bw);
		}
		return wordlist;
	}
}

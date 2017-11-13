package compiler.lexical_analysis.constructor.impl;

import java.util.ArrayList;
import java.util.List;

import compiler.lexical_analysis.constructor.Constructor;
import compiler.pojo.word.Vt.Vt_word;
import compiler.pojo.word.Vt.type.Delimiter;
import utils.Myutils;
import utils.Utils_properties;


/**
 * Constructor of Delimiter list
 * 
 * @author Puppert
 *
 */
public class DelimiterConstructor implements Constructor {

	public static List<Vt_word> wordlist = new ArrayList<>();
	
	@Override
	public List<Vt_word> construct() {
		String delimiters = Utils_properties.getLexicalProperties().getProperty("delimiter");
		List<String> list = Myutils.getSimpleRule(delimiters,"|");
		for(String str:list) {
			Vt_word bw = new Delimiter();
			bw.setWord(str);
			bw.setType();
			wordlist.add(bw);
		}
		return wordlist;
	}

	@Override
	public List<Vt_word> add(String word) {
		Vt_word bw = new Delimiter();
		bw.setWord(word);
		bw.setType();
		wordlist.add(bw);
		return wordlist;
	}

	@Override
	public List<Vt_word> remove(String word) {
		Vt_word bw = new Delimiter();
		bw.setWord(word);
		bw.setType();
		if(wordlist.contains(bw)) {
			wordlist.remove(bw);
		}
		return wordlist;
	}
}

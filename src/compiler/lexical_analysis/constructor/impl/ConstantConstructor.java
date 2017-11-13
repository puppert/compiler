package compiler.lexical_analysis.constructor.impl;

import java.util.ArrayList;
import java.util.List;

import compiler.lexical_analysis.constructor.Constructor;
import compiler.pojo.word.Vt.Vt_word;
import compiler.pojo.word.Vt.type.Constant;


/**
 * @author Puppert
 *
 */
public class ConstantConstructor implements Constructor {

	public static List<Vt_word> wordlist = new ArrayList<>();
	
	@Override
	public List<Vt_word> construct() {
		return wordlist;
	}

	@Override
	public List<Vt_word> add(String word) {
		Vt_word bw = new Constant();
		bw.setWord(word);
		bw.setType();
		wordlist.add(bw);
		return wordlist;
	}

	@Override
	public List<Vt_word> remove(String word) {
		Vt_word bw = new Constant();
		bw.setWord(word);
		bw.setType();
		if(wordlist.contains(bw)) {
			wordlist.remove(bw);
		}
		return wordlist;
	}
}

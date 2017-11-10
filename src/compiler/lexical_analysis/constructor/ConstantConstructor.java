package compiler.lexical_analysis.constructor;

import java.util.ArrayList;
import java.util.List;

import compiler.lexical_analysis.word.Basic_word;


/**
 * @author Puppert
 *
 */
public class ConstantConstructor implements Constructor {

	@Override
	public List<Basic_word> construct() {
		List<Basic_word> clist = new ArrayList<>();
		return clist;
	}

	@Override
	public List<Basic_word> add(Basic_word b, List<Basic_word> wordlist) {
		wordlist.add(b);
		return wordlist;
	}

	@Override
	public List<Basic_word> remove(Basic_word b, List<Basic_word> wordlist) {
		wordlist.remove(b);
		return wordlist;
	}



}

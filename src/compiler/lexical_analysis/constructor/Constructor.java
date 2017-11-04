package compiler.lexical_analysis.constructor;

import java.util.List;

import compiler.lexical_analysis.word.Basic_word;


/**
 * @author puppert
 *
 */
public interface Constructor {
	/**
	 * @return
	 */
	public List<Basic_word> construct();
	/**
	 * @param b
	 * @return
	 */
	public List<Basic_word> add(Basic_word b,List<Basic_word> wordlist);
	/**
	 * @param b
	 * @return
	 */
	public List<Basic_word> remove(Basic_word b,List<Basic_word> wordlist);
}

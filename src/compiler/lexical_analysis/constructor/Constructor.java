package compiler.lexical_analysis.constructor;

import java.util.List;

import compiler.pojo.word.Vt.Vt_word;


/**
 * @author puppert
 *
 */
public interface Constructor {
	/**
	 * @return
	 */
	public List<Vt_word> construct();
	/**
	 * @param b
	 * @return
	 */
	public List<Vt_word> add(String word);
	/**
	 * @param b
	 * @return
	 */
	public List<Vt_word> remove(String word);
}

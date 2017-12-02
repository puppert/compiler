package compiler.grammatical_analysis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import compiler.grammatical_analysis.constructor.AnalysisTableConstructor;
import compiler.grammatical_analysis.pojo.Rule;
import compiler.pojo.word.Word;
import compiler.pojo.word.Vt.Vt_word;
import utils.Utils_properties;

public class Analysis {
	public List<String> statuss = new ArrayList<>();
	public List<String> symbols = new ArrayList<>();
	public static Map<String,String> table = null;
	
	
	
	
	/**
	 * 依赖LR1表做分析，递归实现
	 * @param allwords
	 * @return 
	 */
	public boolean Analyze(List<Vt_word> allwords) {
		if(statuss.isEmpty()||symbols.isEmpty()) {
			initailize();
		}
		Vt_word endword = new Vt_word();
		endword.setWord("#");
		allwords.add(endword);
		int pointer = 0;
		while(pointer<allwords.size()) {
			Word w = allwords.get(pointer);
			Construct c = null;
			String key = statuss.get(statuss.size()-1)+":"+w.getWord();
			String movement = table.get(key);
			if(movement.matches("S[0-9]+")) {
				c = new SConstruct();
			}else if(movement.matches("r[0-9]+")) {
				c = new rConstruct();
			}else if (movement.matches("acc")) {
				c = new accConstruct();
				return true;
			}
			if(c!=null) {
				pointer = c.construct(pointer, movement, statuss, w.getWord(), symbols);
			}
		}
		return false;
	}
	
	private void initailize() {
		statuss.add("0");
		symbols.add("#");
		table = AnalysisTableConstructor.getTable();
	}
}
interface Construct{
	public int construct(int pointer,String movement,List<String> statuss,String symbol,List<String> symbols);
	public void pushstatus(String movement,List<String> statuss);
	public void pushsymbol(String symbol,List<String> symbols);
}
class SConstruct implements Construct{

	@Override
	public void pushstatus(String movement, List<String> statuss) {
		String status = movement.substring(1);
		statuss.add(status);
	}

	@Override
	public void pushsymbol(String symbol, List<String> symbols) {
		symbols.add(symbol);
	}

	@Override
	public int construct(int pointer, String movement, List<String> statuss, String symbol, List<String> symbols) {
		pushstatus(movement,statuss);
		pushsymbol(symbol, symbols);
		return pointer+1;
	}
	
}
class rConstruct implements Construct{
	List<Rule> rules = Utils_properties.getRules();
	int num = -1;
	
	@Override
	public void pushstatus(String movement, List<String> statuss) {
		String rulenum = movement.substring(1);
		num = Integer.parseInt(rulenum);
		Rule r = rules.get(num);
		int size = statuss.size();
		for(int i = 0;i<r.getRight().size();i++) {
			statuss.remove(size-1-i);
		}
		String nkey = statuss.get(statuss.size()-1)+":"+r.getLeft().getWord();
		String newmove = Analysis.table.get(nkey);
		String newstatus = newmove.substring(1);
		statuss.add(newstatus);
	}

	@Override
	public void pushsymbol(String symbol, List<String> symbols) {
		if(num>-1) {
			Rule r = rules.get(num);
			int size = symbols.size();
			for(int i = 0;i<r.getRight().size();i++) {
				symbols.remove(size-1-i);
			}
			symbols.add(r.getLeft().getWord());
		}
	}

	@Override
	public int construct(int pointer, String movement, List<String> statuss, String symbol, List<String> symbols) {
		pushstatus(movement, statuss);
		pushsymbol(symbol, symbols);
		return pointer;
	}
}
class accConstruct implements Construct{

	@Override
	public void pushstatus(String movement, List<String> statuss) {
		
	}

	@Override
	public void pushsymbol(String symbol, List<String> statuss) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int construct(int pointer, String movement, List<String> statuss, String symbol, List<String> symbols) {
		// TODO Auto-generated method stub
		return pointer+1;
	}
}

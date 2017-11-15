package compiler.grammatical_analysis.constructor;

import compiler.grammatical_analysis.pojo.Rule_pointer;

public class RuleConstructor {
	public Rule_pointer ChangeSign(Rule_pointer r,String sign) {
		Rule_pointer rp = new Rule_pointer();
		rp.setLeft(r.getLeft());
		rp.setSymbol(r.getSymbol());
		rp.setRight(r.getRight());
		int index = 0;
		for(int i = 0;i<r.getRight().size();i++) {
			sign = r.getRight().get(i).getWord();
			index = i;
		}
		String status = r.getRight().get(index+1).getWord();
		rp.setSymbol(status);
		return rp;
	}
}

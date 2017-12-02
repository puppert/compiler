package compiler.grammatical_analysis.constructor;

import java.util.ArrayList;
import java.util.List;

import compiler.grammatical_analysis.pojo.Connect;
import compiler.grammatical_analysis.pojo.Project;
import compiler.grammatical_analysis.pojo.Rule;
import compiler.grammatical_analysis.pojo.Rule_pointer;
import compiler.pojo.word.Word;
import utils.Utils_properties;

public class ProjectConstructor {
	public static List<Project> plist = null;
	public static List<Connect> clist = ConnectConstructor.getClist();
	public static List<Rule> rlist = Utils_properties.getRules();
	
	public static List<Project> getProjects() {
		if(plist == null) {
			initialize();
		}
		return plist;
	}
	private static void initialize() {
		plist = new ArrayList<>();
		Project p = new Project();
		p.setStatus("0");
		List<Rule_pointer> rplist = new ArrayList<>();
		Rule_pointer rp = new Rule_pointer();
		Rule r = rlist.get(0);
		rp.setLeft(r.getLeft());
		rp.setRight(r.getRight());
		rp.setPointer(r.getRight().get(0).getWord());
		rp.setSymbol("#");
		rplist.add(rp);
		p.setRules(rplist);
		p = CompliteProject(p);
		
		plist.add(p);
	}
	
	public static Project CreateNextProject(Connect c) {
		Project p = new Project();
		p.setStatus(c.getFollow());
		List<Rule_pointer> folist = new ArrayList<>();
		for(Project pro:plist) {
			if(pro.getStatus().equals(c.getFront())) {
				Project front = pro;
				List<Rule_pointer> frlist = front.getRules();
				for(Rule_pointer r:frlist) {
					if(r.getPointer().equals(c.getSign())) {
						Rule_pointer newr = RuleConstructor.ChangeSign(r, r.getPointer());
						folist.add(newr);
					}
				}
			}
		}
		p.setRules(folist);
		p = CompliteProject(p);
		return p;
	}
	
	private static Project CompliteProject(Project p) {
		List<Rule_pointer> list = p.getRules();
		List<Rule> rlist = Utils_properties.getRules();
		List<Rule_pointer> newlist = new ArrayList<>();
		boolean change = false;
		
		for(Rule_pointer l:list) {
			String point = l.getPointer();
			for(Rule r:rlist) {
				if(point.equals(r.getLeft().getWord())) {
					List<Word> rl = r.getRight();
					Rule_pointer rp = new Rule_pointer();
					rp.setLeft(r.getLeft());
					rp.setRight(rl);
					rp.setPointer(rl.get(0).getWord());
					int i = l.getRight().indexOf(new Word(point));
					if(i+1<l.getRight().size()) {
						if(!l.getRight().get(i+1).getWord().matches("<[a-zA-Z0-9_]+>")) {
							rp.setSymbol(l.getRight().get(i+1).getWord());
						}
					}else {
							rp.setSymbol(l.getSymbol());
					}
					if(!list.contains(rp)&&!newlist.contains(rp)) {
						newlist.add(rp);
						change = true;
					}
				}
			}
		}
		list.addAll(newlist);
		p.setRules(list);
		if(change) {
			p = CompliteProject(p);
		}
		return p;
	}
}

package compiler.grammatical_analysis.constructor;

import java.util.ArrayList;
import java.util.List;

import compiler.grammatical_analysis.pojo.Connect;
import compiler.grammatical_analysis.pojo.Project;
import compiler.grammatical_analysis.pojo.Rule_pointer;

public class ProjectConstructor {
	public static List<Project> plist = null;
	public static List<Connect> clist = ConnectConstructor.getClist();
	
	public void initialize() {
		plist = new ArrayList<>();
	}
	
	public Project CreateNextProject(Connect c) {
		Project p = new Project();
		p.setStatus(c.getFollow());
		List<Rule_pointer> list = new ArrayList<>();
		for(Project pro:plist) {
			if(pro.getStatus().equals(c.getFront())) {
				Project front = pro;
				List<Rule_pointer> rlist = front.getRules();
				for(Rule_pointer r:rlist) {
					if(r.getPointer().equals(c.getSign())) {
						RuleConstructor rc = new RuleConstructor();
						Rule_pointer newr = rc.ChangeSign(r, r.getPointer());
						list.add(newr);
						
					}
				}
				/*
				 * 补齐整个项目
				 * 
				 * 
				 * */
			}
		}
		return p;
	}
}

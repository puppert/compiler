package compiler.grammatical_analysis.constructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import compiler.grammatical_analysis.pojo.Connect;
import compiler.grammatical_analysis.pojo.Project;
import compiler.grammatical_analysis.pojo.ProjectFamily;
import compiler.grammatical_analysis.pojo.Rule_pointer;

public class ProjectFamilyConstructor {
	private static ProjectFamily pf = null;
	static int renum = 0;
	static int connum = -1;
	static int pronum = -1;
	private static void initialize() {
		if(pf == null) {
			pf = new ProjectFamily();
			pf.setConnects(new ArrayList<>());
			pf.setProjects(new ArrayList<>());
		}
		
		List<Project> pro = ProjectConstructor.getProjects();
		List<Connect> con = ConnectConstructor.getClist();
		if(pronum == pf.getProjects().size()&&pronum != 0) 
			if(connum == pf.getConnects().size()&&connum != 0) {
				return;
		}
		
		connum = pf.getConnects().size();
		pronum = pf.getProjects().size();
		
		List<Project> newps = new ArrayList<>();
		
		for(Project p:pro) {
			List<Rule_pointer> plist = p.getRules();
			Map<String,List<Rule_pointer>> pointers = new HashMap<>();
			for(Rule_pointer rp:plist) {
				if(rp.getPointer().equals("")) continue;
				List<Rule_pointer> rules = null;
				if(!pointers.containsKey(rp.getPointer())) {
					rules = new ArrayList<>();
				}else {
					rules = pointers.get(rp.getPointer());
				}
				rules.add(rp);
				pointers.put(rp.getPointer(), rules);
			}
			int max = pro.size();
			for(String pt:pointers.keySet()) {
				List<Rule_pointer> oldpos = pointers.get(pt);
				List<Rule_pointer> newpos = new ArrayList<>();
				for(Rule_pointer o:oldpos) {
					Rule_pointer newp =RuleConstructor.ChangeSign(o, pt);
					newpos.add(newp);
				}
				boolean hassign = false;
				for(Project hasp:pro) {
					if(hasp.getRules().containsAll(newpos)) 
						if(!hasp.getStatus().equals(p.getStatus())){
						ConnectConstructor.CreateConnect(p.getStatus(), hasp.getStatus(), pt);
						hassign = true;
						break;
					}
				}
				if(!hassign) {
					ConnectConstructor.CreateConnect(p.getStatus(), String.valueOf(max), pt);
					max++;
				}
			}
			for(Connect c:con){
				if(c.getFront().equals(p.getStatus())) {
					boolean contains = false;
					for(Project pj:pro) {
						if(pj.getStatus().equals(c.getFollow())){
							contains = true;
						}
					}
					if(!contains) {
						Project newp =ProjectConstructor.CreateNextProject(c);
						newps.add(newp);
					}
				}
			}
		}
		pro.addAll(newps);
		pf.setConnects(con);
		pf.setProjects(pro);
		renum++;
		initialize();
	}
	
	public static ProjectFamily getProjectFamily() {
		if(pf==null) {
			initialize();
		}
		return pf;
	}
	
}

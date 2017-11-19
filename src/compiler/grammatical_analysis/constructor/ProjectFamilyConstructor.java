package compiler.grammatical_analysis.constructor;

import java.util.ArrayList;
import java.util.List;

import compiler.grammatical_analysis.pojo.Connect;
import compiler.grammatical_analysis.pojo.Project;
import compiler.grammatical_analysis.pojo.ProjectFamily;
import compiler.grammatical_analysis.pojo.Rule_pointer;

public class ProjectFamilyConstructor {
	private static ProjectFamily pf = null;
	
	private static void initialize() {
		if(pf.equals(null)) {
			pf = new ProjectFamily();
		}
		List<Project> pro = ProjectConstructor.getProjects();
		List<Connect> con = ConnectConstructor.getClist();
		
		for(Project p:pro) {
			List<Rule_pointer> plist = p.getRules();
			List<String> pointers = new ArrayList<>();
			for(Rule_pointer rp:plist) {
				pointers.add(rp.getPointer());
			}
			for(String pt:pointers) {
				ConnectConstructor.CreateConnect(p.getStatus(), String.valueOf(pro.size()), pt);
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
						ProjectConstructor.CreateNextProject(c);
					}
				}
			}
		}
	}
	
	public static ProjectFamily getProjectFamily() {
		if(pf.equals(null)) {
			initialize();
		}
		return pf;
	}
	
}

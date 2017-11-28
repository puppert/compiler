package compiler.grammatical_analysis.constructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import compiler.grammatical_analysis.pojo.Connect;
import compiler.grammatical_analysis.pojo.Project;
import compiler.grammatical_analysis.pojo.ProjectFamily;
import compiler.grammatical_analysis.pojo.Rule;
import compiler.grammatical_analysis.pojo.Rule_pointer;
import utils.Utils_properties;

 
/**
 * @author Puppert
 *
 */
public class AnalysisTableConstructor {
	static private Map<String[],String> Table = new HashMap<String[],String>();//第一个是横轴，第二个是纵轴
	static ProjectFamily pf = ProjectFamilyConstructor.getProjectFamily();
	static List<Rule> rules = Utils_properties.getRules();
	
	public static Map<String[],String> getTable() {
		if(Table.isEmpty()) {
			setTable();
		}
		return Table;
	}
	
	private static void setTable() {
		List<Connect> cons = pf.getConnects();
		List<Project> pros = pf.getProjects();
		for(int i = 0;i<pros.size();i++) {
			Project p = pros.get(i);
			List<Rule_pointer> rps = p.getRules();
			for(Rule_pointer rp:rps) {
				if(rp.getLeft().getWord().equals("<S'>")) {
					if(rp.getPointer().equals("")){
						String[] s = new String[] {p.getStatus(),"#"};
						Table.put(s, "acc");
					}
				}
				else if(rp.getPointer().equals("")) {
					/**
					 * 
					 */
					for(int j=0;j<rules.size();j++) {
						Rule r = rules.get(j);
						if(r.getLeft().getWord().equals(rp.getLeft().getWord())) {
							if(r.getRight().equals(rp.getRight())) {
								String[] s = new String[] {p.getStatus(),r.getLeft().getWord()};
								Table.put(s, "r"+j);
							}
						}
					}
				}else {
					for(Connect c:cons) {
						if(c.getFront().equals(p.getStatus())) {
							if(c.getSign().equals(rp.getPointer())) {
								String[] s = new String[] {p.getStatus(),c.getSign()};
								Table.put(s, "S"+c.getFollow());
							}
						}
					}
				}
			}
 		}
	}
	
}

package test;

import java.util.Map;

import compiler.grammatical_analysis.constructor.AnalysisTableConstructor;

public class Test {

	public static void main(String[] args) {
//		ProjectFamily pf = ProjectFamilyConstructor.getProjectFamily();
//		for(Connect c:pf.getConnects()) {
//			System.out.println(c);
//		}
//		for(Project p:pf.getProjects()) {
//			System.out.println(p);
//		}
		 Map<String[],String> m = AnalysisTableConstructor.getTable();
		 for(Map.Entry<String[], String> entry:m.entrySet()) {
			 System.out.println("["+entry.getKey()[0]+","+entry.getKey()[1]+"]"+"...."+entry.getValue());
		 }
	}
}

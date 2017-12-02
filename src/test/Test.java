package test;

import java.util.List;

import compiler.lexical_analysis.Analysis;
import compiler.pojo.word.Vt.Vt_word;

public class Test {

	public static void main(String[] args) {
//		ProjectFamily pf = ProjectFamilyConstructor.getProjectFamily();
//		for(Connect c:pf.getConnects()) {
//			System.out.println(c);
//		}
//		for(Project p:pf.getProjects()) {
//			System.out.println(p);
//		}
		
//		 Map<String[],String> m = AnalysisTableConstructor.getTable();
//		 for(Map.Entry<String[], String> entry:m.entrySet()) {
//			 System.out.println("["+entry.getKey()[0]+","+entry.getKey()[1]+"]"+"...."+entry.getValue());
//		 }
		String s = "a+B";
		compiler.lexical_analysis.Analysis la = new Analysis();
		List<Vt_word> allwords = la.Analyze(s);
		compiler.grammatical_analysis.Analysis ga = new compiler.grammatical_analysis.Analysis();
		boolean b = ga.Analyze(allwords);
		System.out.println(b);
	}
}

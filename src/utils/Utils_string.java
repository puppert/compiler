package utils;

import java.util.ArrayList;
import java.util.List;

public class Utils_string {
	public static List<String> getSimpleRule(String rules){
		String[] rule = rules.split("|");
		List<String> rlist = new ArrayList<String>();
		for(int i = 0;i<rule.length;i++) {
			rlist.add(rule[i]);
		}
		return rlist;
	}
}

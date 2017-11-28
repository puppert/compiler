package compiler.grammatical_analysis.constructor;

import java.util.ArrayList;
import java.util.List;

import compiler.grammatical_analysis.pojo.Connect;

public class ConnectConstructor {
	private static List<Connect> clist = null;
	
	public static void initialize() {
		clist = new ArrayList<>();
	}
	public static Connect CreateConnect(String front,String follow,String sign) {
		if(clist.equals(null)) {
			initialize();
		}
		Connect c = new Connect();
		c.setFollow(follow);
		c.setFront(front);
		c.setSign(sign);
		if(!clist.contains(c)) {
			clist.add(c);
		}
		return c;
	}
	
	public static List<Connect> getClist(){
		if(clist == null) {
			initialize();
		}
		return clist;
	}
}

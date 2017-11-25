package utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import compiler.pojo.word.Word;
import compiler.pojo.word.Vn.Vn_word;

public class Myutils {
	public static List<String> getSimpleRule(String rules,String regex){
		String[] rule = rules.split(regex);
		List<String> rlist = new ArrayList<String>();
		for(int i = 0;i<rule.length;i++) {
			rlist.add(rule[i]);
		}
		return rlist;
	}
	
	/**
     * 使用 Map按key进行排序
     * @param map
     * @return
     */
    public static Map<String, String> sortMapByKey(Map<? extends String, ? extends String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }

        Map<String, String> sortMap = new TreeMap<String, String>(
                new MapKeyComparator());

        sortMap.putAll(map);

        return sortMap;
    }
    
    public static Map<String,String> spilitRule(String rule){
    	Map<String,String> m = new TreeMap<>();
    	String VnRegex = "<[a-zA-Z0-9_]+>";
    	Pattern VnP = Pattern.compile(VnRegex);
    	Matcher VnM = VnP.matcher(rule);
    	int start = 0;
    	int end = 0;
    	while(VnM.find()){
    		start = VnM.start();
    		if(start!=end) {
    			String Vts = rule.substring(end, start);
    			int vstart = 0;
    	    	int vend = 0;
    			String VtRegex = "[a-zA-Z0-9_]+";
    	    	Pattern VtP = Pattern.compile(VtRegex);
    	    	Matcher VtM = VtP.matcher(Vts);
    	    	while(VtM.find()) {
    	    		vstart = VtM.start();
    	    		if(vstart!=vend) {
    	    			String symbol = Vts.substring(vend, vstart);
    	    			m.put(String.valueOf(vend), symbol);
    	    		}
    	    		m.put(String.valueOf(vstart), VtM.group());
    	    		vend = VtM.end();
    	    	}
    	    	if(vend<Vts.length()) {
    	    		String last = Vts.substring(vend);
    	    		m.put(String.valueOf(vend), last);
    	    	}
    		}
    		m.put(String.valueOf(start), VnM.group());
    		end = VnM.end();
    	}
    	if(end<rule.length()) {
    		String last = rule.substring(end);
    		m.put(String.valueOf(end), last);
    	}
    	return m;
    }
}

class MapKeyComparator implements Comparator<String>{

    @Override
    public int compare(String str1, String str2) {
        int id1 = Integer.parseInt(str1);
        int id2 = Integer.parseInt(str2);
        return id1-id2;
    }
}
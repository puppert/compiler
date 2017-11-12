package utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
}

class MapKeyComparator implements Comparator<String>{

    @Override
    public int compare(String str1, String str2) {
        int id1 = Integer.parseInt(str1);
        int id2 = Integer.parseInt(str2);
        return id1-id2;
    }
}
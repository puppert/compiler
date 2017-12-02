package compiler.lexical_analysis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import compiler.lexical_analysis.constructor.Constructor;
import compiler.lexical_analysis.constructor.impl.ConstantConstructor;
import compiler.lexical_analysis.constructor.impl.DelimiterConstructor;
import compiler.lexical_analysis.constructor.impl.IdentifierConstructor;
import compiler.lexical_analysis.constructor.impl.OperationalConstructor;
import compiler.lexical_analysis.constructor.impl.ReservedConstructor;
import compiler.pojo.word.Vt.Vt_word;
import compiler.pojo.word.Vt.type.Constant;
import compiler.pojo.word.Vt.type.Delimiter;
import compiler.pojo.word.Vt.type.Identifier;
import compiler.pojo.word.Vt.type.Operational;
import compiler.pojo.word.Vt.type.Reserved;
import utils.Myutils;

public class Analysis {
	/**
	 * all Word of paragraph
	 */
	public static List<Vt_word> allWord;
	
	/**
	 * 
	 */
	public static List<Vt_word> constants;
	public static List<Vt_word> delimiters;
	public static List<Vt_word> identifiers;
	public static List<Vt_word> operationals;
	public static List<Vt_word> reserveds;
	
	
	/**
	 * initialize all list
	 * 
	 */
	public static void initialize() {
		ConstantConstructor cc = new ConstantConstructor();
		DelimiterConstructor dc = new DelimiterConstructor();
		IdentifierConstructor ic = new IdentifierConstructor();
		OperationalConstructor oc = new OperationalConstructor();
		ReservedConstructor rc = new ReservedConstructor();
		constants = cc.construct();
		delimiters = dc.construct();
		identifiers = ic.construct();
		operationals = oc.construct();
		reserveds = rc.construct();
		
		allWord = new ArrayList<>();
	}
	
	public Map<String,String> getAllContants(String sentence){
		Map<String,String> map = new TreeMap<>();
		String cregex = "([0-9]+\\.?[0-9]*)|(\".+\")|(\'.?\')";
		Pattern cpattern = Pattern.compile(cregex);
		Matcher cmatcher = cpattern.matcher(sentence);
		int start = 0;
		int end = 0;
		while(cmatcher.find()) {
			String str1 = cmatcher.group();
			start = cmatcher.start();
			map.put(String.valueOf(start), str1);
			if(start != end) {
				String str2 = sentence.substring(end, start);
				Map<Integer,String> ncmap = getAllWord(str2,end);
				for(Integer i:ncmap.keySet()) {
					map.put(String.valueOf(i), ncmap.get(i));
				}
			}
			end = cmatcher.end();
		}
		if(end<sentence.length()) {
			String str3 = sentence.substring(end);
			Map<Integer,String> ncmap = getAllWord(str3,end);
			for(Integer i:ncmap.keySet()) {
				map.put(String.valueOf(i), ncmap.get(i));
			}
		}
		return map;
	}
	public Map<Integer,String> getAllWord(String sentence,int startpoint) {
		Map<Integer,String> map = new TreeMap<>();
		String regex = "\\b[a-zA-Z_]+[a-zA-Z0-9_]*\\b";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(sentence);
		int start = 0;
		int end = 0;
		while(matcher.find()) {
			String str1 = matcher.group();
			start = matcher.start();
			map.put(start+startpoint, str1);
			if(start != end) {
				String str2 = sentence.substring(end, start);
				for(Vt_word b:delimiters) {
					while(str2.contains(b.getWord())) {
						map.put(str2.indexOf(b.getWord())+startpoint+end, b.getWord());
						str2 = str2.replace(b.getWord(), " ");
					}
				}
				String regex2 = "[^\\s]+";
				Pattern pattern2 = Pattern.compile(regex2);
				Matcher matcher2 = pattern2.matcher(str2);
				while(matcher2.find()) {
					map.put(matcher2.start()+end+startpoint, matcher2.group());
				}
			}
			end = matcher.end();
		}
		if(end<sentence.length()) {
			String str3 = sentence.substring(end);
			for(Vt_word b:delimiters) {
				while(str3.contains(b.getWord())) {
					map.put(str3.indexOf(b.getWord())+startpoint+end, b.getWord());
					str3 = str3.replace(b.getWord(), " ");
				}
			}
			String regex2 = "[^\\s]+";
			Pattern pattern2 = Pattern.compile(regex2);
			Matcher matcher2 = pattern2.matcher(str3);
			while(matcher2.find()) {
				map.put(matcher2.start()+end+startpoint, matcher2.group());
			}
		}
		return map;
	}
	
	
	public List<Vt_word> Analyze(String paragragh) {
		initialize();
		Map<? extends String, ? extends String> map = getAllContants(paragragh);
		 Map<String, String> resultMap = Myutils.sortMapByKey(map); 
		for(Map.Entry<String, String> entry : resultMap.entrySet()) {
			String str = entry.getValue();
			String regex = "\\b[a-zA-Z_]+[a-zA-Z0-9_]*\\b";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(str);
			Constructor c = null;
			Vt_word bw = new Vt_word();
			bw.setWord(str);
			if(matcher.matches()) {
				if(reserveds.contains(bw)) {	//check if reserved
					bw = new Reserved();
					c = new ReservedConstructor();
				}else {				//it is Identifier
					bw = new Identifier();
					c = new IdentifierConstructor();
				}
			}else {
				String cregex = "([0-9]+\\.?[0-9]*)|(\".+\")|(\'.?\')";
				Pattern cpattern = Pattern.compile(cregex);
				Matcher cmatcher = cpattern.matcher(str);	//	check if constant
				if(cmatcher.matches()) {
					bw = new Constant();
					c = new ConstantConstructor();
				}else if(operationals.contains(bw)) {
					bw = new Operational();
					c = new OperationalConstructor();
				}else if(delimiters.contains(bw)) {
					bw = new Delimiter();
					c = new DelimiterConstructor();
				}
			}
			bw.setWord(str);
			bw.setType();
			allWord.add(bw);
			if(c!=null) {
				c.add(str);
			}
		}
		return allWord;
	}
}

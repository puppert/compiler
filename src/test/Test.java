package test;

import java.util.List;

import compiler.lexical_analysis.Analysis;
import compiler.lexical_analysis.word.Basic_word;

public class Test {

	public static void main(String[] args) {
		Analysis a = new Analysis();
		String s  = "int main()\r\n" + 
				"{\r\n" + 
				"    printf(\"Hello, World! \\n\");\r\n" + 
				" \r\n" + 
				"    return 1+2;\r\n" + 
				"}";
		List<Basic_word> r = a.main(s);
		for(int i = 0;i<r.size();i++) {
			System.out.println(r.get(i));
		}
	}

}

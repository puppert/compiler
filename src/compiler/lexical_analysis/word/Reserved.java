package compiler.lexical_analysis.word;

public class Reserved extends Basic_word{
	@Override
	public void setType() {
		this.type = 5;
	}
}

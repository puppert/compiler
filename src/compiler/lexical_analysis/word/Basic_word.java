package compiler.lexical_analysis.word;

public class Basic_word {
	private String words;
	protected int type;
	public Basic_word() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Basic_word(String words) {
		super();
		this.words = words;
		this.type = 0;
	}
	public String getWords() {
		return words;
	}
	public void setWords(String words) {
		this.words = words;
	}
	public int getType() {
		return type;
	}
	public void setType() {
		this.type = 0;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((words == null) ? 0 : words.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Basic_word other = (Basic_word) obj;
		if (words == null) {
			if (other.words != null) {
				return false;
			}
		} else if (words.equals(other.words)) {
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return "Basic_word [words=" + words + ", type=" + type + "]";
	}
	
	
}

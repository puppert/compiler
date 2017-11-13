package compiler.pojo.word.Vt;

import compiler.pojo.word.Word;

public class Vt_word extends Word{
	protected int type;
	public Vt_word() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Vt_word(String words) {
		super();
		this.type = 0;
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
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Vt_word other = (Vt_word) obj;
		if (word == null) {
			if (other.word != null) {
				return false;
			}
		} else if (word.equals(other.word)) {
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return "Basic_word [words=" + word + ", type=" + type + "]";
	}
	
	
}

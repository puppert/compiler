package compiler.grammatical_analysis.pojo;

import java.util.List;

import compiler.pojo.word.Word;
import compiler.pojo.word.Vn.Vn_word;

public class Rule_pointer extends Rule {
	private String pointer;
	private String symbol;
	public Rule_pointer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rule_pointer(Vn_word left, List<Word> right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}
	public Rule_pointer(String pointer, String symbol) {
		super();
		this.pointer = pointer;
		this.symbol = symbol;
	}
	public String getPointer() {
		return pointer;
	}
	public void setPointer(String pointer) {
		this.pointer = pointer;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((pointer == null) ? 0 : pointer.hashCode());
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rule_pointer other = (Rule_pointer) obj;
		if (pointer == null) {
			if (other.pointer != null)
				return false;
		} else if (!pointer.equals(other.pointer))
			return false;
		if (symbol == null) {
			if (other.symbol != null)
				return false;
		} else if (!symbol.equals(other.symbol))
			return false;
		return true;
	}
	
}

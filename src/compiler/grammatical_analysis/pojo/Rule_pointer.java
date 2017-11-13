package compiler.grammatical_analysis.pojo;

import java.util.List;

import compiler.pojo.word.Word;
import compiler.pojo.word.Vn.Vn_word;

public class Rule_pointer extends Rule {
	protected int pointer;

	public Rule_pointer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rule_pointer(Vn_word left, List<Word> right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}

	public Rule_pointer(int pointer) {
		super();
		this.pointer = pointer;
	}

	public int getPointer() {
		return pointer;
	}

	public void setPointer(int pointer) {
		this.pointer = pointer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + pointer;
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
		if (pointer != other.pointer)
			return false;
		return true;
	}
}

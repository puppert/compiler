package compiler.grammatical_analysis.pojo;

import java.util.List;

import compiler.pojo.word.Word;
import compiler.pojo.word.Vn.Vn_word;

public class Rule {
	protected Vn_word left;
	protected List<Word> right;
	public Rule() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rule(Vn_word left, List<Word> right) {
		super();
		this.left = left;
		this.right = right;
	}
	public Vn_word getLeft() {
		return left;
	}
	public void setLeft(Vn_word left) {
		this.left = left;
	}
	public List<Word> getRight() {
		return right;
	}
	public void setRight(List<Word> right) {
		this.right = right;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + ((right == null) ? 0 : right.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rule other = (Rule) obj;
		if (left == null) {
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		if (right == null) {
			if (other.right != null)
				return false;
		} else if (!right.equals(other.right))
			return false;
		return true;
	}
	
	
}

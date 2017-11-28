package compiler.grammatical_analysis.pojo;

import java.util.List;

public class Project {
	private String status;
	private List<Rule_pointer> rules;
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Project(String status, List<Rule_pointer> rules) {
		super();
		this.status = status;
		this.rules = rules;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Rule_pointer> getRules() {
		return rules;
	}
	public void setRules(List<Rule_pointer> rules) {
		this.rules = rules;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rules == null) ? 0 : rules.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Project other = (Project) obj;
		if (rules == null) {
			if (other.rules != null)
				return false;
		} else if (!rules.equals(other.rules))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Project [status=" + status + ", rules=" + rules + "]";
	}
	
}

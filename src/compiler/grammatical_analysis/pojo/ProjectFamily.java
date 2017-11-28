package compiler.grammatical_analysis.pojo;

import java.util.List;

public class ProjectFamily {
	private List<Project> projects;
	private List<Connect> connects;
	public ProjectFamily() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProjectFamily(List<Project> projects, List<Connect> connects) {
		super();
		this.projects = projects;
		this.connects = connects;
	}
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	public List<Connect> getConnects() {
		return connects;
	}
	public void setConnects(List<Connect> connects) {
		this.connects = connects;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((connects == null) ? 0 : connects.hashCode());
		result = prime * result + ((projects == null) ? 0 : projects.hashCode());
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
		ProjectFamily other = (ProjectFamily) obj;
		if (connects == null) {
			if (other.connects != null)
				return false;
		} else if (!connects.equals(other.connects))
			return false;
		if (projects == null) {
			if (other.projects != null)
				return false;
		} else if (!projects.equals(other.projects))
			return false;
		return true;
	}
	
	
}

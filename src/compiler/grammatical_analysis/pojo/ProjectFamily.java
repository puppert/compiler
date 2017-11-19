package compiler.grammatical_analysis.pojo;

public class ProjectFamily {
	Project p = new Project();
	Connect c = new Connect();
	public ProjectFamily() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProjectFamily(Project p, Connect c) {
		super();
		this.p = p;
		this.c = c;
	}
	public Project getP() {
		return p;
	}
	public void setP(Project p) {
		this.p = p;
	}
	public Connect getC() {
		return c;
	}
	public void setC(Connect c) {
		this.c = c;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((c == null) ? 0 : c.hashCode());
		result = prime * result + ((p == null) ? 0 : p.hashCode());
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
		if (c == null) {
			if (other.c != null)
				return false;
		} else if (!c.equals(other.c))
			return false;
		if (p == null) {
			if (other.p != null)
				return false;
		} else if (!p.equals(other.p))
			return false;
		return true;
	}
}

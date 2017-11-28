package compiler.grammatical_analysis.pojo;

public class Connect {
	private String front;
	private String follow;
	private String sign;
	public Connect() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Connect(String front, String follow, String sign) {
		super();
		this.front = front;
		this.follow = follow;
		this.sign = sign;
	}
	public String getFront() {
		return front;
	}
	public void setFront(String front) {
		this.front = front;
	}
	public String getFollow() {
		return follow;
	}
	public void setFollow(String follow) {
		this.follow = follow;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((follow == null) ? 0 : follow.hashCode());
		result = prime * result + ((front == null) ? 0 : front.hashCode());
		result = prime * result + ((sign == null) ? 0 : sign.hashCode());
		return result;
	}
	@Override
	//只比较前置和关键词
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Connect other = (Connect) obj;
		if (follow == null) {
			if (other.follow != null)
				return false;
		} 
		if (front == null) {
			if (other.front != null)
				return false;
		} else if (!front.equals(other.front))
			return false;
		if (sign == null) {
			if (other.sign != null)
				return false;
		} else if (!sign.equals(other.sign))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Connect [front=" + front + ", follow=" + follow + ", sign=" + sign + "]";
	}
	
	
}

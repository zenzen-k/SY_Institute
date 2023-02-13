
public class JoinBean {
	String code;
	String pname;
	String cname;
	int cprice;
	String caddr;
	
	public JoinBean() {
		super();
	}
	
	public JoinBean(String code, String pname, String cname, int cprice, String caddr) {
		super();
		this.code = code;
		this.pname = pname;
		this.cname = cname;
		this.cprice = cprice;
		this.caddr = caddr;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCprice() {
		return cprice;
	}
	public void setCprice(int cprice) {
		this.cprice = cprice;
	}
	public String getCaddr() {
		return caddr;
	}
	public void setCaddr(String caddr) {
		this.caddr = caddr;
	}
	
}

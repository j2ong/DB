package Customer;

public class Customer_DTO { 	//customer 테이블의 정보를 담는 클래스 
	private int Cunum;   //PK
	private String Cname;
	private String Acnum;
	
	public int getCunum() {
		return Cunum;
	}
	public void setCunum(int Cunum) {
		this.Cunum = Cunum;
	}
	public String getCname() {
		return Cname;
	}
	public void setCname(String Cname) {
		this.Cname = Cname;
	}
	public String getAcnum() {
		return Acnum;
	}
	public void setAcnum(String Acnum) {
		this.Acnum = Acnum;
	}




}
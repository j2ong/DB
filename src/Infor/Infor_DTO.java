package Infor;

public class Infor_DTO { 		//infor 테이블의 정보를 담는 클래스 
	private String Cname;		//pk
	private String Phone;
	private String Address;

	public String getCname() {
		return Cname;
	}
	public void setCname(String Cname) {
		this.Cname = Cname;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String Phone) {
		this.Phone = Phone;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String Address) {
		this.Address = Address;
	}


}


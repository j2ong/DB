package Loan;

public class Loan_DTO { 	//loan���̺��� ������ ��� Ŭ���� 
	private int Lnum;		//pk	
	private int Lamount;
	private String Ltype;
	private String Acnum;
	
	
	public int getLnum() {
		return Lnum;
	}
	public void setLnum(int Lnum) {
		this.Lnum = Lnum;
	}
	public int getLamount() {
		return Lamount;
	}
	public void setLamount(int Lamount) {
		this.Lamount = Lamount;
	}
	public String getLtype() {
		return Ltype;
	}
	public void setLtype(String ltype) {
		this.Ltype = ltype;
	}
	public String getAcnum() {
		return Acnum;
	}
	public void setAcnum(String acnum) {
		this.Acnum = acnum;
	}
	
	


}


package Save;

public class Save_DTO { 	//save ���̺��� ������ ��� Ŭ���� 
	private int Snum;		//pk
	private int Samount;
	private String Stype;
	private String Acnum;
	
	public int getSnum() {
		return Snum;
	}
	public void setSnum( int Snum) {
		this.Snum = Snum;
	}
	public int getSamount() {
		return Samount;
	}
	public void setSamount(int Samount) {
		this.Samount = Samount;
	}
	public String getStype() {
		return Stype;
	}
	public void setStype(String stype) {
		this.Stype = stype;
	}
	public String getAcnum() {
		return Acnum;
	}
	public void setAcnum(String acnum) {
		this.Acnum = acnum;
	}

	


}


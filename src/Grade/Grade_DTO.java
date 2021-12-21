package Grade;

public class Grade_DTO { //grdae 테이블의 정보를 담는 클래스 
	private int Cunum;   //PK
	private String Acnum;
	private String Grade;
	
	public int getCunum() {
		return Cunum;
	}
	public void setCunum(int cunum) {
		this.Cunum = cunum;
	}
	public String getAcnum() {
		return Acnum;
	}
	public void setAcnum(String Acnum) {
		this.Acnum = Acnum;
	}
	public String getGrade() {
		return Grade;
	}
	public void setGrade(String grade) {
		this.Grade = grade;
	}
	





}
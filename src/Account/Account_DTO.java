package Account;

public class Account_DTO { 	  //Account 테이블의 정보를 저장하는 클래스	
	private String Account;   //PK
	   private int Balance;
	   
   public String getAccount() {
		return Account;
	}
	public void setAccount(String Account) {
		this.Account = Account;
	}
	public int getBalance() {
		return Balance;
	}
	public void setBalance(int balance) {
		this.Balance = balance;
	}
   
   
   
}
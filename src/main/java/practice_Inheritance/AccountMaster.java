package practice_Inheritance;


public class AccountMaster {
	//필드					
	//계좌번호 ( 은행코드-난수2자리 - 난수자리 ) 은행코드- + 난수2-난수2 추상메소드 선언 또는 해당객체 은행코드 + 부모 클래스의 메소드(난수2 -난수2) 
	private String accountNumber = ""; 
	//계좌비밀번호[4자리]
	private int accountPassword = 0;
	//계좌주
	private String accountOwner = "";
	//잔금[초기0원]
	private int accountMoney = 0;
	
	public AccountMaster() {}
	public AccountMaster(String accountNumber , int accountPassword , String accountOwner , int accountMoney) {
		this.accountNumber = accountNumber;
		this.accountPassword = accountPassword;
		this.accountOwner = accountOwner;
		this.accountMoney = accountMoney;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getAccountPassword() {
		return accountPassword;
	}
	public void setAccountPassword(int accountPassword) {
		this.accountPassword = accountPassword;
	}
	public String getAccountOwner() {
		return accountOwner;
	}
	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}
	public int getAccountMoney() {
		return accountMoney;
	}
	public void setAccountMoney(int accountMoney) {
		this.accountMoney = accountMoney;
	}

	//계좌생성메소드 오버라이딩 필요			
	public void creatAccount(AccountMaster bank){	
				if(bank instanceof Kukmin) {
					Kukmin kukmin = (Kukmin) bank;
					kukmin.creatAccount(kukmin);
				}else if (bank instanceof SinHan) {
					SinHan sinhan = (SinHan) bank;
					sinhan.creatAccount(sinhan);
				}else if (bank instanceof Woori) {
					Woori woori = (Woori) bank;
					woori.creatAccount(woori);
				}								
	}																			
}	
		

	
	
	
	
	
			


package practice_Inheritance;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AccountController {
	//싱글톤객체
	private static AccountController accountController = new AccountController();
	private AccountController() {}
	public static AccountController getInstance() {
		return accountController;
	}
	//Db
	Scanner scanner = new Scanner(System.in);
	private ArrayList<AccountMaster> amDb = new ArrayList<>();
	
	//Db반환 메소드
	public ArrayList<AccountMaster> accountInfo() {
		return amDb;		
	}
	// 계좌 생성 메소드
	public boolean createAccount(String accountNumber , int accountPassword , String accountOwner , int accountMoney ) {
		AccountMaster account = new AccountMaster(accountNumber , accountPassword , accountOwner , accountMoney);
		amDb.add(account);
		return true;
	}
	// 계좌 리스트 메소드
	public void print() {		
		ArrayList<AccountMaster> account = accountInfo();
		// 계좌번호를 " - " 구분자로 나눠서 대조
		for(int i = 0; i < account.size(); i ++) {
			StringTokenizer st = new StringTokenizer(account.get(i).getAccountNumber() , "-");
			String bankCode = st.nextToken();
			String bankName = "";
			if(bankCode.equals("03")) 
				bankName = "신한";
			else if(bankCode.equals("04"))
				bankName = "국민";
			else if(bankCode.equals("05"))
				bankName = "우리";
			
			System.out.println(bankName + "  " + account.get(i).getAccountNumber() + "  " 
																+ account.get(i).getAccountMoney()+"원");
		}		
	}
	public void inputMoney() {
		String accountNumber = scanner.next();
		int Money = scanner.nextInt();
		ArrayList<AccountMaster> account = accountInfo();
		//계좌 리스트를 훑어 맞는 계좌번호를 찾으면 입력값을 더한다.
		for(int i = 0; i < account.size(); i++) {
			if(accountNumber.equals(account.get(i).getAccountNumber()))
				account.get(i).setAccountMoney(account.get(i).getAccountMoney() + Money);
		}				
	}	
}






package practice_Inheritance;
import java.util.Scanner;

//accountMaster 상속
public class SinHan extends AccountMaster{
	Scanner scanner = new Scanner(System.in);
	final public static String bankCode = "03";
	
	@Override
	public void creatAccount(AccountMaster bank) {
		int accountMoney = 0;
		
		System.out.println("[계좌주 이름을 입력해주세요.]");
		String name = scanner.next();				
		if(name == "") {
			System.out.println("[공백입력 불가능.]");
			return;
		}
		
		System.out.println("[계좌 비밀번호를 입력해주세요(4자리 제한)]");
		int password = scanner.nextInt();
		if( 9999 >= password && password  >= 0) {}
		else {
			System.out.println("[4자리 제한]");
			return;
		}
		String accountNumber = SinHan.bankCode + "-" + 
								((int)(Math.random() * 9) +""+ (int)(Math.random() * 9)) + "-" + 
								((int)(Math.random() * 9) +""+(int)(Math.random() * 9));
		AccountController.getInstance().createAccount(accountNumber, password, name, accountMoney);
		System.out.println("신한은행 계좌를 만들어주셔서 감사합니다.");
	}
}

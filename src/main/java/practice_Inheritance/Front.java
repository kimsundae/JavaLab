package practice_Inheritance;
import java.util.Scanner;

public class Front {
	//싱글톤 객체
	private static Front front = new Front();
	private Front() {}
	public static Front getInstance() {
		return front;
	}
	AccountMaster am = new AccountMaster();
	private static Scanner scanner = new Scanner(System.in);
	
	public void index() {		
		while(true) {
			printList();
			
			System.out.println();			
			System.out.println("메뉴 > 1.계좌생성 2.예금");
			int num = scanner.nextInt();
			if(num == 1)
				selectAccount();
			else if(num == 2)
				inputMyMoney();	
		}				
	}
	
	// 계좌 생성 메소드
	public void selectAccount() {
		System.out.println("----------계좌 생성---------");
		System.out.println("0.신한은행 1.국민은행 2.우리은행");
		int num = scanner.nextInt();
		if(num == 0) 
			am.creatAccount(new SinHan());
		else if(num == 1)
			am.creatAccount(new Kukmin());
		else if(num == 2) 
			am.creatAccount(new Woori());
		else 
			System.out.println("옳지않은 번호입니다.");			
	}
	//계좌 리스트 출력 메소드
	public void printList() {
		System.out.println("------계좌 관리--------");
		System.out.println("은행명 계좌번호 예금액");
		
		AccountController.getInstance().print();
	}
	// 예금 메소드
	public void inputMyMoney() {
		System.out.println("-------계좌 입금------");
		System.out.println("입금할 계좌번호 : ");
		System.out.println("예금액 : ");
		
		AccountController.getInstance().inputMoney();
	}
	
}

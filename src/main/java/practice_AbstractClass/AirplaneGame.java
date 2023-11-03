package practice_AbstractClass;
import java.util.Scanner;

public class AirplaneGame extends JoiStick {
	
	int bomb = 0;
	//생성자
	public AirplaneGame(){
		this.game = "비행기게임";
		this.bomb = 10;
	}
	Scanner scanner = new Scanner(System.in);
	
	

	public void index() {
		AirplaneGame airplane = new AirplaneGame();
		System.out.println("[ Q 입력 시 게임 강제종료. ]");
		System.out.println("[ "+ game + " 시작]");
		
		while(true) {
			System.out.println("[적 출현.]");
			System.out.println("[공격!]");
			System.out.println("[ A. 일반공격 B. 폭탄발사 C. 특수공격 ]");
			String inputButton = scanner.next();
			if(inputButton.equals("A")) 
				A();
			else if(inputButton.equals("B")) 
				B();
			else if(inputButton.equals("C")) 
				C();
			else if(inputButton.equals("Q")) {
				System.out.println("게임 종료");
				return;
			}
				
		}
	}
	
	public void A() {
		System.out.println("[일반 공격.]");
	}
	public void B() {
		if(this.bomb == 0) {
			System.out.println("[폭탄 부족.]");
			return;
		}
		System.out.println("[폭탄 발사.]");
		System.out.println("[ 남은 폭탄 개수 : " + (bomb - 1) + " ]");
		bomb--;
	}
	public void C() {
		System.out.println("[특수 공격.");
	}

}

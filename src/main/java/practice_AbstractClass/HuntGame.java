package practice_AbstractClass;
import java.util.Scanner;

public class HuntGame extends JoiStick{
	//화살 개수
	int arrows = 0;
	//게임 오버 여부
	boolean gameOver;
	//생성자
	public HuntGame() {
		this.game = "사냥게임";
		this.arrows = 5;
		this.gameOver = true;
	}
	Scanner scanner = new Scanner(System.in);
	
	
	public void index() {
		System.out.println("[ Q 입력 시 게임 강제종료. ]");
		System.out.println("[ "+ game + " 시작]");
		System.out.println("[ 화살 부족 시 게임 오버. ]");
		
		while(gameOver) {
			System.out.println("[적 출현.]");
			System.out.println("[공격!]");
			System.out.println("[ A. 활 쏘기 B. 특수 공격 C. 전리품 줍기 ]");
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
		if(arrows == 0) {
			System.out.println("[화살 부족 게임 오버.]");
			gameOver = false;
		}
		System.out.println("[ 활 쏘기. ]");
		System.out.println("[ 남은 화살 개수 : " + (arrows-1) + "개 ]");
		arrows--;
		
	}	
	public void B() {
		System.out.println("[ 특수 공격. ]");
	}
	public void C() {
		System.out.println(" [ 전리품 줍기. ]");
		System.out.println(" [ 남은 화살 개수 : " + (arrows+1) + "개 ]");
		arrows++;
	}

}

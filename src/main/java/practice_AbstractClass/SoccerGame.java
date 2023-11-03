package practice_AbstractClass;
import java.util.Scanner;

public class SoccerGame extends JoiStick{
	int tired;
	int winPt;
	boolean gameOver;
	//생성자
	SoccerGame(){
		this.game = "축구게임";
		this.tired = 0;
		this.winPt = 100;
		this.gameOver = true;
	}
	Scanner scanner = new Scanner(System.in);
		
	
	public void index() {		
		System.out.println("[ Q 입력 시 게임 강제종료. ]");		
		System.out.println("[ 선수는 행동을 할 때마다 피로도가 상승합니다. ]");
		System.out.println("[ 일정 피로도 상승 시 승률이 떨어집니다. ]");
		System.out.println("[ 승률이 50% 미만이면 게임 오버. ]");
		System.out.println("[ "+ game + " 시작 ]");
		System.out.println("[ 경기 시작. ]");
		while(gameOver) {
			if(tired >= 30) {
				winPt -= 10;
				System.out.println("[ 현재 승률 : " + winPt + "% ]");
				if(50 > winPt) {
					System.out.println("[ 승률 50% 미만, 게임오버. ]");
					gameOver = false;
					return;
				}
			}
			System.out.println("[ A. 슛 B. 패스 C. 선수교체 ]");
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
		System.out.println("[ 슛. ]");
		System.out.println("[ 피로도 상승!! 전체 피로도 : " + (tired + 10) + " ]");
		tired += 10;
	}
	public void B() {
		System.out.println("[ 슛. ]");
		System.out.println("[ 피로도 상승!! 전체 피로도 : " + (tired + 10) + " ]");
		tired += 10;
	}
	public void C() {
		System.out.println("[ 선수 교체. ]");		
		System.out.println("[ 전체 피로도 : " + 0 + " ]");
		tired = 0;
		winPt = 100;
	}

}

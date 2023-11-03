package practice_AbstractClass;
import java.util.Scanner;
public class Start {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("[메뉴 : 1. 축구게임 2. 사냥게임 3.비행기게임 ]");
			int num = scanner.nextInt();
			if(num == 1 ) 
				new SoccerGame().index();
			else if(num == 2)
				new HuntGame().index();
			else if(num == 3)
				new AirplaneGame().index();			
		}

	}

}

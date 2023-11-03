package practice_MvcPattern.mvc예시;

/*
	-Ex10_게시판 패키지
		controller 패키지
			Controller.java
		model 패키지
			Model.java
		view 패키지
			View.java
	Start.java
	
- 1. Start[main함수] 클래스가 View 클래스를 호출 
- 2. View 클래스에서 사용자로부터 입·출력 받기 
- 3. Controller 클래스에서 View로부터 전달받은 데이터를 처리/로직 
- 4. Model 클래스에서 게시물의 모델링	

*/
public class Start {

	public static void main(String[] args) {
		
		View.getInstance().index();

	}

}

package practice_MvcPattern.mvc예시;

import java.util.ArrayList;
import java.util.Scanner;


public class View {
	
	// 1. 싱글톤 객체 [ 1. 프로그램내 하나의 객체 - 공유 메모리 ]
	private static View view = new View();
	private View() {}
	public static View getInstance() {
		return view;
	}
	
	private Scanner scanner = new Scanner(System.in);
	
	//index 함수 
	public void index() {
		while( true ) {
			print_page();
			System.out.print("1.쓰기 2.상세 : ");
			int ch = scanner.nextInt();
			if ( ch == 1) { write_page(); }
			else if ( ch == 2) { view_page(); }
		}
	}
	
	// 쓰기 페이지 함수
	private void write_page() {
		//입력받기
		System.out.println("-------------글쓰기 페이지---------------");
		System.out.print("제목 : ");					String title = scanner.next();
		System.out.print("내용 : ");					String content = scanner.next();
		System.out.print("작성자 : ");				String writer = scanner.next();
		System.out.print("비밀번호 : ");				String password = scanner.next();
		
		int view = 0;	//조회수는 0부터 시작
		
		// 컨트롤러에게 입력받은 값 전달 후 결과를 result에 저장
		boolean result =
		Controller.getInstance().writer(title, content, writer, password, view);
		// 결과에 따른 출력
		if (result) { System.out.println("[알림] 글쓰기 성공");}
		else { System.out.println("[알림] 글쓰기 실패"); }
		
	}
	// 출력 페이지 함수
	private void print_page() {
		// 싱글톤 객체를 통해 modelDb 배열 객체 반환 받기
		ArrayList<Model> result = Controller.getInstance().print();
		System.out.println("-------------비회원 게시판---------------");
		System.out.println("번호\t제목\t작성자\t조회수");
		
		// 반환된 배열 객체 수 만큼 반복
		for(int i = 0; i < result.size(); i++) {
			//배열 내 i번째 객체를 출력
			System.out.println(i+"\t"+result.get(i).toString());
			
		}	
}
	// 상세 페이지 함수
	private void view_page() {
		// 입력받기
		System.out.print(" 게시물번호 : "); int bno = scanner.nextInt();
		// 입력받은 게시물번호의 게시물 정보를 컨트롤에게 요청 [bno 넘겨준 다음]
		Model result = Controller.getInstance().view(bno);
		System.out.println("\n-------------- 게시물 상세( "+bno+") -----------");
		System.out.println("제목 : " + result.getTitle());
		System.out.println("작성자 : " + result.getWriter()
													+ "\t 조회수 : "+ result.getView());
		System.out.println("내용 : " + result.getContent());
		System.out.print(">> 1.뒤로가기 2.삭제 3.수정");
		int ch2 = scanner.nextInt();
		if(ch2 == 1) {return;}	
		
	}		
}

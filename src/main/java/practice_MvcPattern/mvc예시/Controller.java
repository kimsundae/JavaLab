package practice_MvcPattern.mvc예시;
import java.util.ArrayList;

public class Controller {
	
	// 싱글톤 객체
	private static Controller controller = new Controller();
	private Controller() {}
	public static Controller getInstance() {
		return controller;
	}
	
	//필드
	private ArrayList<Model> modelDb = new ArrayList<>();

	
	// 쓰기 처리 함수
	public boolean writer(String title, String content , String writer, String password , int view) {
		// 유효성 검사 [생략]
		// 저장 [ DB 대신 배열 ]
				//객체화
		Model model = new Model(title , content , writer, password , view);
				//객체를 배열에 담기
		modelDb.add(model);
		
		// 결과 반환
		return true;	
	}
	// 모든 게시물[여러개 -> list] 출력 처리 함수
	public ArrayList<Model> print() {
		//유효성 검사 [ 생략 ] 검색,페이징 처리
		return modelDb;
	}
	// 특정 게시물[1개 -> object] 출력 처리 함수
	public Model view(int bno) {
		// * 조회수 올리기 // 객체명 .set필드명( 객체명.get필드명()+1);
		modelDb.get(bno).setView(modelDb.get(bno).getView() + 1);
		return modelDb.get(bno);
	}
	
}

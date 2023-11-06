package practice_MvcPattern.mvc예시;




public class Model {
	// 필드
	private String title;
	private String content;
	private String writer;
	private String password;
	private int view;
	
	// 생성자
	public Model() {}
	public Model(String title , String content , String writer, String password , int view) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.password = password;
		this.view = view;
	}
	
	// 메소드
	@Override
	public String toString() {
		return title +"\t"+writer+"\t"+view;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPassword() {
		return password;
	}
	public void setPasword(String password) {
		this.password = password;
	}
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
	
	

}

package practice_MvcPattern.mvcTest;

public class Model {
	private String title;
	private String writer;
	private int view;
	

	private static Model model = new Model();
	private Model(){}
	public static Model getInstance() {
		return model;
	}
	
	@Override
	public String toString() {
		return title +"\t"+writer+"\t"+view+"\t";
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

}

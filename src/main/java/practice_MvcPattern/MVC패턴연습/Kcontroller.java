package practice_MvcPattern.MVC패턴연습;
import java.util.ArrayList;

public class Kcontroller {
	
	//싱글톤 객체
	private static Kcontroller kcontroller = new Kcontroller();
	private Kcontroller() {}
	public static Kcontroller getInstance() {
		return kcontroller;
	}
	
	//총 금액
	private int totalMoney = 0;
	//총 금액 게터
	public int getTotalMoney() {
		return totalMoney;
	}
	// 세터
	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}
	// 리스트 생성
	private ArrayList<Product> productDb = new ArrayList<>(2);
	
	// 상품 등록 메소드
	public boolean createProduct(String productName,int productPrice, int productRemain) {
		//새로운 product 객체 생성
		Product product = new Product(productName,productPrice,productRemain);
		// 리스트에 객체 넣기
		productDb.add(product);
		// 결과 반환
		return true;
	}
	
	//상품 객체 리스트 반환
	public ArrayList<Product> productInfo(){
		return productDb;
	}
	
	//카트 담기 메소드
	public void chooseProduct(int menuNum) {
		// 상품 재고가 0이 아니라면 카트 카운트 +1 , 재고 1 감소
		if( productDb.get(menuNum).getProductRemain() != 0 ) {
			
			productDb.get(menuNum).setcartCount(productDb.get(menuNum).getcartCount()+1);
			productDb.get(menuNum).setProductRemain(productDb.get(menuNum).getProductRemain()-1);			
		}		
		else
			System.out.println("재고가 부족합니다.");		
	}
	
	//결제 실패 시 재고 반환 메소드
	public void buyFail() {
		for(int i = 0; i < productDb.size(); i++) 
			productDb.get(i).setProductRemain(productDb.get(i).getProductRemain() + productDb.get(i).getcartCount());		
	}				
}

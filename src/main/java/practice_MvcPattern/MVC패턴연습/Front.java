package practice_MvcPattern.MVC패턴연습;

import java.util.ArrayList;
import java.util.Scanner;

public class Front {
	
	//싱글톤 객체
	private static Front front = new Front();
	private Front() {}
	public static Front getInstance() {
		return front;
	}
	
	private Scanner scanner = new Scanner(System.in);
	
		
	public void index() {
		// 상품 등록 루프 시작
		while(true) {
			System.out.println("상품을 등록하시려면 1 아니면 2 를 입력해주세요");
			int signNum = scanner.nextInt();
			if( signNum == 1 ) { createProduct(); }
			else if( signNum == 2){ break;}
		} // 상품등록 루프 종료 
		
		// 메뉴 루프 시작
		while(true) {
			//메뉴 표시 메소드
			productMenu();			
			int menuNum = scanner.nextInt();			
			//menuNum이 상품 번호와 일치하면 chooseProduct메소드 실행
			printProductName(menuNum);			
		}									
	}
	
	//menuNum이 상품 번호와 일치하면 chooseProduct메소드 실행
	public void printProductName(int menuNum) {		
		ArrayList<Product> product = Kcontroller.getInstance().productInfo();
		
			//menuNum이 상품 리스트 크기와 같다면 결제메소드 , 작다면 카트 담기 메소드
			if (menuNum == product.size())					
					buyProduct();
			
			else if( menuNum < product.size() ){
				for(int i = 0; i < product.size(); i++) {
					// 입력 번호와 상품 번호와 같다면 상품 담기 메소드
					if(product.get(menuNum).getProductName() == product.get(i).getProductName()) 					
						Kcontroller.getInstance().chooseProduct(menuNum);
			}							
		}					
	}
	
	//메뉴 표시 메소드
	public void productMenu() {
		ArrayList<Product> product = Kcontroller.getInstance().productInfo();
		
		for(int i = 0; i < product.size(); i++ ) 
			
			System.out.print(i+"."+product.get(i).getProductName()+" ");
			
		System.out.print(" "+ product.size() + ".결제 ");
	}
	
	//상품 등록 메소드
	public void createProduct() {
		System.out.println("순서대로 입력해주세요 : 상품이름, 상품가격, 상품재고 ");
		
		boolean result =
		Kcontroller.getInstance().createProduct(scanner.next(),scanner.nextInt(),scanner.nextInt());
		
		if( result ) { System.out.println("등록 완료."); }
		else { System.out.println("등록 실패."); }
	}
	
	//결제 메소드
	public void buyProduct() {
		
		ArrayList<Product> product = Kcontroller.getInstance().productInfo();
		
		//카트 리스트 메소드
		cartList();
		
		System.out.println("[1.결제 2.취소]");
		
		int num = scanner.nextInt();
		// 총 금액 계산
		if(num == 1) {
			for(int i = 0; i < product.size(); i++) 				
				Kcontroller.getInstance().setTotalMoney( Kcontroller.getInstance().getTotalMoney() + 
															( product.get(i).getProductPrice() * product.get(i).getcartCount() ));
			
			System.out.println("[총 금액 : " + Kcontroller.getInstance().getTotalMoney());
			System.out.println("[금액을 넣어주세요.]");	
			
			int inputMoney = scanner.nextInt();					
			//총 금액 
			if(inputMoney >= Kcontroller.getInstance().getTotalMoney()) 				
				System.out.println("[결제 성공]");	
			
			else {
				System.out.println("[금액이 부족합니다.]");		
				Kcontroller.getInstance().buyFail();
			}										
		}
		//취소
		else if(num == 2) {
			System.out.println("[결제를 취소하였습니다.]");
			Kcontroller.getInstance().buyFail();
		}					
		//카트 초기화
		for(int i = 0; i < product.size(); i++) 
			product.get(i).setcartCount(0);
		
		//총 금액 초기화
		Kcontroller.getInstance().setTotalMoney(0);
	}
	
	//카트 리스트 메소드
	public void cartList() {
			
		ArrayList<Product> product = Kcontroller.getInstance().productInfo();
			
		System.out.println("-현재 장바구니 목록");
	    System.out.println("----------------");
	    System.out.println("제품명 수량 가격");
	        
	    for(int i = 0; i < product.size(); i++) {	    	
	        if(product.get(i).getcartCount() > 0)
	        	System.out.println(product.get(i).cart());
	    } 	        	   
	}			
}





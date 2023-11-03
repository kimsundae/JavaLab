package practice_MvcPattern.MVC패턴연습;

public class Product {
	//필드
	private String productName;
	private int productPrice;
	private int productRemain;
	private int cartCount = 0;
	
	
	//생성자
	public Product(String productName, int productPrice, int productRemain) {
		this.productName = productName;
		this.productPrice = productPrice;
		this.productRemain = productRemain;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductRemain() {
		return productRemain;
	}
	public void setProductRemain(int productRemain) {
		this.productRemain = productRemain;
	}
	public int getcartCount() {
		return cartCount;
	}
	public void setcartCount(int cartCount) {
		this.cartCount = cartCount;
	}
	
	public String cart() {
		return productName + "\t" + cartCount + "\t" + productPrice * cartCount; 
	}
}

package practice_MvcPattern;


public class Main{
	public static void main(String[] args) {
	if(	passwordCheck(null)) {
		System.out.println("성공");
	}else
		System.out.println("실패");
	}
	
public static boolean passwordCheck(String password) {
 		
 		// 1.
 		if(password == null)return false;
 		// 2.
 		if(password.length() != 4)return false;
 		// 3.
 		for(int i = 0; i < password.length(); i++) {
 			// 아스키코드 48 ~ 57은 0부터 9
 			if(  password.charAt(i) > 57 ||  48 > password.charAt(i) )
 				return false;
 		}
 		return true;
 	}
}
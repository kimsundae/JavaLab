package practice_regex;

public class regex_practice01 {
    public static void main(String[] args) {

        String test1 = "01011";
        String test2 = "홍길동ㄱ";
        String test3 = "문자에숫자가섞여있222을때";
        System.out.println(test1.matches("[0-9]"));
        System.out.println(test1.matches("[0-9]+"));
        System.out.println(test1.matches("[0-9]*"));
        System.out.println(test2.matches("[가-힣]*"));
        System.out.println(test2.matches("[가-힣]+"));
        System.out.println(!test2.matches("[0-9]"));
        System.out.println(!test1.matches("[0-9]*"));
        // false
        System.out.println(!test1.matches("^[0-9]*$"));
        // true
        System.out.println(test1.matches("^[0-9]*$"));
        // true
        System.out.println(!test2.matches("^[0-9]*$"));
        // true
        System.out.println(!test3.matches("^[0-9]*$"));

        System.out.println(test1.matches("^[0-9]*$"));
        System.out.println(test1.matches("\\d{0,4}"));
        System.out.println(test1.matches("\\d{0,5}"));


    }
}

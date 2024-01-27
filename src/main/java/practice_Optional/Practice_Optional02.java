package practice_Optional;

import java.util.Optional;
import java.util.OptionalInt;

public class Practice_Optional02 {
    public static void main(String[] args) {

        String str = "123";
        //1
        if(str != null){
            System.out.println(str);
        }
        //2
        if(Optional.of(str).isPresent()){
            System.out.println(str);
        }
        //3 이 코드를 ifPresent()를 이용해서 바꾸면 더 간단히 할 수 있음. 아래 문장은 참조변수 str이
        //null이 아닐 때만 값을 출력하고, null이면 아무 일도 일어나지 않음.
        Optional.ofNullable(str).ifPresent((s)-> System.out.println(s));
        //Optional.ofNullable(str).ifPresent(System.out::println);

        OptionalInt opt = OptionalInt.of(0);
        OptionalInt opt2 = OptionalInt.empty();
        System.out.println(opt.isPresent());// true
        System.out.println(opt2.isPresent());// false

        System.out.println(opt.getAsInt());// 0
        //System.out.println(opt2.getAsInt()); // NoSuchElementException예외발생

        System.out.println(opt.equals(opt2)); // false

        Optional<String> opt3 = Optional.ofNullable(null);
        Optional<String> opt4 = Optional.empty();

        System.out.println(opt3.equals(opt4)); // true
        System.out.println(OptionalInt.of(1).equals(OptionalInt.of(1))); // true
    }

}

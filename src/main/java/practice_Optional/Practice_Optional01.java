package practice_Optional;

import java.util.Optional;

public class Practice_Optional01 {
    public static void main(String[] args) {
        int result = Optional.of("123")
                .filter(x -> x.length() > 0)
                .map(Integer::parseInt).orElse(-1); // result = 123
        System.out.println(result);
        result = Optional.of("")
                .filter(x -> x.length() > 0)
                .map(Integer::parseInt).orElse(-1); // result = -1
        System.out.println(result);
    }
    static int optStrToInt(Optional<String> optStr, int defaultValue){
        try{
            return optStr.map(Integer::parseInt).get();
        }catch (Exception e){
            return defaultValue;
        }
    }

}

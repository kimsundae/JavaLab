package practice_Lambda;

import java.util.Arrays;

public class Lambda_02 {
    public static void main(String[] args) {

        MyFunction myFunction = (int a, int b) -> a > b ? a : b;
        int big = myFunction.max(5, 3);

    }
    @FunctionalInterface
    public interface MyFunction{
        public abstract int max(int a, int b);
    }
}

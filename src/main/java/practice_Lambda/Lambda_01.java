package practice_Lambda;

import java.util.Arrays;

public class Lambda_01 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        Arrays.setAll(arr, (i) -> (int)(Math.random()*5)+1);
    }
}

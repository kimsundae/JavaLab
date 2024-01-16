package practice_Lambda;

import java.util.*;

public class Lambda_03 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("abc","aaa","bbb","ddd","aaa");
/*        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });*/

        Collections.sort(list, (s1, s2)-> s2.compareTo(s1));

    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestAnything {
    public static void main(String[] args) {
/*
        List<Integer> array = Arrays.asList(1,2,3,4,5);
        List<Integer> copyArray = new ArrayList<>();

        //1.
        for( int i = 0; i < array.size(); i++ )
            copyArray.add(array.get(i));

        System.out.println(copyArray);

        copyArray.clear();

        //2.
        for( int i : array )
            copyArray.add( i );

        System.out.println(copyArray);

        copyArray.clear();

        final List<Integer> copyArray2 = new ArrayList<>();
        // 3.
        array.forEach( r -> copyArray2.add(r) );

        System.out.println(copyArray2);

        copyArray.clear();

        // 4.
        copyArray = array.stream().map( r -> r ).collect(Collectors.toList());

        System.out.println(copyArray);

        copyArray.clear();
*/

/*        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        list = list.stream().map (new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer r){
                return r * 10;
            }
        }).collect(Collectors.toList());
        System.out.println(list.toString());*/

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        list = list.stream().map( i -> i * 10 ).collect(Collectors.toList());
        System.out.println(list.toString());

        list.forEach( System.out::println );
        TestAnything testAnything = new TestAnything();
        Function<String, Boolean> f = (x) -> testAnything.equals(x);
        Function<String, Boolean> f2 = testAnything::equals;
    }
}

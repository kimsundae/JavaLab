package practice_Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// 스트림 만들기 818
public class StreamPractice_02 {
    public static void main(String[] args) {
        // 컬렉션
        List<Integer> list = Arrays.asList(1,2,3,4,5); // 가변인자
        Stream<Integer> intStream = list.stream(); // list를 소스로 하는 컬렉션 생성
        //배열
        /*
        Stream<T> Stream.of(T... values) // 가변인자
        Stream<T> Stream.of(T[])
        Stream<T> Arrays.stream(T[])
        Stream<T> Arrays.stream(T[] array, int startInclusive, int endExclusive)
        */

        Stream<String> strStream1 = Stream.of("a","b","c"); // 가변인자
        Stream<String> strStream2 = Stream.of(new String[]{"a","b","c"});
        Stream<String> strStream3 = Arrays.stream(new String[]{"a","b","c"});
        Stream<String> strStream4 = Arrays.stream(new String[]{"a","b","c"}, 0 , 3);
        /*
        IntStream IntStream.of(int... values) // Stream이 아니라 IntStream
        IntStream IntStream.of(int[])
        IntStream Arrays.stream(int[])
        IntStream Arrays.stream(int[] array ,int startInclusive, int endExclusive)
        */

    }
}

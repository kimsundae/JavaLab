package practice_Stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPractice_03 {
    public static void main(String[] args) {
        Stream<Student> stuStream = Stream.of(
                new Student("이자바", 3, 300),
                new Student("김자바", 1, 200),
                new Student("안자바", 2, 100),
                new Student("박자바", 2, 150)
        );

        long count = stuStream.count();
        stuStream = Stream.of(new Student("이자바", 3, 300), new Student("김자바", 1, 200), new Student("안자바", 2, 100), new Student("박자바", 2, 150));
        long count2 = stuStream.collect(Collectors.counting());

        System.out.println("count = " + count);
        System.out.println("count2 = " + count2);

        stuStream = Stream.of(new Student("이자바", 3, 300), new Student("김자바", 1, 200), new Student("안자바", 2, 100), new Student("박자바", 2, 150));
        long totalScore = stuStream.mapToInt(Student::getTotalScore).sum();

        System.out.println("totalScore = " + totalScore);

        OptionalInt topScore = stuStream.mapToInt(Student::getTotalScore).max();
        Optional<Student> topStudent = stuStream
                .max(Comparator.comparingInt(Student::getTotalScore));

        IntSummaryStatistics stat = stuStream.mapToInt(Student::getTotalScore).summaryStatistics();

        IntStream intStream = new Random().ints(1,46).distinct().limit(6);

        OptionalInt max = intStream.reduce(Integer::max);
        Optional<Integer> max2 = intStream.boxed().collect(Collectors.reducing(Integer::max));

        long sum = intStream.reduce(0, (a,b) -> a + b);
        long sum2 = intStream.boxed().collect(Collectors.reducing(0, (a,b) -> a + b));

        int grandTotal = stuStream.map(Student::getTotalScore).reduce(0, Integer::sum);
        int grandTotal2 = stuStream.collect(Collectors.reducing(0, Student::getTotalScore, Integer::sum));


    }
}

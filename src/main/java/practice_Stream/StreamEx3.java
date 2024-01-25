package practice_Stream;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx3 {
    public static void main(String[] args) {
        Student[] stuArr = {new Student("이자바", 3, 300),
                new Student("김자바", 1, 200),
                new Student("안자바", 2, 100),
                new Student("박자바", 2, 150)
        };
        Stream<Student> stuStream = Stream.of(stuArr);

        stuStream.sorted(Comparator.comparing(Student::getBan)
                .thenComparing(Comparator.naturalOrder())).forEach(System.out::println);
        stuStream = Stream.of(stuArr); // 스트림을 다시 생성
        IntStream stuScoreStream = stuStream.mapToInt(Student::getTotalScore);

        IntSummaryStatistics stat = stuScoreStream.summaryStatistics();
        System.out.println("count="+stat.getCount());
        System.out.println("sum="+stat.getCount());
        System.out.printf("average=%.2f%n", stat.getAverage());
        System.out.println("min="+stat.getMin());
        System.out.println("max="+stat.getMax());
    }
}

package practice_Stream;

import java.util.stream.Stream;

public class Stream_partition_practice00 {
    Stream<Student2> student2Stream = Stream.of(
            new Student2("나자바", true, 1, 1, 300),
            new Student2("김지미", false, 1, 1, 250),
            new Student2("김자바", true, 1, 1, 200),
            new Student2("이지미", false, 1, 2, 150),
            new Student2("남자바", true, 1, 2, 100),
            new Student2("안지미", false, 1, 2, 50),
            new Student2("황지미", false, 1, 3, 100),
            new Student2("강지미", false, 1, 3, 150),
            new Student2("이자바", true, 1, 3, 200),

            new Student2("나자바", true, 2, 1, 300),
            new Student2("김지미", false, 2, 1, 250),
            new Student2("김자바", true, 2, 1, 200),
            new Student2("이지미", false, 2, 2, 150),
            new Student2("남자바", true, 2, 2, 100),
            new Student2("안지미", false, 2, 2, 50),
            new Student2("황지미", false, 2, 3, 100),
            new Student2("강지미", false, 2, 3, 150),
            new Student2("이자바", true, 2, 3, 200)
    );
}

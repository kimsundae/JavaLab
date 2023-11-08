package practice_Stream;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StreamPractice_Sorted {
    public static void main(String[] args) {
        Test test1 = new Test();
        Test test2 = new Test();
        System.out.println("test1 = " + test1);
        System.out.println("test2 = " + test2);
        test1.setTime(LocalDateTime.now()); test1.setNumber(1);
        test2.setTime(LocalDateTime.now()); test2.setNumber(2);
        List<Test> testList = Arrays.asList(test1,test2);
        Stream<Test> testStream = testList.stream();
        testStream.sorted( Comparator.comparing(Test::getTime).reversed() ).forEach(r-> System.out.println(r));


    }
}
class Test{
    private LocalDateTime time;
    private int number;

    public LocalDateTime getTime() {
        return time;
    }

    public int getNumber() {
        return number;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

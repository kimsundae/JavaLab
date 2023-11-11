package standardOfJava.chapter10_TimePackage.LocalDateAndLocalTime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class Example01 {
    public static void main(String[] args) {

        LocalDate today = LocalDate.now(); // 오늘의 날짜 2023-11-11
        LocalTime now = LocalTime.now(); // 현재 시간 23:30:11.036
        System.out.println("today = " + today); // today =
        System.out.println("now = " + now); // now =

        LocalDate birthDate = LocalDate.of(1999,12, 31); // 1999-12-31
        LocalTime birthTime = LocalTime.of(23, 59, 59); // 23:59:59
        System.out.println(birthDate);
        System.out.println(birthTime);
        // 1999년의 마지막날을 의미
        LocalDate birthDate1 = LocalDate.ofYearDay(1999,365); // 1999-12-31

        // 그 날의 0시0분0초부터 86399초(하루는 86400초)
        LocalTime birthTime1 = LocalTime.ofSecondOfDay(86399); // 23:59:59
        System.out.println("birthDate1 = " + birthDate1);
        System.out.println("birthTime1 = " + birthTime1);

        // parse
        LocalDate birthDate2 = LocalDate.parse("1999-10-30"); // 1999-10-20
        LocalTime birthTime2 = LocalTime.parse("23:59:59"); // 23:59:59
        System.out.println("birthDate2 = " + birthDate2);
        System.out.println("birthTime2 = " + birthTime2);

        // 날짜 가져오기
        System.out.println(birthDate2.getYear()); // 1999
        System.out.println(birthDate2.get(ChronoField.YEAR_OF_ERA));
        System.out.println(birthDate2.get(ChronoField.YEAR));

        // 값 변경하기
        birthDate2 = birthDate2.withYear(2023);
        System.out.println(birthDate2 ); // 2023-10-30
        // with() 사용하기
        birthDate2 = birthDate2.with( ChronoField.YEAR, 2013 );
        System.out.println(birthDate2); // 2013-10-30

        // plus() 사용하기
        birthDate2.plus( 1, ChronoUnit.DAYS );

        //truncatedTo() 사용하기
        LocalTime time = LocalTime.of(12, 34, 56);
        System.out.println("time = " + time); // 12:34:56
        time = time.truncatedTo(ChronoUnit.HOURS); // 12:00
        System.out.println(time);
    }
}

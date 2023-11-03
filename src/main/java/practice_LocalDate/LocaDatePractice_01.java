package practice_LocalDate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocaDatePractice_01 {
    public static void main(String[] args) {
        String a1 = " ";
        LocalDate result = LocalDate.parse( a1 , DateTimeFormatter.ISO_DATE );
        LocalDate result2 = LocalDate.parse( "2023-10-20" , DateTimeFormatter.ISO_DATE);
        System.out.println(result);
        System.out.println(result2);
    }
}

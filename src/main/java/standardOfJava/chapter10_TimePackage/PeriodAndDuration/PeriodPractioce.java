package standardOfJava.chapter10_TimePackage.PeriodAndDuration;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodPractioce {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2014, 1, 1);
        LocalDate date2 = LocalDate.of(2015, 12, 31);

        Period pe = Period.between(date1, date2);

        LocalTime time1 = LocalTime.of(00, 00, 00);
        LocalTime time2 = LocalTime.of(12, 34, 56);

        Duration du = Duration.between(time1, time2);


        System.out.println(pe.get(ChronoUnit.YEARS)); // int getYears()

        System.out.println(pe.getUnits());
        System.out.println(du.getUnits());

    }
}

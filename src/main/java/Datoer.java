import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Datoer {
    public static void main(String[] args) {
        LocalDate birthday = LocalDate.of(1998, 11, 12);
        Stream<LocalDate> tendates = IntStream.range(1, 10).mapToObj(i -> birthday.plusYears(i));
        var obj = tendates.map(date -> "Year="+date.getYear()+ " ugedag="+translate(date.getDayOfWeek()));
        obj.forEach(System.out::println);

        IntPredicate leapYear = year -> (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        var leap = IntStream.iterate(LocalDate.now().getYear(), year -> year+1).limit(20).filter(leapYear);
        System.out.println("Leap year");
        leap.forEach(System.out::println);
    }
    public static String translate(DayOfWeek dayOfWeek) {
        return switch (dayOfWeek) {
            case MONDAY -> "Mandag";
            case TUESDAY -> "Tirsdag";
            case WEDNESDAY -> "Onsdag";
            case THURSDAY -> "Torsdag";
            case FRIDAY -> "Fredag";
            case SATURDAY -> "Lørdag";
            case SUNDAY -> "Søndag";
        };
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SoldierMain {
    public static void main(String[] args) {
        List<Soldier> soldiers = new ArrayList<>();
        soldiers.add(new Soldier(4, "Poul1"));
        soldiers.add(new Soldier(2, "Poul2"));
        soldiers.add(new Soldier(7, "Poul3"));
        soldiers.add(new Soldier(5, "Poul4"));
        soldiers.add(new Soldier(5, "Jens"));
        System.out.println("\nall soldiers");
        soldiers.forEach(s -> System.out.println(s));

        Predicate<Soldier> isHighRanked = soldier -> soldier.getRank() > 3;

        System.out.println("\nHigh Soldiers");
        Stream<Soldier> highSoldiers = soldiers.stream().filter(isHighRanked);
        highSoldiers.forEach(s -> System.out.println(s));

        String startsWithLetter = "J";
        System.out.println("\nHigh Soldiers and starts with "+startsWithLetter);
        Predicate<Soldier> startsWithJ = s -> s.getName().startsWith(startsWithLetter);
        Stream<Soldier> highAndJ = soldiers.stream().filter(isHighRanked).filter(startsWithJ);
        //highAndJ.forEach(s -> System.out.println(s));

        System.out.println("Collect");
        List<Soldier> obj = soldiers.stream().filter(isHighRanked).filter(startsWithJ).collect(Collectors.toList());
        System.out.println(obj);


        System.out.println("Mapping");
        List<Soldier> highandJList = highAndJ.collect(Collectors.toList());
        //System.out.println(highandJList);
        //Function<Soldier, String> getnames = soldier -> soldier.getName();
        List<String> names = highandJList.stream().map(s -> s.getName()).collect(Collectors.toList());
        names.forEach(s -> System.out.println(s));
    }
}

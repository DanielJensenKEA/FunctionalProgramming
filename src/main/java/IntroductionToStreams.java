import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class IntroductionToStreams {

    public static void main(String[] args) {
        Function<Double, Long> dblround = d -> Math.round(d*100);
        Predicate<Long> longEqual = rannum -> rannum % 2 == 0;
        Supplier<Double> ran = () -> Math.random();

        Stream<Double> randomNumbers = Stream.generate(ran);
        //randomNumbers.forEach(n -> System.out.println(n));
        //var obj = randomNumbers.map(dblround).filter(longEqual);
        //obj.forEach(o -> System.out.println(o));

        Stream<Long> ranlong = randomNumbers.map(dblround).filter(longEqual).limit(12);
        //ranlong.forEach(r -> System.out.println(r));

        DoubleStream randbl = ranlong.mapToDouble(d -> d);
        System.out.println("max="+randbl.max());
        System.out.println("min="+randbl.min());
    }


}

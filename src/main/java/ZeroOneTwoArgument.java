import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ZeroOneTwoArgument {
    public interface ZeroArgument {
        public void myFunc();
    }
    public interface OneArgument {
        public void myFunc(String str);
    }
    public interface TwoArgument {
        public int myFunc(int a, int b);
    }
    public static void printZero(Main.ZeroArgument z0) {
        z0.myFunc();
    }
    public static void forEachString(List<String> listOfStrings, Consumer<String> consumer) {
        listOfStrings.forEach(consumer); //Egen løsning før jeg kiggede på Eriks
        for (String string : listOfStrings) {
            consumer.accept(string);
        }
    }
    public static <T> void forEach(List<T> lst, Consumer<T> consumer) {
        for (T t : lst) {
            consumer.accept(t);
        }
    }
    public static int sumTwoArgFunction(List<Integer> list, TwoArgument two) {
        int sum = 0;
        for (int t : list ) {
            sum += two.myFunc(t, t);
        }
        return sum;
    }
    public static int valutaomregner(List<Integer> list, TwoArgument two, int kurs) {
        int sum = 0;
        for (int t : list ) {
            sum += two.myFunc(t, kurs);
            System.out.println("inside valutaomregner"+two.myFunc(t, kurs));
        }
        return sum;
    }

    public static void main(String[] args) {
        Consumer<String> toUpper = x -> System.out.println(x.toUpperCase());
        toUpper.accept("viggo");

        Consumer<Long> square = t -> System.out.println(t*t);
        square.accept(50l);

        System.out.println("-----List of Strings--------");
        List<String> lstStr = Arrays.asList("hej", "du", "der");
        forEachString(lstStr, toUpper);
        forEach(lstStr, toUpper);

        System.out.println("-----List of num--------");
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        Consumer<Integer> out = (Integer x) -> System.out.println(x);
        //forEach(list, out);
        list.forEach(out);

        System.out.println("-----ss--------");
        TwoArgument twoplus = (x,y) -> x+y;
        int ss = sumTwoArgFunction(list, twoplus);
        System.out.println(ss);

        TwoArgument twomult = (x,y) -> x*y;
        ss = sumTwoArgFunction(list, twomult);
        System.out.println(ss);

        List<Integer> dollarSedler = Arrays.asList(1, 5, 10);
        int pengedk = valutaomregner(dollarSedler, twomult, 6);
        System.out.println("du har dk="+pengedk);

    }
}

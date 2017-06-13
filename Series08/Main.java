package Series08;

import Series08.Option;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created by peter on 13.06.2017.
 */
public class Main {
    public static void main (String[] args) {

        List<Integer> l = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        System.out.println(
            map(
                    Function.identity(),
                    l
            )
        );

        // [4, 6, 8, 10, 12, 14, 16, 18, 20, 22]
        System.out.println(
            map(
                    x -> 2 * x,
                    map(
                            x -> x + 1,
                            l
                    )
            )
        );

        // [4, 6, 8, 10, 12, 14, 16, 18, 20, 22]
        System.out.println(
                map(
                        x -> (x + 1) * 2,
                        l
                )
        );

        // [4, 6, 8, 10, 12, 14, 16, 18, 20, 22]
        System.out.println(
                doubleMap(
                        x -> x * 2,
                        x -> x + 1,
                        l
                )
        );

        // Es funktioniert trotz Ausgabe auf der Konsole?
        System.out.println(
                doubleMap(
                        x -> {
                            System.out.println("Hallo");
                            return x * 2;
                        },
                        x -> {
                            System.out.println("Welt");
                            return x + 1;
                        },
                        l
                )
        );

        // Flatmap erwartet eine Funktion vom Typ Function<T, R>
        // In diesem Fall wird halt der Inhalt des Options angepasst.
        System.out.println(
                Option.of(5).flatMap(x -> Option.of(x+1)).get()
        );


        // Es kommt ein neuer Option.of(5) zurück
        Option<Integer> opt = Option.of(5);
        System.out.println(
                opt.flatMap(Option::of).get()
        );


    }

    static <T, R> List<R> flatMap(
            Function<T, List<R>> f,
            List<T> list
    ) {
        return fold(
                x -> y -> {
                    x.addAll(f.apply(y));
                    return x;
                },
                new ArrayList<R>(),
                list
        );
    }

    static <T, R> List<R> doubleMap(
            Function<T, R> f,
            Function<T, T> g,
            List<T> l
    ) {
        return fold(
                x -> y -> {
                    x.add(
                            f.apply(g.apply(y))
                    );
                    return x;
                },
                new ArrayList<R>(),
                l
        );
    }

    static <T> T method1 (T x, T y) {
        return x;
    }

    static <T> T method2 (T x, T y) {
        return null;
    }

    static <T, R> List<R> map(
            Function<T, R> f,
            List<T> list
    ) {

        return fold(
                x -> y -> {
                    x.add(f.apply(y));
                    return x;
                },
                new ArrayList<R>(),
                list
        );
    }

    static <T, R> R fold(
            Function<R, Function<T, R>> f, R initial, List<T> list
    ) {
        R result = initial;
        for(T e : list) {
            result = f.apply(result).apply(e);
        }
        return result;
    }
}

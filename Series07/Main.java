package Series07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by peter on 28.05.2017.
 */
public class Main {
    public static void main(String[] args) {

        // Der Unterschied, man muss Doppelpunkte verwenden. Java unterscheided Methoden und Funktionen, das sind zwei unterschiedliche Dinge
        // Die leben in sehr unterschiedlichen Welten. Javascript hat keine UNterscheidung, da es funktional inspiriert ist.
        List<Double> zweierpotenzen = map(
                x -> {
                    x = curry(
                            Math::pow
                    ).apply(2D).apply((double)x);
                    System.out.println(x);
                    return x;
                },
            Arrays.asList(1D, 2D, 3D, 4D, 5D, 6D, 7D, 8D, 9D, 10D)
        );

        List<Integer> testlist = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
        System.out.println(
            reverse(testlist)
        );

        // [1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800]
        System.out.println(
                scan(
                        x -> y -> x * y,
                        1,
                        testlist
                )
        );

        // [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
        System.out.println(
                reverse(testlist)
        );
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


    /* Hier habe ich eine Frage:
    Die bisherige fold-Funktion verhält sich doch schon so wie left fold oder nicht?
    Verlangt die Aufgabe 2 von mir, dass ich diese so umbaue, dass ich sie wie eine
    gecurryiete Funktion ähnlich in Haskell verwenden kann?
    In dem Fall quitiert mir Java den Dienst, da es mit den Übergabeparametern
    im Return nicht hinhaut. ? :(
     */
    /*
    static <T, R> Function<
            Function<
                    T,
                    R
            >,
            Function<
                    R,
                    Function<
                            List<T>,
                            R
                    >
            >
    > foldl(
    ) {
        return x -> y -> z -> {
            return fold(
                    x,
                    y,
                    z
            );
        };
    }
    */
/*
Info aus der Vorlesung :
    Was musste man mit dem Foldl hier machen?
 */

    static <T> List<T> reverse(List<T> list) {
        return fold(
                x -> y -> {
                    x.add(0, y);
                    return x;
                },
                new ArrayList<T>(),
                list
        );
    }

    static <T> List<T> reverseScan(List<T> list) {
        return scan(
                x -> y -> y,
                list.get(0),
                list
        );
    }

    // Eher unschön, da ich das neutrale Element in der Liste stehen habe
    // und nachträglich entferne.
    static <T, R> List<R> scan(
            Function<T, Function<R,R>> f,
            R initial,
            List<T> list
    ) {
        List<R> result = new ArrayList<R>();
        result.add(initial);

        for(T e : list) {
            result.add(
                    f.apply(
                            e
                    ).apply(
                            result.get(
                                    result.size() - 1
                            )
                    )
            );
        }
        result.remove(0);
        return result;
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

    static <T, S, R> Function<T, Function<S, R>> curry(
            BiFunction<T, S, R> f
    ) {
        return x -> y -> f.apply(x, y);
    }

    static <T, S, R> BiFunction<T, S, R> uncurry(
            Function<T, Function<S, R>> f
    ) {
        return (x, y) -> f.apply(x).apply(y);
    }
}

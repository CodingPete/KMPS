package Series06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by peter on 28.05.2017.
 */
public class Main {
    public static void main(String[] args) {

        List<Integer> countTest = new ArrayList<>();
        countTest.add(1);
        countTest.add(2);
        countTest.add(3);
        countTest.add(4);

        System.out.println(count(countTest));   // 4
        System.out.println(sum(countTest));     // 10
        System.out.println(prod(countTest));    // 24

        List<Boolean> boolTest = new ArrayList<>();
        boolTest.add(true);
        boolTest.add(true);

        System.out.println(and(boolTest));  // True, da alle Werte in der Liste true

        System.out.println(
                map(
                    x -> x + 1,
                    countTest
                )
        ); // [2, 3, 4, 5]

        System.out.println(
                filter(
                        x -> x % 2 == 0,
                        countTest
                )
        );  // [2, 4]

        List<List<Integer>> flatMapTest = new ArrayList<List<Integer>>();
        flatMapTest.add(
                Arrays.asList(1,2)
        );
        flatMapTest.add(
                Arrays.asList(3,4)
        );
        flatMapTest.add(
                Arrays.asList(5,6)
        );

        System.out.println(
                flatMap(
                        x -> x,
                        flatMapTest
                )
        );

        System.out.println(
                flatten(
                        flatMapTest
                )
        );
    }

    static <T> Integer count(List<T> list) {
        //Function<Integer, Function<T, Integer>> f = x -> y -> x + 1;
        return fold(
                x -> y -> x + 1,
                0,
                list
        );
    }

    static Integer sum(List<Integer> numbers) {
        return fold(
                x -> y -> x + y,
                0,
                numbers
        );
    }

    static Integer prod(List<Integer> numbers) {
        return fold(
                x -> y -> x * y,
                1,
                numbers
        );
    }

    static Boolean and(List<Boolean> booleans) {
        return fold(
                x -> y -> x && y,
                true,
                booleans
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

    static <T> List<T> filter(
            Predicate<T> p,
            List<T> list
    ) {

        return fold(
                x -> y -> {
                    if(p.test(y)) {
                        x.add(y);
                    }
                    return x;
                },
                new ArrayList<T>(),
                list
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

    static <T> List<T> flatten(
            List<List<T>> list
    ) {
        return fold(
                x -> y -> {
                    x.addAll(y);
                    return x;
                },
                new ArrayList<T>(),
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

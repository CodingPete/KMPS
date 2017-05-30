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

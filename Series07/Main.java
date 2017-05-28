package Series07;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created by peter on 28.05.2017.
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> testgelaende = Arrays.asList(1, 2, 3 ,4);
        System.out.println(
                fold(
                        x -> y -> y - x,
                        0,
                        testgelaende
                )
        );
    }

    static <T, R> R foldl(
            Function<R, Function<T, R>> f,
            R initial,
            List<T> list
    ) {
        return null;
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

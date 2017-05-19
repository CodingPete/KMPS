package Series04;

import java.util.function.Function;

/**
 * Created by peter on 05.05.2017.
 */
public abstract class Option<T> {
    public abstract T get();
    public abstract boolean isPresent();
    public abstract T orElse(T other);
    public abstract String toString();

    public abstract <R> Option<R> map (Function<T, R> f);
    public abstract <R> Option<R> flatMap (Function<T, Option<R>> f);
}

package Series04;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.function.Function;

/**
 * Created by peter on 05.05.2017.
 */
public class None<T> extends Option<T> {

    private None() {};

    public static <T> Option<T> empty() {
        return new None<>();
    }

    public static <T> Some<T> of(T value) {
        throw new NotImplementedException();
    }

    public static <T> Option<T> ofNullable(T value) {
        throw new NotImplementedException();
    }

    @Override
    public T get() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isPresent() {
        return false;
    }

    @Override
    public T orElse(T other) {
        return other;
    }

    @Override
    public String toString() {
        return "Empty";
    }

    @Override
    public <R> Option<R> map(Function<T, R> f) {
        throw new NotImplementedException();
    }

    @Override
    public <R> Option<R> flatMap(Function<T, Option<R>> f) {
        throw new NotImplementedException();
    }
}

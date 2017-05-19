package Series04;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.function.Function;

/**
 * Created by peter on 05.05.2017.
 */
public class Some<T> extends Option<T> {

    private T value;

    private Some(T value) {
        this.value = value;
    }

    public static <T> Option<T> empty() {
        throw new NotImplementedException();
    }

    public static <T> Some<T> of(T value) {
        return new Some<>(value);
    }

    public static <T> Option<T> ofNullable(T value) {
        throw new NotImplementedException();
    }

    @Override
    public T get() {
        return value;
    }

    @Override
    public boolean isPresent() {
        return true;
    }

    @Override
    public T orElse(T other) {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public <R> Option<R> map(Function<T, R> f) {
        return Some.of(f.apply(value));
    }

    @Override
    public <R> Option<R> flatMap(Function<T, Option<R>> f) {
        return f.apply(value);
    }
    // Die Funktion flatMap kann auch mit map modelliert werden,
    // da sich ja bloß der generische Typ der funktion ändert.
}

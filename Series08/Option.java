package Series08;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by peter on 19.05.2017.
 */
public abstract class Option<T> {
    public abstract T get();
    public abstract boolean isPresent();
    public abstract T orElse(T other);

    public static <T> Some<T> of(T value) {
        return new Some<>(value);
    }

    public static <T> None<T> empty() {
        return new None<>();
    }

    public abstract <R> R fold(R initial, Function<T, R> f);

    public <R> Option<R> map(Function<? super T, ? extends R> f) {

        return fold(
                empty(),
                x -> of(
                        f.apply(x)
                )
        );
    }

    public <R> Option<R> flatMap(Function<T, Option<R>> f) {
        return fold(
                empty(),
                f
        );
    }

    public abstract Option<T> filter(Predicate<T> p);

    public abstract void foreach(Consumer<T> c);

    public static class Some<T> extends Option<T> {

        private T value;

        private Some(T value) {
            this.value = value;
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
        public <R> R fold(R initial, Function<T, R> f) {
            return f.apply(value);
        }

        @Override
        public Option<T> filter(Predicate<T> p) {
            return fold(
                    empty(),
                    x -> {
                        if(p.test(value)) return of(value);
                        else return empty();
                    }
            );
        }

        @Override
        public void foreach(Consumer<T> c) {
            c.accept(value);
        }
    }

    public static class None<T> extends Option<T> {

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
        public <R> R fold(R initial, Function<T, R> f) {
            return initial;
        }

        @Override
        public Option<T> filter(Predicate<T> p) {
            return empty();
        }

        @Override
        public void foreach(Consumer<T> c) {
            // tunix, da None
        }
    }
}

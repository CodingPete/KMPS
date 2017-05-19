package Series03;

/**
 * Created by peter on 05.05.2017.
 */
public abstract class Option<T> {
    public abstract T get();
    public abstract boolean isPresent();
    public abstract T orElse(T other);
    public abstract String toString();
}

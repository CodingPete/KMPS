package Series03;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by peter on 05.05.2017.
 */
public class LimitedIntegerIterator<T> implements Iterable<T>, Iterator<T> {
    private Iterator<T> value;
    private int count;
    private int actions = 0;

    public LimitedIntegerIterator(Iterator<T> value, Integer count) {
        this.value = value;
        this.count = count;
    }

    @Override
    public boolean hasNext() {
        return actions < count && value.hasNext();
    }

    @Override
    public T next() {
        if(this.hasNext()) {
            this.actions++;
            return value.next();
        }
        else throw new NoSuchElementException();
    }

    @Override
    public Iterator<T> iterator() {
        return this;
    }
}

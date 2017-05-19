package Series03;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by peter on 05.05.2017.
 */
public class IntegerIterator implements Iterator<Integer> {
    private Integer value;
    private Integer max = Integer.MAX_VALUE;

    public IntegerIterator(Integer start) {
        value = start;
    }

    public IntegerIterator(Integer start, Integer count) {
        value = start;
        this.max = start + count;
    }

    @Override
    public boolean hasNext() {
        return value < max;
    }

    @Override
    public Integer next() {
        if(this.hasNext()) {
            value = value + 1;
            return value;
        }
        else throw new NoSuchElementException();
    }

}

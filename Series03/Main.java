package Series03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public enum Base {
        U, A, C, G
    }

    public static Option<Base> parseBase(char input) {
        switch(input) {
            case 'U':
                return Some.of(Base.U);
            case 'A':
                return Some.of(Base.A);
            case 'C':
                return Some.of(Base.C);
            case 'G':
                return Some.of(Base.G);
            default:
                return None.empty();
        }
    }

    public static Option<List<Base>> parseRNA(String input) {
        char[] values = input.toCharArray();
        List<Base> result = new ArrayList<>();
        for(char c : values) {
            Option<Base> base = parseBase(c);
            if(base.isPresent()) {
                result.add(base.get());
            } else return None.empty();
        }
        return Some.of(result);
    }

    public static <T> Iterator<Integer> enumFrom(Integer start) {
        return new IntegerIterator(start);
    }

    public static <T> Iterator<T> take(Iterator<T> iterator, Integer count) {
        return new LimitedIntegerIterator<>(iterator, count);
    }

    public static void main(String[] args) {

        Iterator<Integer> begrenzt = take(enumFrom(999), 10);
        while(begrenzt.hasNext()) System.out.println(begrenzt.next());

        begrenzt = take(enumFrom(999), 10);
        for(Integer i : new makeIteratorIterable<>(begrenzt)) {
            System.out.println(i);
        }
    }

    public static class makeIteratorIterable<T> implements Iterable<T> {

        private Iterator<T> iterator;

        public makeIteratorIterable(Iterator<T> iterator) {
            this.iterator = iterator;
        }

        @Override
        public Iterator<T> iterator() {
            return iterator;
        }
    }
}

package Series04;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peter on 05.05.2017.
 */
public class Main {
    public static void main(String[] args) {

        Number[] numbers = new Number[4];
        // Integer[] integers = numbers;               // Geht nicht.
        Object[] objects = numbers;

        // Hinzufügen eines Obertyps in das Array
        // objects[0] = new Object();
        // Führt zum Laufzeitfehler ArrayStoreException, da das Array
        // ja nachwievor vom Typ Number ist.

        List<Number> lNumbers = new ArrayList<>();
        // List<Integer> lIntegers = lNumbers;         // Geht nicht
        // List<Object> lObjects = lNumbers;           // Geht nicht
        // Listen mit unterschiedlichem generischen Typ sind invariant



        List<Integer> lIntegers =  new ArrayList<>();
        lIntegers.add(1);
        Number number = coGet(lIntegers, 0);

        number = conGet(lIntegers, 0);

        conSet(lIntegers, 1, 2);
    }

    static <T> T coGet(List<? extends T> list, int index) {
        return list.get(index);
    }


    // Durch <? super T> wird die Liste read-only
    static <T> T conGet(List<? super T> list, int index) {
        //  return list.get(index);
        // Nicht implementierbar, da Integer von Number erbt.
        return null;
    }

    // Durch <? extends T> wird die Liste write-only
    static <T> void coSet(List<? extends T> list, int index, T value) {
        //  list.set(index, value);
        // Nicht implementierbar, da Integer von Number erbt.
    }

    static <T> void conSet(List<? super T> list, int index, T value) {
        list.set(index, value);
    }
}

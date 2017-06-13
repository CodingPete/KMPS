package Vorlesung;

import java.util.function.Consumer;

/**
 * Created by peter on 09.06.2017.
 */
public class Closure {
    public static void main(String[] args) {

        for(int i = 0; i < 10; i++) {
            final int j = i;
            setTimeout(x -> System.out.println(j), 100*i);
        }
    }

    public static void setTimeout(
            Consumer<Void> f,
            int milliseconds
    ) {
        new Thread(() -> {
            try {
                Thread.sleep(milliseconds);
                f.accept(null);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
// Variablen in Lambdaausdrücken müssen final oder effectively final sein

// Tony Hoare hat sich das mit den Nullreferenzen ausgedacht. (ALGOL W)
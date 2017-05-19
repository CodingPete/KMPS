package Series05;

/**
 * Created by peter on 19.05.2017.
 */
public class Main {
    public static void main(String[] args) {

        Option<Integer> opt = Option.of(5);

        Option<Object> opt2 = opt.map(
                x -> x*2
        );

        System.out.println(
                opt2.get()
        );

    }
}

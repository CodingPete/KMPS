package Series01;

public class aufgabe02 {


    public static void main(String[] args) {
        Object[] liste = {
                new CharValue('a'),
                new BoolValue(false),
                new CharValue('c')
        };

        for(int i = 0; i < liste.length; i++) {
            System.out.println(tuwatt(liste[i]).value);
        }

    }

    public static Value<?> odd(boolean b) {
        if(b) return new CharValue('a');
        else return new BoolValue(false);
    }

    public static Value<?> tuwatt(Object input) {

        if(input instanceof BoolValue) {
            ((BoolValue) input).value = !((BoolValue) input).value;
        }

        return (Value<?>)input;
    }

}

abstract class Value<T> {

    protected T value;

    public T get() {
        return value;
    }
}

class CharValue extends Value<Character> {
    public CharValue(char input) {
        this.value = input;
    }
}

class BoolValue extends Value<Boolean> {
    public BoolValue(boolean input) {
        this.value = input;
    }
}

/**
 * Created by peter on 28.05.2017.
 */

// Erzeugung
let zweierpotenzen =  map(
    x => 2**x,
    [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
);

// Ausgabe
map(
    x => console.log(x),
    zweierpotenzen
);

function curry<T, S, R> (
    f: (T) => (S) => (R)
) :(T) => ((S) => (R)) {
    return x => y => f(x)(y);
}

function uncurry<T, S, R> (
    f: (T) => ((S) => (R)),
) {
    return (x, y) => f(x)(y);
}

function map<T, R>(
    f: (T) => (R),
    list: [T]
) :[R] {
    return reduce(
        x => y => {
            x.push(f(y));
            return x;
        },
        [],
        list
    );
}

function reduce<T, R>(
    f: (R) => (T) => R,
    initial: R,
    array: [T]
) :R {
    let result = initial;
    for(let x of array) {
        result = f(result)(x);
    }
    return result;
}
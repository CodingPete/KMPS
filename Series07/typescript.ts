/**
 * Created by peter on 28.05.2017.
 */

// Erzeugung
let zweierpotenzen =  map(
    x => {
        x = 2**x;
        console.log(x);
        return x;
    },
    [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
);

// Curry Version von Math.pow
let powc = curry(
    Math.pow
);

console.log(
    powc(2)(4)
);

// zurückcurry
let pow = uncurry(
    powc
);

console.log(
    pow(2, 4)
);

// Zweierpotenzen mit curry
let zweierCurry = map(
    x => {
        x = powc(2)(x);
        console.log(x);
        return x;
    },
    [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
);

function curry<T, R, S>(
    f: (x: T, y:R) => S
) : (x: T) => (y: R) => S {
    return (x: T) => (y: R) => f(x, y);
}

function uncurry<T, R, S> (
    f: (x: T) => (y: R) => S
) : (x: T, y: R) => S {
        return (x: T, y: R) => f(x)(y);
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
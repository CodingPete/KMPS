/**
 * Created by peter on 28.05.2017.
 */

function count<T>(
    list: [T]
) :number {
        return reduce(
            x => y => x + 1,
            0,
            list
        );
}

function sum (
    numbers: [number]
) :number {
        return reduce(
            x => y => x + y,
            0,
            numbers
        )
}

function prod (
    numbers: [number]
) :number {
        return reduce(
            x => y => x * y,
            1,
            numbers
        );
}

function and(
    booleans: [boolean]
) :boolean {
        return reduce(
            x => y => x && y,
            true,
            booleans
        );
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

function filter<T, R> (
    p: (T) => (boolean),
    list: [T]
) :[R] {
        return reduce(
            x => y => {
                if(p(y)) x.push(y);
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
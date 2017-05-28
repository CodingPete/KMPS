/**
 * Created by peter on 28.05.2017.
 */

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
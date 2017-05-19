/**
 * Created by peter on 31.03.2017.
 */

let x = ['a', false, 'c', 1];

function odd(b:string|boolean): string|boolean {
    if(b) return 'a';
    else return false;
}

for(let i = 0; i < x.length; i++) {
    console.log(odd(x[i]));
}
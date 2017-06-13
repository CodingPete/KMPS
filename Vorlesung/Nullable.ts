/**
 * Created by peter on 09.06.2017.
 */
type User = {
    name : String
    age: number
}

let user1: User = {
    name : "Jan",
    age: 24
};  // age undefined, null, nan
// Das kann man konfigurieren, dass typescript den kram nicht akzeptiert.

// falsy "", 0, undefined, null
var numbers = [Any]()
numbers.append(42)
let s: String = (numbers[0] as String)
/*
Error: 'Any' is not convertible to 'String'; did you mean to use 'as!' to force downcast?
*/

let b : String = (numbers[0] as! String)
/* Crash */

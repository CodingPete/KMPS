
// Ein normales Array ist in Swift by-value. Dadurch kann es in der folgenden function
// nicht verändert werden.
func gimme_array() {
    let myArray = [Int]()
    let input = 4
    myArray.append(input)   // Error: cannot use mutating member on immutable value: 'myArray'
}


// Austausch des by-value Arrays gegen ein by-reference Array.
// Durch hinzufügen eines Wertes bleibt die Referenz auf das zugrunde Liegende Objekt unverändert
func gimme_array_working() {
    let myArray : NSMutableArray = [] 
    let input = 4
    myArray.add(input)
}

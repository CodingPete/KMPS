/**
 * Created by peter on 07.04.2017.
 */
function myFunction() {
    let x = 42;
    const y = 4242;

    x = 43;     // Variable lässt sich verändern
    y = 4343;   // Cannot assign to 'y' because it is a constant or a read-only property.
}

    // Was ist let ////////////////////////////////////////////////////////
    // Ähnlich wie Javascript's var.
    // Block scoped abwärts */
    let known_to_inner = 4;
    if(known_to_inner == 4) {
        known_to_inner = 2;         // Innerer Block kennt lets des umgebenen Blocks
        let unknown_to_outer = 5;
    }
    unknown_to_outer = 5;   // Äußerer Block kennt lets tieferer Blöcke nicht.

    // Neudeklaration nicht möglich */
    let redeclare = 42;
    let redeclare = 42; // Cannot redeclare block-scoped variable 'redeclare'


    // Was ist const ////////////////////////////////////////////////////////
    // Selbe Scoping-Regeln wie let
    // Kann nicht mehr verändert werden
    // Allerdings kann die darunter liegende Struktur verändert werden
    class Dragon {
        name: string;

        constructor(name: string) {
            this.name = name;
        }

        tuwatt() {
            return "Hi my name is " + name;
        }
    }

    const durgen = new Dragon("Puff the magic dragon");
    durgen.tuwatt();                // returns Hi my name is Puff...
    durgen.name = "Spyro";
    durgen.tuwatt();                // returns Hi my name is Spyro

    durgen = new Dragon("Grisou");  // Cannot assign to 'durgen' because it is a constant or read-only property


    // Was ist var ////////////////////////////////////////////////////////
    // Var ist die javascripttypische Variablendeklaration
    // Aus Kompatibilitätsgründen in Typescript enthalten
    // Var-Deklarationen sind innerhalb ihrer Umgebung stets erreichbar (Im Gegensatz zu let) (leak out)
    function blaa() {
        if(42) {
            var leaks_out = 5;
        }
        leaks_out = 5;          // Variable ist erreichbar
    }
    function bluu() {
        if(42) {
            let stays_inside = 5;
        }
        stays_inside = 32;      // Cannot find name 'stays_inside'
    }

    // Var-Deklarationen können stets redeclared werden und sich durch selbigen Scope überschreiben
    for(var i = 0; i < 10; i++) {
        for(var i = 10; i > 0; i++) {
            // Die For-Schleifen kommen sich durch die doppelte Deklaration von var i in die Quere
        }
    }

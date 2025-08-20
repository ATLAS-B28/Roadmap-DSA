/*
Derive the fmt:Debug impl for Structure. 
It is a structure which contains a single i32
*/
//#[derive(Debug)]
//struct Structure(i32);
/*
Put the Structure inside of the structure Deep.
Make it printable
*/
//#[derive(Debug)]
//struct Deep(Structure);
//pretty printing with {:#?}
/*#[derive(Debug)]
struct Persona<'a> {
    name: &'a str,
    age: u8
}

use std::fmt;

#[derive(Debug)]
struct MinMax(i64, i64);

impl fmt::Display for MinMax {
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        write!(f, "({}, {})", self.0, self.1)
    }
}

#[derive(Debug)]
struct Matrix2D {
    x: f64,
    y: f64,
}

impl fmt::Display for Matrix2D {
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        write!(f, "x: {}, y: {}", self.x, self.y)
    }
}

fn main() {
    println!("Hello world");
    let x = 28;
    println!("On this day: {}", x);
    println!("{:?} months in a year.", 12);
    println!("{1:?} {0:?} is the {actor:?} name.", "Brad", "Pitt", actor="actor's");
    let s = Structure(3);
    println!("This derived impl of Debug which is {:?} has value {:?}", s, s.0);
    let d = Deep(Structure(8));
    println!("The Deep Structure: {:?} has value {:?} and {:?}", d, d.0, d.0.0);
    let name = "Aditya";
    let age = 23;
    let aditya = Persona {name, age};
    println!("{:#?}", aditya);
    let minmax = MinMax(9,100);
    println!("Compare structures: ");
    println!("Display: {}", minmax);
    println!("Debug: {:?}", minmax);

    let big_range = MinMax(-300, 300);
    let small_range = MinMax(-3, 3);

    println!("The big range is {big} and small range is {small}", 
        small = small_range,
        big = big_range);

    let point = Matrix2D {x: 3.1415, y: 7.85};

    println!("Compare points: ");
    println!("Display: {}", point);
    println!("Debug: {:?}", point);
}*/

use std::fmt;

struct List(Vec<i32>);

impl fmt::Display for List {
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        let vector = &self.0; //extracting value using tuple indexing
        //and create a reference
        write!(f, "[")?;
        for (index, v) in vector.iter().enumerate() {
            if index != 0 {
                write!(f, ", ")?;
            }
            write!(f, "{}", index)?;
            write!(f, ": ")?;
            write!(f, "{}", v)?;
        }
        write!(f,"]")
    }
}

fn main() {
    let v = List(vec![1,2,3,4,5]);
    println!("{}", v);
}
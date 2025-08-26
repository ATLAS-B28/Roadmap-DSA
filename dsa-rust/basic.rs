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
}

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
}*/
//Variable Bindings - type safety via static typing is already there.
//we can annotate the bindings, but compiler can infer on its own
//they are immutable by default, but this can be overriddeb using the mut modifier
/*fn main() {
    let an_int = 1u32;
    let a_bool = true;
    let unit = ();
    let copy_int = an_int;
    let mut mutable = 1;
    println!("An int: {}", copy_int);
    println!("A bool: {}", a_bool);
    println!("Unit value: {:?}", unit);
    let _unused = 3u32;
    println!("Before mutation: {}", mutable);
    mutable += 1;
    println!("After mutation: {}", mutable);
}*/
//variable bindings have a scope, and are constrained to live in the block
//a block is a collection of statements enclosed by braces {}
/*fn main() {
    //let long_lived_var = 1;
    //{
     //   let short_lived = 2;
     //   println!("Inner short: {}", short_lived);
    //}
    //println!("Outer short: {}", short_lived);
    //println!("Outer long: {}", long_lived_var);
    //variable shadowing - occurs when a var declared within a certain
    //scope(inner block) has the same name as a var declared in outer scope
    //the inner scope var shadows the outer scope var
    let ninja = 1;
    {
        println!("Before being shadowed: {}", ninja);
        let ninja = "abc";//shadows the outer one
        println!("Shodowed in inner block: {}", ninja);
    }
    println!("Outside the block: {}", ninja);
    let ninja = 2;//this shadows the previous binding
    println!("Outside after being shadowed: {}", ninja);
    //declare first = its possible to declare variable bindings frist and
    //initialize them later, but declaraion is must before use
    let a_binding;

    {
        let x = 2;
        a_binding = x * x;
    }
    println!("a binding: {}", a_binding);

    let b_binding;
    //println!("Another binding: {}", b_binding);
    b_binding = 1;
    println!("Another binding: {}", b_binding);
    //freezing - when data is bound by the same name immutably, it also
    //freezes. Frozen data can't be modified until the immutable binding goes out of scope.
    let mut _mutable_int = 8i32;
    /*{
        //shadowing by immutable _mutable_int
        let _mutable_int = _mutable_int;
        _mutable_int = 50;//gives error
    }*/
    _mutable_int = 4;//this is not frozen
    println!("Mutable int after shadowing: {}", _mutable_int);
}*/
//Casting - no implicit type conversion exits, but explicit type conversion
//can be performed using 'as' keyword
/*#![allow(overflowing_literals)]
fn main() {
    let dec = 65.7763_f32;
    //let integer : u8 = dec;//gives error
    let integer = dec as u8;
    let character = integer as char;
    //let character = dec as character;//float cannot be converted conversion rules
    println!("Casting: {} -> {} -> {}", dec, integer, character);
    //when casting any value to unsigned type, T, std::T::MAX + 1 is added
    //or subtracted until the value fits into the new type
    println!("1000 as a u16 is: {}", 1000 as u16);
    println!("1000 as a u8 is: {}", 1000 as u8);
    //1000-256-256-256=232
    //1st 8 LSB are kept and while rest towards the MSB get truncated
    //-1+256=255
    println!("-1 as a u8 is: {}", (-1i8) as u8);
    //for +ve numbers this is the same as modulus
    println!("1000 mod 256 is: {}", 1000 % 256);
    //if the MSB bit of that value is 1 then value is -ve
    println!();
    //while casting to a signed type, the bitwise result is same as
    //1st casting to the corresponding unsigned type
    //unless it already fits
    println!("128 as a i16 is: {}", 128 as i16);
    //in boundary case 128 value is 8 bit 2's complement representation
    //is -128
    println!("128 as a i8 is: {}", 128 as i8);
    //1000 as u8 -> 232
    //232 as u16 -> 232
    //232 as i8 -> -24
    println!("1000 as a u8 is also: {}", 1000 as u8);
    println!("232 as a u16 is also: {}", 232 as u16);
    println!("232 as a i8 is also: {}", 232 as i8);
    //saturating cast - when casting from float to int. if floating
    //point value exceeds the upper bound or is less than lower bound,
    //returned value will be equal to bound crossed
    //300.0 as u8 is 255
    println!("300.0 as u8 is: {}", 300.0_f32 as u8);
    //-100.0 as u8 is 0
    println!("-100.0 as u8 is: {}", -100.0_f32 as u8);
    //nan as u8 is 0
    println!("nan as u8 is: {}", f32::NAN as u8);
    /*
    this behavior incurs a small runtime cost and can be avoided
    with unsafe methods, however the results might overflow and 
    return **unsound values**, use there methods wisely
     */
    unsafe {
        //300.0 as u8 is 44
        println!("300.0 as u8 is: {}", 300.0_f32.to_int_unchecked::<u8>());
        //-100.0 as u8 is 156
        println!("-100.0 as u8 is: {}", (-100.0f32).to_int_unchecked::<u8>());
        //nan as u8 is 0
        println!("nan as u8 is: {}", f32::NAN.to_int_unchecked::<u8>());
    }
    /**
     * Inference is strong in rust, it looks at vars at initialization
     * and also afterwards too
     */
    let ele = 5u8;//compiler knows coz of annotation
    let mut vec = Vec::new();//empty vector, compiler has no idea of the data type
    vec.push(ele);//now it knows the type
    println!("{:?}", vec);
}*/

//Aliasing - using type statment can be used to give a new name to an
//axisting type. Types must have UpperCamelCase names or compiler will
//raise a warning. Except for this are - usize, f32, etc
//its used to reduce boilerplate code.
/*type NanoSecond = u64;
type Inch = u64;
type U64 = u64;
type Sample = i64;

fn main() {
    let nanoseconds: NanoSecond = 5 as u64;
    let inches: Inch = 2 as u64;
    let sample: Sample = 3 as i64;
    println!("{} nanoseconds + {} inches = {} unit?", nanoseconds, inches, nanoseconds + inches);
    println!("i64 is: {}", sample);
}*/
//form trait allows for a type to define how to create itself from
//another type, hence providing simple mechanism for converting between several types.
//there numerous implementations of this trait within the STD for conversion
//of primitives and common types 
/*use std::convert::From;
use std::convert::Into;

#[derive(Debug)]
struct Number {
    value: i32,
}

//Into trait is simply the reciprocal of the From trait, it defines
//how to convert a type into another type.
//calling this requires us to specify the result type as compiler is unable
//to determine this most of the time.

#[derive(Debug)]
struct Number2 {
    value: i32,
}

impl Into<Number2> for i32 {
    fn into(self) -> Number2 {
        Number2 {value: self}
    }
}

impl From<i32> for Number {
    fn from(item: i32) -> Self {
        Number {value: item}
    }
}
//both traits are designed to be used interchangably as complementry
//implementation for both is not necessary, if from trait is implemented
//then into will call it when necessary, but converse is not true
//implementating into for your type will not automatically provide it 
//with an implementation of from
//TryFrom and TryInto are generic traits for converting between types,
//but used for fallible conversions and returns 'Result's

use std::convert::TryFrom;
use std::convert::TryInto;

#[derive(Debug, PartialEq)]
struct EvenNum(i32);

impl TryFrom<i32> for EvenNum {
    type Error = ();

    fn try_from(value: i32) -> Result<Self, Self::Error> {
        if value % 2 == 0 {
            Ok(EvenNum(value))
        }  else {
            Err(())
        }
    }
}
*/
//Converting to String - we use ToString trait for the type
//rather than doing so directly, one should implement fmt::Display trait
//which automatically provides toString and also allows printing the 
//type as discussed in the section on print!

use std::fmt;

struct Circle {
    rad: i32
}

impl fmt::Display for Circle {
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        write!(f, "Circle of radius {}", self.rad)
    }
}

fn main() {
    //let num = Number::from(30);
    //println!("My number is {:?}", num.value);
    //let int = 4;
    //let numm: Number2 = int.into();
    //println!("My number is {:?}", numm.value);

    //tryfrom
    //assert_eq!(EvenNum::try_from(8), Ok(EvenNum(8)));
    //assert_eq!(EvenNum::try_from(5), Err(()));

    //tryinto
    //let res: Result<EvenNum, ()> = 8i32.try_into();
    //assert_eq!(res, Ok(EvenNum(8)));
    //let res2: Result<EvenNum, ()> = 5i32.try_into();
    //assert_eq!(res2, Err(()));
    let circle = Circle {rad: 6};
    println!("{}", circle.to_string());
}
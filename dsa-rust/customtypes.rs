/*
Rust custom data types are formed mainly through the two keywords:
struct: define a structure
enum: define an enumeration
Constants can also be created via the const and static keywords.
*/
/**
 * Structures - 
 * There are 3 types of structs that can be created - 
 * Tuple structs, where are basically named tuples
 * classic C structs
 * Unit structs, field less allowed, used for generics
 */
/*#[allow(dead_code)]


#[derive(Debug)]
struct Person {
    name: String,
    age: u8,
}

//unit struct
struct Unit;//no fields

//a tuple struct
struct Pair(i32, f32);

//struct with 2 fields
struct Point {
    x: f32,
    y: f32,
}
#[warn(dead_code)]
//structs can be reused as fields of another struct
struct Rect {
    top_left: Point,
    bottom_right: Point,
}
//add a function rect_area which cal the area of rect and
//we do nested destructuring
fn rect_area(recttwo: Rect) -> f32 {
    let Rect {
        top_left: Point {x: left_edge, y: top_edge},
        bottom_right: Point {x: right_edge, y: bottom_edge}
    } = recttwo;
    (right_edge - left_edge) * (top_edge - bottom_edge)
}
//sqaure function using point of f32 type and returns a rectangle
fn square(point: Point, scale: f32) -> Rect {
    Rect {
        top_left: Point {x: point.x, y: point.y + scale},
        bottom_right: Point {x: point.x + scale, y: point.y}
    }
}

fn main() {
    //struct created with field init shorthand
    let name = String::from("Aditya");
    let age = 22;
    let aditya = Person {name, age};

    println!("{:?}", aditya);

    let point: Point = Point {x: 3.45, y: 45.6};
    let another_point: Point = Point {x: 4.6, y: 3.4};

    println!("point coordinates: ({}, {})", point.x, point.y);
    //struct update syntax is -
    let bottom_right = Point {x: 10.67, ..another_point};
    println!("second point: ({}, {})", bottom_right.x, bottom_right.y);

    //can do destructuring using let bindings
    let Point {x: left_edge, y: top_edge} = point;

    let _rect = Rect {
        top_left: Point {x: left_edge, y: top_edge},
        bottom_right: bottom_right,
    };

    let _unit = Unit;

    let pair = Pair(1,0.1);

    println!("pair contains: {:?} and {:?}", pair.0, pair.1);

    //destructure the tuple struct
    let Pair(integer, decimal) = pair;

    println!("pair contains {:?} and {:?}", integer, decimal);
    let recttwo = Rect {
        top_left: Point {x: 1.0, y: 4.0},
        bottom_right: Point {x: 5.0, y: 1.0},
    };
    println!("Area of rectangle is: {}", rect_area(recttwo));
    let square = square(Point{x: 1.0, y:3.0}, 6.0);
    println!("Square created with top left point at ({}, {})", square.top_left.x, square.top_left.y);
}*/
/**
 * Enum allows the creation of a type which may be one of a few different
 * variants. Any variant can be used as long as the other variants are
 * constructed in the same way
 * Enums can have different types as variants
 * Enums can be used to create a linked list
 * Enums can be used to implement a trait object
 */
/*enum WebEvent {
    //enum variants are - unit like
    PageLoad,
    PageUnload,
    //tuple like structs
    KeyPress(char),
    Paste(String),
    Click {x: i64, y: i64},//c like struct
}
//type alias can be used to refer the variants of enum
enum LongNameEnum {
    Add,
    Subtract,
}

//creating type alias
type Ops = LongNameEnum;

//most common use of type alias for enums is in impl blocks
//using the self as alias
enum LongNameEnum2 {
    Divide,
    Multiply,
}

//use declaration can be used so that we don't need manual scoping
#[allow(dead_code)]
enum Stage {
    Beginner,
    Advanced,
}
#[warn(unused_variables)]
enum Role {
    Student,
    Teacher,
}

impl LongNameEnum2 {
    fn run(&self, x: i32, y: i32) -> i32 {
        match self {
            Self::Divide => x / y,
            Self::Multiply => x * y,
        }
    }
}

fn inspect(event: WebEvent) {
    match event {
        WebEvent::PageLoad => println!("Page Loaded"),
        WebEvent::PageUnload => println!("Page Unloaded"),
        WebEvent::KeyPress(c) => println!("Pressed '{}'", c),
        WebEvent::Paste(s) => println!("Pasted \"{}\"", s),
        WebEvent::Click {x, y} => {
            println!("Clicked at x = {}, y = {}.", x, y);
        },
    }
}

enum Number {
    Zero,
    One,
    Two,//implicit discriminator starts at 0
}

enum Color {
    Red = 0xff0000,
    Green = 0x00ff00,
    Blue = 0x0000ff,
}

fn main() {
    let pressed = WebEvent::KeyPress('x');
    let pasted = WebEvent::Paste("my text".to_owned());
    let click = WebEvent::Click {x: 20, y: 30};
    let load = WebEvent::PageLoad;
    let unload = WebEvent::PageUnload;

    inspect(pressed);
    inspect(pasted);
    inspect(click);
    inspect(load);
    inspect(unload);

    let x = Ops::Add;
    let y = Ops::Subtract;
    match x {
        Ops::Add => println!("You chose addition"),
        Ops::Subtract => println!("You chose subtraction"),
    }

    let x = LongNameEnum2::Multiply;
    let y = LongNameEnum2::Divide;
    println!("10 * 2 = {}", x.run(10, 2));
    println!("10 / 2 = {}", y.run(10, 2));

    //explicit use each name so they are avialable without manual 
    //scoping
    use crate::Stage::{Beginner, Advanced};
    //automatically use each name inside the Role
    use crate::Role::*;
    let stage = Beginner;//equivalent to Stage::Beginner
    let role = Student;//equivalent to Role::Student

    match stage {
        Beginner => println!("Begineers are starting their learning journy"),
        Advanced => println!("Advanced learners are mastering their subjects"),
    }
    match role {
        Student => println!("Students are learning Rust"),
        Teacher => println!("Teachers are teaching Rust"),
    }

    println!("Zero is {}", Number::Zero as i32);
    println!("One is {}", Number:: One as i32);//enums can be cast as integers
    println!("Roses are #{:06x}", Color::Red as i32);
    println!("Violets are #{:06x}", Color::Blue as i32);
}*/
//linked-list using enums and list crate 
use crate::List::*;

enum List {
    //constructor - tuple struct that wraps the element and a 
    //poiner to the next node 
    Constructor(u32, Box<List>),
    //nil a node that signifies the end of the linked list
    Nil,
}

impl List  {
    fn new() -> List {
        Nil
    }
    fn prepend(self, ele: u32) -> List {
        Constructor(ele, Box::new(self))
    }
    fn len(&self) -> u32 {
        match *self {//*self points to list 
            Constructor(_, ref tail) => 1 + tail.len(),
            Nil => 0
        }
    }
    fn stringify(&self) -> String {
        match *self {
            Constructor(head, ref tail) => {
                format!("{}, {}", head, tail.stringify())
            },
            Nil => {
                format!("Nil")
            },
        }
    }
}

//constants - an unchangeable value use common case
//static a possibly mutable variable with static lifetime, the static
//lifetime is inferred and does not have to be specified, accessing
//or modifying a mutable static variable is unsafe 

//global scope
static LANGUAGE: &str = "RUST";
const THRESHOLD: i32 = 10;

fn is_big(n: i32) -> bool {
    n > THRESHOLD
}

fn main() {
    let mut list = List::new();

    list = list.prepend(1);
    list = list.prepend(2);
    list = list.prepend(3);

    println!("LL has length: {}", list.len());
    println!("{}", list.stringify());

    let n = 16;
    println!("This is {}", LANGUAGE);
    println!("The Threshold is {}", THRESHOLD);
    println!("{} is {}", n, if is_big(n) {"big"} else {"small"});
}
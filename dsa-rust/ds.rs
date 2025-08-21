use std::fmt::{self, Formatter, Display};
//tuples can be used as func arguments and as return a valuea
fn reverse(pair: (i32, bool)) -> (bool, i32) {
    let (int_param, bool_param) = pair;
    (bool_param, int_param)
}

#[derive(Debug)]
struct Matrix(f32, f32, f32, f32);

impl Display for Matrix {
    fn fmt(&self, f: &mut Formatter) -> fmt::Result {
        write!(f, "({:.2} {:.2} \n {:.2} {:.2})", self.0, self.1, self.2, self.3)
    }
}

//transpose of the matrix
impl Matrix {
    fn transpose(&self) -> Matrix {
        Matrix(self.0, self.2, self.1, self.3)
    }
}

fn main() {
    let long_tuple = (1u8, 2u16, 3u32, 4u64, -1i8, 
        -2i16, -3i32, -4i64, 0.1f32, 0.2f64, 'a', true);

    //values can be extracted from the tuple using tuple indexing
    println!("Long tuple first value: {}", long_tuple.0);
    println!("Long tuple second value: {}", long_tuple.1);

    let tuple_of_tuples = ((1u8, 2u16, 2u32), (4u64, -1i8), -2i16);

    println!("tuple of tuples: {:?}", tuple_of_tuples);

    let pair = (1, true);
    println!("Pair is {:?}", pair);

    println!("The reversed pair is {:?}", reverse(pair));

    println!("One element tuple: {:?}", (5u32,));
    println!("Just an integer: {:?}", (5u32));

    let tuple = (1, "Aditya", 4.5, true);//tuples can be destructured to create bindings

    let (a, b, c, d) = tuple;
    println!("{:?}, {:?}, {:?}, {:?}", a, b, c, d);

    let matrix = Matrix(1.1, 1.2, 2.1, 2.2);
    println!("Matrix:\n{}", matrix);
    println!("Transpose:\n{}", matrix.transpose())//transpose part of Matrix struct
}
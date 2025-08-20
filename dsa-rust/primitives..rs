/**
 * 
 * Scalar Types- 
 * Signed Integers - i8,i16,i32,i64,i128,isize<-pointer sizes
 * Unsigned Integers - u8,u16,u32,u64,u128,usize<-pointer sizes
 * Floating point - f32,f64
 * char unicode scalar values like 'a','α'and'∞' (4 bytes each)
 * bool either true or false
 * unit type () whose only possible value is an empty tuple: ()
 * 
 * Compound Types-
 * Arrays like [1,2,3]
 * Tuples like (1,true)
 * 
 * Type Annotations - used to explicityly declare the data type of a 
 * var, func param, return value. 
 * let var_name: Type;
 * fn fun_name(param_name: ParameterType) -> Return type
 * When to use them-
 * 1) Ambiguity in Type inference
 * 2) Function Signatures
 * 3) Static Items and Constants
 */

fn main() {
    let log: bool = true;
    let a_float: f64 = 1.09;
    let an_int = 58i32; //suffix annotation
    let default_float = 4.5;//implicit
    let default_int = 10; //implicit type annotations
    //using mutable
    //a type can be infered from the context too
    let mut inferred = 12; //type i64 is inferred from another lines
    inferred = 3458372;
    //mutable variable
    let mut mutable = 12;
    mutable = 43;//here it is mutable i32
    mutable = true;//but here its bool which will give error
    //we can overwrite with shadowing
    let mutable = true; //shadowing the previous mutable

    //Compound types
    let my_arr: [i32; 5] = [1,2,3,4,5];
    //tuple though is collection of different types
    let my_tuple = (5u32, 1u8, true, -5.90f32);
    //print statments for all the above ones
    println!("Log: {}", log);
    println!("Float: {}", a_float);
    println!("Int with suffix: {}", an_int);
    println!("Default Float: {}", default_float);
    println!("Default Int: {}", default_int);
    println!("Inferred: {}", inferred);
    println!("Mutable: {}", mutable);
    println!("Array: {:?}", my_arr);
    println!("Tuple: {:?}", my_tuple);
    //printing types
    println!("Type of log: {}", std::any::type_name::<bool>());
    println!("Type of a_float: {}", std::any::type_name::<f64>());
    println!("Type of an_int: {}", std::any::type_name::<i32>());
    println!("Type of default_float: {}", std::any::type_name::<f64>());
    println!("Type of default_int: {}", std::any::type_name::<i32>());
    println!("Type of inferred: {}", std::any::type_name::<i32>());
    println!("Type of mutable: {}", std::any::type_name::<bool>());
    println!("Type of my_arr: {}", std::any::type_name::<[i32; 5]>());
    println!("Type of my_tuple: {}", std::any::type_name::<(u32, u8, bool, f32)>());
    
}
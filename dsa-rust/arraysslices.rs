/**
 * Array is collection of objects of same type T, stored in
 * contiguous memory. Arrays are created using brackets [],
 * and their length, which is known at compile time, is part
 * their type signature [T; length]
 * Slice are similar to arrays, but their length is not known at 
 * compile time. A slice is a 2 word object, 1st is pointer to data
 * 2nd is length of slice. Word size is the same as usize, determined by
 * processor architecture. Slices are used to borrow a section of an array
 * and have the type signature &[T]
 */

use std::mem;
//this func borrows a slice
fn analysis_slice(slice: &[i32]) {
    println!("First element of slice: {}", slice[0]);
    println!("The slice has {} elements", slice.len());
}

fn main() {
    let xs : [i32; 5] = [1,2,3,4,5];
    let ys : [i32; 500] = [0; 500];//initialized to same value
    println!("First element of array: {}", xs[0]);
    println!("Second element of array: {}", xs[1]);

    //len returns the count of elements in array
    println!("Number of elements in array: {}", xs.len());

    //arrays are stack allocated
    println!("Array xs occupies {} bytes", mem::size_of_val(&xs));
    println!("Array ys occupies {} bytes", mem::size_of_val(&ys));

    ///arrays is now being automatically borrowed as slices
    println!("Borrow the whole array as a slice");
    analysis_slice(&xs);

    //Slices can point to a section of an array
    //they are of the form starting_idx...end_idx
    //starting_idx is 1st position in slice
    //end_idx is one more than the last position in slice
    println!("Borrow a section of array as a slice.");
    analysis_slice(&ys[1 .. 4]);

    let empty_array: [u32; 0] = [];//<- empty slice &[]
    assert_eq!(&empty_array, &[]);
    assert_eq!(&empty_array, &[][..]);

    for i in 0..xs.len() + 1 {
        match xs.get(i) {
            Some(xval) => println!("{}: {}", i, xval),
            //Optin<T> enum - Some and None are variants of it 
            //used to represent values that might be present or might be absent
            //its type that explicitly handles the possibility of a missing value
            //unlike null references
            None => println!("Slow down! {} is too far!", i),
        }
    }
}

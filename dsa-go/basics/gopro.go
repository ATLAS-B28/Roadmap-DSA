package main
///learn unio types ,buffers
import "fmt"

type Person struct {
	name   string
	age    int
	job    string
	salary float64
}

func myMessage(fname string, lname string) {
	fmt.Println("Hello ", fname, lname)
}

func add(x int, y int) (result int) {
	result = x + y
	return
}

func getSalary(pers Person) float64 {
	return pers.salary
}
func multiInput(x int, y string) (result int, txt1 string) {
	//here the 2nd braces are the return vars and their data types
	result = x + x
	txt1 = y + " World!"
	return
}

func mapSample(m int) string {
	a := make(map[int]string)
	a[1] = "Aditya"
	a[2] = "Abhijeet"
	return a[m]
}
func main() {
	myMessage("Aditya", "Bhambere")
	fmt.Println(add(10, 20))
	_, b := multiInput(10, "Aditya")
	fmt.Println(b)
	a, _ := multiInput(10, "Aditya")
	fmt.Println(a)
	//initiate struct
	p1 := Person{
		name:   "Aditya",
		age:    20,
		job:    "Student",
		salary: 50000.0,
	}
	fmt.Println(p1)
	fmt.Println(p1.name)
	fmt.Println(p1.age)
	fmt.Println(getSalary(p1))
	fmt.Println(mapSample(2)) //the return type refers to the value's type

	var v = make(map[string]string)
	var w map[string]string
	fmt.Println(v == nil) //not empty
	fmt.Println(w == nil) //it is true it is empty

	e := map[string]int{"one": 1, "two": 2, "three": 3}
	for k, v := range e {
		fmt.Println(k, " -> ", v)
	}
	// define an order using a new array_string and then append it as
	var f []string
	f = append(f, "one", "two", "three") //<- append it this way
	for _, element := range f {          //then iterate over it
		fmt.Printf("%v -> %v\n", element, e[element]) //but call the e's element
	}
}

//code-snippet
/*x := 10
var y string = "Aditya"
c, d := 28, "Aditya"
const PI = 3.145
var i int = 15
fmt.Printf("%b\n", i)
fmt.Printf("%+d\n", i)
fmt.Printf("%O\n", i)
fmt.Println(x)
fmt.Println(y)
fmt.Printf("%T\n", c)
fmt.Printf("%v", c)
fmt.Printf("%T\n", d)
fmt.Println(PI)
fmt.Println("Hello World")*/
//arrays
/*
		arr := [...]int{2, 3, 4, 6}
		fmt.Println(arr)
		fmt.Println(arr[0])
		arr[2] = 10
		fmt.Println(arr)
		arr1 := [...]string{1: "Aditya", 2: "Abhijeet"}
		fmt.Println(arr1)
	///slices
	//array_string to slice
	var myarray = [...]int{1, 2, 3, 4, 5}
	var slice = myarray[1:4] //<- slice made form array_string
	fmt.Println(slice)
	fmt.Printf("Length = %d\n", len(slice))   //no.of elements in slice
	fmt.Printf("Capacity = %d\n", cap(slice)) //no.of elements in slice can grow or shrink to
	slice = append(slice, 6)
	fmt.Println(slice)
	slice2 := []int{1, 2, 4, 5}
	slice3 := append(slice, slice2...)
	fmt.Printf("Length = %d\n", len(slice3))
	fmt.Printf("Capacity = %d\n", cap(slice3))
	fmt.Printf("%v\n", slice3)
	numbers := []int{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}
	fmt.Println(numbers)
	copyNum := numbers[:len(numbers)-10]
	//cap and len of numbers is 15 and we did 15-10 = 5
	numCopy := make([]int, len(copyNum))
	copy(numCopy, copyNum)
	fmt.Printf("After copying-\n")
	fmt.Println(numCopy)*/
//if else loops
/*x := 18
y := 20
if x > y {
	fmt.Println("x is greater than y")
} else {
	fmt.Println("y is greater than x")
}
//for loop
for i := 0; i < 5; i++ {
	if i == 3 {
		continue
	}
	fmt.Println(i)
}
fruits := [3]string{"apple", "banana", "mango"}
for v, _ := range fruits {
	fmt.Printf("%v\n", v)
}*/

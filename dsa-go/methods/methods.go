package main

import "fmt"

/*
so here we see the concept of methods
where go automactically calls the methods based
on value or pointer receiver types
*/

type Rect struct {
	width, height int
}

func (r *Rect) area() int { //area method is defined with a receiver of type pointer to *Rect
	//cause method receives the memory address of the struct
	//any changes made are reflected in the struct
	return r.width * r.height
	//operates directly on the struct
}

func (r Rect) perim() int { //perim method is defined with a receiver of type Rect
	//it works on the copy and not the struct itself
	return 2*r.width + 2*r.height
}

func main() {
	r := Rect{width: 10, height: 5} //value receiver
	fmt.Println("area: ", r.area())
	fmt.Println("perim: ", r.perim())

	rp := &r //pointer receiver
	fmt.Println("area: ", rp.area())
	fmt.Println("perim: ", rp.perim())
}

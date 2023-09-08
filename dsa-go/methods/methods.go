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

func (r *Rect) area() int {
	return r.width * r.height
}

func (r Rect) perim() int {
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

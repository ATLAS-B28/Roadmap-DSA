package main

/*
In Go, a type is considered to implement an
interface if it has the same method
signatures as the interface specifies
. If a type has a method with the same
name and signature as the methods defined
in an interface, it will automatically
be considered as implementing
that interface.
*/
import (
	"fmt"
	"math"
)

type geometry interface {
	area() float64
	perim() float64
}

type rect struct {
	width, height float64
}

type circle struct {
	radius float64
}

func (r rect) area() float64 {
	return r.width * r.height
}

func (r rect) perim() float64 {
	return 2*r.width + 2*r.height
}

func (c circle) area() float64 {
	return math.Pi * c.radius * c.radius
}

func (c circle) perim() float64 {
	return 2 * math.Pi * c.radius
}

func measure(g geometry) {
	fmt.Println(g)
	fmt.Println(g.area())
	fmt.Println(g.perim())
}

func main() {
	r := rect{width: 10, height: 5}
	c := circle{radius: 10}
	measure(r)
	measure(c)
}

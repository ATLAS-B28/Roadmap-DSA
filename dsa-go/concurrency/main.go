package main

/*
Goroutines are lightweight,
independently executing functions
that run concurrently with other
goroutines. You can create a
goroutine by prefixing a function
call with the go keyword.

import (
	"fmt"
	"time"
)

func sayHello() {
	for i := 0; i < 5; i++ {
		fmt.Println("Hello")
		time.Sleep(100 * time.Millisecond)
	}
}
func sayWorld() {
	for i := 0; i < 5; i++ {
		fmt.Println("World")
		time.Sleep(150 * time.Millisecond)
	}
}

func main() {
	go sayHello()
	go sayWorld()
	time.Sleep(1 * time.Second)
}
*/
/*
Channels are used to communicate
and synchronize data between
goroutines. They provide a
safe way to send and receive
values. Here's an example
of using channels to communicate
between goroutines


import "fmt"

func sum(nums []int, result chan<- int) {
	//The result parameter is a channel of
	//type int used to send the result back.
	sum := 0
	for _, num := range nums {
		sum += num
	}
	result <- sum
}

func main() {
	nums := []int{1, 2, 3, 4, 5}
	result := make(chan int)
	go sum(nums[:len(nums)/2], result)
	go sum(nums[len(nums)/2:], result)

	sum1 := <-result
	sum2 := <-result

	totalSum := sum1 + sum2
	fmt.Println("Total sum: ", totalSum)
}
*/

import (
	"fmt"
	"sync"
	"time"
)

var counter int
var mutex sync.Mutex

func increment() {
	mutex.Lock()
	defer mutex.Unlock()
	counter++
}

func main() {
	for i := 0; i < 10; i++ {
		go increment()
	}

	time.Sleep(time.Second)
	fmt.Println("Counter:", counter)
}

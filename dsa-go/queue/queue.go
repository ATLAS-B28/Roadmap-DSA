package main

import "fmt"

type Queue struct {
	items []int
}

func (q *Queue) Enqueue(item int) {
	q.items = append(q.items, item)
}

func (q *Queue) Dequeue() int {
	if len(q.items) == 0 {
		panic("Queue is empty")
	}
	item := q.items[0]
	q.items = q.items[1:]
	return item
}

func (q *Queue) isEmpty() bool {
	return len(q.items) == 0
}
func main() {
	queue := Queue{}
	queue.Enqueue(10)
	queue.Enqueue(20)
	queue.Enqueue(30)
	fmt.Println(queue)
	fmt.Println("Is the queue empty? ", queue.isEmpty())
	item := queue.Dequeue()
	fmt.Println("Dequeued item: ", item)
	fmt.Println(queue)
}

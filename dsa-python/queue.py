from collections import deque

class Queue:
    def __init__(self):
        self.items = deque()

    def is_empty(self):
        return len(self.items) == 0
    
    def enqueue(self, item):
        self.items.append(item)

    def dequeue(self):
        if self.is_empty():
            raise Exception("Queue is empty")
        return self.items.popleft()
    
    def size(self):
        return len(self.items)
    
    def print_queue(self):
        print(self.items)


queue = Queue()
queue.enqueue(1)
queue.enqueue(2)
queue.enqueue(3)
queue.print_queue()

queue.dequeue()
queue.print_queue()
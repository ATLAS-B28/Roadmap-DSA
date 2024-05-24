class Stack:
    def __init__(self):
        self.items = []

    def is_empty(self):
        return self.items == []
    
    def push(self,item):
        self.items.append(item)

    def pop(self):
        if self.is_empty():
            return "Stack is empty"
        return self.items.pop()
    
    def peek(self):
        if self.is_empty():
            return "Stack is empty"
        return self.items[-1]
    
    def size(self):
        return len(self.items)
    
    def print_stack(self):
        print(self.items)

stacks = Stack()
stacks.push(1)
stacks.push(2)
stacks.push(3)
stacks.push(4)
stacks.push(5)
stacks.print_stack()
stacks.pop()
stacks.print_stack()
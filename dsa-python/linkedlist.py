class Node:
    def __init__(self,data=None):
        self.data = data
        self.next = None

class LL:
    def __init__(self):
        self.head = None

    def add_node(self,data):
        new_node = Node(data)
        if not self.head:
            self.head = new_node
            return
        last = self.head
        while last.next:
            last = last.next
        last.next = new_node

    def delete_node(self,data):
        if not self.head:
            return
        if self.head.data == data:
            self.head = self.head.next
            return
        curr=self.head
        while curr.next:
            if curr.next.data == data:
                curr.next = curr.next.next
                return
            curr = curr.next

    def print_list(self):
        curr = self.head
        while curr:
            print(curr.data, end = "<-")
            curr = curr.next
        print()

ll = LL()
ll.add_node(1)
ll.add_node(2)
ll.add_node(3)
ll.add_node(4)
ll.add_node(5)
ll.delete_node(4)
ll.print_list()
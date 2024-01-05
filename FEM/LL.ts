
namespace LinkedListModule{
    class Node<T> {
      value: T;
      next: Node<T> | null;

      constructor(value:T){
        this.value = value;
        this.next = null;
      }
    }


   export class LinkedList<T> {
     private head: Node<T> | null;
     private tail: Node<T> | null;

     constructor(){
        this.head = null;
        this.tail = null;
     }

     isEmpty(): boolean {
        return this.head === null;
     }

     append(value: T): void {
        const newNode = new Node(value);

        if(this.isEmpty()){
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail!.next = newNode;
            this.tail = newNode;
        }
     }

     prepend(value: T): void {
        const newNode = new Node(value);

        if(this.isEmpty()){
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
     }

     delete(value: T): void {
        if(this.isEmpty()){
            return;
        }

        if(this.head!.value === value){
            this.head = this.head!.next;
            if(this.head === null){
                this.tail = null;
            }
            return;
        }

        let currentNode: Node<T> | null = this.head;
        let prevNode: Node<T> | null = null;

        while(currentNode !== null){
            if(currentNode.value === value){
                if(prevNode !== null){
                    prevNode.next = currentNode.next;
                    if(currentNode == this.tail){
                        this.tail = prevNode;
                    }
                    return;
                }
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
     }

     print(): void {
        if(this.isEmpty()){
            console.log("List is empty");
            return;
        }

        let currentNode = this.head;

        while(currentNode !== null){
            console.log(`<-${currentNode.value}`);
            currentNode = currentNode.next;
        }
     }
    }
}
const LL = new LinkedListModule.LinkedList<number>();
LL.append(1);
LL.append(2);
LL.append(3);
LL.append(4);
LL.print();

LL.prepend(0);
LL.print();

LL.delete(3);
LL.print();


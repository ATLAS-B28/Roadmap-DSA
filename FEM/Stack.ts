class Stack<T> {
    private stack: T[];
    constructor() {
        this.stack = [];
    }

    isEmpty(): boolean {
        return this.stack.length === 0;
    }

    push(item: T): void {
        this.stack.push(item);
    }

    pop(): T | undefined {
        return this.stack.pop();
    }

    peek(): T | undefined {
        return this.stack[this.stack.length-1];
    }

    size(): number {
        return this.stack.length;
    }

    print(): void {
        console.log(this.stack);
    }
}

const st = new Stack<number>();
st.push(1);
st.push(2);
st.push(3);
st.push(4);
st.push(5);
st.print();

console.log(st.pop());

console.log(st.peek());

console.log(st.size());

st.print();

console.log(st.isEmpty());
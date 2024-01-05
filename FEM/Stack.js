var Stack = /** @class */ (function () {
    function Stack() {
        this.stack = [];
    }
    Stack.prototype.isEmpty = function () {
        return this.stack.length === 0;
    };
    Stack.prototype.push = function (item) {
        this.stack.push(item);
    };
    Stack.prototype.pop = function () {
        return this.stack.pop();
    };
    Stack.prototype.peek = function () {
        return this.stack[this.stack.length - 1];
    };
    Stack.prototype.size = function () {
        return this.stack.length;
    };
    Stack.prototype.print = function () {
        console.log(this.stack);
    };
    return Stack;
}());
var st = new Stack();
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

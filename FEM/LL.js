var LinkedListModule;
(function (LinkedListModule) {
    var Node = /** @class */ (function () {
        function Node(value) {
            this.value = value;
            this.next = null;
        }
        return Node;
    }());
    var LinkedList = /** @class */ (function () {
        function LinkedList() {
            this.head = null;
            this.tail = null;
        }
        LinkedList.prototype.isEmpty = function () {
            return this.head === null;
        };
        LinkedList.prototype.append = function (value) {
            var newNode = new Node(value);
            if (this.isEmpty()) {
                this.head = newNode;
                this.tail = newNode;
            }
            else {
                this.tail.next = newNode;
                this.tail = newNode;
            }
        };
        LinkedList.prototype.prepend = function (value) {
            var newNode = new Node(value);
            if (this.isEmpty()) {
                this.head = newNode;
                this.tail = newNode;
            }
            else {
                newNode.next = this.head;
                this.head = newNode;
            }
        };
        LinkedList.prototype.delete = function (value) {
            if (this.isEmpty()) {
                return;
            }
            if (this.head.value === value) {
                this.head = this.head.next;
                if (this.head === null) {
                    this.tail = null;
                }
                return;
            }
            var currentNode = this.head;
            var prevNode = null;
            while (currentNode !== null) {
                if (currentNode.value === value) {
                    if (prevNode !== null) {
                        prevNode.next = currentNode.next;
                        if (currentNode == this.tail) {
                            this.tail = prevNode;
                        }
                        return;
                    }
                }
                prevNode = currentNode;
                currentNode = currentNode.next;
            }
        };
        LinkedList.prototype.print = function () {
            if (this.isEmpty()) {
                console.log("List is empty");
                return;
            }
            var currentNode = this.head;
            while (currentNode !== null) {
                console.log("<-".concat(currentNode.value));
                currentNode = currentNode.next;
            }
        };
        return LinkedList;
    }());
    LinkedListModule.LinkedList = LinkedList;
})(LinkedListModule || (LinkedListModule = {}));
var LL = new LinkedListModule.LinkedList();
LL.append(1);
LL.append(2);
LL.append(3);
LL.append(4);
LL.print();
LL.prepend(0);
LL.print();
LL.delete(3);
LL.print();

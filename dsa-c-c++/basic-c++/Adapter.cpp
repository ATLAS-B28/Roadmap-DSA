//Adapter
/**
 * They are classes that modify or extend the bheavior
 * of existing classes or functions.
 * 2 Commonly used adapters are:
 * 1. Stack
 * 2. Queue
*/

#include <iostream>
#include <stack>

int main() {
    std::stack<int> myStack;

    myStack.push(10);
    myStack.push(20);
    myStack.push(30);
    myStack.push(40);

    std::cout << "Top element: " << myStack.top() << std::endl;

    myStack.pop();

    std::cout << "Top element: " << myStack.top() << std::endl;

    return 0;
}
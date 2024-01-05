//Templating
/**
 * Templates in C++ provide a way to write reusable and generic code, 
 * allowing you to write algorithms and data structures that can work with 
 * different types without sacrificing performance or type safety.
*/

//Function templates
/**
 * Function Templates: Function templates allow you to define a generic 
 * function that can be used with different types. The type parameter(s) are 
 * specified within angle brackets (<>) before the function declaration. 
 * Example: template <typename T> void foo(T value) { ... }. 

#include <iostream>

template<typename T>
T max(T a,T b) {
    return (a > b) ? a : b;
}

int main() {
    int maxInt = max(5 ,4);//T deduced as integer
    double maxDouble = max(3.12, 5.67);//T deduced as double
    std::cout << maxInt << std::endl;
    std::cout << maxDouble << std::endl;
    return 0;
}*/

//Class templates
/**
 * Class Templates: Class templates allow you to define a generic class 
 * that can be used with different types. The type parameter(s) are 
 * specified within angle brackets (<>) after the class name. 
 * Example: template <typename T> class MyClass {  code  };

#include <iostream>
#include <vector>

template <typename T>
class Stack {
    private:
       std::vector<T> eles;
    public:
       void push(T ele) {
        eles.push_back(ele);
       }

       T pop() {
        T top = eles.back();
        eles.pop_back();
        return top;
       }
};

int main() {
    Stack<int> intStack;
    intStack.push(10);
    intStack.push(20);
    int top1 = intStack.pop();
    std::cout << top1 << "\n";

    Stack<std::string> stringStack;
    stringStack.push("Hello");
    stringStack.push("World");
    std::string top2 = stringStack.pop();
    std::cout << top2 << "\n";
    return 0;
}

//Template specialization
/**
 * Template specialization: Template specialization allows you to define a
 * specific version of a template that can be used with different types.

#include <iostream>

template <typename T>
void print(T value) {
    std::cout << "Generic: " << value << std::endl;
}

template <>
void print<int>(int value) { // template argument used to specify the concrete types
                            //  that should be used in the specialization
    std::cout << "Specializes: " << value << std::endl;
}

int main() {
    print("Hello");
    print(42);
    return 0;
}*/

//Template recursion - allows compile time computations or perform complex
//computations
/*
#include <iostream>

template <int N>
struct Factorial
{
    static constexpr int value = N * Factorial<N - 1>::value;
};

template <>
struct Factorial<0>
{
    static constexpr int value = 1;
};

int main() {
    constexpr int factorialOf10 = Factorial<10>::value;
    std::cout << factorialOf10 << std::endl;
    return 0;
}
*/

/*Template Type Traits - templates that provide
 *information about types at compile time. They
 *allow you to use type information of the type 
 *and perform tyoe-based optimizations or logic.
*/

#include <type_traits>
#include <iostream>

template <typename T>
void printType() {
    if(std::is_integral<T>::value) {
        std::cout << "Type is an integer" << std::endl;
    } else {
        std::cout << "Type is not an integer" << std::endl;
    }
}

int main() {
    printType<int>();
    printType<double>();
    return 0;
}
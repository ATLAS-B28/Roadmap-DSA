//Allocators
/**
 * They provide a way to allocate and deallocate memory
 * for objects and containers. They provide
 * customized way to manage memory.
 * There is a default allocator that allocates memory
 * or we can override it with our own implementation.
*/

#include <iostream>
#include <vector>
#include <memory>

//custom allocator that prints a message
//when memory is deallocated
template <typename T>
struct MyAllocator
{
   using value_type = T;

   MyAllocator() noexcept {};

   template <typename U>
   MyAllocator(const MyAllocator<U>&) noexcept {};

   T* allocate(std::size_t n) {
    std::cout << "Allocating memory for " << n << " objects" << std::endl;
    return static_cast<T*>(::operator new(n * sizeof(T)));
   }

   void deallocate(T* p, std::size_t n) {
    std::cout << "Deallocating memory for " << n << " objects" << std::endl;
    ::operator delete(p);
   }
};

int main() {
    std::vector<int, MyAllocator<int>> myVector;

    myVector.push_back(10);
    myVector.push_back(20);
    myVector.push_back(30);

    return 0;
}

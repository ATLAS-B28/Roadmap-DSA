#include <iostream>
#include <memory>

using namespace std;

int main(){
    //allocate memory for an integer
    int* ptr = new int;
    //assign a value to the integer
    *ptr = 10;//* dereferences the pointer, 
    //allowing access to value stored 
    //at the memory at the location pointed 
    //to by ptr
    //print the value of the integer
    std::cout << *ptr << std::endl;//value printed pointed by ptr
    std::cout << ptr << std::endl; //prints the value of pointer itself,
    // which is the memory address of the allocated integer value
    std::cout << &ptr << std::endl;//address-of operator is used to obtain memory address
    //of variable 'ptr' 
    //deallocate the memory
    delete ptr;
    //unique pointer
    unique_ptr<int> ptr3 = make_unique<int>(40);
    //A move-only smart pointer that manages unique ownership of a resource.
    cout<<*ptr<<endl;
    // No need to manually delete the memory, it will be automatically 
    //released when ptr goes out of scope
    //shared pointer
    shared_ptr<int> ptr4 = make_shared<int>(50);
    shared_ptr<int> ptr5 = ptr4;
    cout<<*ptr4<<endl;
    cout<<*ptr5<<endl;
    // Memory is automatically released when all shared_ptr instances go out of scope
    shared_ptr<int> sharedPtr = make_shared<int>(42);
    weak_ptr<int> weakPtr = sharedPtr;
    // weakPtr shares ownership but doesn't increase reference count
    cout<<*sharedPtr<<endl;
    // To access the object, weakPtr needs to be locked to a shared_ptr
    if(auto lockedPtr = weakPtr.lock()){
        cout<<*lockedPtr<<endl;
    }else{
        cout<<"Object no longer exists"<<endl;
    }
    return 0;
}
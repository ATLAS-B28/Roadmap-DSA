#include <iostream>
#include <string>
using namespace std;

//basic object and class

class Test{
    public:
       int myInt;
       void myFunc(){
           printf("myInt: %d\n", myInt);
       }
};

//inheritance

class Shape{
    public:
     void setColor(string color){
         this->color = color;
     }
     void draw(){
        cout << "Drawing a shape with color: " << color << endl;
     }
    private :
        string color;
};

class Circle : public Shape{
    public:
      void setRadius(double radius){
        this->radius = radius;
      }
      void draw(){
        cout << "Drawing a circle with radius: " << radius << endl;
      }
    private:
       double radius;
};
//polymorphism
//runtime polymorphism - uses virtual functions. A subclass 'overrides' the base class implementation.

class Shape2{
  public:
    virtual void draw(){//<- virtual keyword is used to mark the function in base calss as virtual
    //used when abstract classes, polymorphic behaviour, runtime binding.
      cout<<"Drawing a shape."<<endl;
    }
};

class Circle2 : public Shape2{
   public:
     void draw(){
      cout << "Drawing a circle." << endl;
     }
};

//compile-time polymorphism - uses 'overloading' function technique. Appropriate function call decided by compiler based on arguments.

void print(int num){
    cout << "Integer: " << num << endl;
}

void print(double num){
  cout << "Double: " << num << endl;
}
//abstraction
class Shape3{
  public:
     virtual void draw() = 0;//pure virtual function
     virtual ~Shape3() {}
};

class Circle3 : public Shape3{
  public:
     void draw(){
       cout << "Drawing a circle." << endl;
     }
};

//interface
class Printable{
  public:
     virtual void print() const = 0;
     virtual ~Printable() {} // destructor - called before object of a class is destroyed to clean up memory
};

class Book : public Printable{
  public:
     void print() const{
      cout << "Printing a book." << endl;
     }
};

class Magazine : public Printable{
  public:
     void print() const{
      cout << "Printing a magazine." << endl;
     }
};

void printObjects(const Printable* const objects[],int count){
  for(int i = 0; i < count; i++){
    objects[i]->print();
  }
}

int main(){
    Test myClass;
    Circle c1;

    Shape2* shapePtr = new Circle2();
    shapePtr->draw();
    delete shapePtr;

    Shape3* shapePtr2 = new Circle3();
    shapePtr2->draw();
    delete shapePtr2;
    
    Book book;
    Magazine magazine;

    Printable* objects[] = { &book, &magazine};
    printObjects(objects,2);

    myClass.myInt = 10;
    myClass.myFunc();
    c1.setColor("red");
    c1.setRadius(10);
    c1.draw();
    print(10);
    print(3.14);
    return 0;
}
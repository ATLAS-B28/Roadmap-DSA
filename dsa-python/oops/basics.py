'''
Here
Sample Class 
class Object:
    class_variable=some value
    instance_variable
    __private_variable
    def __init__(self, param1, param2):<-constructor(parameterized)
        self.instance_variable = param1
    def __str___():<- dunder method
        string format to print object 
    def __init__():<-non parameterized
        Some code
    def some_method(self, param1, param2):
        self.instance_variable = param1
    def __display_call(self):<-used to access private variable
        self.__private_variable
    def calling_private_func(self):<-calling private method indirectly via another func
        self.__display_call(self)
    @class_method <-decorator
    def class_method(self, params..):
        some code
    @static_method <- no need of cls or self can be called directly, not bound to any class or 
    its instances, cannot access the class attributes and method needs explicit passing
    generally used as utility functions
    def static_method(params....):
        some code
    
Here obj = Object(param1, param2) <-constructor allows as it is called automatically

Name Mangling - object.__Object__private_variable rarely used        

Objects - realworld entity, represents an instance of class
Instance/object variables - Their copies with instance based values and are scoped to that particular object only, 
cannot be shared and accessed only via -

   object.obj_variable where object = Object()

Within the class we access instance variable with -

   self.obj_variable where self refers to the Object

Class - Metadata/template and contains the attributes and behaviors of its object instance
All this allow an object to have state and ability to operate on it
Class variables - Once instanisated persists across all the instances of a class and can be accessed via -

   object.class_variable or Object.class_variable where object = Object
   object.static_method() or Object.static_variable() where object = Object

Encapsulation - A class hides implementation details while letting a specific kind of access to its
inner details. Encapsulation = Data Bundling + Access Control

Inheritance - Certain attributes and behaviors can be accessed and used elsewhere from the origin
can lead to a strict heirarchy in code 

Polymorphism - The objects take different form and exhibit different behaviors to same message
 Same message = uniform interface/method call
 Different forms = different object types/classes
 Different behaviors = different implementations

In python we have method overriding(runtime) and operator overloading(compiled), no method overloading
A code has polymorphic classes when we focus on composition allowing classes to be used in
other classes allowing a code to be losely coupled

Abstraction - Abstraction is primarily about hiding implementation details.
Ability to define attributes and behavior which could later be implemented elsewhere
Could be concerte and abstract behavior is allowed 

Key Benefits:
Abstraction hides implementation complexity
Polymorphism allows treating different objects uniformly ->
  "Uniformly" refers to when the decision is made about which implementation to use:
   Compile-Time Polymorphism (Static)
    Decision made during compilation - uniform interface, different parameter signatures
   Runtime Polymorphism (Dynamic)
    Decision made during execution - uniform interface, same method signature
Together: Write code once, work with many implementations

Interface - Similar to abstraction, but defines contracts and enforces them strictly 
on implementing entities, all behaviors are abstract in nature

How They Achieve Abstraction:
Contract Definition: Define WHAT methods exist, not HOW they work
Force Implementation: Subclasses must provide the actual logic
Hide Complexity: User interacts with simple method calls
Polymorphism: Same interface, different implementations
Key Difference:
Abstract Class: Can have some concrete methods (partial hiding)
Interface: All methods abstract (complete hiding)

Overriding = Same params, different implementations (runtime)
Method Overriding (Runtime Polymorphism):
Same method signature (name + parameters)
Different implementations in child classes
Decided at runtime based on object type

Overloading = Different params, different implementations (compile-time)
Method Overloading (Compile-time Polymorphism):
Same method name but different parameters
Different implementations based on parameter types/count
Decided at compile time

Abstract and interface focus on overriding here only thing is abstract allow some defaults and 
interface enforces strict overriding(subject to change)


class Box:
    length = 0
    breadth = 0
    def set_dimension(self, length, breadth):
        self.length = length
        self.breadth = breadth
        return self.length, self.breadth
    def cal_area(self):
        return self.length * self.breadth
    def cal_perimeter(self):
        return 2 * (self.length + self.breadth)
    
box = Box()
length = int(input("Enter length:"))
breadth = int(input("Enter breadth:"))
box.set_dimension(length, breadth)
print("Area:",box.cal_area())
print("Perimeter:", box.cal_perimeter())'''

#employee class with id, name, basic, then cal_sal with ta, da and precentages of each from the basic
class Employee:
    id = 0
    name = ""
    basic = 0
    desg = ""
    def set_attr(self, id, name, basic, desg):
        self.id = id
        self.name = name
        self.basic = basic
        self.desg = desg

    def cal_sal(self):
        ta = 0.1 * self.basic
        da = 0.12 * self.basic
        hra = 0.15 * self.basic
        return self.basic + ta + da + hra
    
#taking input and creating a dict of id and employee class object
employees = {}
n = int(input("Enter number of employees:"))
for i in range(n):
    for j in range(1):
        id = int(input("Enter employee id:"))
        name = input("Enter employee name:")
        basic = int(input("Enter employee basic:"))
        desg = input("Enter employee designation:")
        emp = Employee()
        emp.set_attr(id, name, basic, desg)
        employees[id] = emp

print("Employee Details: ")
for id, emp in employees.items():
    print(f"ID: {id}\t", end="")
    print(f"Name: {emp.name}\t", end="")
    print(f"Designation: {emp.desg}\t", end="")
    print(f"Salary: {emp.cal_sal()}")
    print()

#cannot instantiate abstract class and access their properties, and subclass implementation is compulsory
from abc import ABC, abstractmethod

class Shape(ABC):
    @abstractmethod
    def area(self,name):
        pass
    @abstractmethod
    def perimeter(self):
        pass
class Circle(Shape):
    def __init__(self, radius, name):
        self.radius = radius
        self.name = name 
    def area(self):
        return self.name, round(3.14 * self.radius ** 2)
    def perimeter(self):
        return round(2 * 3.14 * self.radius)
class Rectangle(Shape):
    def __init__(self, length, breadth):
        self.length = length
        self.breadth = breadth
    def area(self):
        return self.length * self.breadth
    def perimeter(self):
        return 2 * (self.length + self.breadth)
    
c1 = Circle(5,"circle")
r1 = Rectangle(5, 10)
print(c1.area())
print(c1.perimeter())
print(r1.area())
print(r1.perimeter())
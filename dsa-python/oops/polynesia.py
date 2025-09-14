'''
Polymorphism - 

Runtime Polymorphism -
Method overriding - same method name with different parameters, can have default params or pass word is used to leave it ambiguous

Compile time Polymorphism -
Operator overloading - same operator with different parameters using dunder methods
'''
class Vehicle:
    name = None
    color = None
    price = None
    manufacturer = None
    gear = None
    segment = None
    engine = None
    def __init__(self, name, color, price, manufacturer, engine, gear, segment):
        self.name = name
        self.color = color
        self.price = price
        self.manufacturer = manufacturer
        self.engine = engine
        self.gear = gear
        self.segment = segment

    def detials(self):
        return (f"Name: {self.name}\n"
                f"Color: {self.color}\n"
                f"Price: {self.price}\n"
                f"Manufacturer: {self.manufacturer}\n"
                f"Engine: {self.engine}\n"
                f"Gear: {self.gear}\n"
                f"Segment: {self.segment}\n")
    
    def max_speed(self):
        pass
    
    def change_gear(self):
        pass

    def engine_start(self):
        pass
        
    
class Car(Vehicle):
    def __init__(self, name, color, price, manufacturer, engine, gear, segment):
        super().__init__(name, color, price, manufacturer, engine, gear, segment)
    def max_speed(self):
        return "130 Kmph"
    def change_gear(self):
        return "7 Speed Automatic"
    def engine_start(self):
        return "Engine Started" 
    def detials(self):
        return super().detials()

class Tractor(Vehicle):
    def __init__(self, name, color, price, manufacturer, engine, gear, segment):
        super().__init__(name, color, price, manufacturer, engine, gear, segment)
    def max_speed(self):
        return "80 kmph"
    def change_gear(self):
        return "7 Speed Manual"
    def engine_start(self):
        return "Engine Started"
    def detials(self):
        return super().detials()
    
c1 = Car("Honda NSX", "Blue", 1000000, "Honda", "4-ltr Turbo V6", 6, "Premium")
t1 = Tractor("Mahindra", "Red", 600000, "Mahindra", "5-ltr Turbo inline-4", 5, "Agriculture")
print(c1.detials())
print(t1.detials())
print(c1.max_speed())
print(t1.change_gear())

#operator overloading
class Complex:
    def __init__(self, a, b):
        self.a = a
        self.b = b
    def __add__(self, other):
        return self.a + other.a, self.b + other.b
c2 = Complex(1, 2)
print(c2.a, c2.b)
print(c2.__add__(c2))
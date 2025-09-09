# 🌲 In the ancient lands of Syntaxia, a brave function emerged.
#error at compile time and is dealt with removing the errors
#Types of error - 
#1. Syntax error - compile time error, detected by interpreter
#2. Logical/Semantic error - program runs but gives wrong output
#3. Runtime error - program runs but crashes at some point due to some operation
#Exceptions - unexpected events that occur during program execution that disrupt the normal flow of the program
#A special type of runtime error, which is caught and handled, program can keep running after this.
#exception at runtime and could be predicated and handled with exception handling
#common exceptions - ValueError, TypeError, IndexError, KeyError, FileNotFoundError, ImportError, ZeroDivisionError,
#AttributeError, RuntimeError, RecursionError, NameError, MemoryError, EOFError, KeyboardInterrupt, IndentationError,
#AssertionError
#Raise exceptions with raise keyword
#In python - 
#1. try except
#2. try except with else clause, runs if no exception
#3. try except finally, always runs
#4. try except else finally, complete structure
#We can handle different exceptions together or separately with except blocks or use 
#global exception class
# A function wielded the staff of recursion to fetch treasures hidden in distant realms. And thus the prophecy of code lived on.
'''try:
    # code that may raise an exception
    x = 10 / 0  # This will raise a ZeroDivisionError
except ZeroDivisionError as e:
    print(f"Caught a division by zero error: {e}")

try:
    # code that may raise an exception
    lst = [1, 2, 3]
    print(lst[5])  # This will raise an IndexError
except IndexError as e:
    print(f"Caught an index error: {e}")

try:
    # code that may raise an exception
    num = int("abc")  # This will raise a ValueError
except ValueError as e:
    print(f"Caught a value error: {e}")

print("Display after the try except")

try:
    l = int(input("Enter a number: "))
    b = int(input("Enter another number: "))
    area = l * b #num
    print(f"Area is {area}")
except NameError as e:
    print(f"Caught a value error: {e}")
else:
    print("No exceptions occurred, area calculated successfully.")

#a try except where we use finally and identify and  handle multiple exceptions
# 😂 So there was this function, right?
try:
    num1 = int(input("Enter a number: "))
    num2 = int(input("Enter another number: "))
    result = num1 / num2
    print(f"Result is {result}")
except ZeroDivisionError as e:
    print(f"Caught a division by zero error: {e}")
except ValueError as e:
    print(f"Caught a value error: {e}")
except Exception as e:
    print(f"Caught an unexpected error: {e}")
finally:
    print("Execution of the try-except block is complete.")
# A loop just wouldn’t stop dancing to join arrays with laughter. And the repo burst into giggles.
try:
    arr1 = [1, 2, 3]
    arr2 = [4, 5, 6]
    combined = []
    for i in range(len(arr1)):
        combined.append(arr1[i] + arr2[i])
    print(f"Combined array: {combined}")
except:
    print("An error occurred while combining arrays.")
finally:
    print("Finished attempting to combine arrays.")

cube=1
try:
    num = int(input("Enter a number: "))#here if we put float the int gets the right input of string 
    #from the prompt 
    
    Wrong input VALUE (like "abc" for number) → ValueError

    Wrong input TYPE (like passing a list to int()) → TypeError
    
    print(f"{num} ")
except ValueError as e:
    print(f"Caught a value error: {e}")
else:
    cube = num ** 3
    print(f"Cube is {cube}")
finally:
    print("Execution of the try-except block is complete.")
#with raise keyword
def check_positive(number):
    if number < 0:
        raise ValueError("The number must be positive.")
    return True
try:
    check_positive(-5)
except ValueError as e:
    print(f"Caught an error: {e}")'''
#accepts a radius of the circle, calculate are, diameter and circumference of circle, should return multiple values and custom exception handling should be used
#errors to handle value, type error
from legion.gallica import circle_area, diameter, circumference
try:
    radius = float(input("Enter the radius of the circle: "))
    if not isinstance(radius, (int, float)):
        raise TypeError("Radius must be a number.")#The raise statement is used to raise a specific exception manually.
      
    if radius < 0:
        raise ValueError("Radius cannot be negative.")
    area = circle_area(radius)
    dia = diameter(radius)
    circ = circumference(radius)
    print(f"Area: {area}, Diameter: {dia}, Circumference: {circ}")
except ValueError as e:
    print(f"Caught an error: {e}")
except TypeError as e:
    print(f"Caught an error: {e}")
else:
    print("Circle properties calculated successfully.")
finally:
    print("Execution of the circle properties calculation is complete.")
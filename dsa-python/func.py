#def - key word for functions
#resuable, modular, maintainable, easy to debug, easy to understand
#def function_name(parameters):
#function body
#return value/nothing if void function, multiple return values
#def add(a, b):
#    return a + b
#print(add(2, 3))
#print(add(5, 6))
#print(add(10, 20))
#print(add(100, 200))
#first_name = input("Enter First Name: ")
#last_name = input("Enter Last Name: ")
#def print_name(first_name, last_name):
#    print(f"Welcome, {first_name} {last_name} to Rust Workshop")#this is void function
#print_name(first_name, last_name)
#def print_name_return(first_name, last_name):
#    return f"Welcome, {first_name} {last_name} to Rust Workshop"#this is non void function aka has return type of string
#print(print_name_return(first_name, last_name))
#import math
#def multi(a,b):
#    return a*b
#mul = multi(3,5)
#another_mul = 3 * multi(5,78)
#print(mul)
#print(another_mul)
#print(math.sqrt(another_mul))
#multiple value return
'''
def arithmetic(a,b):
    return a+b, a-b, a*b, a/b, str(a), str(b)#while returning multiple values separated by commas
#python automatically creates a tuple
print(arithmetic(3,5))
print(type(arithmetic(3, 5)))
add, sub, multi, divide, st1, str2 = arithmetic(3, 5)
print(add)
print(sub)
print(multi)
print(divide)
print(st1)
print(str2)
print(type(st1))
print(type(str2))
print(type(add))
#function with default parameters
def func(a, b=10):
    return a + b
print(func(5))#b takes default value of 10 
'''
'''
#write a function to cal of area of rectangle
l=int(input("Enter length: "))
b=int(input("Enter breadth: "))
def area_rectangle(l,b):
    return l, b, l*b
print(f"{l} and {b} are the length and breadth of rectangle and area is {area_rectangle(l,b)[2]}")
#convert the celcius to fahrenheit
c=int(input("Enter temperature in celcius: "))
def cel_to_fah(c):
    return (c * 1.8) + 32
print(f"{c} celcius is {cel_to_fah(c)} fahrenheit")
#check if a number is odd or even
n=int(input("Enter a number: "))
def even_odd_check(n):
    if c % 2 == 0:
        print(f"{n} is even")
    else:
        print(f"{n} is odd")
even_odd_check(n)
'''
#factorial of a number
n=int(input("Enter a number to find factorial: "))
def factorial(n):
    fact = 1
    for i in range(1, n + 1):
        fact *= i
    return fact
print(f"Factorial of {n} is {factorial(n)}")
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

#n=int(input("Enter a number to find factorial: "))
#def factorial(n):
#    fact = 1
#    for i in range(1, n + 1):
#        fact *= i
#    return fact
#print(f"Factorial of {n} is {factorial(n)}")
'''
     * 2 arrays, one defined by user and other predefined
     * 1st array defined in main and
     * 2nd array defined in main and prompted for user to input data
     * 1) Take input from user and store in 2nd array
     * 2) Search an element in 1st array and print the index
     * 3) Reverse contents of the 2nd array
     * 4) Sum of factorial of single digit positive numbers from 2nd array
     * if none print -1

#function to add to 2nd array
def new_func(size):
    arr2 = [] 
    for i in range(size):
        n = int(input("Enter a number: "))
        arr2.append(n)
    return arr2
#search an element in 1st array and print the index
def searching(arr1, search_item):
        for i in range(len(arr1)):
            if arr1[i] == search_item:
                print(f"Element {search_item} found at index {i}")
#reversing using 
def reverse(arr2):
        print("Reversed Array 2: ")
        for i in range(len(arr2) - 1, -1, -1):
            print(arr2[i], end=" ")   
#Sum of factorial of single digit positive numbers from 2nd array
def fact_single_positive(arr2):
        sum = 0   
        for i in range(len(arr2)):
            if arr2[i] < 10 and arr2[i] > 0:
                sum += factorial(arr2[i])
        if sum > 0:
            print(f"\nSum of factorial of single digit positive numbers is: {sum}")
        else:
            print(-1)
#Helper function
def factorial(n):
            fact = 1
            for i in range(1,n+1):
                fact *= i
            return fact 


def main():
    arr1 = [10, 20, 30, 40, 50, 60, 70, 80, 90]
    size = int(input("Enter size of array 2: "))
    arr2 = new_func(size)
    print("Array 1 ",arr1)
    print("Array 2 ",arr2)
    search_term = int(input("Enter a number to search: "))
    searching(arr1, search_term)
    reverse(arr2)
    fact_single_positive(arr2)


main()'''
#armstrong number
'''n=int(input("Enter a number to check if it is armstrong or not: "))
def armstrong(n):
    sum = 0
    nLen = len(str(n))
    temp = n
    while temp > 0:
        digit = temp % 10
        sum += digit ** nLen
        temp // 10
    if n == sum:
        print(f"{n} is an armstrong number")
        print(f"Sum of factorial of single digit positive numbers is: {sum}")
    else:
        print(-1)

armstrong(n)'''
def palindrome(n):
    temp = n
    rev = 0
    while temp > 0:
        digit = temp % 10
        rev = (rev*10) + digit
        temp = temp // 10
    if n == rev:
        print(f"{n} is a palindrome")
    else:
        print(f"{n} is not a palindrome")
num = int(input("Enter a number to check if it is palindrome or not: "))
palindrome(num)
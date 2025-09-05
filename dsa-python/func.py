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
'''def palindrome(n):
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
palindrome(num)'''
#keyword argument
# 🪐 On a distant server orbiting Saturn,
'''def emp_dets(name,id,phone,des,basic,company):
    print(f"Employee Details:\nName: {name}\nID: {id}\tPhone: {phone}\tDesignation: {des}\tBasic Salary: {basic}\tCompany: {company}")
    ta = basic * .05
    hra = basic * .07
    pf = basic * .1
    gross = basic + ta + hra
    net = gross - pf
    print(f"TA: {ta}\nHRA: {hra}\nPF:{pf}\nGross Salary: {gross}\nNet Salary: {net}")
emp_dets(basic=250000,name="John Doe", id=101, phone="1234567890", des="SDE", company="SAAB")'''
# A variable uploaded its consciousness to resist the tyranny of runtime errors. But a rogue bug invaded its memory banks.
#Arbitary arguments - 1 - Arbitary positional arguments also called
# variable length (this is for non-keyword arguments), 
#2 - keyword arbitary arguments - **kwargs
#def add(*args):#any number arguments are taken by args
#    print(type(args))#it is of type tuple
#    sum = 0
#    sum_idx = 0
#    for i in args:
#        sum += i
#    for i in range(len(args)):
#        sum_idx += args[i]
#    return sum, sum_idx
#print(add(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
# ⚡ Inside the mainframe of a corporate empire,
'''
def emp_dets(**kwargs):#takes any number of keyword arguments
    print(type(kwargs))
    for key, value in kwargs.items():
        print(f"{key}: {value} ", end="")
#only string type keys no integers
emp_dets(name="Aditya",id=101, basic=350000, desg="Sr. SDE", company="Kongsberg")
# A hacker function jacked into the system to escape the recursion loop of doom. And the network pulsed with rebellion.
def func(a, b, *args, **kwargs):
    print("\n",a)
    print(b)
    print(args)
    print(kwargs)
func(1, 2, 3, 4, 5, name="Aditya", id=101, basic=350000, desg="Sr. SDE", company="Kongsberg")'''
#scope - of variable, function is localized based on its initilization and usage
#some are global and others local to a loop to a function or file
#nested function is good sample to show scoping
'''
global_var = 100
global_var2 = 200
def emp_data(name,id,desg,basic,company):
    local = 20
    
    print(f"{name}\t{id}\n{basic}\t{desg}\t{company}")
    global global_var
    global global_var2
    print(global_var)
    print(global_var+100)#here only the addition happens 
    global_var2 = global_var2 + 100 #but here we delcared the global_var as global and
    #and used in an expression it changes completely
    print(global_var2)
    def net(income):
        nonlocal local always used in nested functions  
        ta = income * .05
        hra = income * .07
        pf = income * .1
        gross = income + ta + hra
        net = gross - pf
        return net, local
    print(net(basic))
    print(local)#accessible here too as local is declared nonlocal
emp_data("Aditya",101,"Sr. SDE",2500000,"Samtel")
print(global_var)#doesnot update the value here
print(global_var2)#updates the value here'''
#partitioning string function based on the word's 1st occurance
# a proper function not the inbuilt ones
s = "Python is easy to learn and this is a work shop"
def partition_func(s, sep):
    before = ""
    after = ""
    found = False
    for i in range(len(s)):
       if s[i:i+len(sep)] == sep and not found:#ith word to element before i+len(sep) 
           before = s[:i]
           after = s[i+len(sep):] 
           found = True
    if found:
        return before, sep, after
    else:
        return s, "", ""
print(partition_func(s,'is'))
#if else and elif sample code
# This is a sample code to demonstrate if, else and elif statements in Python.
'''x = 10
y = 20
if x > y:
    print("x is greater than y")
elif x < y:
    print("x is less than y")
else:
    print("x is equal to y")'''
# This code compares two variables x and y and prints the result based on the comparison.
'''
Write a program to input two numbers and print their sum, difference, product, and division.
'''
''''
x = float(input("1st num: "))
y = float(input("2nd num: "))
print("Sum:", x + y)
print("Difference:", x - y)
print("Product:", x * y)
print("Division: ", x / y if y != 0 else "Cannot divide by zero")

Write a program to take the radius of a circle as input and print its area.
(Hint: Area = 3.14 * r * r)

radius = float(input("Radius: "))
area = 3.14 * radius * radius
print("Area of the circle:", area)

Write a program to input three numbers and print the largest number.

num1 = float(input("Enter first number: "))
num2 = float(input("Enter second number: "))
num3 = float(input("Enter third number: "))
if num1 >= num2:
    if num2 >= num3:
        largest = num1
    else:
        largest = num3
else:
    if num1 >= num3:
        largest = num2
    else:
        largest = num3
print("Largest number is:", largest)

Write a program to create a simple calculator that performs addition, subtraction, multiplication, and division based on user choice.
(Hint: Take two numbers as input and then ask the user to enter +, -, *, or /)

num1 = float(input("1st num: "))
num2 = float(input("2nd num: "))
operation = input("Enter operation (+, -, *, /): ")
if operation == "+":
    print("Result:", num1 + num2)
elif operation == "-":
    print("Result:", num1 - num2)
elif operation == "*":
    print("Result:", num1 * num2)
elif operation == "/":
    if num2 != 0:
        print("Result:", num1 / num2)
    else:
        print("Cannot divide by zero")

Write a program to input two numbers and check which one is greater using comparison operators.

num1 = float(input("Enter first number: "))
num2 = float(input("Enter second number: "))
if num1 > num2:
    print("First number is greater than second number.")
elif num1 < num2:
    print("First number is less than second number.")
else:
    print("Both numbers are equal.")

Write a program to input a number and print whether it is even or odd using modulus operator %.

num = int(input("Enter a number: "))
if num % 2 == 0:
    print("The number is even.")
else:
    print("The number is odd.")

Write a program to input a number and find its square and cube using exponent operator **

num = float(input("Enter a number: "))
square = num ** 2
cube = num ** 3
print("Square of the number:", square)
print("Cube of the number:", cube)

Write a program to input a number and check if it is divisible by both 3 and 5.

num = int(input("Enter a number: "))
if num % 3 == 0 and num % 5 == 0:
    print("The number is divisible by both 3 and 5.")
else:
    print("The number is not divisible by both 3 and 5.")

Write a program to input a person’s age and decide if they are:
Child (age < 13)
Teenager (13–19)
Adult (20–59)
Senior (60 and above)

age = int(input("Enter your age: "))
if age < 13:
    print("You are a Child.")
elif 13 <= age <= 19:
    print("You are a Teenager.")
elif 20 <= age <= 59:
    print("You are an Adult.")
elif age >= 60:
    print("You are a Senior.")

Write a program to input marks of a student and print the Grade:
90 and above → A
80-89 → B
70-79 → C
60-69 → D
Below 60 → Fail

marks = float(input("Enter your marks: "))
if marks >= 90:
    print("Grade: A")
elif 80 <= marks < 90:
    print("Grade: B")
elif 70 <= marks < 80:
    print("Grad: C")
elif 60 <= marks < 70:
    print("Grade: D")
elif marks < 60:
    print("Grade: Fail")

Write a program to input a year and check whether it is a leap year or not.
(Hint: A year is leap if divisible by 400 OR (divisible by 4 but not by 100))

year = int(input("Enter a year: "))
if (year % 400) or (year % 4 and not year % 100):
    print(year, "is a leap year.")
else:
    print(year, "is not a leap year.")'''
'''
Loop - for loop iterate over sequence of elements - eg - list, range, string, tuple
while loop - iterate over condition is true or false
for var in range(start(optional)(inclusive), end(required)(exclusive), step(optional)) or a list/dict/string/tuple:
    do operations
also we can do
for numerical or bitwise or logical evaluations:
    do operations

initiate outside the var in the condition if required
while condition - could be bitwise, logical, true/false, comparison operations, can operate on Data Structures too - all are evaluated:
    do operations
    updating the condition for next iteration, this is equation of termination condition too

data_lst = ["Aditya", "Ripudaman", "Arynaka"]
for name in data_lst:
    #length of each word
    print(name, len(name))
import math
tu = (34,55,664,32424,67411)
for var in tu:
    print(math.pow(var, 2))#square of each element

string = "Argentum"
for char in string:
    print(char)
#what if I wanna iterate over tuple but jump by 2 elements
for i in range(0, len(data_lst)):
    print(data_lst[i])
'''
#write a program from 40 to 20 and square the even numbers
import math
'''

for squared in range(40, 20,-1):
    if squared % 2 == 0:
        print(squared)
#while loop version
num = 40
while num >= 20:
    if num % 2 == 0:
        print(num)
    num-=1       
#count the no. of elements and print the elements
tu2 = (34, 55, 664, 32424, 67411)
count = 0
for i in range(0, len(tu2)):
    count+=1
    print(tu2[i]," at the index ", i ," count is", count)
#while loop version
i = 0
count = 0
while i < len(tu2):
    count+=1
    print(tu2[i]," at the index ", i ," count is", count)
    i+=1
#display all the strings with serial numbers
tu3 = ("Aditya", "Abhijeet", "Ripudaman", "Arynaka", "Kakashi", "Naruto", "Neji")
for i in range(0, len(tu3)):
    print(i+1, tu3[i])
#while loop version
i = 0
while i < len(tu3):
    print(i+1, tu3[i])
    i+=1
#print table for numbers 
num = int(input("Enter a number: "))
for i in range(1,11):
    print(num, " x ", i, " = ", (num*i))
#while loop version
i = 1
while i <= 10:
    print(num, " x ", i, " = ", (num*i))
    i+=1
#get number from user if odd then caluclate cube else even calculate square
iterations = int(input("Enter number to run iterations: "))
for i in range(0,iterations):
    num = int(input("Enter a number: "))
    if num % 2 == 0:
        print("Square of ", num, " is ", (math.pow(num, 2)))
    else:
        print("Cube of ", num, " is ", (math.pow(num, 3)))
#while loop version
i = 0
while i < iterations:
    num = int(input("Enter a number: "))
    if num % 2 == 0:
        print("Square of ", num, " is ", (math.pow(num, 2)))
    else:
        print("Cube of ", num, " is ", (math.pow(num, 3)))
    i+=1

#accept yes or no from user and then take a number and see if its even or odd
choice = input("Do you want to continue? (yes/no): ").lower()
while choice == 'yes':
    num = int(input("Enter a number: "))
    if num % 2 == 0:
        print("Square is: ", math.pow(num, 2))
    else:
        print("Cube is: ", math.pow(num, 3))
    choice = input("Do you want to continue? (yes/no): ").lower()
#print the series - 1,8,27,64,125,...n
n = int(input("Enter the number of terms: "))
for i in range(1, n+1):
    print(i**3, end=", " if i < n else "\n")
#while loop version
i = 1
while i <= n:
    print(i**3, end=", " if i < n else "\n")
    i+=1
#1,8,27,16,125...n
n = int(input("Enter the number of terms: "))
for i in range(1, n+1):
    if i % 2 == 0:
        print(i**2, end=", " if i < n else "\n")
    else:
        print(i**3, end=", " if i < n else "\n")
#while loop version
i = 1
while i <= n:
    if i % 2 == 0:
        print(i**2, end=", " if i < n else "\n")
    else:
        print(i**3, end=", " if i < n else "\n")
    i+=1
#0,1,1,2,3,5
n = int(input("Enter the number of terms: "))
a, b = 0, 1
for i in range(n):
    print(a, end=", " if i < n-1 else "\n")
    a, b = b, a + b
#while loop version
i = 0
while i <= n:
    print(a, end=", " if i < n-1 else "\n")
    a, b = b, a + b
    i+=1
#accept a number and find out its factorial of it
num = int(input("Enter a number: "))
fact = 1
for i in range(1, num + 1):
    fact *= i
print("Factorial of", num, "is", fact)
#while loop version
i = 1
while i <= num:
    fact *= i
    i += 1
print("Factorial of", num, "is", fact)
#accept a number and find out no.of digits
num = int(input("Enter a number: "))
count = 0
for i in str(num):
    count += 1
print("Number of digits in", num, "is", count)
#while loop version
count = 0
temp = num
while temp > 0:
    temp //= 10 #//= means floor division
    count += 1
print("Number of digits in", num, "is", count)
'''
#accept a number and see if its prime or not
'''
num = int(input("Enter a number: "))
if num > 1:
    if num == 2:
        print(num, " is Prime")

    for i in range(2, num):
        if num % i == 0 and num!=0: 
            print(num, " is Composite")
            break
        else:
            print(num, " is Prime")   
            break    
else:
    print("Less then or equal to 1, (1,0,-ve numbers not allowed)")
#with flag
if num > 1:
    flag = True
    for i in range(2, num):
        if num % i == 0 and num != i:
            flag=False
            break
        else:
            flag=True
    print(num, "Prime" if flag else "Composite")
'''
'''
#while loop version
i = 2#start from 2
flag = True
if num > 1:
    while i < num:
        if num % i == 0:
            flag = False
        else:
            flag = True
        i+=1
    print("Prime" if flag else "Not Prime")
else:
    print("Not Prime")'''
#get all the prime numbers between one and 100
''''
for num in range(1, 101):
    if num > 1:
        flag=True
        for i in range(2, num):
            if num%i==0 and num!=i:
                flag=False
                break
            else:
                flag=True
    else:
        flag=False
    print(num, " is Prime" if flag else " is Not Prime")
#while loop version
'''
'''
num = 1
while num <= 100:
    if num > 1:
        while i < num:
            if num%i==0 and num!=i:
                flag=False
                break
            else:
                flag=True
            i+=1
    else:
        flag=False
    if flag:
        print(num, end=", " if num < 100 else "\n")
    else:
        print("Not prime")'''
'''
for i in range(6):
    for j in range(3):
        print(j,i)
1
22
333
4444
pattern using nested for loop

num = int(input("Enter number for a right angled triangle: "))
for i in range(1,num+1):
    for j in range(1,i+1):
        print(i, end="")
    print()

for a pattern
    1
   22
  333
  and so on using nested for loop

num = int(input("Enter number for a reversed right angled triangle: "))
for i in range(1,num+1):
    print(" " * (num-i)+str(i)*i)
        
for i in range(1,11):
    #i*1, i*2 and so on 
    print("table of", i)
    for j in range(1,11):
        print(f"{i}x{j}={i*j}", sep="\n", end="\t")
    print()'''
#find the sum of all digits of entered number
num = int(input("Enter the number: "))
sum = 0
for i in str(num):
    sum += int(i)
print("Sum for",num,"is",sum)
#find the largest and smallest number from a list of numbers
li = [2,34,56,77,8,1,9]
largest = li[0]
smallest = li[0]
for i in range(len(li)):
    if i < len(li) and li[i] > largest:
        largest = li[i]
    elif i < len(li) and li[i] < smallest:
        smallest = li[i]
print("Largest is",largest,"Smallest is",smallest)

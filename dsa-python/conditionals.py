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
x = float(input("1st num: "))
y = float(input("2nd num: "))
print("Sum:", x + y)
print("Difference:", x - y)
print("Product:", x * y)
print("Division: ", x / y if y != 0 else "Cannot divide by zero")
'''
Write a program to take the radius of a circle as input and print its area.
(Hint: Area = 3.14 * r * r)
'''
radius = float(input("Radius: "))
area = 3.14 * radius * radius
print("Area of the circle:", area)
'''
Write a program to input three numbers and print the largest number.
'''
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
'''
Write a program to create a simple calculator that performs addition, subtraction, multiplication, and division based on user choice.
(Hint: Take two numbers as input and then ask the user to enter +, -, *, or /)
'''
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
'''
Write a program to input two numbers and check which one is greater using comparison operators.
'''
num1 = float(input("Enter first number: "))
num2 = float(input("Enter second number: "))
if num1 > num2:
    print("First number is greater than second number.")
elif num1 < num2:
    print("First number is less than second number.")
else:
    print("Both numbers are equal.")
'''
Write a program to input a number and print whether it is even or odd using modulus operator %.
'''
num = int(input("Enter a number: "))
if num % 2 == 0:
    print("The number is even.")
else:
    print("The number is odd.")
'''
Write a program to input a number and find its square and cube using exponent operator **
'''
num = float(input("Enter a number: "))
square = num ** 2
cube = num ** 3
print("Square of the number:", square)
print("Cube of the number:", cube)
'''
Write a program to input a number and check if it is divisible by both 3 and 5.
'''
num = int(input("Enter a number: "))
if num % 3 == 0 and num % 5 == 0:
    print("The number is divisible by both 3 and 5.")
else:
    print("The number is not divisible by both 3 and 5.")
'''
Write a program to input a person’s age and decide if they are:
Child (age < 13)
Teenager (13–19)
Adult (20–59)
Senior (60 and above)
'''
age = int(input("Enter your age: "))
if age < 13:
    print("You are a Child.")
elif 13 <= age <= 19:
    print("You are a Teenager.")
elif 20 <= age <= 59:
    print("You are an Adult.")
elif age >= 60:
    print("You are a Senior.")
'''
Write a program to input marks of a student and print the Grade:
90 and above → A
80-89 → B
70-79 → C
60-69 → D
Below 60 → Fail
'''
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
'''
Write a program to input a year and check whether it is a leap year or not.
(Hint: A year is leap if divisible by 400 OR (divisible by 4 but not by 100))
'''
year = int(input("Enter a year: "))
if (year % 400) or (year % 4 and not year % 100):
    print(year, "is a leap year.")
else:
    print(year, "is not a leap year.")
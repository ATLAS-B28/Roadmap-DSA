#operators 
#binary, unary, special, ternary,
#bitwise, arithmetic, logical, identity, membership, assignment
#operators in python

# Arithmetic Operators
'''a = 4
b = 5
num = a + b
print(a+b)
print(a-b)
print(a*b)
print(a/b)
print(a//b)  # Floor Division
print(a**b)  # Exponentiation
print(a%b)   # Modulus
# Assignment Operators
a = 10
b = 20
a += b  # a = a + b
print(a)  # Output: 30
# Comparison Operators
print(a == b)  # Equal to
print(a != b)  # Not equal to
print(a > b)   # Greater than
print(a < b)   # Less than

print(a >= b)  # Greater than or equal to
print(a <= b)  # Less than or equal to

# Logical Operators
x = True
y = False
print(x and y)  # Logical AND
print(x or y)   # Logical OR
print(not x)    # Logical NOT
# Identity Operators
print(a is b)  # Identity (is)
print(a is not b)  # Identity (is not)
# Membership Operators
list1 = [1, 2, 3, 4, 5]#here values are checked for membership
dict1 = {1: 'a', 2: 'b'}#here keys are checked for membership
print(3 in list1)  # Membership (in)
print(list1[2] in list1)
print(6 not in list1)  # Membership (not in)
print(1 in dict1)
print('a' in dict1.values())  # to check membership in dictionary values we do dictionary.value()<- func to get the values
#lets do operations with alteast one String
str1 = "Hello"
str2 = "World"
print(str1 + " " + str2)  # String Concatenation
print(str1 * 3)  # String Repetition
print(3 * str1)
# Bitwise Operators
print(a & b)  # Bitwise AND
print(a | b)  # Bitwise OR
print(a ^ b)  # Bitwise XOR
print(~a)  # Bitwise NOT
print(a << 2)  # Left Shift
print(a >> 2)  # Right Shift
# Ternary Operator
result = "a is greater" if a > b else "b is greater"
print(result)  # Output: b is greater
# Special Operators
# None Type
print(type(None))  # Output: <class 'NoneType'>
print("%.3f" %(25.73796211))
print(True+False+1)'''
'''base = float(input("Enter base: "))
height = float(input("Enter height: "))
area_right_angled_triangle = 0.5 * base * height
print("Area of right-angled triangle: {:.2f}".format(area_right_angled_triangle))#using {:.2f} with format func
# Caluclate DA-3%, HRA-3%, PF-750, Income Tax-7%, Gross = Salary+HRA+DA, Net Salary=gross-PF-IT
#we have to use the above operators and take input and display all
#Also we have to get designation, name, department
#no functions needed
name = input("Enter your name: ")
designation = input("Enter your designation: ")
department = input("Enter your department: ")
salary = float(input("Enter your salary: "))
da = salary * 0.03  # DA - 3% - salary * 3/100 (0.03) 
hra = salary * 0.03  # HRA - 3% - 
pf = 750  # PF - 750
#we deduct Income tax
income_tax = salary * 0.07  # Income Tax - 7%
gross = salary + da + hra  # Gross Salary
net_salary = gross - pf - income_tax  # Net Salary
print("\nEmployee Details:")
print("Name: ", name)
print("Designation: ", designation)
print("Department: ", department)
print("Salary: ", salary)
print("DA (3%): ", da)
print("HRA (3%): ", hra)
print("PF: ", pf)
#want to make the value more precise how to do it using format in income tax 
#getting a .00000011 want to precise up till 2 decimals 
income_tax_print = format(income_tax, '.2f')  # Formatting income tax to 2 decimal places
print("Income Tax (7%): ", income_tax_print)
print("Gross Salary: ", gross)
print("Net Salary: ", net_salary)'''
#calculate the area, diameter and circumference of a circle
radius = float(input("Enter the radius of the circle: "))
import math
area_circle = math.pi * radius ** 2  # Area of the circle
diameter_circle = radius * 2  # Diameter of the circle
circumference_circle = 2 * math.pi * radius  # Circumference of the circle
print("Area of the circle: {:.2f}".format(area_circle))
print("Diameter of the circle: {:.2f}".format(diameter_circle))
print("Circumference of the circle: {:.2f}".format(circumference_circle))
#Take student name, marks in maths, english, science
#then calculate total and average maths
#print them
student_name = input("Enter student's name: ")
marks_maths = float(input("Enter marks in Maths: "))
marks_english = float(input("Enter marks in English: "))
marks_science = float(input("Enter marks in Science: "))
total_marks = marks_maths + marks_english + marks_science
average_marks = total_marks / 3  # Average of the marks
print("Student Name: ", student_name)
print("Marks in Maths: ", marks_maths)
print("Marks in English: ", marks_english)
print("Marks in Science: ", marks_science)
print("Total Marks: ", total_marks)
print("Average Marks: {:.2f}".format(average_marks))  # Formatting average marks to 2 decimal places

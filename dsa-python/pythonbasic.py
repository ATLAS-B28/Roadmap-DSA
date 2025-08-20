#print("Hello world")
#x = 10
#y = 9
#sum = x + y
#print(sum)

#if sum > 15:
 #   print("Sum is greater than 15")
#else:
#    print("Sum is less than 15")    

#for i in range(6):
#  print(i)

#def add_num(a,b):
 #  return a + b

#result = add_num(5,8)
#print(result)

#def fact(n):
#   if n == 0:
#      return 1
#   else:
#      return n*fact(n-1)
   
#print(fact(5))
#print("File", "Name", "txt", sep="-")
#num1 = 56.67
#num2 = 45.5
#sum = num1 + num2
#res = "Sum of %.3f and %.3f is %.3f" %(num1, num2, sum)
#print(res)
#day = 28
#month = 8
#year = 2025
#brith_month = "Birthday!! and month is %s" %("August")
#print(day, month, year, sep="/", end="\t")
#print(brith_month)

str1 = "Aditya"
str2 = "Aranyka"
print("Name 1: {1}, Name 2: {0}".format(str1, str2))
print("Divison: {}".format(5/4))
num1 = int(input("Enter num1: "))
num2 = int(input("Enter num2: "))
multiplication = num1 * num2
print("Mulitplication is {2} for numbers {0} and {1}".format(num1, num2, multiplication))
"""
take input from user - name, location, college, course, start date, duration
"""
name = input("Enter your name: ")
location = input("Enter your location: ")
college = input("Enter your college: ")
course = input("Enter your course: ")
start_date = input("Enter your start date: ")
duration = int(input("Enter your course duration: "))

print("Name: {}, Location: {}, College: {}, Course: {}, Start Date: {}, Duration: {}".format(name, location, college, course, start_date, duration))
# This is a simple Python script to demonstrate basic input/output and string formatting.
#tuples, dict examples
# Tuples are immutable sequences in Python.
# Example of a tuple
my_tuple = (1, 2, 3, "Hello", "World")
print(my_tuple)
# Example of a dictionary
#to access elements we use keys only 
my_dict = {
    "name": "Alice",
    "age": 30,
    "city": "New York"
}
print(my_dict)
print(my_dict["age"])
# Lists in Python are mutable.
mylist = ["apple", "banana", "cherry"]
print(mylist)
print(mylist[1])
# Sets in Python are unordered collections of unique elements.
#unordered, unchangeable(remove and add), and unindexed.
myset = {"apple", "banana", "cherry"}
print(myset)
#String are data structures and they are immutable, squence of unicode, 
#creation: Strings are created by enclosing characters within single quotes ('...'), 
#double quotes ("..."), or triple quotes ('''...''' or """...""").
#Indexing and Slicing is also allowed
#No Separate Character Type
my_string = "Hello, World!"
print(my_string)
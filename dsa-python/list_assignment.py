'''
Udpate and delete elements
create a list of frutis from the user input
and replace the 3rd with another fruit
remove the last fruit
insert a new fruit at the beginning
'''
fruits = []
n = int(input("Enter number of fruits: "))
for i in range(n):
    fruit = input("Enter fruit name: ")
    fruits.append(fruit)
print("Original list:", fruits)
# Replace the 3rd fruit

new_fruit = input("Enter new fruit name: ")
fruits[2] = new_fruit
print("Updated list:", fruits)
#remove last fruit
if fruits:
    fruits.pop()
    print("After removing last fruit:", fruits)
#insert new fruit at the beginning
if fruits:
    new_fruit = input("Enter new fruit name: ")
    fruits.insert(0, new_fruit)
    print("After inserting new fruit at the beginning:", fruits)
'''
a program to get names from the user and create a list
and then ask user to give a name and see if exists or not in the lsit
'''
names = []
m = int(input("Enter number of names: "))
for j in range(m):
    name = input("Enter name: ")
    names.append(name)
print("List of names:", names)
search_name = input("Enter a name to search: ")
if search_name in names:
    print(search_name, "exists in the list")
else:
    print(search_name, "does not exist in the list")
'''
Create a 2D array for 3 students for 3 subjects and print the marks of student 2 in subject 3 and calulate the marks of 1st student
'''
marks = []
for k in range(3):
    student_marks=[]
    for l in range(3):
        mark = int(input(f"Enter marks for student {k+1} in subject {l+1}: "))
        student_marks.append(mark)
    marks.append(student_marks)
print("Marks of student 2 in subject 3:", marks[1][2])
#using loop to calculate the sum
total_marks = 0
for mark in marks[0]:
    total_marks += mark
print("Total marks of student 1:", total_marks)
'''
Find common elements among 2 inputted lists and return it
'''
list1 = []
list2 = []
p = int(input("Enter number of elements in list 1: "))
for x in range(p):
    element = input("Enter element for list 1: ")
    list1.append(element)
q = int(input("Enter number of elements in list 2: "))
for y in range(q):
    element = input("Enter element for list 2: ")
    list2.append(element)
print("List 1:", list1)
print("List 2:", list2)
common_elements = []
for ele in list1:
    if ele in list2 and ele not in common_elements:
        common_elements.append(ele)
if len(common_elements) == 0:
    print("No common elements found")
print("Common elements:", common_elements)
'''
find and remove duplicate integers and maintain the order of the user defined list
'''
user_list = []
r = int(input("Enter number of integers: "))
for z in range(r):
    integer = int(input("Enter integer: "))
    user_list.append(integer)
print("Original list:", user_list)
unique_list = []
for num in user_list:
    if num not in unique_list:
        unique_list.append(num)
print("List after removing duplicates:", unique_list)
'''
create a dict of employees whcih stores ID, Name, Dept, Basic Salary of 5 employees
1) Accept this information from the user 
2) Accept department name from user and return the count of employees of that department and their details
3) Return another dict that stores the details of employees whose basic is greater than 10000
'''

employees = {}
n = 5
print("Enter details of 5 employees to be added to the database:-")
for i in range(1, n  + 1):
    print(f"\nEnter details for Employee {i}")
    emp_id = int(input("Enter Employee ID: "))
    emp_name = input("Enter Employee Name: ")
    emp_dept = input("Enter Employee Department: ")
    emp_basic = int(input("Enter Employee Basic Salary: "))
    emp={}
    if (emp_id not in employees.keys() and 
        emp_basic > 0 and 
        emp_dept.isalpha() and 
        emp_name.isalpha()):
        emp = {
         'Employee ID': emp_id,
         'Employee Name': emp_name,
         'Employee Department': emp_dept,
         'Employee Basic Salary': emp_basic
        }
    employees[emp_id] = emp
print("Employees Data Added Successfully!")
for key, value in employees.items():
    print(f"{key}: {value} | ", end="\n")
print()

dept = input("Enter the department to display data: ")
if dept.isalpha():
    print(f"Employees Data for {dept} Department:-")
    count = 0
    for key, value in employees.items():
        if value.get('Employee Department') == dept:
            count += 1
            
            for k, v in value.items():
                print(f"{k}: {v} | ", end="\n")
    print(f"Total Employees in {dept} Department: {count}")
print()

exec = {}
for key, value in employees.items():
    if value.get('Employee Basic Salary') > 10000:
        exec[key] = value
print("Employees with Basic Salary > 10000:-")
for key, value in exec.items():
    print(f"{key}: {value} | ", end="\n")

'''
A program to invert dict (key to value and value to key) and return the dict

sample = {'a': 1, 'b': 2, 'c': 3, 'd': 4, 'e': 5}
print("Original Dict:-")
for key, value in sample.items():
    print(f"{key}: {value} | ", end="\n")
#in-place inversion
for key in list(sample.keys()):
    value = sample[key]#copy the value from the key's element, extact the value
    sample[value] = key#then use it as key and previous key as value
    del sample[key]#delete the previous keys from the dict
#in-place inversion using dict comprehension
sample = {value: key for key, value in sample.items()}
#separate dict inversion 
inverted = {value: key for key, value in sample.items()}
print("Inverted Dict:-")
for key, value in sample.items():
    print(f"{key}: {value} | ", end="\n")
print("Inverted Dict using separate dict:-")
for key, value in inverted.items():
    print(f"{key}: {value} | ", end="\n")

Merge two dictionaries as input and merge them, if common key found add their values instead of replacing
'''
'''
print("Merging 2 user defined dictionaries for a list of Cars and their Unit Numbers: ")
length = int(input("Enter the length of the dict 1 to be merged: "))
dict1 = {}
dict2 = {}
for i in range(1, length + 1):
    car = input(f"Enter car name {i}: ").upper().replace(" ","")
    unit = int(input(f"Enter unit: "))
    dict1[car] = unit
length1 = int(input("Enter the length of the dict 2 to be merged: "))
for i in range(1, length1 + 1):
    car = input(f"Enter car {i}: ").upper().replace(" ", "")
    unit = int(input(f"Enter unit: "))
    dict2[car] = unit
#merging logic 
merged = dict1.copy() #copy dict1 to merged
for key, value in dict2.items():
    if key in merged.keys():
        merged[key] += value #add values if key exists, aka this is same 
    else:
        merged[key] = value #add key-value pair if key doesn't exist aka unique not repeated
print()
print("Merged Dict for Cars:-")
for key, value in merged.items():
    print(f"{key}: {value} | ", end="\n")
    

User defined nested dictionaries where each student has 3 subjects with their marks
structure - {key - Stuent Name type string: value type dict: {Subject1 type string: marks type integer,....}}

student_entry={}
n = int(input("Enter number of students to be added: "))
#create a student name dict and add elements in an inner dict
for i in range(1, n + 1):
    student_name = input(f"Enter name of student {i}: ")
    for j in range(1, 4):
        sub_name = input("Enter subject name: ")
        sub_marks = int(input("Enter subject marks: "))
        if student_name not in student_entry.keys():
            student_entry[student_name]={f'{sub_name} {j}': sub_marks}
        else:
            student_entry[student_name][f'{sub_name} {j}'] = sub_marks#updating the value of marks? 
print("Student Data Added Successfully!")
for key, value in student_entry.items():
    print(f"{key}: {value} | ", end="\n")
print()
#average of subjects for each students
for key, value in student_entry.items():
    total = 0
    for k, v in value.items():
        total += v
    avg = total // 3
    print(f"Average marks of {key} is {avg}")
#find topper in each subject

let top marks be -1 and student as "" and 
for key, value from student entry
then get the subject key from i - 1 to 3aassss
if value from sub key is not none and sub key > top marks 
then set top marks to subkey's value and key AAAA student name
in the end enter the sub key as key for topper list as this is topper -> subject 1 -> student name

toppers = {}
for i in range(1, 4):
    top_marks = -1
    top_student = ""
    #sub_key = f"Subject {i}"
    for student_name, subjects in student_entry.items():
        for sub_key, marks in subjects.items():
            if sub_key.endswith(f" {i}") and marks > top_marks:
                top_marks = marks
                top_student = student_name
    toppers[f"Subject {i}"] = {top_student: top_marks}
print("Toppers in each subject:-")
for key, value in toppers.items():
    print(f"{key}: {value} | ", end="\n")'''
#if 2 keys have same value have only one key-value pair
#separate program to take a country and its capital
#2 dictionary
'''
countries1 = {}
countries2 = {}
n = int(input("Enter number of countries to be added: "))
for i in range(1, n + 1):
    country = input(f"Enter name of country {i}: ")
    capital = input(f"Enter capital of country {i}: ")
    countries1[country] = capital
for i in range(1, n + 1):
    country = input(f"Enter name of country {i}: ")
    capital = input(f"Enter capital of country {i}: ")
    countries2[country] = capital
#merge logic
merged = countries1.copy()
for key, value in countries2.items():
    if value not in merged.values():
        merged[key] = value
print("Merged Countries Dict:-")
for key, value in merged.items():
    print(f"{key}: {value} | ", end="\n")'''
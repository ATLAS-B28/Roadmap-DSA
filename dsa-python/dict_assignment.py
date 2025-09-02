'''
create a dict of employees whcih stores ID, Name, Dept, Basic Salary of 5 employees
1) Accept this information from the user 
2) Accept department name from user and return the count of employees of that department and their details
3) Return another dict that stores the details of employees whose basic is greater than 10000
'''
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

'''
A program to invert dict (key to value and value to key) and return the dict
'''
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
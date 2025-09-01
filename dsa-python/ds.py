#lists
#nums = [1,2,3,4,5,3,211,3124,22,3,5,3,3,3]
#print(nums[0]) #mutable, any data type, nested list, same data type in same list
#diff_ds = [1,"Aditya",2.08,True]
#print(diff_ds)
'''
List all the functions of the list - 
append, clear, copy, count, extend, index, insert, pop, remove, reverse, sort,
'''
#difference between append and extend
#nums.append(6)#can add element, tuple, dictationary, list
#nums.append((2,3))
#nums.append([4,5])
#nums.append({1:"Aditya",2:"Abhijeet"})
#print(nums)
#nums.extend([7,8,9])#requires an iterable
#nums.extend("string")
#nums.extend((2, 3))
#nums.extend({1:"Aditya", 2:"Abhijeet"})#adds the keys only
# lets say we do this values - builtin_function_or_method' object is not iterable
#print(nums)
#index
'''print(nums.index(3))
print(nums.index(3, 5))#start searching from index 5
print(nums.index(3, 5, 10))#search between index 5 and 10
#insert
nums.insert(0,0)#index, value
print(nums)
#If i have to remove multiple elements
nums[1:5] = []
print(nums)
#remove
#nums.remove(3)#removes first occurence of 3
#All occurances of 3
#while 3 in nums:
 #   nums.remove(3)
print(nums)
'''
#nums.sort()
#print(nums)
#nums.sort(reverse=True)
#print(nums)
#nums2 = [1,2,3,4,5,3,211,3124,22,3,[5,3,2,1]]
#nums2.sort()
#print(nums2) #error as it contains a nested list
#sorting using key defined by us
#nums3 = ["Aditya", "Abhijeet", "Abhishek", "Amit"]
#nums3.sort(key=len)
#print(nums3)
#sorted()
#my_num = sorted(nums3)#,reverse=True)
#print(my_num)
#add ing elemnets of 2 lists
#num4 = [1,2,3,4,5]
#num5 = [6,7,8,9,10]
#print("Min in nums", min(nums))
#res2 = []
#for i in range(0, len(num4)):
#    res2.append(num4[i]+num5[i])
#print(res2)

#tuples - immutable lists, sequenctial, different and same data types
'''
nums = (1,2,3,4,5,2,4)
print(nums)
students=(('SI123','SPIC',22990),('SI456','DA',90045),('SI789','DS',74832),('SI1011','.NET',428293))
serial=1
print("Sr.No SIID Course ID")
print("*"*30)
for i in students:
    print(f"{serial}. ",end="")
    for j in range(len(i)):
        print(i[j], end="")
        if j < len(i) - 1:
            print(", ", end="")
    print()
    serial+=1
#slicing in tuple - start, end, step
tu2=(1,2,3,4,5,6,7,8,9)
sub=tu2[:-3]
sub2=tu2[-5:-1]
print(sub)
print(sub2)
#Unpacking and packing in python for tuples
emp = ("Aditya", 23, "Software Engineer",1234455)
name, age, designation = emp
print(name, age, designation)
name="Abhijeet"
designation="Data Analyst"
print(name)
print(designation)
emp=(name, 30, designation)
print(emp)'''
#Write a program to check whether a tuple is palindrome or not
'''tu=tuple(input("Enter a tuple to check for plaindrome:"))
if tu == tu[::-1]:
    print(tu,"is palindrome")'''
#write a program to create tuple for user inputted employees and each has a tuple of id, name, salary and also find the highest salary of them
'''
no_of=int(input("Enter no. of employees:"))
employees=[]
for i in range(0,no_of):
    emp_id=int(input("Enter your employee id:"))
    emp_name=input("Enter your employee name:")
    emp_salary=float(input("Enter your annual salary"))
    #optimize it coz we are using to much memory use list and then add to empolyees tuple
    li_emp = [emp_id, emp_name, emp_salary]
    #emp=(emp_id, emp_name, emp_salary)
    employees+=[li_emp]
    print(id(employees))
snr=1
emp_tup=tuple(employees)
print("Sr.No EmpID, Name, Salary")
print("*"*30)
for i in employees:
    print(f"{snr}. ",end="")
    for j in range(len(i)):
        print(i[j],end="")
        if j < len(i) - 1:
            print(", ",end="")
    print()
    snr+=1

#now to find the largest of employee salaries
max_sal=employees[0]
for i in employees:
      if i[2] > max_sal[2]:
        max_sal=i
print("The highest salary is:",max_sal[2])
'''
'''
#sets - unordered and no repeatation
my_set_nums = {1,2,3,4,5}
print(my_set_nums)

#dictionaries - key - value -  duplicate key can overwrite the original 
#key is allowed, values can be duplicate without overwrite as they have separate unique key
#dict - value mutable, key immutable, heterogeneous, no slicing and indexing. Order of insertion is maintained
my_bucket_list = {
    "India":("New Delhi","Mumbai","Mathura","Kashi","Ayodhya","Jaipur","Gangtok"),
    "Japan":("Tokyo","Koyto","Nara"),
    "Phillipines":"Manila",
    "Australia":"Sydney",
    "Iran":("Tehran","Percepolis"),
    "Nepal":"Kathmandu",
    "Italy":["Rome","Naples","Palermo","Imola"],
    "France":"Marsellies",
    "Germany":"Munich",
    "Poland":"Warsaw",
    "Brazil":"Rio De Jenerio",
    "Canada":("Ottawa","Toronto"),
    "USA":["Washington DC","Texas","Florida"],
    "Oman":"Muscat",
    "UAE":"Dubai",
    "South Africa":"Cape of Good Hope",

}
print("My bucket list")
print(my_bucket_list.keys())
print(my_bucket_list.values())
for keys, values in my_bucket_list.items():
    print(keys,":",values)
#want to add new element 
my_bucket_list["Spain"]="Madrid"
my_bucket_list["Portugal"]="Lisbon"
my_bucket_list["South Korea"]=["Seoul","Jeju"]
#updating an existing element
my_bucket_list["Italy"].append("Venice")#it is list no problem
print("After updating the dict")
print(my_bucket_list.keys())
for keys, values in my_bucket_list.items():
    print(keys,":",values)
my_bucket_list.pop("Spain")
my_bucket_list.popitem()#removes last inserted item, LIFO principal
print("After removing some elements")
print("{\n")
for keys, values in my_bucket_list.items():
    print(keys,":",values,",")
print("\n}")
my_bucket_list.clear()
# Write a python function generate_grades (student_dict) that takes a dictionary containing student names as keys and their marks (out of 100) as values. 
# The program should creat new dicitonary where students are assigned grades:
#  user defined 

student_marks = {}
n = int(input("Enter number of students:"))
if n >= 0 and n <= 20:
 for i in range(n):
    name = input("Enter student name:")
    marks = int(input("Enter student marks:"))
    if marks >= 0 and marks <= 100 and name.isalpha():
        student_marks[name] = marks

if len(student_marks) != 0 or student_marks.values() != -1 or student_marks.keys() != " ":
  for names,marks in student_marks.items():
    if 90 <= marks <= 100:
        student_marks[names]="A"
    elif 80 <= marks <= 89:
        student_marks[names]="B"
    elif 70 <= marks <= 79:
        student_marks[names]="C"
    elif 60 <= marks <= 69:
        student_marks[names]="D"
    else:
        student_marks[names]="F"
print("Marks to Grade Conversion for",n,"students-")
print("{\n")
for keys, values in student_marks.items():
    print("\t",keys,":",values,",")
print("\n}")'''
#write program to tkae string text and return a dict of key as words and value as the no. of occurances
'''text = input("Enter a string:")
string_to_list = text.split()
word_count_from_list = {}
for word in text.split():
    #remove punctuation and normalize the words 
    word = word.lower().strip('.,!?";\'')
    #using get to get the int value, also if its new word then default to 0 otherwise add 1
    #this is counting freq using get(key,default) func of dict
    word_count_from_list[word] = word_count_from_list.get(word,0)+1
   
    #if word in word_count_from_list:
    #    word_count_from_list[word] += 1
    #else:
    #    word_count_from_list[word] = 1
for k, v in word_count_from_list.items():
    print(f"{k}:{v}")'''
#print(word_count)
#a user inputted nested dict where dict={key:{}..} and print the it
#unpacking dict using **
dict1 = {"a": 1, "b": 2}
dict2 = {"c": 3, "d": 4}
merged_dict = {**dict1, **dict2}
print(merged_dict)

n = int(input("Enter number of employees:"))
employees = {}
if n >= 0 and n <= 20:
    for i in range(n):
        print(f"Sr No {i+1}")
        emp_name=input("Enter your name:")
        emp_id=int(input("Enter your employee id:"))
        emp_salary=float(input("Enter your gross salary:"))
        emp_function=input("Enter your designation:")
        emp_dept=input("Enter your department:")
        if emp_name.isalpha() and emp_dept.isalpha() and emp_function.isalpha():
         employees[emp_id]={"Name":emp_name,"ID":emp_id,"Gross Salary":emp_salary,"Designation":emp_function,"Department":emp_dept}
        #else:
         #   employees[-1] = {}
          #  break
#print(employees)
print("Employee Details: ")
#format - id: name-, etc, wanna use ** for unpacking the inner dict
for emp_id, emp_info in employees.items():
    print(f"ID: {emp_id}-\t", end="")
    print(", ".join(f"{k}: {v}" for k, v in emp_info.items() if k != "ID"))
    #for key, value in emp_info.items():
     #   if key == "ID":
     #    continue
     #   else:
     #       print(f"{key}: {value}, ")
    print()

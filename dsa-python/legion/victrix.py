#employee data is stored, searched, displayed and updated, deleted too
def store_data(emp_dict):
    id = input("Enter employee ID: ")
    name = input("Enter employee name: ")
    age = int(input("Enter employee age: "))
    dept = input("Enter employee department: ")
    desgination = input("Enter employee designation: ")
    if id.isalnum() and dept.isalpha() and name.isalpha()  and age > 0:
     emp_dict[id] = {'Id': id,
                     'Name': name, 
                     'Age': age, 
                     'Department': dept ,
                     'Designation': desgination
                    }
    print(f"Employee data stored successfully: {emp_dict[id]}")

def search_by_id(emp_dict):
   id = input("Enter the id to be searched: ")
   if id in emp_dict:
      for id, details in emp_dict[id]:
         print(f"Employee details: {details}")
   else:
      print("Employee not found")

def display_emp(emp_dict):
    for id, details in emp_dict.items():
        print(f"Employee ID: {id}, Details: {details}")
    
def update_by_id(emp_dict):
   id = input("Enter the id to be updated: ")
   if id in emp_dict:
        name = input("Enter new employee name: ")
        age = int(input("Enter new employee age: "))
        dept = input("Enter new employee department: ")
        desgination = input("Enter new employee designation: ")
        if id.isalnum() and dept.isalpha() and name.isalpha()  and age > 0:
         emp_dict[id] = {'Id': id,
                         'Name': name, 
                         'Age': age, 
                         'Department': dept ,
                         'Designation': desgination
                        }
        print(f"Employee data updated successfully.")
   else:
        print("Employee not found")

def delete_emp(emp_dict):
   id = input("Enter the id to be deleted: ")
   if id in emp_dict:
        del emp_dict[id]
        print(f"Employee data deleted successfully.")
   else:
      print("Employee not found")
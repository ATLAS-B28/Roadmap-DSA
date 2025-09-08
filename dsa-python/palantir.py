#menu drive with ability for the user to continue or exit the program 
#and choices to select from
from legion.victrix import *
def employee_management():
    emp_dict = {}
    while True:
        print("\t\t\tPalantir Employee Management System: ")
        print("1. Store employee data")
        print("2. Search employee by ID")
        print("3. Display all employee data")
        print("4. Update employee by ID")
        print("5. Delete employee by ID")
        print("6. Exit")
        print()
        choice = int(input("Enter your choice: "))
        print()
        if choice == 1:
            store_data(emp_dict)
        elif choice == 2:
            search_by_id(emp_dict)
        elif choice == 3:
            display_emp(emp_dict)
        elif choice == 4:
            update_by_id(emp_dict)
        elif choice == 5:
            delete_emp(emp_dict)
        else:
            print("Exiting the program.")
            break
        yes_no = input("Do you want to continue the operation?")
        if yes_no == 'yes':
            print()
            continue
        else:
            print()
            break
employee_management()
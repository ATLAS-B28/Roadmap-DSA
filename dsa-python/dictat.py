'''
Menu driven - Enter Sales person data, create dict for each, we could
store in another dict, update, delete and display them all this without functions 
2nd part is to bifurgate data using NORTH, SOUTH, EAST, WEST
'''
sales = {}
regions = {'NORTH': {}, 'SOUTH': {}, 'EAST': {}, 'WEST': {}}
print("Sales Person Management System:-")
n = int(input("Enter the number of Sales Persons to be added: "))
if n >= 0 and n <= 100:
    for i in range(n):
        sales_person_name=input("Enter Sales Person Name: ")
        sales_person_id=int(input("Enter Sales Person ID: "))
        sales_person_sales=int(input("Enter Sales Person Sales Performance current Quarter: "))
        sales_person_target=int(input("Enter Sales Person Target current Quarter: "))
        sales_person_region=input("Enter Sales Person Region (NORTH, SOUTH, EAST, WEST): ").upper()
        if (sales_person_id != 0 and 
            sales_person_name.isalpha() and 
            sales_person_id >= 0 and 
            sales_person_region in regions and 
            sales_person_sales > 0 and
            sales_person_target > 0):

            sales[sales_person_id]={
                'Sales Person ID':sales_person_id,
                'Sales Person Name':sales_person_name,
                'Sales Person Sales Performance current Quarter':sales_person_sales, 
                'Sales Person Target Current Quarter':sales_person_target,
                'Sales Person Region':sales_person_region
            }
print("\nSales Person Data Added Successfully!")

#while not 0 do this operations if 0 then just break and end the program
while True:
#functionality to keep doing operations until the user wants for that a Yes no prompt is used
 choice = input("Do you want to continue with your choice (yes/no)? ").lower()
 if choice == 'yes':     
   print("\nOperations-")
   print("1. Update Sales Person Data")
   print("2. Delete Sales Person Data")
   print("3. Display All Sales Person Data")
   print("Any number other than 1, 2, 3 to Exit")
   option=int(input("Enter the operation number: ")) 
   if option == 1:
     print("Enter sales person ID to update")
     sales_person_id = int(input("Enter Sales Person ID: "))
     if sales_person_id in sales:
        print("Enter new details")
        sales_person_name=input("Enter Sales Person Name: ")
        sales_person_sales=int(input("Enter Sales Person Sales Performance current Quarter: "))
        sales_person_target=int(input("Enter Sales Person Target current Quarter: "))
        sales_person_region=input("Enter Sales Person Region (NORTH, SOUTH, EAST, WEST): ").upper()
        if sales_person_name.isalpha() and sales_person_id >= 0 and sales_person_region in regions and sales_person_sales > 0:
            sales[sales_person_id]={
                'Sales Person ID':sales_person_id,
                'Sales Person Name':sales_person_name,
                'Sales Person Sales Performance current Quarter':sales_person_sales, 
                'Sales Person Target Current Quarter':sales_person_target,
                'Sales Person Region':sales_person_region
            }
            print("Sales Person Data Updated Successfully!")
            print(sales)
        else:
            print("Invalid Input")
   elif option == 2:
     print("Enter the ID to delete sales person: ")
     sales_person_id = int(input("Enter Sales Person ID: "))
     if sales_person_id in sales.keys():
        del sales[sales_person_id]
        print("Sales Person Data Deleted Successfully!")
     else:
        print("Sales Person Data Not Found!")
   elif option == 3:
     print("Enter the ID for sales person to be displayed: ")
     sales_person_id = int(input("Enter Sales Person ID: "))
     if sales_person_id in sales:
        print("Sales Person Data:-")
        #formatting the print statement
        for key, value in sales[sales_person_id].items():
            print(f"{key}: {value}\t", end="")
        print("Sales Person Data Displayed Successfully!")
     else:
        print("Sales Person Data Not Found!")
   elif option == 4:
     print("Exiting the program.")
 elif choice == 'no':
  break
#adding the user inputted region bifurcation operation like searching a sales person
print("\nOperation to bifurcate data based on regions underway...")
#for key and values in sales, if value has region key present in regions 
for key, value in sales.items():
    if value.get('Sales Person Region') in regions.keys():
        regions[value.get('Sales Person Region')]=value
region = input("Enter the region to display data (NORTH, SOUTH, EAST, WEST): ").upper()
if region in regions:
   print(f"Sales Person Data for {region} Region:-")
   print(regions[region])
else:
   print("Region not found please enter proper region name.")
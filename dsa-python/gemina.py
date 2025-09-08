from legion.adiutrix import (string_splitting, string_joining)
from legion.gallica import shape_dict
from legion.MenuDrive import *

def main():
    ele_dict1 = {}
    ele_list = []
    while True:
        print("Choose an operation:")
        print("1. Dictionary operations")
        print("2. List operations")
        print("3. String operations")
        print("4. Calculate the area of a shape")
        print()
        choice = int(input("Enter your choice (1/2/3/4) or any other key to exit: "))
        print()
        if choice == 1:
         while True:
          
          print()
          add_func_dict(ele_dict1)
          sort = sort_func_dict(ele_dict1)
          print(f"Sorted elements by frequency: {sort}")
          search_dict(ele_dict1)
          cont = input("Do you want to continue with dictionary operations? (y/n): ")
          if cont.lower() != 'y':
              break
        elif choice == 2:
            while True:
             
             add_func_list(ele_list)
             search_func_list(ele_list)
             sort_func_list(ele_list)
             update_func_list(ele_list)
             update_element_func_list(ele_list)
             cont = input("Do you want to continue with list operations? (y/n): ")
             if cont.lower() != 'y':
                 break
        elif choice == 3:
            while True:
              str1 = input("Enter the string to be split: ")
              split_str = string_splitting(str1)
              print(f"Split string: {split_str}")
              str2 = input("Enter the delimiter for joining: ")
              joined_str = string_joining(split_str, str2)
              print(f"Joined string: {joined_str}") 
              cont = input("Do you want to continue with string operations? (y/n): ")  
              if cont.lower() != 'y':
                 break
        elif choice == 4:
            shape = input("Enter the shape (square, rectangle, circle): ")
            if shape in shape_dict:
                #if so then check which is it then access the dictationary and call the function with []() notation
                if shape == 'square':
                    side = float(input("Enter the side length: "))
                    area = shape_dict[shape](side)
                    print(f"Area of {shape}: {area}")
                elif shape == 'rectangle':
                    length = float(input("Enter the length: "))
                    breadth = float(input("Enter the breadth: "))
                    area  = shape_dict[shape](length, breadth)
                elif shape == 'circle':
                    radius = float(input("Enter the radius: "))
                    area = shape_dict[shape](radius)
                    print(f"Area of {shape}: {area}")
        else:
            print("Exiting the program.")
            break
        input1 = input("Do you want to continue? (y/n): ")
        if input1.lower() != 'y':
            break

main()
from legion.adiutrix import *

def add_func_dict(ele_dict1):
    ele = input("Enter the element to be added: ")
    add_ele(ele, ele_dict1)
    print(f"Current frequency dictionary: {ele_dict1}")
def sort_func_dict(ele_dict1):
    sorted_elements = sort_by_freq(ele_dict1)
    return sorted_elements
def search_dict(ele_dict1):
    input2 = input("Enter key to search in the dictionary: ")
    search = get_ele(input2, ele_dict1)
    print(f"Element is present in the dictionary: '{input2}': {search}")

def add_func_list(ele_list):
        ele1 = input("Enter the element to be added: ")
        add_list(ele1, ele_list)
        print(f"Current list: {ele_list}")
def search_func_list(ele_list):
    ele2 = input("Enter the element to be searched: ")
    index = get_list_ele(ele2, ele_list)
    print(f"Index of '{ele2}' in the list: {index}")
def sort_func_list(ele_list):
    sorted_list = sort_list(ele_list)
    print(f"Sorted list: {sorted_list}")
def update_func_list(ele_list):
    ele3 = input("Enter new element to update the list: ")
    updated_list = update_list(ele3, ele_list)
    print(f"Updated list: {updated_list}")
def update_element_func_list(ele_list):
     index_to_update = int(input("Enter the index to update the element: "))
     element_to_update = input("Enter the new element to be placed at the index: ")
     updated_list_element = update_list_element(element_to_update, ele_list, index_to_update)
     print(f"List after updating element at index {index_to_update}: {updated_list_element}")
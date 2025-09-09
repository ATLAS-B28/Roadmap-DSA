'''
* Courses being are offered to students. Students
* have the facility to check which course is available
* at institution. Write a program
* 1. Search of course
* 2. Sort the list of courses in an ascending alphabets
* 3. Sort courses in ascending order of length of spelling
'''
list = ["Java","Python","JS","C++","C#","Go","Rust","TS","Erlang","Elixir","Gleam","R","Scala","Kotlin"]

def search_course(course):
    if course in list:
        return f"{course} is available"
    else:
        return f"{course} is not available"
    
def sort_courses_len():
    #sort using for, if loops
    for i in range(len(list)):
        for j in range(len(list) - 1 - i):#as i increases the length of unsorted goes on decereasing 
            if len(list[j]) > len(list[j + 1]):#len is used to get the word length and compare them 
                list[j], list[j + 1] = list[j + 1], list[j]#if jth > j+1th and swap them
    return list

def sort_courses_alpha():
    for i in range(len(list)):
        for j in range(len(list) - 1 - i):#as i increases the length of unsorted goes on decereasing 
            if list[j].lower() > list[j+1].lower():#after using lower, if jth > j+1th and swap them else just move on
                list[j], list[j + 1] = list[j + 1], list[j]
    return list
'''
Also 2nd question - take 2 lists and merge them into 3rd lists 
and size should be dynamically
after that reverse the 3rd list
'''

def create_list():
    '''n = int(input("Enter the size of the array 1: "))
    list = []
    for i in range(n):
        ele = int(input("Enter element: "))
        list.append(ele)
    return list'''
    n = int(input("Enter the size of the array: "))
    return [int(input("Enter element: ")) for _ in range(n)]
    #here _ is a throwaway variable, as we don't have to operate on it

def merge_list(list1, list2):
    '''"""list3 = list1 + list2
    return list3"""'''
    return [*list1, *list2]#unpacking the lists 

def reverse_list(list3):
    #using slicing to reverse the list
    return list3[::-1]

def main():
    course = input("Enter course to search: ")
    print(search_course(course))
    print("Courses sorted by length of spelling: ", sort_courses_len())
    print("Courses sorted in alphabetical order: ", sort_courses_alpha())
    print("Creating first list:")
    list1 = create_list()
    print("Creating second list:")
    list2 = create_list()
    print("List 1: ", list1)
    print("List 2: ", list2)
    print("Merged List: ")
    list3 = merge_list(list1, list2)
    print("List 3: ",list3)
    print("Reverse List: ")
    print(reverse_list(list3))

if __name__ == "__main__":
    main()


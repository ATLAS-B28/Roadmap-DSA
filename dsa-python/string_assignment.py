print("\t\tAssignment on String")

#s = input("Enter the String: ")
print("1. Write a program in Python to find whether the input contains only alphabets either capital or small or it alphanumeric only.")
print("2. To find all words starting with the latter 'a' in a givn string.")
print("3. Consider the list give below. Extract all positive elements from the list, suing list comprehension syntax.")
print("4. Consider the list give below. filter the below list t obtain a new list that contains only scripting.")
print("5. Create a decorator name '@capitalcase_decorator' that when applied to any function converts the string parameter of the target function to an uppercase letters.")
print("6. Using the list given below write a python program to find the square of eacg element in the list.")
print("7. Using the list given below write a python program to find all the names that start with letter R.")

ch = int(input("Enter your choice: "))
if ch == 1:
    text = input("Enter the String: ")
    if text.isalpha():
        print("The string contains only Alphabets.")
    elif text.isalnum():
        print("The string is Alphanumeric.")
    else:
        print("The string contains Special Characters too.")

elif ch == 2:
    string = "Apple is a fruit, and apricot is another one and Almond is a dry fruit."
    words_with_a=[]
    for word in string.split():
        if word.startswith('a') or word.startswith('A'):
            words_with_a.append(word)
    print("Words starting with 'a': ",words_with_a)
        
elif ch == 3:
    linums = [12,-4,75,-35,-92,121,500,-235]
    positive_nums = [x for x in linums if x>0]
    print("Positive numbers: ",positive_nums)

elif ch == 4:
    languages = ["Javascript", "Python", "R", "Golang", "C++", "Java", "Typescript", "Shell script"]
    scripting = [lang for lang in languages if "script" in lang]
    print("Scripting languages: ",scripting)

elif ch == 6:
    numlist = [3,5,7,4,11,8,9]
    squares = [x**2 for x in numlist]
    print("Squares: ",squares)

elif ch == 7:
    names = ["Abhijeet", "Rukia", "Aditya", "Red Ranger", "Aditi", "Roshani"]
    r_names = [name for name in names if name.startswith('R')]
    print("Names starting with 'R':",r_names)
else:
    print("Invalid choice! Please try again.")
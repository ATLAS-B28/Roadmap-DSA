from legion.adiutrix import custom_ord, custom_chr

#write a program to accept a 2 diff. characters and display the sum and diff. of their ASCII values.
#sample o/p - The sum of ASCII values = 165 and diff. of ASCII values = 35
def ascii_values():
    char1 = input("Enter 1st character: ")
    char2 = input("Enter 2nd character: ")
    if len(char1) == 1 and len(char2) == 1:
        sum_ascii = custom_ord(char1) + custom_ord(char2)
        diff_ascii = custom_ord(char1) - custom_ord(char2)
        print(f"The sum of ASCII values = {sum_ascii} and diff. of ASCII values = {abs(diff_ascii)}")
        print()
    else:
        print("Please enter only single characters.")
        print()
#Write a program to accept a alphabet in upper case or in lowr case. Display the next alphabet 
#accordingly i.e. 'a' follows 'b' and 'z' follows 'a'
def next_alpha(char):
    #check if the char is alphabet and not empty then
    #go into the loop if z is there loop back and return a same for upper case
    #for others use the char to ascii map to get the equivalent value and add 1 get the next char
    #and covert back using ascii to char map
    if char.isalpha() and char != " ":
        if char == 'z':
            return 'a'
        elif char == 'Z':
            return 'A'
        else:
            return custom_chr(custom_ord(char) + 1)
#Write a program to accept a character if it is a letter then display the case i.e. lower to upper
#otherwise check whether it is digit or special character
#Sample i/p - p
#Sample o/p - 'p is a letter p is a lower case'
def character_case_check():
    char = input("Enter a character: ")
    if len(char) == 1:
        if char.isalpha():
            if char.islower():
                print(f"{char} is a letter and it is a lower case")
            else:
                print(f"{char} is a letter and it is a upper case")
        elif char.isdigit():
            print(f"{char} is a digit")
        else:
            print(f"{char} is a special character")
    else:
        print("Please enter only single characters.")
#Write a program in java accept a string/word and display the new string after removing all the vowels present in it
#Sample i/p - COMPUTER APPLICATIONS
#Sample o/p - CMTR PPLCTNS
def remove_vowels():
    str1 = input("Enter a string: ")
    vowels = "aeiouAEIOU"
    new_str = ''.join(char for char in str1 if char not in vowels)
    return new_str
#Write a program to input a word/string count all the alphabets excluding vowels present in the word/string
#Sample i/p - Happy New Year
#Sample o/p - no. of alphabets excluding vowels = 8
def count_alphabets_excluding_vowels():
    str1 = input("Enter a string: ")
    vowels = "aeiouAEIOU"
    total_non_vowels = sum(1 for char in str1 if char.isalpha() and char not in char)
    return total_non_vowels

def main():
    while True:
        print("Menu:")
        print("1. ASCII Values")
        print("2. Next Alphabet")
        print("3. Character Case Check")
        print("4. Remove Vowels from String")
        print("5. Count Alphabets Excluding Vowels")
        print("6. Exit")
        choice = int(input("Enter your choice: "))
        if choice == 1:
            ascii_values()
        elif choice == 2:
            val = input("Enter a character: ")
            if len(val) == 1:
                print(f"The next alphabet is {next_alpha(val)}")
            else:
                print("Please enter only single characters.")
        elif choice == 3:
            character_case_check()
        elif choice == 4:
            print(f"After removing the vowels: {remove_vowels()}")
        elif choice == 5:
            print(f"Alphabets excluding vowels are: {count_alphabets_excluding_vowels()}")
        elif choice == 6:
            print("Exiting the program.")
            break
        else:
            print("Invalid choice. Please try again.")
            print()
        cont = input("Do you want to continue? (yes/no): ")
        if cont.lower() != 'yes':
            break

main()
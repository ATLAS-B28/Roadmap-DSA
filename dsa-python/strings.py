#strings are immutable, no modification
#character are extracted using forward from 0 and backward from -1
#during concatenation of strings a new string is created~
#* is used for replication
#Slicing - in string we can get fargment of the string using [:] here [start:stop:step]
#in slicing start is inclusive and stop is exclusive
#in slicing step is optional and by default it is 1
#in slicing if start is not mentioned it is considered as 0
#in slicing if stop is not mentioned it is considered as len(string)
#in slicing if step is not mentioned it is considered as 1
#in slicing if step is negative then start should be greater than stop
#in slicing if step is negative then start and stop are considered from backward
#in slicing if start is greater than stop and step is positive then it will return empty string
#in slicing if start is less than stop and step is negative then it will return empty string
#string functions - len(), min(), max(), str()
#string methods - upper(), lower(), find(), replace(), split(), join(), strip(), isalpha(), isdigit(), isalnum(), 
#startswith(), endswith(), index(), islower, isupper, count(), split, splitline
#slicing example
'''
s = "Hello, World!"
print(s[0:5]) #Hello
print(s[7:12]) #World
print(s[:5]) #Hello
print(s[7:]) #World!
print(s[:]) #Hello, World!
print(s[::2]) #Hlo ol!
print(s[1::2]) #el ol!
print(s[::-1]) #!dlroW ,olleH
print(s[-1:-6:-2]) #!dlro
print(s[-6:-1]) #World
lang = "Rust"
for la in lang:
    print(la, end="\t")
print()
data=[1,2,4,[233,4553,13123],"Aditya",12.34,4.09]
for i in data:
    if type(i)==list:
        for j in range(len(i)):
            print(i[j],end=", ")
        print("\n")
        continue
    print(i)'''
#for i in data[3]:
 #   print(i)
''''
print("Ad" in "Aditya")
print("Ad" not in "Aditya")
print("ua" in "Aditya")
print(" " in "hello world")
print("Aditya\'s native language is \"Marathi\"")
msg = "Hello, World!"
print("Occurance of l:", msg.count("l"))
print("Count of L:", msg.count("L"))'''

#msg2 = '''\'Rust\' is an incredible 
#language to learn and build applications in.'''
'''
print(msg2)
print(msg2.endswith("build applications in."))
print(msg2.startswith("\'Rust\'"))
print(msg2.find("learn"))
print(msg2.split())
print(msg2.splitlines())
num="-244"
print(num.zfill(6))
text = "random-text---"
print(text.zfill(20))'''
#menu driven program take a string from user
'''
perform
1. split string into word while removing the punctuation marks
2. join the words back into a sentence with a custom separator ('|')
3. Partition the string based on 1st occurance of user inputted word
4. Reverse the words order using split() and join()
5. Count Vowels, Consonants, numbers, special characters
6. Remove Duplicate Characters
7. Count a Specific Character in a String
No need of function just simple set of if's and for loops and 
using the string inbuilt functions to perform operations 
'''
print("\t\tMenu Driven Assignment")
s = ""
print("1. Split string into words while removing punctuation marks")
print("2. Join the words back into a sentence with a custom separator ('|')")
print("3. Partition the string based on 1st occurance of user inputted word")
print("4. Reverse the words order using split() and join()")
print("5. Count Vowels, Consonants, numbers, special characters")
print("6. Remove Duplicate Characters")
print("7. Count a Specific Character in a String")
print("8. Exit")
ch = int(input("Enter your choice: "))
if ch == 1:
    s = input("Enter a String with punctuation '-' : ")
    '''
    to remove all punctuation marks we need a list of all of them, 
    punctuation_marks = [',', '.', ':', ';', '!', '?', '"', "'", '(', ')', '[', ']', '{', '}', '-', '_', '+', '=', '*', '/', '%', '^', '&', '$', '#', '@', '~', '`', '|', '\\', '<', '>', ' ']
 
    for mark in punctuation_marks:
        s = s.replace(mark, ' ')
    '''
    #if checks for non - symbols
    for cha in s:
        if not cha.isalnum() and cha != '-':
            s = s.replace(cha, ' ')
    if len(s) == 0:
        print("No words in the string, please input a proper string with '-'")
        exit(0)
    #now we can split the string into words
    words = s.split('-')
    print("Words in the string are:")
    print(words)
elif ch == 2:
    s = input("Enter a String: ")
    if len(s) == 0:
        print("No words in the string, please input a proper string")
        exit(0)
    #we have split it and rejoin while adding the separator
    word = s.split()
    join_words = '|'.join(word)
    print("Joined string with '|' separator is:")
    print(join_words)
elif ch == 3:
    s = input("Enter a String: ")

    word_partition = input("Enter a word to separate the sentence:")
    res = s.partition(word_partition)#destructuring a tuple
    #what if I input is This is my cat with separator as is then it will split it on This<-is But I want the is only - challenge
    if res[1]:
         print("Words when with", res[1], "separator:",res[0], res[2])
    else:
        print("No such word in the string")
elif ch == 4:
    s = input("Enter a String: ")
    words = s.split()
    reverse_words =' '.join(words[::-1])
    print("Reversed words order is:")
    print(reverse_words)
elif ch == 5:
    s = input("Enter a String: ")
    vowels = "aeiouAEIOU"
    vowels_count = 0
    consonants_count = 0
    num_count = 0
    special_count = 0
    special_characters = "!@#$%^&*()-+={}[]|\\:;\"'<>,.?/~`"
    for cha in s:
        if cha in vowels and cha.isalpha():
            vowels_count += 1
        elif cha not in vowels and cha.isalpha(): 
            consonants_count += 1
        elif cha.isdigit():
            num_count += 1
        #now for special characters we need a string and see if cha belongs to it or no and then count
        elif cha in special_characters:
            special_count += 1
    print("Vowels:", vowels_count)
    print("Consonants:", consonants_count)
    print("Numbers:", num_count)
    print("Special Characters:", special_count)
elif ch == 6:
    s = input("Enter a String: ")
    is_there = ""
    for cha in s:
        if cha not in is_there:
            is_there += cha
    print(is_there)   
elif ch == 7:  
    s = input("Enter a String: ")  
    char_to_count = input("Enter a character to count:")
    count = 0
    for cha in s:
        if cha == char_to_count:
            count += 1
    print(count)
elif ch == 8:
    print("Exiting the program")
else:
    print("Invalid choice")




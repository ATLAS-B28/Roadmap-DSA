'''
Objective:
To practice creating, reading, writing, and manipulating text files using Python.
Q1. Create and Write to a File (Basic)
Write a Python program to:
1. Create a new text file named 'student.txt'.
2. Write the following student names into it:
   Shivansh
   Rohan
   Aditi
   Priya
   Ankit
3. Display a message: "File created and data written successfully!"
Q2. Read and Display File Content
Write a Python program to read 'student.txt' and display all the names line by line.
Example Output:
Shivansh
Rohan
Aditi
Priya
Ankit

with open("students.txt", "w")  as file:
    file.write("Aditya\nAbhijeet\nKakashi\nShinji")
print("File created and data written successfully!")
with open("students.txt", "r") as file:
    for line in file:
        print(line.strip())
'''
'''
Q3. Count the Total Number of Words
Create a file named 'story.txt' and write a small paragraph (5-6 lines).
Write a program to:
- Count the total number of words in the file.
- Print the result.
Sample Output:
Total words in file: 42
Q4. Search for a Word in a File
Write a program to:
- Ask the user to enter a word.
- Check whether the word exists in 'story.txt'.
- Print "Word found" or "Word not found" accordingly.

with open("story.txt", "w") as file:
    file.write("Once upon a time in a magical land, there lived a brave knight named Sir Lancelot. He was " \
    "known for his courage and bravery. One day, while exploring the enchanted forest, " \
    "he stumbled upon a hidden treasure. With his heart filled with joy, he returned home, " \
    "forever changed by his extraordinary adventure.")
print("File created and data written successfully!")
with open("story.txt", "r") as file:
    #count words
    content = file.read()
    words = content.split()
    count = len(words)
    print("Total words in file: ", count)
with open("story.txt", "r") as file:
    word = input("Enter a word: ")
    if word in file.read():
        print("Word found")
    else:
        print("Word not found")
'''
'''
Q5. Copy File Content to Another File
Write a program to:
1. Read the content of 'story.txt'.
2. Copy it into a new file named 'backup.txt'.
3. Print a message "Content copied successfully!"
Q6. Append Data to an Existing File
Write a program to:
- Open 'student.txt' in append mode.
- Add three more names:
  Neha
  Karan
  Mehul
- Display the updated content of the file.

#copy 
with open("story.txt", "r") as file:
    content = file.read()
    with open("backup.txt", "w") as backup:
        backup.write(content)
        print("Content copied successfully!")

Q7. Count Lines, Words, and Characters
Write a program to read 'story.txt' and display:
- Total number of lines
- Total number of words
- Total number of characters (including spaces)
Example Output:
Lines: 6
Words: 45
Characters: 270

with open("story.txt", "r") as file:
    content = file.read()
    lines = content.split('\n')
    words = content.split()
    char = content
    print("Lines: ", len(lines))
    print("Words: ", len(words))
    print("Characters: ", len(char))
'''
'''
Q8. Remove Blank Lines from a File
Write a program to:
- Remove all blank lines from 'story.txt'.
- Save the updated content into 'clean_story.txt'.

Q9. Find and Replace a Word in a File
Write a program to:
- Ask the user for a word to find and a word to replace it with.
- Replace all occurrences of the word in 'story.txt'.
- Save the changes in the same file.
Q10. Display Top 5 Longest Words
Write a Python program to:
- Read 'story.txt'.
- Display the top 5 longest words present in the file.
Example Output:
Longest words: ['Programming', 'Adventure', 'Beautiful', 'Experience', 'Journey']

with open("story.txt", "r") as file:
    content = file.read()
find_word = input("Enter a word to find: ")
replace_With = input("Enter a word to replace with: ")
new_content = content.replace(find_word, replace_With)
with open("story.txt", "w") as file:
    file.write(new_content)
with open("story.txt", "r") as file:
    content = file.read()
    words = content.split()
    words.sort(key=len, reverse=True)
    print("Longest words: ", words[:5])
'''
import os
#try:
#    os.rename("story.txt", "finalfantasy.txt")
#    print("File renamed successfully")
#except:
#    print("Not renamed successfully")
#print(os.getcwd())
print(os.chdir("C:\\Users\\abhij\\OneDrive\\Desktop\\PrepV2\\dsa-python"))
print("Changed to:", os.getcwd())
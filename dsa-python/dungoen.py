#create a program to create a func to make a directory and 2 more sub dir and make it the current directory
import os
'''def create_directory():
    os.mkdir("Python Assignment")
    os.chdir("Python Assignment")
    os.mkdir("Data")
    os.mkdir("Backup")
    print("Directory created successfully")
create_directory()
#list and filter the files in the Data dir of the Python Assignment Dir
#5 in number all are text and named data1 to data5
def create_file():
    os.chdir("C:\\Users\\abhij\\OneDrive\\Desktop\\PrepV2\\Python Assignment\\Data")

    for i in range(1,6):
        with open(f"data{i}.txt", "w") as file:
            file.write(f"This is data{i}")
def display_files():
    os.chdir("C:\\Users\\abhij\\OneDrive\\Desktop\\PrepV2\\Python Assignment\\Data")

    for file in os.listdir():
        if file.endswith(".txt"):
            print(file)'''
def write_file_names():
    os.chdir("C:\\Users\\abhij\\OneDrive\\Desktop\\PrepV2\\Python Assignment\\Data")
    with open("file_names.txt", "w") as file:
        for file_name in os.listdir():
            if file_name.endswith(".txt"):
                file.write(file_name + "\n")
#create_file()
#display_files()
write_file_names()
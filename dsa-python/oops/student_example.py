#student class takes name, id, age, fee details
class Students:
    school = "Jhon 23rd School"
    year = 2014
    name = None
    id = None
    age = None
    fee = None
    __fee_details = None
    def __init__(self, name, id, age, fee, fee_details):
        self.name = name
        self.id = id
        self.age = age
        self.fee = fee
        self.__fee_details = fee_details
    def __str__(self):
        return f"\nName: {self.name}\nAge: {self.age}\nFee: {self.fee}\nSchool:{self.school}\nYear:{self.year}\nFee Details: {self.__fee_details}"
   # def dispaly_details(self):
    #    return f'\nName: {self.name}\nAge: {self.age}\nFee: {self.fee}'
    def __display_fee_details(self):
        return self.__fee_details
    def calculate_fee(self):
        if self.__fee_details == "paid":
            return f"Fee paid. Total Amount = {self.fee*12}"
        elif self.__fee_details == "unpaid":
            return f"Fee unpaid. Total Amount = {self.fee*12}"
    @classmethod
    def change_school(cls, school_name):
        cls.school = school_name
        return cls.school
    @classmethod
    def year_change(cls, year):
        cls.year = year
        return cls.year
    @staticmethod
    def calculate_age(birth_year):
        return 2024 - birth_year
        
students = {}
n = int(input("Enter number of students:"))
for _ in range(n):
    for i in range(1):
        name = input("Enter student name:")
        id = int(input("Enter student id:"))
        age = int(input("Enter student age:"))
        fee = int(input("Enter student fee:"))
        fee_details = input("Enter fee details:")
        print()
        student = Students(name, id, age, fee, fee_details)
        students[id] = student
print()
print("Student Details: ")
for id, student in students.items():
    print(f"ID: {id}\t", end="")
    print(student)
    print(student.calculate_fee())
    print()
print()
search_details = int(input("Enter student id to search to check fee status:"))
if search_details in students:
    print(students[search_details]._Students__display_fee_details())

print()
change_school = int(input("Enter student id to change school:"))
if change_school in students:
    new_school = input("Enter new school name:")
    print(f"{students[change_school].id} is now in {students[change_school].change_school(new_school)}")

print()
change_year = int(input("Enter student id to change year:"))
if change_year in students:
    new_year = int(input("Enter new year:"))
    print(f"{students[change_year].id} is now in {students[change_year].year_change(new_year)} academic year")

print()
brith_year = int(input("Enter student id to calculate age:"))
print(f"Age of {students[brith_year].id} is {students[brith_year].calculate_age(students[brith_year].age)}")
print()
print("Student Details: ")
for id, student in students.items():
    print(f"ID: {id}\t", end="")
    print(student)
    print(student.calculate_fee())
    print()
print()
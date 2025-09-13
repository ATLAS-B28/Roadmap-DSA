'''
Assignment 3
1. Create a Faculty Management System to manage the functioning of the faculties.
Define a class called Faculty with following specifications:
• Private members are: 
  faculty id (Integer), faculty name (String) 
• Public members are:
 o constructor (1 parameter as faculty id should be automatically generated)
 o Getters and setters
 o public float calculate Payment()
Derive a class called VisitingFaculty from Faculty class with following specifications:
 • Private members are - no_of_hours(float), rate(float), total_amt_paid, TDS_amt_deducted
 • Public members are:
  o Constructor (two parameters - for hours and rate) 
  o Getters and setters
  o Override calculatePayment() method that calculates the payment of the Visiting Faculty by the formula: total payment = rate no of hours. 10% TDS should be deducted.

Derive another class called OnRollFaculty from Faculty class with following specifications:
• Private members are-basicSalary, netSalary, grossSalary, totalLeaves (integer) and a static variable, leavesLeft(integer) 
⚫ Public members are:
o Override calculate Payment() method that calculates the payment of the OnRoll Facultyby considering provident fund i.e PF (10% of basic salary), leaves (if exceed the total leaves allocated), gratuity amount.
o Override printDetails() method that prints the details of On roll faculty.
There are currently 1 visiting faculty and 3 On Roll faculties. The number of either faculties may increase if required.
Create a class "TestMain" which has main() method.
The class also should have a static method "public static Faculty getFaculty Details()". This method should display the option to the user whether Visiting or On-roll faculty. It should return "Faculty" object created. The main method should invoke this method to create the object.
⚫ public static void show(Faculty f)- This method should show the details of the faculty and print the payment generated.
Invoke show method to print the details.
'''
class Faculty:
    __faculty_id = None
    __faculty_name = None
    def __init__(self, faculty_id, faculty_name):
        self.__faculty_id = faculty_id
        self.__faculty_name =  faculty_name
    def get_faculty_id(self):
        return self.__faculty_id
    def get_faculty_name(self):
        return self.__faculty_name
    #setter username
    def set_faculty_name(self, username):
        if username and  len(username.strip()) > 0:
            self.__faculty_name = username
        else:
            raise ValueError("Invalid name")
    def calculate_payment(self):
        pass
    def print_details(self):
        pass

class VisitingFaculty(Faculty):
    __no_of_hrs = None
    __rate = None
    __total_amt_paid = None
    __TDS_amt_deducted = None

    def __init__(self, faculty_id, faculty_name, no_of_hrs, rate):
        super().__init__(faculty_id, faculty_name)
        self.__no_of_hrs = no_of_hrs
        self.__rate = rate
    def get_faculty_id(self):
        return super().get_faculty_id()
    def get_faculty_name(self):
        return super().get_faculty_name()
    def set_faculty_name(self, username):
        return super().set_faculty_name(username)
    def get_faculty_no_of_hrs(self):
        return self.__no_of_hrs
    def get_faculty_rate(self):
        return self.__rate
    #total payment = rate no of hours. 10% TDS should be deducted.
    def calculate_payment(self):
        #gross = rate * no of hrs
        #tds = gross * 10% aka 0.1
        #net = gross - tds
        total_payment = self.__rate * self.__no_of_hrs
        self.__TDS_amt_deducted = total_payment * 0.1
        self.__total_amt_paid = round(total_payment - self.__TDS_amt_deducted, 2)
        return self.__total_amt_paid
    def print_details(self):
        return (f"Faculty Name: {self.__faculty_name}\n"
                f"Faculty ID: {self.__faculty_id}\n"
                f"Number of Hours: {self.__no_of_hrs}\n"
                f"Rate: {self.__rate}\n"
                f"Total Amount Paid: {self.calculate_payment()}\n")

class OnRollFaculty(Faculty):
    #basicSalary, netSalary, grossSalary, 
    # totalLeaves (integer) and a static variable, 
    # leavesLeft(integer) 
    __basic_salary = None
    __net_salary = None
    __gross_salary = None
    __total_leaves = None
    __leave_left = 30

    def __init__(self, faculty_id, faculty_name, basic_salary, total_leaves):
        super().__init__(faculty_id, faculty_name)
        self.__basic_salary = basic_salary
        self.__total_leaves = total_leaves
    def get_faculty_id(self):
        return super().get_faculty_id()
    def get_faculty_name(self):
        return super().get_faculty_name()
    def get_basic_salary(self):
        return self.__basic_salary
    def get_total_leaves(self):
        return self.__total_leaves
    def calculate_payment(self):
        leaves_deduction = 0
        if self.__total_leaves > OnRollFaculty.__leave_left:#bit more complicated 
            excess_leaves = self.__total_leaves - OnRollFaculty.__leave_left
            daily_salary = self.__basic_salary / 30
            leaves_deduction = daily_salary * excess_leaves
        self.__gross_salary = self.__basic_salary + 0.35
        pf = 0.1 * self.__basic_salary
        self.__net_salary = round(self.__gross_salary - (pf + leaves_deduction), 2)
        #limit to 2 decim
        return (self.__net_salary)
    def print_details(self):
        return (f"Faculty Name: {self.get_faculty_name()}\n"
                f"Faculty ID: {self.get_faculty_id()}\n"
                f"Basic Salary: {self.__basic_salary}\n"
                f"Total Leaves: {self.__total_leaves}\n"
                f"Net Salary: {self.calculate_payment()}\n")
    
class TestMain():
    faculties = {}

    @staticmethod
    def get_faculty_details():
        faculty_id = int(input("Enter Faculty ID: "))
        faculty_name = input("Enter Faculty Name: ")
        faculty_type = input("Enter Faculty Type (Visiting/OnRoll): ")
        if faculty_type.lower() == "visiting":
            no_of_hrs = float(input("Enter Number of Hours: "))
            rate = float(input("Enter Rate: "))
            faculty = VisitingFaculty(faculty_id, faculty_name, no_of_hrs, rate)
        elif faculty_type.lower() == "onroll":
            basic_salary = float(input("Enter Basic Salary: "))
            total_leaves = int(input("Enter Total Leaves: "))
            faculty = OnRollFaculty(faculty_id, faculty_name, basic_salary, total_leaves)
        else:
            raise ValueError("Invalid Faculty Type")
        TestMain.faculties[faculty_id] = faculty
        return faculty
    @staticmethod
    def show(faculty):
        print(faculty.print_details())
    @staticmethod
    def main():
        while True:
            print("1. Add Faculty\n2. Show Faculty\n3. Exit")
            choice = int(input("Enter your choice: "))
            if choice == 1:
                faculty = TestMain.get_faculty_details()
                print("Faculty added successfully")
            elif choice == 2:
                faculty_id = int(input("Enter Faculty ID: "))
                if faculty_id in TestMain.faculties:
                    TestMain.show(TestMain.faculties[faculty_id])
                else:
                    print("Faculty not found")
            elif choice == 3:
                break
            else:
                print("Invalid choice")

TestMain.main()

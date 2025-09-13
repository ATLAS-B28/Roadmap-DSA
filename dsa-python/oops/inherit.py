'''
1. Single Inheritance - Company -> Employee
'''
class Company:
    company_name = "TechCorp"  # Static company name
    
    def __init__(self, address):
        self.address = address
    def company_info(self):
        return f"Company: {Company.company_name}, Address: {self.address}"

class Employee(Company):
    def __init__(self, address, emp_id, salary):
        super().__init__(address)
        self.emp_id = emp_id
        self.salary = salary
    def employee_info(self):
        return f"Employee ID: {self.emp_id}, Salary: {self.salary}"

emp = Employee("Mumbai", 101, 50000)
print(emp.company_info())
print(emp.employee_info())

'''
2. Multiple Inheritance - Employee + Department -> Manager
'''
class Employee:
    company_name = "Microsoft"  # Static company name
    
    def __init__(self, name, salary):
        self.name = name
        self.salary = salary

class Department:
    def __init__(self, dept_name):
        self.dept_name = dept_name

class Manager(Employee, Department):
    def __init__(self, name, salary, dept_name, bonus):
        Employee.__init__(self, name, salary)
        Department.__init__(self, dept_name)
        self.bonus = bonus
    def __str__(self):
        return f"Manager: {self.name} at {Employee.company_name}, Dept: {self.dept_name}, Salary: {self.salary}, Bonus: {self.bonus}"

mgr = Manager("John", 80000, "IT", 10000)
print(mgr)

'''
3. Multilevel Inheritance - Company -> Employee -> Manager
'''
class Company:
    company_name = "Google"  # Static company name
    
    def __init__(self):
        pass

class Employee(Company):
    def __init__(self, name, salary):
        super().__init__()
        self.name = name
        self.salary = salary

class Manager(Employee):
    def __init__(self, name, salary, team_size):
        super().__init__(name, salary)
        self.team_size = team_size
    def __str__(self):
        return f"Manager {self.name} at {Company.company_name}, Team: {self.team_size}"

mgr = Manager("Alice", 90000, 5)
print(mgr)

'''
4. Hierarchical Inheritance - Employee -> (Manager, Developer)
'''
class Employee:
    company_name = "Amazon"  # Static company name
    
    def __init__(self, name, salary):
        self.name = name
        self.salary = salary

class Manager(Employee):
    def __init__(self, name, salary, bonus):
        super().__init__(name, salary)
        self.bonus = bonus

class Developer(Employee):
    def __init__(self, name, salary, tech_stack):
        super().__init__(name, salary)
        self.tech_stack = tech_stack

mgr = Manager("Bob", 70000, 5000)
dev = Developer("Carol", 60000, "Python")
print(f"Manager: {mgr.name} at {Employee.company_name}, Bonus: {mgr.bonus}")
print(f"Developer: {dev.name} at {Employee.company_name}, Tech: {dev.tech_stack}")

'''
5. Hybrid Inheritance
'''
class Company:
    company_name = "General Atomic"  # Static company name
    
    def __init__(self, address, phone):
        self.address = address
        self.phone = phone
    def __str__(self):
        return f"{Company.company_name} {self.address} {self.phone}"

class Employee(Company):
    def __init__(self, name, address, phone, position, salary):
        super().__init__(address, phone)
        self.name = name
        self.position = position
        self.salary = salary
    def __str__(self):
        return f"{self.name} {Company.company_name} {self.address} {self.phone} {self.position} {self.salary}"

class Engineer(Employee):
    def __init__(self, name, address, phone, position, salary, project):
        super().__init__(name, address, phone, position, salary)
        self.project = project
    def __str__(self):
        return f"{self.name} {Company.company_name} {self.address} {self.phone} {self.position} {self.salary} {self.project}"

class Manager(Employee):
    def __init__(self, name, address, phone, position, salary, bonus):
        super().__init__(name, address, phone, position, salary)
        self.bonus = bonus
    def __str__(self):
        return f"{self.name} {Company.company_name} {self.address} {self.phone} {self.position} {self.salary} {self.bonus}"

class Department:
    def __init__(self, department):
        self.department = department

class SrManager(Manager):
    def __init__(self, name, address, phone, position, salary, bonus, project, department):
        super().__init__(name, address, phone, position, salary, bonus)
        self.project = project
        self.department = department
    def __str__(self):
        return f"{self.name} {Company.company_name} {self.address} {self.phone} {self.position} {self.salary} {self.bonus} {self.project} {self.department}"

class TechLead(SrManager):
    def __init__(self, name, address, phone, position, salary, bonus, project, department):
        super().__init__(name, address, phone, position, salary, bonus, project, department)
    def __str__(self):
        return f"\nName- {self.name}\nCompany- {Company.company_name}\nAddress- {self.address}\nPhone- {self.phone}\nPosition- {self.position}\nSalary- {self.salary}\nBonus- {self.bonus}\nProject- {self.project}\nDepartment- {self.department}\n"

# Test
techlead = TechLead("Aditya", "California", 89901221, "TechLead", "4500000", "60000", "IIC", "Aircraft Control & Integrated Intelligence")
print(techlead)



'''
Company
 |______________
 |             '\'
 Employee       '\' probalematic
 |____________   '\'
 |   |       |    '\'___
 HR Engineer Manager   |  
     |        |       Department  
     |        Sr. Manager--|
     |          /
     |_________/
        |
      Techlead
'''
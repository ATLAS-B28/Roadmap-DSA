'''
Problem Statement:
Create a Bank Management  where:

A Person has general details like name and age.
A Customer (inherits from Person) has an account number and balance.
A Bank (inherits from Customer) provides methods to deposit and withdraw money.
A LoanAccount (multiple inheritance from both Customer and a new Loan class) manages loans.

Person (Base Class)
Attributes: name, age

Customer (Inherits from Person - Multilevel Inheritance)
Attributes: Account_number, balance
Methods: display_customer_details()

Bank (Inherits from Customer - Multilevel Inheritance)
Methods: deposit(amount), withdraw(amount)

Loan (Separate Class)
Attributes: loan_amount
Methods: apply_loan(amount)

LoanAccount (Inherits from Customer and Loan - Multiple Inheritance)
Methods: view_loan_details()
person -> customer->|-> bank
(Using Composition|
we passed         | 
cutomer to loan)  | |-> loan_account
              loan->|
                
'''
class Person:
    def __init__(self, name, age):
        self.name = name
        self.age = age
    
class Customer(Person):
    def __init__(self, name, age, acc_no, balance):
        super().__init__(name, age)
        self.acc_no = acc_no
        self.balance = balance
    def display_customer_details(self):
        return (f"Name: {self.name}\n"
                f"Age: {self.age}\n"
                f"Account Number: {self.acc_no}\n"
                f"Balance: {self.balance}\n")
class Bank(Customer):
    def deposit(self, amount):
        if amount > 0:
            self.balance += amount
            return f"Deposited {amount} successfully. New balance: {self.balance}"
        else:
            return f"Amount is invalid"
    def withdraw(self, amount):
        if amount > 0 and amount <= self.balance:
            self.balance -= amount
            return f"Withdrawn {amount} successfully. New balance: {self.balance}"
        else:
            return f"Invalid amount or insufficient balance"
#focus on naming variables and what to do properly
class Loan:
    def __init__(self, loan_limit, customer_balance: Customer):
        self.loan_limit = loan_limit
        self.customer = customer_balance#composition
        self.current_loan = 0
    def apply_loan(self, amount):
        if amount <= 0:
            return "Invalid loan amount"
        if amount > self.loan_limit:
            return f"Loan amount {amount} to high"
        if self.current_loan + amount > self.loan_limit:
            return f"Total loan would exceed limit"
        self.current_loan += amount
        return f"Loan of {amount} approved. Total loan: {self.current_loan}"
    def repay_loan(self, amount):
        if amount <= 0:
            return "Invalid repayment amount"
        if amount > self.current_loan:
            return f"Repayment exceeds current value. Refund of {amount - self.current_loan} will be processd soon"
        self.current_loan -= amount
        return f"Repaid {amount}. Remaining loan: {self.current_loan}"
class LoanAmount(Customer, Loan):
    def __init__(self, customer: Customer, loan_limit):
        Customer.__init__(self, customer.name, customer.age, customer.acc_no, customer.balance)
        Loan.__init__(self, loan_limit, customer)
    def view_loan_details(self):
        return (f"Loan Limit: {self.loan_limit}\n"
                f"Current Loan: {self.current_loan}\n"
                f"Available Credit: {self.loan_limit - self.current_loan}\n")
    
customer = Customer("Aditya", 23, "123", 100000)
lm = LoanAmount(customer, 34440)
print(lm.apply_loan(1000))
print(lm.repay_loan(500))
print(lm.view_loan_details())
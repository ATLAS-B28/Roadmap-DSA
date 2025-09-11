''''
Python Assignment1. Create a BankAccount class with instance variables account_number and balance.
2. Define a constructor to initialize these variables.
3. Create methods to deposit and withdraw money.
4. Use class variables to track the total number of accounts created.
'''
class BankAccount:
    acc_no = None
    balance = None
    __credentials = {
        "address":"",
        "user_id":""
    }
    password = None
    count_no_of_account = 0
    def __init__(self, acc_no, balance, credential, password):
        self.acc_no = acc_no 
        self.balance = balance
        self.__credentials = credential
        self.password = password
    def deposit(self, amount):
        if amount > 0:
         self.balance += amount
         return f"{amount} deposited"
        else:
           return f"{amount} invalid"
    def withdraw(self, amount):
        if self.balance >= amount:
            self.balance -= amount
            return f"{amount} withdrawn"
        else:
            return "Not enough funds"
    def __display_details(self):
        print(f"User Id: {self.__credentials['user_id']}, Address: {self.__credentials['address']}")
    def __str__(self):
        return f"Account Number: {self.acc_no}, Balance: {self.balance}"
    @staticmethod
    def credit_score(self):
        #calculate credit score
        if self.balance > 100000:
            return "High"
        elif self.balance > 50000:
            return "Medium"
        elif self.balance > 10000:
            return "Low"
        else:
            return "Very Low"
        
    
accounts = {}
start = input("Do you want to Start account creation process? (yes/no): ")
if start.lower() == "yes":
 while True:
    
    for _ in range(1):
        acc_no = int(input("Enter the account number: "))
        balance = float(input("Enter the balance: "))
        address = input("Enter the address: ")
        user_id = hash(str(acc_no) + address)
        cred = {"address":address,"user_id":user_id}
        password = int(input("Enter password: "))
        accounts[acc_no] = BankAccount(acc_no, balance, cred, password)
        BankAccount.count_no_of_account += 1
        print("Account created successfully")
        print("-----------------------------------------------")
    cont = input("Do you want to continue? (yes/no): ")
    if cont.lower() != "yes":
        break
else:
    print("Account creation process aborted.")

print("-----------------------------------------------")
print("Account details:")
for acc_no, account in accounts.items():
    print(f"Account Number: {acc_no}, Balance: {account.balance}")
print("-----------------------------------------------")
print("Deposit money:")
n1 = int(input("Enter account to deposit amount into:"))
if n1 in accounts:
    amount = float(input("Enter the amount to deposit: "))
    print(accounts[n1].deposit(amount))
print("Withdraw money:")
n2 = int(input("Enter account to withdraw amount from:"))
if n2 in accounts:
    amount = float(input("Enter the amount to withdraw: "))
    print(accounts[n2].withdraw(amount))
print("Account details after deposit and withdrawal:")
for acc_no, account in accounts.items():
    print(f"Account Number: {acc_no}, Balance: {account.balance}")
print("-----------------------------------------------") 
acc_cred_no = int(input("Enter account number to display details:"))
print("Enter password for the account")
password = int(input("Enter password: "))
if acc_cred_no in accounts:
 if password == accounts[acc_cred_no].password:   
     accounts[acc_cred_no]._BankAccount__display_details()
 else:
     print("Invalid password")
else:
    print("Account not found")
print("-----------------------------------------------")
print("Credit Score")
acc_cred_no = int(input("Enter account number to display credit score:"))
if acc_cred_no in accounts:
    print(f"Credit Score {BankAccount.credit_score(accounts[acc_cred_no])}")
print("-----------------------------------------------")
print(f"Total number of accounts created: {BankAccount.count_no_of_account}")



#menudriven with functions
#1st is to add an account where we create a nested dictonary of users
#2nd deposit money
#3rd withdraw money
#4th display account details
#5th display balance
#6th exit
#a csv to write data to 
users = {}

def create_acc():
    name = input("Enter your name: ")
    account_no = int(input("Enter your account number: "))
    balance = float(input("Enter initial balance: "))
    acc_type = input("Enter account type (Savings/Current): ")
    holder_name = input("Enter account holder's name: ")
    if account_no in users:
        print("Account already exists.")
        return
    if balance < 0:
        print("Invalid balance. Please enter a positive value.")
        return
    if acc_type.lower() not in ['savings', 'current']:
        print("Invalid account type. Please enter 'Savings' or 'Current'.")
        return
    if account_no <= 0:
        print("Invalid account number. Please enter a positive value.")
        return
    users[account_no] = {'name': name, 'balance': balance, 'acc_type':acc_type, 'holder_name': holder_name}
    print("Account created successfully!")

def desposit_func(amount, account_no):
    if account_no in users:
        if str(amount).startswith('-'):
            print("Invalid amount. Please enter a positive value.")
            return
        users[account_no]['balance'] += amount
        print(f"Deposited {amount}. New balance is {users[account_no]['balance']}")
    else:
        print("Account not found.")
        
def withdraw_func(amount, account_no):
    if account_no in users:
        if users[account_no]['balance'] >= amount and not str(amount).startswith('-'):
            users[account_no]['balance'] -= amount
            print(f"Withdrawn {amount}. New balance is {users[account_no]['balance']}")
        else:
            print("Insufficient balance.")
    else:
        print("Account not found.")

def display_by_number(account_no):
    if account_no in users:
        print(f"Account Number: {account_no}")
        for key, value in users[account_no].items():
            print(f"{key.capitalize()}: {value}")
    else:
        print("Account not found.")

def display_all():
    if users:
        for account_no, details in users.items():
            print(f"\nAccount Number: {account_no}")
            for key, value in details.items():
                print(f"{key.capitalize()}: {value}")
    else:
        print("No accounts to display.")

def display_balance_number(account_no):
    if account_no in users:
        print(f"Balance for account {account_no} is {users[account_no]['balance']}")
    else:
        print("Account not found.")

def main():
    #want to ask the user if they want to continue or not
    continue_choice = input("Do you want to start the process? (y/n): ").lower()
    if continue_choice == 'y':
     while True:
        print("\nMenu:")
        print("1. Create Account")
        print("2. Deposit Money")
        print("3. Withdraw Money")
        print("4. Display Account Details by Account Number")
        print("5. Display All Account Details")
        print("6. Display Balance by Account Number")
        print("7. Exit")
        choice = int(input("Enter your choice (1-7): "))
        
        if choice == 1:
            create_acc()
        elif choice == 2:
            acc_no = int(input("Enter account number: "))
            amount = float(input("Enter amount to deposit: "))
            desposit_func(amount, acc_no)
        elif choice == 3:
            acc_no = int(input("Enter account number: "))
            amount = float(input("Enter amount to withdraw: "))
            withdraw_func(amount, acc_no)
        elif choice == 4:
            acc_no = int(input("Enter account number: "))
            display_by_number(acc_no)
        elif choice == 5:
            display_all()
        elif choice == 6:
            acc_no = int(input("Enter account number: "))
            display_balance_number(acc_no)
        elif choice == 7:
            print("Exiting the application.")
            break
        else:
            print("Invalid choice. Please try again.")
        continue_choice = input("Do you want to continue? (y/n): ").lower()
        if continue_choice != 'y':
            print("Exiting the application.")
            break
    else:
        print("Exiting the application.")
print("Banking Customer Software: ")
main()
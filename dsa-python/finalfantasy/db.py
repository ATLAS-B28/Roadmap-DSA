#to perform crud on a database of FINAL FANTASY GAME
#we will be using MySQL, Python, PIP, and it's official connectors
#next step will be to create funcs for CRUD functionality
#create we will embed the variables from the user input and execute, 
# fetch all and by id, updating by getting and resetting the updated data
#finally to delete by id, we will be using try-catch-finally for each this is standard practice
#this a python-mysql based CRUD REST API application
#finally a main 
import mysql.connector
import time

def get_by_id(id):
    connection, cursor = con_cursor()
    try:
        query = "SELECT * FROM characters WHERE id = %s"
        start_time = time.time()
        cursor.execute(query, (id,))
        res = cursor.fetchone()
        end_time = time.time()
        execution_time = end_time - start_time
        if res:
            print("+----+---------------+-------+---------------+------------------+------------+")
            print("| id | name          | stats | favorites     | special_attacks  | apperances |")
            print("+----+---------------+-------+---------------+------------------+------------+")
            for row in res:
                print(f"| {row[0]:<2} | {row[1]:<13} | {row[2]:<5} | {row[3]:<13} | {row[4]:<16} | {row[5]:<10} |")
            print("+----+---------------+-------+---------------+------------------+------------+")
            print(f"{len(res)} rows in set {execution_time} sec")
        else:
            print(f"Empty set {execution_time} sec")
       # connection.commit()
    except Exception as e:
        print(f"{e}")
    finally:
        cursor.close()
        connection.close()

def get_all():
    connection, cursor = con_cursor()
    try:
        '''
    Connection = Phone line to database
Cursor = The conversation/commands you send through that line
    '''
        query = "SELECT * FROM characters"
        start_time = time.time()
        cursor.execute(query)
        res = cursor.fetchall()
        end_time = time.time()
        execution_time = end_time - start_time
        
        if res:
            print("+----+---------------+-------+---------------+------------------+------------+")
            print("| id | name          | stats | favorites     | special_attacks  | apperances |")
            print("+----+---------------+-------+---------------+------------------+------------+")
            for row in res:
             print(f"| {row[0]:<2} | {row[1]:<13} | {row[2]:<5} | {row[3]:<13} | {row[4]:<16} | {row[5]:<10} |")
            print("+----+---------------+-------+---------------+------------------+------------+")
            print(f"Query in {execution_time} sec")
        else:
            print(f"Empty set {execution_time} sec")
    except Exception as e:
        print(f"{e}")
    finally:
        cursor.close()
        connection.close()

def create_character(name, stats, favorites, special_attacks, apperances):
    connection, cursor = con_cursor()
    try:
        query = "INSERT INTO characters (name, stats, favorites, special_attacks, apperances) VALUES (%s, %s, %s, %s, %s)"
        #%s is just a placeholder in the SQL    
        data = name, stats, favorites, special_attacks, apperances
        start_time = time.time()
        cursor.execute(query, data) 
        connection.commit()
        end_time = time.time()
        execution_time = end_time - start_time
        print(f"Character created successfully in {execution_time} sec")
    except Exception as e:
        print(f"{e}")
    finally:
        
        cursor.close()
        connection.close()

def update_character(id, name, stats, favorites, special_attacks, apperances):
    connection, cursor = con_cursor()
    try:
        query = "UPDATE characters SET name=%s, stats=%s, favorites=%s, special_attacks=%s, apperances=%s where id=%s"
        start_time = time.time()
        cursor.execute(query, (name, stats, favorites, special_attacks, apperances, id))
        connection.commit()
        end_time = time.time()
        execution_time = end_time - start_time
        print(f"Character updated successfully in {execution_time} sec")
    except Exception as e:
        print(f"{e}")
    finally:
        cursor.close()
        connection.close()

def delete_character(id):
    connection, cursor = con_cursor()
    try: 
        query = "DELETE FROM characters WHERE id = %s"
        start_time = time.time()
        cursor.execute(query, (id,))
        connection.commit()
        end_time = time.time()
        execution_time = end_time - start_time
        print(f"Character deleted successfully in {execution_time} sec")
    except Exception as e:
        print(f"{e}")
    finally:
        cursor.close()
        connection.close()

def con_cursor():
    connection = mysql.connector.connect(
        host="localhost",
        port=3306,
        user="root",
        password="admin28",
        database="library_ff"
    )
    cursor = connection.cursor()
    return connection,cursor

def main():
    #menu driven 
    #option 
    print("FF Library")
    print("Options - ")
    print("1. Create Character")
    print("2. Get All Characters")
    print("3. Get Character by ID")
    print("4. Update Character by ID")
    print("5. Delete Character by ID")
    print("6. Get all Characters")
    print("7. Exit")
    while True:
        choice = int(input("Enter your choice: "))
        if choice == 1:
            name = input("Enter name: ")
            stats = input("Enter stats: ")
            favorites = input("Enter favorites: ")
            special_attacks = input("Enter special attacks: ")
            apperances = input("Enter apperances: ")
            create_character(name, stats, favorites, special_attacks, apperances)
        elif choice == 2:
            get_all()
        elif choice == 3:
            id = int(input("Enter ID: "))
            get_by_id(id)
        elif choice == 4:
            id = int(input("Enter ID: "))
            name = input("Enter name: ")
            stats = input("Enter stats: ")
            favorites = input("Enter favorites: ")
            special_attacks = input("Enter special attacks: ")
            apperances = input("Enter apperances: ")
            update_character(id, name, stats, favorites, special_attacks, apperances)
        elif choice == 5:
            id = int(input("Enter ID: "))
            delete_character(id)
        elif choice == 7:
            break
        else:
            print("Invalid choice, please try again!")
        cont = input("Do you want to continue? (y/n)")
        if cont == "n":
            break



main()
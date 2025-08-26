#menu driven using if and for loops
#if input is 1 then 1st program will run
#so we will be utilizing if elif and also no use of def just
'''
if input==1:
   then run the program using for loops
elif input==2:
and so on
'''
print("Menu Driven Program:")
print("1. Print all the strings as list with their serial number.")
print("2. Print all squares of even numbers between 40 to 20.")
print("3. Print the series from 0,1,1,2,3,5...n.")
print("4. Check whether prime or not.")
options = int(input("Enter your choice: "))
if options == 1:
    li = ["Hello", "World", "This", "Is", "A", "List"]
    for i in range(0, len(li)):
        print(i+1, ".", li[i])
elif options == 2:
    for i in range(40,19,-1):
        if i%2 == 0:
            print(i**2)
elif options == 3:
    a ,b = 0, 1
    n = int(input("Enter the number of terms: "))
    for i in range(0, n + 1):
        print(a, b)
        a, b = b, a + b
elif options == 4:
    num = int(input("Enter the number: "))
    if num > 1:
        flag = True
        for i in range(2, num):
            if num%i == 0:
                flag = False
                break
            else:
                flag = True
        print(num, "is prime" if flag else "is composite")
    else:
        print(num, "is 0 or 1 or -ve number")
else:
    print("Invalid choice")
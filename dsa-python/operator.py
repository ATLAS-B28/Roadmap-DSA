#operators 
#binary, unary, special, ternary,
#bitwise, arithmetic, logical, identity, membership, assignment
#operators in python

# Arithmetic Operators
a = 4
b = 5
num = a + b
print(a+b)
print(a-b)
print(a*b)
print(a/b)
print(a//b)  # Floor Division
print(a**b)  # Exponentiation
print(a%b)   # Modulus
# Assignment Operators
a = 10
b = 20
a += b  # a = a + b
print(a)  # Output: 30
# Comparison Operators
print(a == b)  # Equal to
print(a != b)  # Not equal to
print(a > b)   # Greater than
print(a < b)   # Less than

print(a >= b)  # Greater than or equal to
print(a <= b)  # Less than or equal to

# Logical Operators
x = True
y = False
print(x and y)  # Logical AND
print(x or y)   # Logical OR
print(not x)    # Logical NOT
# Identity Operators
print(a is b)  # Identity (is)
print(a is not b)  # Identity (is not)
# Membership Operators
list1 = [1, 2, 3, 4, 5]#here values are checked for membership
dict1 = {1: 'a', 2: 'b'}#here keys are checked for membership
print(3 in list1)  # Membership (in)
print(list1[2] in list1)
print(6 not in list1)  # Membership (not in)
print(1 in dict1)
print('a' in dict1.values())  # to check membership in dictionary values we do dictionary.value()<- func to get the values
#lets do operations with alteast one String
str1 = "Hello"
str2 = "World"
print(str1 + " " + str2)  # String Concatenation
print(str1 * 3)  # String Repetition
print(3 * str1)
# Bitwise Operators
print(a & b)  # Bitwise AND
print(a | b)  # Bitwise OR
print(a ^ b)  # Bitwise XOR
print(~a)  # Bitwise NOT
print(a << 2)  # Left Shift
print(a >> 2)  # Right Shift
# Ternary Operator
result = "a is greater" if a > b else "b is greater"
print(result)  # Output: b is greater
# Special Operators
# None Type
print(type(None))  # Output: <class 'NoneType'>
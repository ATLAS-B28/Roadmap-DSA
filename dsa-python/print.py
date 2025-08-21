message = 'Python is easy to learn'
print(message.endswith('easy')) #Output:False
print(message.endswith('to learn'))# Output: True
print(message.startswith('Pyth'))# Output: True
print(message.startswith('Python is'))# Output: True
print(message.startswith('pyth'))# Output: False


name = "Student"
age = 25
greeting = "My name is {} and I am {} years old.".format(name, age)
print(greeting)

greeting = "My name is {0} and I am {1} years old.".format(name, age)  # Positional
greeting = "My name is {name} and I am {age} years old.".format(name="Sumit", age=25)

print("Python  "*4)

# default arguments
print("Hi  {}, Contact No- {}.".format("Sandra", 123456))

# positional arguments
print("Hello {0}, Contact No-  {1}.".format("Sandra", 230.2346))

# keyword arguments
print("Hi there  {name}, Contact No-  {cno}.".format(name="Sandra", cno=234567891))

# mixed arguments
print("Hello {0}, your balance is {blc}.".format("Sandra", blc=200000))

greeting = f"My name is {name} and I am {age} years old."
print(greeting) 

print(f"Next year, {name} will be {age + 1} years old.")

# \n is a line boundary 
text = '''Python is easy to learn \n
Its is OOPs based\n Its super cool language'''
# split the text from space
print(text.splitlines())

words = ["Hello", "world", "Python", "is", "awesome"]
sentence = " ".join(words)  # Joins with a space
print(sentence)

numbers = ["1", "2", "3", "4"]
comma_separated = ", ".join(numbers)  # Joins with ", "
print(comma_separated)

text = "Hello, to the world of Python!"
result = text.partition(", ")
print(result)

text = "It is raining"
print(text.zfill(15))
print(text.zfill(20))
print(text.zfill(13))

number = "-246"
print(number.zfill(6))
number = "+523"
print(number.zfill(6))
text = "--random+text"
print(text.zfill(20))


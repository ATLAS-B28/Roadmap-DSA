print("Hello world")
x = 10
y = 9
sum = x + y
print(sum)

if sum > 15:
    print("Sum is greater than 15")
else:
    print("Sum is less than 15")    

for i in range(6):
  print(i)

def add_num(a,b):
   return a + b

result = add_num(5,8)
print(result)

def fact(n):
   if n == 0:
      return 1
   else:
      return n*fact(n-1)
   
print(fact(5))
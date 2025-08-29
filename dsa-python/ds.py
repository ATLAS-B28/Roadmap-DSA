#lists
nums = [1,2,3,4,5,3,211,3124,22,3,5,3,3,3]
#print(nums[0]) #mutable, any data type, nested list, same data type in same list
#diff_ds = [1,"Aditya",2.08,True]
#print(diff_ds)
'''
List all the functions of the list - 
append, clear, copy, count, extend, index, insert, pop, remove, reverse, sort,
'''
#difference between append and extend
#nums.append(6)#can add element, tuple, dictationary, list
#nums.append((2,3))
#nums.append([4,5])
#nums.append({1:"Aditya",2:"Abhijeet"})
#print(nums)
#nums.extend([7,8,9])#requires an iterable
#nums.extend("string")
#nums.extend((2, 3))
#nums.extend({1:"Aditya", 2:"Abhijeet"})#adds the keys only
# lets say we do this values - builtin_function_or_method' object is not iterable
#print(nums)
#index
'''print(nums.index(3))
print(nums.index(3, 5))#start searching from index 5
print(nums.index(3, 5, 10))#search between index 5 and 10
#insert
nums.insert(0,0)#index, value
print(nums)
#If i have to remove multiple elements
nums[1:5] = []
print(nums)
#remove
#nums.remove(3)#removes first occurence of 3
#All occurances of 3
#while 3 in nums:
 #   nums.remove(3)
print(nums)
'''
#nums.sort()
#print(nums)
#nums.sort(reverse=True)
#print(nums)
#nums2 = [1,2,3,4,5,3,211,3124,22,3,[5,3,2,1]]
#nums2.sort()
#print(nums2) #error as it contains a nested list
#sorting using key defined by us
nums3 = ["Aditya", "Abhijeet", "Abhishek", "Amit"]
#nums3.sort(key=len)
#print(nums3)
#sorted()
my_num = sorted(nums3)#,reverse=True)
print(my_num)
#add ing elemnets of 2 lists
num4 = [1,2,3,4,5]
num5 = [6,7,8,9,10]
print("Min in nums", min(nums))
res2 = []
for i in range(0, len(num4)):
    res2.append(num4[i]+num5[i])
print(res2)
'''
#tuples - immutable lists
nums = (1,2,3,4,5)
print(nums[2])

#sets - unordered and no repeatation
my_set_nums = {1,2,3,4,5}
print(my_set_nums)

#dictionaries - key - value
my_dic = {
    "name":"Aditya",
    "age":21,
    "city":"Delhi",
    "party":"Akhand Bharatiya Anime Sangh"
}
for key, value in my_dic.items():
    print(f"{key}:{value}")
print(my_dic.get("party"))
print(my_dic.update({"party":"Akhand Bharatiya Anime Party"}))
for key, value in my_dic.items():
    print(f"{key}:{value}")
print(my_dic.pop("party"))
for key, value in my_dic.items():
    print(f"{key}:{value}")'''
#lists
nums = [1,2,3,4,5]
print(nums[0]) #mutable

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
    print(f"{key}:{value}")
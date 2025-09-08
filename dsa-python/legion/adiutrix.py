#adiutrix named after a legion known as helpers
#define a few operations to add, sort according to the frequency and get the element
def add_ele(ele, ele_dict):
    if ele in ele_dict:
        ele_dict[ele] += 1
    else:
        ele_dict[ele] = 1
def get_ele(ele, ele_dict):
    if ele in ele_dict:
        return ele_dict[ele]
    else:
        return 0
def sort_by_freq(ele_dict):
    #make the sorting simpler
    return sorted(ele_dict.items(), key=lambda x: x[1], reverse=True)
#define list operations
def add_list(ele1, ele_list):
    ele_list.append(ele1)
def get_list_ele(ele1, ele_list):
    if ele1 in ele_list:
        return ele_list.index(ele1)
    else:
        return 0
def update_list(ele1, ele_list):
    ele_list.append(ele1)
    return ele_list
def update_list_element(new_ele, ele_list, index):
    if 0 <= index < len(ele_list):
        ele_list[index] = new_ele
    return ele_list
def sort_list(ele_list):
    return sorted(ele_list)
#define string operations like spliting etc
def string_splitting(str1):
    return str1.split()
def string_joining(str1, str2):
    return str2.join(str1)
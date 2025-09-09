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

def custom_ord(char):
    ascii_map = {
        'a': 97, 'b': 98, 'c': 99, 'd': 100, 'e': 101,
        'f': 102, 'g': 103, 'h': 104, 'i': 105, 'j': 106,
        'k': 107, 'l': 108, 'm': 109, 'n': 110, 'o': 111,
        'p': 112, 'q': 113, 'r': 114, 's': 115, 't': 116,
        'u': 117, 'v': 118, 'w': 119, 'x': 120, 'y': 121,
        'z': 122, 'A': 65, 'B': 66, 'C': 67, 'D': 68,
        'E': 69, 'F': 70, 'G': 71, 'H': 72, 'I': 73,
        'J': 74, 'K': 75, 'L': 76, 'M': 77, 'N': 78,
        'O': 79, 'P': 80, 'Q': 81, 'R': 82, 'S': 83,
        'T': 84, 'U': 85, 'V': 86, 'W': 87, 'X': 88,
        'Y': 89, 'Z': 90, '0': 48, '1': 49, '2': 50,
        '3': 51, '4': 52, '5': 53, '6': 54, '7': 55,
        '8': 56, '9': 57, '!': 33, '@': 64, '#': 35,
        '$': 36, '%': 37, '^': 94, '&': 38, '*': 42,
        '(': 40, ')': 41, '-': 45, '_': 95, '+': 43,
        '=': 61, '[': 91, ']': 93, '{': 123, '}': 125,
        '|': 124, '\\': 92, ':': 58, ';': 59, '"': 34,
        "'": 39, '<': 60, '>': 62, ',': 44, '.': 46,
        '?': 63, '/': 47, ' ': 32
    }
    return ascii_map.get(char, 0)

def custom_chr(ascii):
    char_map = {
        97: 'a', 98: 'b', 99: 'c', 100: 'd', 101: 'e',
        102: 'f', 103: 'g', 104: 'h', 105: 'i', 106: 'j',
        107: 'k', 108: 'l', 109: 'm', 110: 'n', 111: 'o',
        112: 'p', 113: 'q', 114: 'r', 115: 's', 116: 't',
        117: 'u', 118: 'v', 119: 'w', 120: 'x', 121: 'y',
        122: 'z', 65: 'A', 66: 'B', 67: 'C', 68: 'D',
        69: 'E', 70: 'F', 71: 'G', 72: 'H', 73: 'I',
        74: 'J', 75: 'K', 76: 'L', 77: 'M', 78: 'N',
        79: 'O', 80: 'P', 81: 'Q', 82: 'R', 83: 'S',
        84: 'T', 85: 'U', 86: 'V', 87: 'W', 88: 'X',
        89: 'Y', 90: 'Z', 48: '0', 49: '1', 50: '2',
        51: '3', 52: '4', 53: '5', 54: '6', 55: '7',
        56: '8', 57: '9', 33: '!', 64: '@, ', 35: '#',
        36: '$', 37: '%', 94: '^', 38: '&', 42: '*',
        40: '(', 41: ')', 45: '-', 95: '_', 43: '+',
        61: '=', 91: '[', 93: ']', 123: '{', 125: '}',
        124: '|', 92: '\\', 58: ':', 59: ';', 34: '"',
        39: "'", 60: '<', 62: '>', 44: ',', 46: '.',
        63: '?', 47: '/', 32: ' '
    }
    return char_map.get(ascii, ' ')
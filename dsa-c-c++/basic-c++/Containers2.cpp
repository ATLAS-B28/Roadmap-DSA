//Function objects
/**
 * also called functors are objects that can be
 * called as if they were functions.
 * They are used with algorithms to customize their
 * behavior. STL gives us a variety of functors
 * like less, greater, equal_to, etc.
 */

#include <iostream>
#include <vector>
#include <algorithm>
/*
struct AddValue
{
   int val;

   AddValue(int v) : val(v) {}

   int operator()(int num) const {
    return num + val;
   }
};

int main() {
    AddValue add5(5);

    int res = add5(10);

    std::cout << "Result: " << res << std::endl;

    return 0;
}
*/
/**
 * Function objects can be useful when 
 * you need to customize the behavior of an 
 * algorithm, such as sorting or searching. You can define your own 
 * function object or use predefined function objects provided 
 * by the C++ Standard Library, such as std::less, 
 * std::greater, std::plus, etc.
 * Here's an example of using a function object with the 
 * std::sort algorithm:
*/

struct LengthComparator 
{
     bool operator()(const std::string& str1,const std::string& str2) const {
        return str1.length() < str2.length();
     }
};

int main() {
    std::vector<std::string> words = {"apple", "banana", "cherry", "date", "elderberry"};

    std::sort(words.begin(), words.end(), LengthComparator());

    std::cout << "Sorted words by length: \n";
    
    for(const std::string& word : words){
        std::cout << word << "\n";
    }
    std::cout << std::endl;

    return 0;
}

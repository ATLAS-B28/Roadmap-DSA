//containers
/**
 * are data structures that store and organize elements
 * STL gives us a variety of containers like vector,
 * list, set, map, etc.
 * Allows us to do random access, insertion/deletion and ordering
 * guarantees that elements are stored in the order in which they are inserted
*/

//Vector
/*
#include <iostream>
#include <vector>

int main() {
    std::vector<int> nums;

    nums.push_back(10);
    nums.push_back(20);
    nums.push_back(30);
    nums.push_back(40);

    std::cout << "First element: " << nums[0] << std::endl;

    //iterate over the vector using iterator
    std::cout << "All elements: ";
    for(auto it = nums.begin(); it != nums.end(); ++it) {
        std::cout << *it << " ";
    }
    std::cout << std::endl;
    return 0;
}*/

//List - doubly linked list
/*
#include <iostream>
#include <list>

int main() {
    std::list<std::string> names;

    names.push_back("Abhijit");
    names.push_back("Abhishek");
    names.push_back("Aditya");
    names.push_back("Ajatshatru");
    names.push_back("Amavasu");

    std::cout << "All names: ";
    for(auto it = names.begin(); it != names.end(); ++it) {
        std::cout << *it << " ";
    }
    std::cout << std::endl;
    return 0;
}*/

//Set
/*
#include <iostream>
#include <set>

int main() {
    std::set<int> nums;

    nums.insert(10);
    nums.insert(20);
    nums.insert(30);
    nums.insert(40);
    nums.insert(20);

    std::cout << "All numbers: ";
    for(auto it = nums.begin(); it != nums.end(); ++it) {
        std::cout << *it << " ";
    }
    std::cout << std::endl;
    return 0;
}*/

//Map
/*
#include <iostream>
#include <map>

int main() {
    std::map<std::string,int> scores;

    scores["Abhijit"] = 100;
    scores["Abhishek"] = 200;
    scores["Aditya"] = 300;
    scores["Ajatshatru"] = 400;
    scores["Amavasu"] = 500;

    std::cout << "All scores: ";
    for(auto it = scores.begin(); it != scores.end(); ++it) {
        std::cout << it->first << ": " << it->second << " ";
    }
    std::cout << std::endl;

    return 0;
}*/

//Algorithms
/**
 * They are generic functions that operate
 * on containers. The STL provides a wide range
 * for common opertions like sorting, searching, modifying
 * and so on.
*/
//Sorting

#include <iostream>
#include <vector>
#include <algorithm>
#include <numeric>

int sortingSTL(){
    std::vector<int> nums = {5, 2, 4, 1, 3};

    std::sort(nums.begin(),nums.end());

    std::cout << "Sorted Numbers: ";
    for(int num : nums) {
        std::cout << num << " ";
    }
    std::cout << std::endl;
    return 0;
}

//Searching

int searchingSTL() {
    std::vector<int> nums = {5, 2, 4, 1, 3};

    int target = 8;
    auto it = std::find(nums.begin(),nums.end(), target);
    
    if (it != nums.end())
    {
        std::cout << "Target found ar index: " << std::distance(nums.begin(), it);
    }
    else
    {
        std::cout << "Target not found" << std::endl;
    }
    return 0;
    
}

//Modifying

int modifyingSTL() {
    std::vector<int> nums = {5, 2, 4, 1, 3};

    std::transform(nums.begin(), nums.end(), nums.begin(), [](int num) {
        return num * 2;
    });

    std::cout << "Modified numbers: ";
    for(int num : nums) {
        std::cout << num << " ";
    }
    std::cout << std::endl;
    return 0;
}

//Accumulating

int accumulatingSTL() {
    std::vector<int> nums = {5, 2, 4, 1, 3};

    int sum = std::accumulate(nums.begin(), nums.end(), 0);

    std::cout << "Sum of numbers: " << sum << std::endl;

    return 0;
}

//Removing

int removingSTL(){
    std::vector<int> nums = {5, 2, 4, 1, 3};

    int target = 8;
    auto it = std::remove(nums.begin(), nums.end(), target);

    nums.erase(it, nums.end());

    std::cout << "Updated nums: ";
    for(int num : nums) {
        std::cout << num << " ";
    }
    std::cout << std::endl;

    return 0;


}

int main() {
    sortingSTL();
    searchingSTL();
    modifyingSTL();
    accumulatingSTL();
    removingSTL();
    return 0;
}
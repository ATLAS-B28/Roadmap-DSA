#include <iostream>
#include <vector>

int binarySearch(const std::vector<int>& nums, int target) {
    int left = 0;
    int right = nums.size() - 1;

    while(left <= right) {
        int mid = left + (right - left) / 2;

        if(nums[mid] == target) {
            return mid;
        } else if(nums[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    return -1;
}

int linearSearch(const std::vector<int>& nums, int target) {
    for(int i = 0; i < nums.size(); i++) {
        if(nums[i] == target) {
            return i;
        }
    }

    return -1;
}

int main() {
    std::vector<int> nums = {1 ,3, 5, 7, 9, 11, 13};
    int target = 7;

    int index = binarySearch(nums ,target);
    int indexLinear = linearSearch(nums ,target);

    if(index != -1) {
        std::cout << "Target found at index: " << index << std::endl;
    } else {
        std::cout << "Target not found" << std::endl;
    }

    if(index != -1) {
        std::cout << "Target found at index: " << index << std::endl;
    } else {
        std::cout << "Target not found" << std::endl;
    }

    return 0;
}
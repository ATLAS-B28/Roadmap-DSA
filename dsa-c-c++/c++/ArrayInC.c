#include <stdio.h>

int main(){
    int arr[5] = {1, 2, 3, 4, 5};
    int length = sizeof(arr)/sizeof(arr[0]);
    printf("Length of array: %d\n", length);
    return 0;
}
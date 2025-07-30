#include <stdio.h>
int main() {
    int arr[6] = {1,2,3,4,5,6}, *ptr;
    ptr=arr;
    ptr++;
    printf("%d", *(ptr+2));
    return 0;
}
#include <stdio.h>
void traverse(int arr[], int n) {
    for(int i = 0; i < n; i++) {
        printf("%d", arr[i]);
    }
    printf("\n");
}
void insert(int arr[], int *n, int pos, int val) {
    for(int i = *n; i > pos; i--) {
        arr[i] = arr[i-1];
    }
    arr[pos] = val;
    (*n)++;
}
void delete(int arr[], int *n, int pos) {
    for(int i = pos; i< *n-1; i++) {
        arr[i] = arr[i+1];
    }
    (*n)--;
}

void reverse(int arr[], int n) {
    for(int i = 0; i < n/2; i++) {
        int temp = arr[i];
        arr[i] = arr[n-1-i];
        arr[n-1-i] = temp;
    }
}

void sort(int arr[], int n) {
    for(int i = 0; i < n-1; i++) {
        for(int j = 0; j < n-i-1; j++) {
            if(arr[j] > arr[j+1]) {
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
}

int bs(int arr[], int n, int key) {
    int left = 0, right = n-1;
    while(left <= right) {
        int mid = left + (right-left)/2;
        if(arr[mid] == key) {
            return mid;
        } 
        if(arr[mid] < key) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return -1;
}

int removeDuplicate(int arr[], int n) {
    int j = 0;
    for(int i = 1; i < n; i++) {
        if(arr[i] != arr[j]) {
            arr[++j] = arr[i];
        }
    }
    return j + 1;
}

void merge(int arr1[], int n1, int arr2[], int n2, int res[]) {
    int i = 0, j = 0, k = 0;
    while(i < n1 && j < n2) {
        if(arr1[i] <= arr2[j]) {
            res[k++] = arr1[i++];
        } else {
            res[k++] = arr2[j++];
        }
    }
    while(i < n1) {
        res[k++] = arr1[i++];
    }
    while(j < n2) {
        res[k++] = arr2[j++];
    }
}

int main() {
    int arr[] = {5,2,5,6,7,8};
    int n = sizeof(arr)/sizeof(arr[0]);
    printf("Orginal: ");
    traverse(arr, n);
    sort(arr, n);

    printf("Search: 2: %d\n", bs(arr, n, 3));
}
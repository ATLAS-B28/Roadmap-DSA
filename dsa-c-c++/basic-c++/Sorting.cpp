#include <iostream>
#include <vector>
using namespace std;

//bubble sort

void bubbleSort(int arr[], int n) {
    for(int i = 0; i < n - 1; i++) {
        for(int j = 0; j < n - i - 1; j++) {
            if(arr[j] < arr[j+1]) {
                swap(arr[j],arr[j+1]);
            }
        }
    }
}

//insertion sort

void insertionSort(int arr[], int n) {
    for(int i = 0; i < n; i++) {
        int key = arr[i];
        int j = i - 1;
        while(j >= 0 && arr[j] > key) {
            arr[j+1] = arr[j];//if j is greater then current i aka key
            //then shift it by 1 position and make space for key(i element)
            j--;
        }
        arr[j+1] = key;//as we decremented j from its current value by 
        //using j-- so j+1 will be equal to j and insert a key there
    }
}

//merge sort

void merge(int arr[], int left, int mid, int right) {
     int n1 = mid - left + 1;
     int n2 = right - mid;

     //initialize temp dynamic arrays for left and right
     //using container's vector
     vector<int> leftArr(n1), rightArr(n2);

     for(int i = 0; i < n1; i++) {
        leftArr[i] = arr[left + i];
     }

     for(int j = 0; j < n2; j++) {
        rightArr[j] = arr[mid + 1 + j];
     }

     int i = 0; 
     int j = 0; 
     int k = left;

     while(i < n1 && j < n2) {
        if(leftArr[i] <= rightArr[j]) {
            arr[k] = leftArr[i];
            i++;
        } else {
            arr[k] = rightArr[j];
            j++;
        }
        k++;
     }

     while(i < n1) {
        arr[k] = leftArr[i];
        i++;
        k++;
     }

     while (j < n2) {
        arr[k] = rightArr[j];
        j++;
        k++;
     }
     
}

void mergeSort(int arr[], int left, int right) {
    if(left < right) {
        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }
}

//quick sort

int partition(int arr[], int low, int high) {
    int pivot = arr[high];//select the rightmost element as pivot
    int i = (low - 1);//index of smaller element compare to the pivot
    //incremeneted whenever element is smaller than or equal to pivot

    for(int j = low; j <= high - 1; j++) {
        //if current element is smaller than or equal to pivot
        if(arr[j] <= pivot) {
            i++;
            swap(arr[i], arr[j]);//swap current element with element of smaller index
            //this places the smaller element at left of the pivot in the sorted part of the array
        }
    }
    swap(arr[i + 1], arr[high]);//swap the pivot with element at i + 1
    return (i + 1);//return partition index
}

void quickSort(int arr[], int low, int high) {
    if(low < high) {
        int pi = partition(arr, low, high);

        //sort element before and after the partition index
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}
/**
 * Consider the following array: arr = [7, 2, 1, 6, 8, 5, 3].

Let's assume that low = 0 and high = 6.

Initially, the pivot is selected as the rightmost element, which is arr[high] = 3.

The index i is initialized as low - 1, which is -1.

The for loop starts iterating from low to high - 1 (from 0 to 5 in this example).

At the first iteration (j = 0), the current element arr[j] is 7, which is greater than the pivot. So, no action is taken.

At the second iteration (j = 1), the current element arr[j] is 2, which is smaller than the pivot.
i is incremented to become 0 (i++).

The elements at indices 0 and 1 are swapped, resulting in the array: [2, 7, 1, 6, 8, 5, 3].

At the third iteration (j = 2), the current element arr[j] is 1, which is smaller than the pivot.
i is incremented to become 1 (i++).

The elements at indices 1 and 2 are swapped, resulting in the array: [2, 1, 7, 6, 8, 5, 3].

At the fourth iteration (j = 3), the current element arr[j] is 6, which is greater than the pivot. So, no action is taken.

At the fifth iteration (j = 4), the current element arr[j] is 8, which is greater than the pivot. So, no action is taken.

At the sixth iteration (j = 5), the current element arr[j] is 5, which is smaller than the pivot.
i is incremented to become 2 (i++).

The elements at indices 2 and 5 are swapped, resulting in the array: [2, 1, 5, 6, 8, 7, 3].

After the loop completes, all the elements smaller than or equal to the pivot (3) are placed to the left of the smaller index i (2).

Finally, the pivot element (3) is swapped with the element at the position i + 1 (2 + 1), resulting in the array: [2, 1, 3, 6, 8, 7, 5].

The partition index is returned as i + 1, which is 3 in this case.

After the partitioning process, the array is divided into two parts: [2, 1] 
and [6, 8, 7, 5]. The pivot element, 3, is in its correct sorted position, 
and all elements to the left of it are smaller,
while all elements to the right of it are greater.
*/

//selection sort

void selectionSort(int arr[], int n) {
    for(int i = 0; i < n - 1; i++) {
        int minIndex = i;
        
        for(int j = i + 1;j < n; j++) {
            if(arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }
        swap(arr[i] , arr[minIndex]);
    }
}

//heap sort

void heapify(int arr[], int n, int i) {
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i  + 2;

    if(left < n && arr[left] > arr[largest]) {
        largest = left;
    }

    if(right < n && arr[right] > arr[largest]) {
        largest = right;
    }

    if(largest != i) {
        swap(arr[i], arr[largest]);

        heapify(arr, n, largest);
    }
}

void heapSort(int arr[], int n) {
    //build max heap
    for(int i = n / 2 - 1; i >= 0; i--) {
        heapify(arr, n, i);
    }

    for(int i = n - 1; i >= 0; i--) {
        swap(arr[0], arr[i]);
        heapify(arr, i, 0);
    }
}

int main() {
    int arr[] = {64, 34, 25, 12, 22, 11, 90};
    int n = sizeof(arr) / sizeof(arr[0]);

    bubbleSort(arr, n);
    insertionSort(arr, n);
    mergeSort(arr, 0, n - 1);
    quickSort(arr, 0, n - 1);
    selectionSort(arr, n);
    heapSort(arr, n);
    cout << "Bubble Sorted array: \n";
    for(int i = 0; i < n; i++) {
        cout << arr[i] << " ,";
    }
    cout << "\n" << endl;
    cout << "Insertion Sorted array: \n";
    for(int j = 0; j < n; j++) {
        cout << arr[j] << " ,";
    }
    cout << "\n" << endl;
    cout << "Merge Sorted array: \n";
    for(int z = 0; z < n; z++) {
        cout << arr[z] << " ,";
    }
    cout << "\n" << endl;
    cout << "Quick Sorted array: \n";
    for(int k = 0; k < n; k++) {
        cout << arr[k] << " ,";
    }
    cout << "\n" << endl;
    cout << "Selection Sorted array: \n";
    for(int l = 0; l < n; l++) {
        cout << arr[l] << " ,";
    }
    cout << "\n" << endl;
    cout << "Heap Sorted array: \n";
    for(int m = 0; m < n; m++) {
        cout << arr[m] << " ,";
    }

    return 0;
}
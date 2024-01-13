//merge sort

/**
 * @param {number[]} left
 * @param {number[]} right
 * @returns {number[]}
*/

function merge(left, right) {
     const merged = [];
     let i = 0;
     let j = 0;

     while(i < left.length && j < right.length) {
        if(left[i] <= right[i]) {
            merged.push(left[i]);
            i++;
        } else {
            merged.push(right[j]);
            j++;
        }
     }

     return merged.concat(left.slice(i)).concat(right.slice(j));
}

/**
 * @param {number[]} arr
 * @returns {number[]}
 */

function mergeSort(arr) {
    if(arr.length <= 1) {
        return arr;
    }

    const mid = Math.floor(arr.length / 2);
    const left = mergeSort(arr.slice(0, mid));
    const right = mergeSort(arr.slice(mid));

    return merge(left, right);
}

//swap function utility

/**
 * @param {number[]} arr
 * @param {number} i
 * @param {number} j
 */

function swap(arr, i ,j) {
    const temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

//selection sort


/**
 * @param {number[]} arr
 * @returns {number[]}
 */

function selectionSort(arr) {
    //if, lets say, length is 8 then it will run for 6 iterations
    for(let i = 0; i < arr.length - 1; i++) {

        let minIndex = i;
    //then this will run for 7 
       for(let j = i + 1; j < arr.length; j++) {

         if(arr[j] < arr[minIndex]) {

            minIndex = j;

         }
       }

       swap(arr, i, minIndex);
    }
    return arr;
}

//insertion sort

/**
 * @param {number[]} arr
 * @returns {number[]}
 */

function insertionSort(arr) {
    for(let i = 1; i < arr.length; i++) {
        let j = i;
        while(j > 0 && arr[j] < arr[j - 1]) {
            swap(arr, j, j - 1);
            j--;
        }
    }
    return arr;
}

//qucik sort 

/**
 * @param {number[]} arr
 * @returns {number[]}
 */

function qucikSOrt(arr) {
    if(arr.length <= 1) {
        return arr;
    }

    const pivot = arr[arr.length - 1];
    const left = [];
    const right = [];

    for(let i =0; i < arr.length - 1; i++) {
        if(arr[i] <= pivot) {
            left.push(arr[i]);
        } else { 
            right.push(arr[i]);
        }
    }

    return [...qucikSOrt(left), pivot, ...qucikSOrt(right)];
}

//heap sort

/**
 * @param {number[]} arr
 * @param {number} n //size of heap
 * @param {number} i // index of root of subtree
 */

function heapify(arr, n, i) {
    let largest = i;
    const left = 2 * i + 1;
    const right = 2 * i + 2;

    if(left < n && arr[left] > arr[largest]) {
        largest = left;
    } 

    if(right < n && arr[right] > arr[largest]) {
        largest = right;
    }

    if(largest !== i) {
        swap(arr ,i, largest);
        heapify(arr, n, largest);
    }
}

/**
 * @param {number[]} arr
 */

function buildMaxHeap(arr) {
    const n = arr.length;
    const start = Math.floor(n / 2) - 1;
    
    for(let i = start; i >= 0; i--) {
        heapify(arr, n, i);
    }
}

/**
 * @param {number[]} arr
 * @returns {number[]}
 */

function heapSort(arr) {
    buildMaxHeap(arr);

    for(let i = arr.length - 1; i > 0; i--) {
        swap(arr, 0, i);
        heapify(arr, i, 0);
    }

    return arr;
}

const arr1 = [64, 34, 25, 12, 22, 11, 90];

const mergeResult = mergeSort(arr1);

console.log("Result of merge sort: ",mergeResult);

const arr2 = [64, 34, 25, 12, 22, 11, 90];

const selectionResult = selectionSort(arr2);

console.log("Result of selection sort: ",selectionResult);

const arr3 = [64, 34, 25, 12, 22, 11, 90];

const insertionResult = selectionSort(arr3);

console.log("Result of insertion sort: ",insertionResult);

const arr4 = [64, 34, 25, 12, 22, 11, 90];

const quickResult = qucikSOrt(arr4);

console.log("Result of quick sort: ",quickResult);

const arr5 = [64, 34, 25, 12, 22, 11, 90];

const heapResult = heapSort(arr5);

console.log("Result of heap sort: ",heapResult);
package Sorting;

public class CheapAndExpensive {
    public static void main(String[] args) {
        int[] priceList = new int[]{23,45,12,56,100,8900,20};
        System.out.println("Most cheap item is: "+cheap(priceList));
        System.out.println("Most expensive item is: "+expensive(priceList));
        int[] res = priceWithBubble(priceList);
        System.out.println("Cheapest using bubble sort: " + res[0]);
        System.out.println("Expensive using bubble sort: " + res[res.length-1]);
        int[] res2 = priceWithSelection(priceList);
        System.out.println("Cheapest using selection sort: " + res2[0]);
        System.out.println("Expensive using selection sort: " + res2[res.length-1]);


    }
    public static int cheap(int[] arr) {
        int minIdx = 0;
        for(int i = 1; i < arr.length - 1; i++) {
            if(arr[i] < arr[minIdx]) {
                minIdx = i;
            }

        }
        return arr[minIdx];
    }
    public static int expensive(int[] arr) {
        int maxIdx = 0;
        for(int i = 1; i < arr.length - 1; i++) {
            if(arr[i] > arr[maxIdx]) {
                maxIdx = i;
            }
        }
        return arr[maxIdx];
    }
    public static int[] priceWithBubble(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < n - 1 - i; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
    public static int[] priceWithSelection(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for(int j = i + 1; j < n; j++) {
                if(arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
        return arr;

    }
}

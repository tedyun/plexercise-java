import java.util.Arrays;

public class PeekValleySort {
    
    /**
     * Sort the array using merge sort algorithm.
     */
    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 2) {
            return;
        }
        for (int i = 1; i < arr.length; i+=2) {
            if (arr[i] > arr[i - 1]) {
                if (i == arr.length - 1) {
                    // edge case when i is the last element
                    swap(arr, i - 1, i);
                } else if (arr[i + 1] >= arr[i - 1]) {
                    swap(arr, i - 1, i);
                } else {
                    swap(arr, i, i + 1);
                }
            } else {
                if (arr[i + 1] < arr[i]) {
                    swap(arr, i , i + 1);
                }
            }
        }
    }

    public static void swap(int[] input, int indA, int indB) {
        int temp = input[indA];
        input[indA] = input[indB];
        input[indB] = temp;
    }

    public static void main (String[] args) {
        int[] testArray = new int[] {4, 6, 3, 3, 7, 2, 9, 4, 5, 1, 8, 10, 13, 15};
        sort(testArray);
        // add sanity test
        System.out.println(Arrays.toString(testArray));
    }
}
import java.util.Arrays;

public class InsertionSort {
    
    /**
     * Sort the array using merge sort algorithm.
     */
    public static void sort(int[] input) {
        for (int i = 0; i < input.length; i++) {
            int j = i - 1;
            while (j >= 0 && input[j] > input[j + 1]) {
                swap(input, j, j + 1);
                j--;
            }
        }
    }

    public static void swap(int[] input, int indA, int indB) {
        int temp = input[indA];
        input[indA] = input[indB];
        input[indB] = temp;
    }

    public static void main (String[] args) {
        int[] testArray = new int[] {4, 6, 3, 3, 7, 2, 9, 4, 5, 1, 8};
        sort(testArray);
        // add sanity test
        System.out.println(Arrays.toString(testArray));
    }
}
import java.util.Arrays;

public class MergeSort {
    
    /**
     * Sort the array using merge sort algorithm.
     */
    public static void sort(int[] input) {
        int[] aux = new int[input.length];
        sort(input, aux, 0, input.length - 1);
    }

    /**
     * Sort the array between start and end array. Auxiliary array provided.
     */
    public static void sort(int[] input, int[] aux, int start, int end) {
        if (start >= end) {
            return;
        }

        // Here start < end, so mid < end and start <= mid.
        int mid = (start + end) / 2;
        sort(input, aux, start, mid);
        sort(input, aux, mid + 1, end);
        merge(input, aux, start, mid, end);
    }

    /**
     * Merge [start, mid] and [mid + 1, end] subarrays.
     */
    public static void merge(int[] input, int[] aux, int start, int mid, int end) {
        int lp = start;
        int rp = mid + 1;
        int auxp = start;
        while (auxp <= end) {
            if (lp > mid) {
                aux[auxp] = input[rp++];
            } else if (rp > end) {
                aux[auxp] = input[lp++];
            } else if (input[lp] <= input[rp]) {
                aux[auxp] = input[lp++];
            } else {
                aux[auxp] = input[rp++];
            }
            auxp++;
        }
        // copy aux back to input
        for (int i = start; i <= end; i++) {
            input[i] = aux[i];
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
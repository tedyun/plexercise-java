import java.util.Arrays;

public class QuickSort {
    
    /**
     * Sorts the array using quick sort
     * TODO: doc
     */
    public static void sort(int[] input) {
        sort(input, 0, input.length - 1);
    }
    
    /**
     * Sorts the array in place
     * TODO: doc
     */
    public static void sort(int[] input, int low, int high) {
        // TODO: argument validation
        if (low < high) {
            int pivotPos = partition(input, low, high);
            sort(input, low, pivotPos - 1);
            sort(input, pivotPos + 1, high);
        }
            
    }

    /**
     * Picks a pivot, partitions the array, returns the pivot index.
     */
    private static int partition(int[] input, int low, int high) {
        int pivot = input[high];
        int elemLessThanPivot = 0;
        for (int i = low; i < high; i++) {
            if (input[i] < pivot) {
                elemLessThanPivot++;
                swap(input, low + elemLessThanPivot - 1, i);
            }
        }
        if (elemLessThanPivot < high - low) {
            swap(input, low + elemLessThanPivot, high);
        }
        return low + elemLessThanPivot;
    }

    private static void swap(int[] input, int i, int j) {
        if (i != j) {
            int temp = input[i];
            input[i] = input[j];
            input[j] = temp;
        }
    }

    /**
     * Main
     */
    public static void main(String[] args) {
        int[] testArray = new int[] {4, 6, 3, 3, 7, 2, 9, 4, 5, 1, 8};
        sort(testArray);
        // add sanity test
        System.out.println(Arrays.toString(testArray));
    }
}
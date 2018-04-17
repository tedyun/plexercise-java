public class BinarySearch {
    public static int binarySearch(int[] a, int x) {
        int low = 0, high = a.length - 1;
        while (low < high) {
            int mid = (low + high + 1) / 2;
            if (x == a[mid]) {
                return mid;
            } else if (x < a[mid]) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        // if this is reached, it means low = high
        if (a[low] == x) {
            return low;
        } 
        return -1;
    }

    public static void main(String[] args) {
        int[] a = new int[] {1, 1, 2, 3, 5, 6, 7, 8, 9, 11, 24, 27, 35, 36, 50};
        System.out.println(binarySearch(a, 2));
    }
}
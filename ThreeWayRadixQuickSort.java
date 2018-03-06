import java.util.Arrays;

public class ThreeWayRadixQuickSort {

    public static void sort(String[] a) {
      sort(a, 0, a.length - 1, 0);
    }
  
    private static int charAt(String a, int pos) {
      if (pos < a.length()) {
        return (int) a.charAt(pos);
      } else {
        return -1;
      }
    }
  
    private static void swap(String[] a, int x, int y) {
      String temp = a[x];
      a[x] = a[y];
      a[y] = temp;
    }
  
    private static void sort(String[] a, int low, int high, int d) {
        if (high <= low) return;
        int lp = low, rp = high;
        int pivot = charAt(a[low], d);
        int i = low + 1;
    
        // partitioning
        while (i <= rp) {
          int current = charAt(a[i], d);
          if (current < pivot) {
            swap(a, i, lp);
            i++;
            lp++;
          } else if (current > pivot) {
            swap(a, i, rp);
            rp--;
          } else {
            i++;
          }
        }
    
        // sort "less than" part
        sort(a, low, lp - 1, d);
        // recursively sort "equal" partition in the next "digit"
        if (pivot >= 0) sort(a, lp, rp, d + 1);
        // sort "greater than" part
        sort(a, rp + 1, high, d);
      }
  
    public static void main(String[] args) {
      String[] abc = new String[] {"asdlgjdskfa", "gjfklasdr", "bewjrlkj", "asdjk", "alkdsjf"};
      sort(abc);
      System.out.println(Arrays.toString(abc));
    }
  }
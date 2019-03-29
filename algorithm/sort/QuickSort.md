``` java
package basic.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/3/28 0028
 */
public class QuickSort {


    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int low, int high) {
        if (high <= low) {
            return;
        }
        int j = partition(a, low, high);
        sort(a, low, j - 1);
        sort(a, j + 1, high);
    }

    private static int partition(Comparable[] a, int low, int high) {
        int i = low, j = high + 1;
        Comparable v = a[low];
        while (true) {
            while (less(v, a[--j])) {
                if (j == low) {
                    break;
                }
            }
            while (less(a[++i], v)) {
                if (i == high) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exchange(a, i, j);
        }
        exchange(a, low, j);
        return j;
    }

    private static boolean less(Comparable a, Comparable b) {
        if (a == b) {
            return false;
        }
        return a.compareTo(b) < 0;
    }

    private static void exchange(Object[] a, int i, int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Comparable[] a = new Comparable[]{3, 5, 3, 1, 8, 9, 2, 2, 2, 1, 7, 1, 5};
        QuickSort.sort(a);
        System.out.println(Arrays.toString(a));
    }

}

```

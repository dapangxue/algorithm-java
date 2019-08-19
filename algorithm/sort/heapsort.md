# HeapSort
##
```java
import java.util.Arrays;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-8-19
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] a = new int[]{1, 4, 5, 1, 2, 3, 7};
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void heapSort(int[] array) {
        if (array == null || array.length == 1) {
            return;
        }
        // 先构建一个大顶堆
        buildArrayToHeap(array);
        for (int i = array.length - 1; i >= 0; i--) {
            // 每次将堆顶和堆的末尾元素进行交换
            exchange(array, 0, i);
            // buildMaxHeap(array, 0, i);
            buildMinHeap(array, 0, i);
        }
    }

    public static void buildArrayToHeap(int[] array) {
        if (array == null || array.length == 1) {
            return;
        }

        int fix = array.length / 2 - 1;
        for (int i = fix; i >= 0; i--) {
            // buildMaxHeap(array, i, array.length);
            buildMinHeap(array, i, array.length);
        }
    }

    /**
     * 构建大顶堆
     * @param array
     * @param fix
     * @param heapSize
     */
    public static void buildMaxHeap(int[] array, int fix, int heapSize) {
        int leftIndex = 2 * fix + 1;
        int rightIndex = 2 * fix + 2;
        int maxValueIndex = fix;

        if (leftIndex < heapSize && array[leftIndex] > array[maxValueIndex]) {
            maxValueIndex = leftIndex;
        }
        if (rightIndex < heapSize && array[rightIndex] > array[maxValueIndex]) {
            maxValueIndex = rightIndex;
        }

        if (maxValueIndex != fix) {
            exchange(array, maxValueIndex, fix);
            buildMaxHeap(array, maxValueIndex, heapSize);
        }
    }

    public static void buildMinHeap(int[] array, int fix, int heapSize) {
        int leftIndex = 2 * fix + 1;
        int rightIndex = 2 * fix + 2;
        int minValueIndex = fix;

        if (leftIndex < heapSize && array[leftIndex] < array[minValueIndex]) {
            minValueIndex = leftIndex;
        }
        if (rightIndex < heapSize && array[rightIndex] < array[minValueIndex]) {
            minValueIndex = rightIndex;
        }

        if (minValueIndex != fix) {
            exchange(array, minValueIndex, fix);
            buildMinHeap(array, minValueIndex, heapSize);
        }
    }

    public static void exchange(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

}

```

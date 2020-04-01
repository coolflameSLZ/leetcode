package basealg.heap;

import common.Heap;

import static common.Heap.HEAP_BEGIN_IDX;
import static common.Heap.swap;


public class 堆排序 {


    public static void sort(int[] array, int size) {

        // 将整个数组堆化
        Heap.heapifyAllArray(array, size);


        // 将最后一位和第一位对调，然后堆化
        // 将倒数第二位和第一位对调，然后堆化
        // 将倒数第三位和第一位对调，然后堆化
        // 。。。。。
        // 最终，越大的，越靠后。
        for (int i = size; i > 1; i--) {
            swap(array, HEAP_BEGIN_IDX, i);
            Heap.heapifyDown(array, HEAP_BEGIN_IDX, i);
        }


    }

}

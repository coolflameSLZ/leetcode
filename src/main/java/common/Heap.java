package common;

/**
 * 堆
 */
public class Heap {
    public static final int HEAP_BEGIN_IDX = 1;
    private int[] heapArray; // 数组，从下标1开始存储数据
    private int capacity; // 堆可以存储的最大数据个数
    private int count; // 堆中已经存储的数据个数

    public Heap(int capacity) {
        heapArray = new int[capacity + 1];
        this.capacity = capacity;
        count = 0;
    }


    /**
     * 插入 ，
     * 1.先将新元素放到最后，
     * 2.然后进行堆化， 即自下往上比较大小后交换,保证父亲比儿子大即可
     *
     * @param data
     */
    public void inster(int data) {

        if (count >= capacity) {
            throw new RuntimeException("堆满了");
        }

        // 1 把数据追加到数组最后
        count++;
        heapArray[count] = data;

        // 2 如果最后追加的这个元素，比他的父亲大
        // 就进行向上堆化
        int i = this.count;
        while (getParentIndex(i) > 0 && heapArray[i] > heapArray[getParentIndex(i)]) {

            int parentIndex = getParentIndex(i);
            swap(heapArray, i, parentIndex);
            i = parentIndex;
        }
    }

    /**
     * 删除最大元素
     *
     * @return 删除的最大值
     */
    public int removeMax() {

        if (count == 0) {
            throw new RuntimeException("堆中没有元素");
        }

        int result = heapArray[HEAP_BEGIN_IDX];

        count--;
        // 数组最后一位放到堆顶
        heapArray[HEAP_BEGIN_IDX] = heapArray[count];
        // 堆化
        heapifyDown(heapArray, 1, count);

        return result;
    }


    /**
     * 将一个数组完全堆化，
     * 从最后一个元素的父亲开始，依次向前堆化。
     * 直到head完成堆化
     *
     * @param array
     * @param heapSize
     */
    public static void heapifyAllArray(int[] array, int heapSize) {
        for (int i = getParentIndex(heapSize); i > 0; --i) {
            heapifyDown(array, i, heapSize);
        }
    }

    /**
     * 自上向下堆化。
     * 从头节点开始，与更大的儿子进行交换。 然后将指针指向父亲交换后的位置,
     *
     * @param heapArray
     * @param beginNode
     * @param heapSize
     */
    public static void heapifyDown(int[] heapArray, int beginNode, int heapSize) {

        int index = beginNode;

        while (true) {
            int maxPos = index;

            // 父亲比左儿子小，最大值换成左儿子
            if (getLeftSonIndex(beginNode) <= heapSize && heapArray[beginNode] < heapArray[getLeftSonIndex(beginNode)]) {
                maxPos = getLeftSonIndex(beginNode);
            }

            // 如果右儿子更大，那么最大值换成右儿子
            if (getRightSonIndex(beginNode) <= heapSize && heapArray[maxPos] < heapArray[getRightSonIndex(beginNode)]) {
                maxPos = getRightSonIndex(beginNode);
            }

            // 如果 经过了两轮比较，父亲依然是最大的，那么退出
            if (maxPos == beginNode) {
                break;

                // 交换后，指针指向交换后的位置（新的最大值）
            } else {
                swap(heapArray, beginNode, maxPos);
                index = maxPos;
            }
        }


    }

    /**
     * 自下向上的堆化
     * <p>
     * 从给定的节点开始，
     * 如果他比父亲大，就与父亲交换，刷新指针的位置，指向交换后的位置
     *
     * @param heapArray
     * @param tail
     */
    public static void heapifyUp(int[] heapArray, int tail) {

        int index = tail;

        while (heapArray[index] > heapArray[getParentIndex(index)]) {
            swap(heapArray, index, getParentIndex(index));
            index = getParentIndex(index);
        }


    }


    //========似有方法============

    /**
     * 交换数组中两个位置的值
     *
     * @param array  数组
     * @param index1 位置1
     * @param index2 位置2
     * @return 交换后的数组，与传入数组为同一对象
     */
    public static int[] swap(int[] array, int index1, int index2) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Number array must not empty !");
        }
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
        return array;
    }

    /**
     * 获取父亲节点索引
     *
     * @param index
     * @return
     */
    public static int getParentIndex(int index) {
        return index / 2;
    }

    /**
     * 获取左孩子节点索引
     *
     * @param index
     * @return
     */
    public static int getLeftSonIndex(int index) {
        return index * 2;
    }

    /**
     * 获取右孩子节点索引
     *
     * @param index
     * @return
     */
    public static int getRightSonIndex(int index) {
        return (index * 2) + 1;
    }


}
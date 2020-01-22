package common;

/**
 * 堆
 */
class Heap {
    private int[] heapArray; // 数组，从下标1开始存储数据
    private int capacity; // 堆可以存储的最大数据个数
    private int count; // 堆中已经存储的数据个数

    public Heap(int capacity) {
        heapArray = new int[capacity + 1];
        this.capacity = capacity;
        count = 0;
    }

    /**
     * 获取父亲节点索引
     *
     * @param index
     * @return
     */
    public int getParentIndex(int index) {
        return index / 2;
    }

    /**
     * 获取左孩子节点索引
     *
     * @param index
     * @return
     */
    public int getLeftSonIndex(int index) {
        return index * 2;
    }

    /**
     * 获取右孩子节点索引
     *
     * @param index
     * @return
     */
    public int getRightSonIndex(int index) {
        return (index * 2) + 1;
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

        // 1
        count++;
        heapArray[count] = data;

        // 2 执行条件，孩子比父亲大
        int i = this.count;
        while (getParentIndex(i) > 0 && heapArray[i] > heapArray[getParentIndex(i)]) {

            int parentIndex = getParentIndex(i);
            swap(heapArray, i, parentIndex);
            i = parentIndex;
        }
    }

    /**
     * 删除最大元素
     */
    public void removeMax() {

        if (count == 0) {
            throw new RuntimeException("堆中没有元素");
        }

        count--;
        // 数组最后一位放到堆顶
        heapArray[1] = heapArray[count];
        // 堆化
        heapify(heapArray, 1, count);


    }

    private void heapify(int[] heapArray, int head, int tail) {

        while (true) {
            int maxPos = head;

            if (getLeftSonIndex(head) <= tail && heapArray[head] < heapArray[getLeftSonIndex(head)]) {
                maxPos = getLeftSonIndex(head);
            }

            if (getRightSonIndex(head) <= tail && heapArray[head] < heapArray[getRightSonIndex(head)]) {
                maxPos = getRightSonIndex(head);
            }

            if (maxPos == head) {
                break;
            }

            swap(heapArray, tail, maxPos);
            head = maxPos;
        }


    }

    /**
     * 交换
     *
     * @param heapArray
     * @param i
     * @param j
     */
    private void swap(int[] heapArray, int i, int j) {
        int tmp = heapArray[i];
        heapArray[i] = heapArray[j];
        heapArray[j] = tmp;
    }


}
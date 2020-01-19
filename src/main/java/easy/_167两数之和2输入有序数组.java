package easy;

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 说明:
 * <p>
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * <p>
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://dev.lingkou.xyz/problems/two-sum-ii-input-array-is-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _167两数之和2输入有序数组 {

    public static void main(String[] args) {


    }

    public int[] twoSum(int[] numbers, int target) {

        if (numbers.length == 0) {
            return numbers;
        }
        if (numbers.length == 1 && numbers[0] == target) {
            return new int[]{1};
        }

        if (numbers.length == 1) {
            return new int[]{};
        }

        // 因为数组是有序的，所以用双指针法。
        // 首尾两个指针，相向而行。 两个指针指向的数字，如果比目标大。尾指针前进，反之头指针前进。
        // 知道他们碰头，如果没有目标值，返回空

        int headInx = 0;
        int tailInx = numbers.length - 1;

        while (headInx < tailInx) {

            int curMerge = numbers[headInx] + numbers[tailInx];

            if (curMerge == target) {
                return new int[]{headInx + 1, tailInx + 1};
            } else if (curMerge < target) {
                headInx++;
            } else {
                tailInx--;
            }
        }

        return new int[]{};


    }

}

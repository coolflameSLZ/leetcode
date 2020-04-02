package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _1两数之和 {

    public static void main(String[] args) {


        int[] ints = {2, 7, 11, 15};
        int[] result = twoSum(ints, 9);
        for (int i : result) {
            System.out.println(i);
        }


    }

    public static int[] twoSum(int[] nums, int target) {


        /**
         * 设计一个kv
         * k 为值，v为索引
         * 总和 - 当前的值 = 另一半的值（另一半的索引）
         * 只要map中有另一半的值存在，即可成功返回。
         */
        Map<Integer, Integer> hashMap = new HashMap<>();

        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {

            int currentValue = nums[i];

            int leftValue = target - currentValue;
            Integer leftIndx = hashMap.get(leftValue);

            if (leftIndx != null) {
                result[0] = leftIndx;
                result[1] = i;
                return result;
            } else {
                hashMap.put(currentValue, i);
            }
        }

        return result;
    }
}

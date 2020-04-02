package leetcode.easy;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _53最大子序和 {

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println(
                maxSubArray(nums)
        );


    }


    public static int maxSubArray(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        int maxSum = nums[0];// 保存历史最大值
        int curSum = nums[0];// 保存当前最大值

        // 指针扫描的时候又两种策略
        // 追加 or 新建一个数组
        // 那种数组大，选择哪种策略
        for (int i = 1; i < nums.length; i++) {

            int newNum = nums[i];
            int oldSum = curSum + newNum;

            // 如果新的大,重新开始计数
            // 如果还是老数组大，那么此值追加到老数组中
            boolean newIsGood = newNum > oldSum;
            if (newIsGood) {
                curSum = newNum;
            } else {
                curSum = oldSum;
            }

            // 保存历史最大值
            if (newIsGood && newNum > maxSum) {
                maxSum = newNum;
            } else if (!newIsGood && oldSum > maxSum) {
                maxSum = oldSum;
            }

//            System.out.println("max=" + maxSum);
//            System.out.println("cur=" + curSum);
//            System.out.println("====================================");
        }

        return maxSum;
    }


}

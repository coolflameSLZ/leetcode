package easy;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _35搜索插入位置 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};

        System.out.println(
                searchInsert(nums, 5)
        );


    }


    public static int searchInsert(int[] nums, int target) {

        // 空数组，直接插入
        if (nums.length == 0) {
            return 0;
        }


        // 指针扫描数组，
        // 当前数字 大于 等于 目标数字的时候，
        // 目标数字即可插入到当前位置
        for (int i = 0; i < nums.length; i++) {

            int currentNum = nums[i];

            if (currentNum >= target) {
                return i ;
            }
        }

        // 所有的数字都比目标小，就插入到最后
        return nums.length ;


    }
}

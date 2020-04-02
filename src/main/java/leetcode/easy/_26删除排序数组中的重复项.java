package leetcode.easy;

import java.util.Arrays;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * <p>
 * 给定数组 nums = [1,1,2],
 * <p>
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * <p>
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * <p>
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _26删除排序数组中的重复项 {

    public static void main(String[] args) {
//        nums = [0,0,1,1,1,2,2,3,3,4]
        int[] nums = new int[]{0, 1, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
        System.out.println("===============");
        Arrays.stream(nums)
                .forEach(System.out::println);

    }

    public static int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        // 一个慢指针i,一个快指针j
        // 慢指针i 只有当被修改值当时候，才向后挪一下
        // 快指针j 每一回合都向后挪一下
        int i = 0;

        for (int j = 1; j < nums.length; j++) {

            // 当快慢指针指向当值，不一样当时候，慢指针的下一个值,被修改成新找到的j值。
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }else {
                // 当快慢指针指向的值一样的时候，什么都不做，快指针向后挪，直到发现不一样都值。
            }

        }

        return i+1;
    }
}

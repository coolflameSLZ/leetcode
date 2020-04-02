package leetcode.easy;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _169多数元素 {

    public static void main(String[] args) {


    }


    public int majorityElement(int[] nums) {


        Integer nowWinner = null;

        int nowCount = 0;


        // 循环遍历nums
        // 如果是多数数组,count ++
        // 如果不是多数数组，count --
        // 当积分为0的时候， 下一轮的数组，便是新的赢家，count ++
        for (int num : nums) {


            if (nowCount == 0) {
                nowCount++;
                nowWinner = num;
                continue;
            }

            if (nowWinner == num) {
                nowCount++;
            } else {
                nowCount--;
            }
        }

        return nowWinner;


    }

}

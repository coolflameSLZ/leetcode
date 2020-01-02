package easy;

import java.util.Objects;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 * <p>
 * 你能不将整数转为字符串来解决这个问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _3回文数 {

    public static void main(String[] args) {

        System.out.println(isPalindrome(12321));

    }

    public static boolean isPalindrome(int x) {

        //负数永远不是回文数
        //10的倍数也永远不是回味数,0除外
        if (x == 0) {
            return true;
        }
        if (x < 0 || (x % 10 == 0)) {
            return false;
        }

        // 把持住入参
        int hold = x;
        int checksum = 0;


        // 连续取余，将余数 *10 ，即可反转
        while (x != 0) {
            checksum = checksum * 10;
            int t = x % 10;
            x = x / 10;
            checksum += t;
        }

        return Objects.equals(hold, checksum);
    }
}

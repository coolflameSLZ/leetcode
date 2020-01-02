package easy;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _2整数反转 {


    public static void main(String[] args) {

        System.out.println(reverse(-123));


    }

    public static int reverse(int x) {

        long sum = 0L;

        // 以前的累乘 * 10 + 当前的余数
        // 不要忘记，取余后，再操作一下x，让x变化
        while (x != 0) {
            sum *= 10;

            int t = x % 10;
            x = x / 10;
            sum += t;
        }

        // int 范围，因为反转有越界可能
        // -2147483648——2147483647
        if (sum < -2147483648 || sum > 2147483647) {
            return 0;
        }
        return (int) sum;
    }
}

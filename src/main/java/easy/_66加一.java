package easy;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _66加一 {

    public static void main(String[] args) {


    }


    public int[] plusOne(int[] digits) {

        int length = digits.length;

        // [0] 返回 [1]
        if (length == 1 && digits[0] == 0) {
            return new int[]{1};
        }

        for (int i = length; i > 0; i--) {

            // 如果这一位是9 就需要进位
            // 仅为就是下一次循环，指针指向的值加1
            if (digits[i - 1] == 9) {
                digits[i - 1] = 0;

                if (i - 1 == 0) {

                    // 数组首位也是9 就得重新构建一个 1000000的数组
                    digits = new int[length+1];
                    digits[0] = 1;
                    for (int j = 0; j < length; j++) {
                        digits[j+1]=0;
                    }


                }

            } else {
                digits[i - 1] += 1;
                break;
            }

        }

        return digits;


    }

}

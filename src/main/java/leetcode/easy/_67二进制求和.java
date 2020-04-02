package leetcode.easy;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _67二进制求和 {

    public static void main(String[] args) {


        System.out.println(
                addBinary("11111", "11")
        );

    }


    public static String addBinary(String a, String b) {
        if ("0".equals(a)) {
            return b;
        }

        if ("0".equals(b)) {
            return a;
        }

        // 找出最大的长度
        int max = Math.max(a.length(), b.length());
        int carry = 0;
        String result = "";

        // 从每个数字的最右边开始处理，
        // 当数组越界的时候，返回0
        for (int i = 0; -i < max; i--) {

            int ia = a.length() - 1 + i;
            int ib = b.length() - 1 + i;

            // char 转数字，利用 char - char(‘0’) 的差值,得到具体的数字值
            int achar = ia < 0 ? 0 : a.charAt(ia) - '0';
            int bchar = ib < 0 ? 0 : b.charAt(ib) - '0';

//            String format = StrUtil.format("carry={}+achar={}+bchar={}", carry, achar, bchar);
//            System.out.println(format);

            // 本回合的结果
            int tmpRes = carry + achar + bchar;

            // 进位处理
            if (tmpRes > 1) {
                // 进位，本位-2
                carry = 1;
                tmpRes = tmpRes - 2;
            } else {
                // 本回合结果不大于1 将进位取消
                carry = 0;
            }

            // 往前追加
            result = tmpRes + result;

        }

        // 进位没进完
        if (carry > 0) {
            result = carry + result;
        }


        return result;
    }

}

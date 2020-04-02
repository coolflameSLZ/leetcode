package lcof;

/**
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _11旋转数组的最小数字 {

    public static void main(String[] args) {


    }


    public static int minArray(int[] numbers) {


        for (int i = 1; i < numbers.length; i++) {

            int pre = numbers[i - 1];
            int cur = numbers[i];

            if (pre > cur) return cur;
        }

        return numbers[0];
    }


}

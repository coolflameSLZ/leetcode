package easy;

/**
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 * <p>
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _172阶乘后的零 {

    public static void main(String[] args) {


    }

    public static int trailingZeroes(int n) {

        //能除开5都算
        int fivetimes = 0;
        //因为只有5和2相乘才可以是10。于是计算n中5的个数，要注意比如25其实是有两个5，
        while (n >= 5) {
            //每次都只加一层的个数
            //第一层有5的个数（以25为例）
            fivetimes += n / 5;
            //除以5之后就变成了第二层（n中包含25的个数，如果有一个就会在第二层判断时+1）...以此类推之后是n中包含25*5=125的个数;
            n = n / 5;
        }
        return fivetimes;


    }


}

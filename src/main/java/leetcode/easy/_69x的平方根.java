package leetcode.easy;

/**
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _69x的平方根 {

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));


    }


    public static int mySqrt(int x) {

        if (x==1){
            return 1;
        }


        long left = 0;
        long right = x;
        long mid = right / 2;
        while (true) {

            // 中位数的平方，如果比结果大，那么就选左半边
            // 注意，int类型的值，的平方容易超过int最大值
            boolean chooseLeft = mid * mid > x;

            // 左半边，就是有边界移到中位数这里
            if (chooseLeft) {
                right = mid;
            } else {
                left = mid;
            }

            // 重新选择新的中位数
            mid = (left + right) / 2;

//            System.out.println("left=" + left + ",right=" + right + ",mid=" + mid);
            // 当中位数 和任意一边相同的时候，就退出
            if (mid == left || mid == right) {
                return (int) mid;
            }
        }
    }

}

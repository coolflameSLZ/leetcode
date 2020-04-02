package lcof;

/**
 * P44
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _4二维数组中的查找 {

    public static void main(String[] args) {


    }


    /**
     * 上面比下面小
     * 右边比左边大
     * 我们参考二叉查找树的思路来做。
     * 可以不回头的找到
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {

        // 边界,"null"-->false,[][][]-->false,
        if (matrix.length == 0 || matrix[0].length == 0) return false;

        int row = 0;
        int col = matrix[0].length - 1;

        // 指针不能越界
        while (row <= matrix.length - 1 && col >= 0) {

            int curNum = matrix[row][col];
            // 退出条件
            if (target == curNum) return true;

            // 目标值更小,去小的地方查找
            if (curNum > target) {
                col = col - 1;
            } else {
                // 目标值更大，去大的地方查找
                row = row + 1;
            }
        }
        return false;
    }


}

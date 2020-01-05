package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _70爬楼梯 {

    public static void main(String[] args) {
        System.out.println(climbStairs(4));


    }


    /**
     * 递归 + 记忆
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {

        Map<Integer, Integer> memo = new HashMap<>();

        return climbStairs(0, n, memo);
    }

    /**
     * @param i    当前阶数
     * @param n    目标阶数
     * @param memo 这个map 中存储的是上 x阶楼梯的方法，之间取就行
     * @return
     */
    private static int climbStairs(int i, int n, Map<Integer, Integer> memo) {


        System.out.println("从第i=" + i + ",走到n=" + n);

        // 不需要爬楼梯
        if (i > n) {
            return 0;
        }
        // 只相差一步，返回1
        if (i == n) {
            return 1;
        }

        // 获取缓存中的职
        Integer count = memo.get(n - i);
        if (count == null) {
            // 从当前楼梯 到目标楼梯 可以分解为上一步，或上两步
            count = climbStairs(i + 1, n, memo) + climbStairs(i + 2, n, memo);
            memo.put(n - i, count);
        }

        return count;


    }


}



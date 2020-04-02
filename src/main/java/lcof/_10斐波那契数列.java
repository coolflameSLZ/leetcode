package lcof;

import java.util.HashMap;
import java.util.Map;

/**
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _10斐波那契数列 {

    public static void main(String[] args) {

        System.out.println(fib(4));

    }


    public static int fib(int n) {

        Map<Integer, Integer> resultMap = new HashMap<>();

        return fibHelper(n, resultMap);
    }

    public static int fibHelper(int n, Map<Integer, Integer> resultMap) {


        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }


        if (resultMap.get(n) == null) {
            int result = (fibHelper(n - 1, resultMap) + fibHelper(n - 2, resultMap)) % 1000000007;
            resultMap.put(n, result);
            return result;
        } else {
            return resultMap.get(n);
        }


    }


}

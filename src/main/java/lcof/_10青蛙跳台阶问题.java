package lcof;

import java.util.HashMap;
import java.util.Map;

/**
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _10青蛙跳台阶问题 {

    public static void main(String[] args) {


    }


    public int numWays(int n) {

        HashMap<Integer, Integer> resultMap = new HashMap<>();
        return  numWays(0,n,resultMap);
    }

    public int numWays(int i, int n, Map<Integer, Integer> resultMap) {

        if (i > n) return 0;

        if (i == n) return 1;


        Integer result = resultMap.get(n);

        if (result == null) {
            result = numWays(i + 1, n, resultMap) + numWays(i + 2, n, resultMap);
            result %= 1000000007;
            resultMap.put(i,result);
        }

        return result;
    }


}

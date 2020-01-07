package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * <p>
 * <p>
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _118杨辉三角 {

    public static void main(String[] args) {

        generate(5);

    }


    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows + 1; i++) {

            // {[1]}
            if (i == 1) {
                result.add(Collections.singletonList(1));
                // {[1],[1,1]}
            } else if (i == 2) {
                result.add(Arrays.asList(1, 1));
            } else if (i > 2) {

                List<Integer> last = result.get(result.size() - 1);
                List<Integer> tmp = new ArrayList<>();
                tmp.add(1);
                for (int j = 1; j < last.size(); j++) {
                    Integer a = last.get(j - 1);
                    Integer b = last.get(j);
                    tmp.add(j, a + b);
                }

                tmp.add(1);
//                System.out.println("num="+i+"tmp="+tmp);

                result.add(tmp);
            }


        }

        return result;

    }


}

package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * <p>
 * <p>
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 * <p>
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _119杨辉三角2 {

    public static void main(String[] args) {

        System.out.println(

                getRow(3)
        );

    }


    public static List<Integer> getRow(int rowIndex) {

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < rowIndex + 1; i++) {

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

                result.add(tmp);
            }
        }

        return result.get(result.size()-1);


    }


}

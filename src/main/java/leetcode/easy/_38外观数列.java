package leetcode.easy;


import javax.xml.transform.Result;
import java.util.Objects;

/**
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * <p>
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
 * <p>
 * 注意：整数序列中的每一项将表示为一个字符串。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "1211"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-and-say
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _38外观数列 {

    public static void main(String[] args) {

        countAndSay(4);

    }


    public static String countAndSay(int n) {

        String result = "1";
        for (int i = 0; i < n-1; i++) {
            result = checkStr(result);
        }

        return result;
    }


    public static String checkStr(String check) {

        //边界
        if (check == null || check.length() == 0) {
            return "";
        }
        // 当前指针指向的字母，将他初始化为check的第一个字母
        char hold = check.charAt(0);
        // 计数
        int count = 0;
        // 结果
        String result = "";

        // 遍历给定字符串，
        // 遇到新字母，组合结果，刷新，count 重置为1
        // 遇到老字母，count +1
        for (int i = 0; i < check.length(); i++) {

            char charAt = check.charAt(i);

            if (Objects.equals(hold, charAt)) {
                count++;
            } else {
                result = result + count + hold;
                count = 1;
                hold = charAt;
            }
        }
        // 遍历完后，count 还有值把最后的这一位加上
        result = result + count + hold;
        return result;
    }


}
































package leetcode.easy;

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * <p>
 * 如果不存在最后一个单词，请返回 0 。
 * <p>
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: "Hello World"
 * 输出: 5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _58最后一个单词的长度 {

    public static void main(String[] args) {

        System.out.println(
                lengthOfLastWord("a ")
        );

    }


    public static int lengthOfLastWord(String s) {

        int length = s.length();
        int resultCount = 0;
        boolean ifstart = false;

        // 从后往前扫描，
        // 不是空格，数量累加1
        // 当发现空格的时候，返回历史记录
        for (int i = length; i > 0; i--) {

            char currentChar = s.charAt(i - 1);
            // 坑，当输入字符串为 “  a    ”的时候，最后的空格，不能算
            if (currentChar != ' ') {
                ifstart = true;
            }

            if (ifstart) {
                if (currentChar == ' ') {
                    return resultCount;
                } else {
                    resultCount++;
                }
            }


        }
        return resultCount;
    }
}

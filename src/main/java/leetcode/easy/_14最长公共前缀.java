package leetcode.easy;

/*14. 最长公共前缀*
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _14最长公共前缀 {
    public static void main(String[] args) {


        String[] strings = {"aa", "a"};
        String out = longestCommonPrefix(strings);

        System.out.println(out);


    }

    public static String longestCommonPrefix(String[] strs) {

        // 如果空数组，第一个是空字符串。返回“”
        if (strs.length == 0 || "".equals(strs[0])) {
            return "";
        }

        String flagStr = strs[0];
        StringBuilder commonStr = new StringBuilder();

        for (int i = 0; i < flagStr.length(); i++) {
            char c = flagStr.charAt(i);

            // 便利其他字母，添加共子串，
            // 如果公共，追加到公共字母里面
            // 如果不公共，退出并返回历史公共子串
            for (int s = 1; s < strs.length; s++) {
                String otherStrs = strs[s];
                // 数组中其他位置字符串的 第i个字符
                // 如果与第一个不符合，或者 不够长 退出
                if (otherStrs.length() - 1 < i || otherStrs.charAt(i) != c) {
                    return commonStr.toString();
                }
            }

            //经历了对比，追加这个公共字符
            commonStr.append(c);
        }
        return commonStr.toString().toString();
    }
}

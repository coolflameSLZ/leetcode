package mid;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _3无重复字符的最长子串 {

    public static void main(String[] args) {

        int i = lengthOfLongestSubstring("23456");
        System.out.println(i);

    }

    public static int lengthOfLongestSubstring(String s) {

        int result = 0;

        // 字符记忆表
        Set<Character> memChar = new HashSet<>();
        // 快慢指针
        int fast = 0;
        int slow = 0;


        // 当字母不重复的时候，快指针后移，刷新结果
        // 当字母为重复的时候，慢指针后移，同时删除掉沿途的字母，
        // 直至字母不重复，继续操作快指针
        while (fast < s.length() && slow < s.length()) {

            char fastChar = s.charAt(fast);
            char slowChar = s.charAt(slow);

            boolean ifContains = memChar.contains(fastChar);

            if (!ifContains) {
                memChar.add(fastChar);
                result = Integer.max(result, fast - slow + 1);
                fast = fast + 1;
            } else {
                memChar.remove(slowChar);
                slow = slow + 1;
            }
        }

        return result;
    }


}

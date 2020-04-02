package leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _20有效的括号 {
    public static void main(String[] args) {

        boolean valid = isValid("{[]}{");

        System.out.println(valid);
    }

    public static boolean isValid(String s) {

        if (s.isEmpty()) {
            return true;
        }

        Stack<Character> checkStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            // 空的 放进去
            if (checkStack.empty()) {
                checkStack.push(currentChar);
                continue;
            }

            Character stackChar = checkStack.peek();
            Character mirrorChar = getMirror(currentChar);
            // 相同，取出来
            if (stackChar.equals(mirrorChar)) {
                checkStack.pop();
                continue;
            }
            // 不相同，存进去
            if (!stackChar.equals(mirrorChar)) {
                checkStack.push(currentChar);
                continue;
            }

        }
        // 循环一遍如果，栈中有内容，证明不对称
        return checkStack.size() == 0;
    }

    public static char getMirror(char c) {
        if ('{' == c) {
            return '}';
        }

        if ('}' == c) {
            return '{';
        }

        if ('(' == c) {
            return ')';
        }

        if (')' == c) {
            return '(';
        }

        if ('[' == c) {
            return ']';
        }

        if (']' == c) {
            return '[';
        }
        throw new RuntimeException("char is not valite");
    }


}

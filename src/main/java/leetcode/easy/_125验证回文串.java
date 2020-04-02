package leetcode.easy;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _125验证回文串 {

    public static void main(String[] args) {

        System.out.println(isPalindrome("123321"));

    }


    public static boolean isPalindrome(String s) {


        // 双指针法，两个指针，首位开始向中间遍历，知道 两个指针碰撞到一起， 如果依然是相同字母，则true

        int headIndex = 0;
        int tailIndex = s.length() - 1;

        //跳过到字符
        while (tailIndex >= headIndex) {

            // 正方向 ,不是有效字符跳过
            char headChar = s.charAt(headIndex);
            System.out.println("head->" + headChar);
            if (!Character.isLetterOrDigit(headChar)) {
                headIndex++;
                continue;
            }


            // 逆方向
            char tailChar = s.charAt(tailIndex);
            System.out.println("tail->" + tailChar);
            if (!Character.isLetterOrDigit(tailChar)) {
                tailIndex--;
                continue;
            }


            System.out.println("对比,head=" + headChar + ",tail=" + tailChar);
            // 字符不相同,退出，返回false
            // 字符相同，首位同时往里收

            if (Character.toLowerCase(headChar) != Character.toLowerCase(tailChar)) {
                return false;
            } else {
                headIndex++;
                tailIndex--;
            }

        }

        return true;
    }




}

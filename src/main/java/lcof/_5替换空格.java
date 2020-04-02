package lcof;

/**
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _5替换空格 {

    public static void main(String[] args) {


    }

    // 没什么坑，挨个替换就好
    public String replaceSpace(String s) {


        final String replace = "%20";
        String result = "";

        for (int i = 0; i < s.length(); i++) {

            char cur = s.charAt(i);

            if (cur == ' ') {
                result = result + replace;
            } else {
                result = result + cur;
            }
        }
        return  result;


    }


}

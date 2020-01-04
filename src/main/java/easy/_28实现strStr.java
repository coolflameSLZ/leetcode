package easy;


/**
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _28实现strStr {

    public static void main(String[] args) {


        System.out.println(
                strStr("sunlizhong", "zhong")
        );


    }

    public static int strStr(String haystack, String needle) {

        if ("".equals(needle)){
            return 0;
        }

        // 循环结束条件是 haystack - needle 的长度 超过了
        int endIndex = haystack.length() - needle.length() ;

        for (int hi = 0; hi <= endIndex ; hi++) {

            for (int ni = 0; ni < needle.length(); ni++) {

                char hayChar = haystack.charAt(hi + ni);
                char nedChar = needle.charAt(ni);

                // 如果字符串不相等，那么本回合查找结束，haystack指针后移动，进行下一回合查找
                if (hayChar != nedChar) {
                    break;
                }

                // 如果 needle 指针便利完毕。 则证明找到了子串。可以返回了。
                if (ni == needle.length() - 1) {
                    return hi;
                }
            }
        }

        // 经历所有回合，没有找到匹配字符串，返回-1
        return -1;
    }
}

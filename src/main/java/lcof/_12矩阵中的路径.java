package lcof;

/**
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _12矩阵中的路径 {

    public static void main(String[] args) {


    }

    public boolean exist(char[][] board, String word) {

        char[] words = word.toCharArray();





        return false;
    }

    public boolean exist(int i, int j, char[][] board, char targetChar) {

        if (i < 0 || j < 0) return false;

        if (board.length > i) return false;

        if (board[i - 1].length > j) return false;

        char curChar = board[i - 1][j - 1];

        if (curChar == '/') return false;

        if (curChar != targetChar) return false;

        // 相等
        board[i - 1][j - 1] = '/';
        return true;
    }


}

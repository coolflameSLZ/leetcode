package easy;

import common.TreeNode;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * <p>
 * 示例 1:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * <p>
 * 示例 2:
 * <p>
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _110平衡二叉树 {

    public static void main(String[] args) {


    }

    public static boolean isBalanced(TreeNode root) {


        if (root == null) {
            return true;
        }

        // 高度差
        int deltaDepth = Math.abs(depth(root.left, 0) - depth(root.right, 0));

        // 如果高度差 大于1 返回失败
        if (deltaDepth > 1) {
            return false;
        }

        // 递归查询，知道查完所有的节点
        return isBalanced(root.left) && isBalanced(root.right);


    }

    // 深度优先访问，返回node 的层级
    public static Integer depth(TreeNode root, Integer count) {

        if (root == null) {
            return count;
        } else {
            count = count + 1;
        }


        int leftDepth = depth(root.left, count);
        int rightDepth = depth(root.right, count);

        return Math.max(leftDepth, rightDepth);

    }


}

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
        if (root == null) return true;

        Integer diff = traverse(root.left, 0) - traverse(root.right, 0);

        return Math.abs(diff) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }


    //  某个节点的最大深度
    public static Integer traverse(TreeNode treeNode, Integer depthCount) {
        if (treeNode == null) {
            return depthCount;
        }
        return Integer.max(traverse(treeNode.left, depthCount + 1), traverse(treeNode.right, depthCount + 1));
    }


}

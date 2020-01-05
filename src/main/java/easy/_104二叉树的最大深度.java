package easy;

/**
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _104二叉树的最大深度 {

    public static void main(String[] args) {


    }


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return maxDepth(root, 0);

    }

    // 递归 + 记忆法
    public static int maxDepth(TreeNode root, int count) {

        // root ==null 证明触底，返回count
        // 反之没有触底，count +1
        if (root == null) {
            return count;
        } else {
            count = count + 1;
        }

        // 左右两个子树分别递归求解，
        // 再比较一些，哪个求解的值大，就返回哪个
        int left = maxDepth(root.left, count);
        int right = maxDepth(root.right, count);

        return Math.max(left, right);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }


    }
}
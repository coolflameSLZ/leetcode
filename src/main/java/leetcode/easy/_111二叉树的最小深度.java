package leetcode.easy;

public class _111二叉树的最小深度 {

    public static void main(String[] args) {


    }


    public int minDepth(TreeNode root) {


        if (root == null) {
            return 0;
        }

        // 每次递归，都需要结果+1 这个是渐进条件
        // 如果左子树未空， 就看右子树的深度
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        // 如果右子树未空， 就看右子树的深度
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }

        // 左右都有孩子，就取最小值
        return Math.min(minDepth(root.right), minDepth(root.left)) + 1;


    }



}

package easy;

import common.TreeNode;

public class _617合并二叉树 {

    public static void main(String[] args) {


    }


    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        return traverse(t1, t2);
    }


    // 修改原来的节点
    public static TreeNode traverse(TreeNode t1, TreeNode t2) {

        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }

        //合并根节点
        t1.val = t1.val + t2.val;

        //合并子节点
        t1.left = traverse(t1.left, t2.left);
        t1.right = traverse(t1.right, t2.right);

        return t1;
    }

    // 不修改原来的节点
    public static TreeNode traverseNotChangeVal(TreeNode t1, TreeNode t2) {

        if (t1 == null && t2 == null) {
            return null;
        }

        Integer t1Val = t1 == null ? 0 : t1.val;
        Integer t2Val = t2 == null ? 0 : t2.val;

        // 构造 先合并根节点
        TreeNode resultTreeNode = new TreeNode(t1Val + t2Val);


        // 递归合并子节点
        resultTreeNode.left = traverseNotChangeVal(t1 != null ? t1.left : null, t2 != null ? t2.left : null);
        resultTreeNode.right = traverseNotChangeVal(t1 != null ? t1.right : null, t2 != null ? t2.right : null);


        return resultTreeNode;
    }


}

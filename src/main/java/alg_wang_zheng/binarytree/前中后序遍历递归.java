package alg_wang_zheng.binarytree;

import common.TreeNode;

public class 前中后序遍历递归 {


    /**
     * preOrder(r) = print r->preOrder(r->left)->preOrder(r->right)
     *
     * @param treeNode
     */
    public static void DLR(TreeNode treeNode) {

        if (treeNode == null) return;

        // 自己
        System.out.println(treeNode.val);

        // 左孩子
        DLR(treeNode.left);

        // 右孩子
        DLR(treeNode.right);
    }


    /**
     * inOrder(r) = inOrder(r->left)->print r->inOrder(r->right)
     *
     * @param treeNode
     */
    public static void LDR(TreeNode treeNode) {

        if (treeNode == null) return;

        // 左孩子
        LDR(treeNode.left);

        // 自己
        System.out.println(treeNode.val);

        // 右孩子
        LDR(treeNode.right);
    }


    /**
     * postOrder(r) = postOrder(r->left)->postOrder(r->right)->print r
     *
     * @param treeNode
     */
    public static void LRD(TreeNode treeNode) {

        if (treeNode == null) return;

        // 左孩子
        LRD(treeNode.left);

        // 右孩子
        LRD(treeNode.right);

        // 自己
        System.out.println(treeNode.val);
    }


}

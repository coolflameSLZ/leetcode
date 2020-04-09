package basealg.binarytree;

import common.TreeNode;

/**
 * 后继和前驱
 * <p>
 * 定义：
 * 一个结点的后继，是大于x.key的最小关键字的结点。
 * 一个结点的前驱，是小于x.key的最大关键字的结点。
 * <p>
 * bst有个特性
 * 一个节点的右儿子，以及子孙，都比当前节点大。（右儿子的最左边子孙，就是后继节点）
 * 一个节点的左儿子，以及子孙，都比当前节点小。（左儿子的最右边子孙，就是前驱结点）
 * 但我们需要考虑，某一个节点，没有左右儿子的情况，那么就得去父亲那里找。
 */
public class 查找前驱后继节点 {


    /**
     * 前驱节点
     * 速记， 左手后继节点，右手前驱节点
     *
     * @param treeNode
     * @return
     */
    public static TreeNode precursor(TreeNode treeNode) {

        if (treeNode == null) {
            return null;
        }

        // 往两个方向找
        // 左孩子↘
        if (treeNode.left != null) {
            // 左孩子的最大值
            TreeNode leftMost = treeNode.left;
            while (leftMost.right != null) {
                leftMost = leftMost.right;
            }
            return leftMost;


        } else {
            // 父亲↖
            // 没有左孩子，就网上找，知道找到一个（↖的父亲） 父亲的右孩子为此节点的数，返回这个父节点。
            TreeNode parent = treeNode.parent;
            while (parent != null && parent.right != null) {
                treeNode = parent;
                parent = treeNode.parent;
            }
            return parent;

        }
    }


}

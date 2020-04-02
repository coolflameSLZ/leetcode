package lcof;

import common.TreeNode;

import java.util.Arrays;

/**
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _7重建二叉树 {

    public static void main(String[] args) {


    }


    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        boolean ifNull = preorder.length == 0 || inorder.length == 0;
        if (ifNull) return null;


        //1.在中序遍历中找到根节点索引
        Integer rootInorderIndex = null;
        for (int i = 0; i < inorder.length; i++) {

            if (inorder[i] == preorder[0]) {
                rootInorderIndex = i;
            }
        }

        if (rootInorderIndex == null) throw new RuntimeException();


        //2.开始分左右
        TreeNode root = new TreeNode(preorder[0]);
        // 左右子节点，分别在preorder 和 inorder中找到
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + rootInorderIndex),
                Arrays.copyOfRange(inorder, 0, 0 + rootInorderIndex));

        root.right = buildTree(Arrays.copyOfRange(preorder, 1 + rootInorderIndex, preorder.length),
                Arrays.copyOfRange(inorder, 1 + rootInorderIndex, inorder.length));

        return root;

    }

}


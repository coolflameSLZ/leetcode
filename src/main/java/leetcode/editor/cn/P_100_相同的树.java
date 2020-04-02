//给定两个二叉树，编写一个函数来检验它们是否相同。 
//
// 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。 
//
// 示例 1: 
//
// 输入:       1         1
//          / \       / \
//         2   3     2   3
//
//        [1,2,3],   [1,2,3]
//
//输出: true 
//
// 示例 2: 
//
// 输入:      1          1
//          /           \
//         2             2
//
//        [1,2],     [1,null,2]
//
//输出: false
// 
//
// 示例 3: 
//
// 输入:       1         1
//          / \       / \
//         2   1     1   2
//
//        [1,2,1],   [1,1,2]
//
//输出: false
// 
// Related Topics 树 深度优先搜索


package leetcode.editor.cn;


import common.TreeNode;

//Java：相同的树
public class P_100_相同的树 {
    public static void main(String[] args) {
        Solution solution = new P_100_相同的树().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public boolean isSameTree(TreeNode t1, TreeNode t2) {

            if (t1 == null && t2 == null) return true;

            if (t1 == null || t2 == null) return false;

            return (t2.val == t1.val) && isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
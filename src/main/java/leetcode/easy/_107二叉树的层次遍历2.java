package leetcode.easy;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其自底向上的层次遍历为：
 * <p>
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _107二叉树的层次遍历2 {

    public static void main(String[] args) {

        TreeNode head = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        head.right = three;
        head.left = second;
        second.right = five;
        second.left = four;
        three.right = seven;
        three.left = six;


        levelOrderBottom(head);


    }


    public static List<List<Integer>> levelOrderBottom(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        Map<Integer, List<Integer>> result = new HashMap<>();
        levelOrderBottom(root, 0, result);

        List<List<Integer>> lists = new ArrayList<>();
        result.forEach(lists::add);
        Collections.reverse(lists);

        return lists;
    }

    public static void levelOrderBottom(TreeNode root, Integer level, Map<Integer, List<Integer>> result) {


        List<Integer> curLevelNode = result.getOrDefault(level, new ArrayList<>());
        curLevelNode.add(root.val);
        result.put(level, curLevelNode);


        if (root.left != null) {
            levelOrderBottom(root.left, level + 1, result);
        }

        if (root.right != null) {
            levelOrderBottom(root.right, level + 1, result);
        }
    }


}
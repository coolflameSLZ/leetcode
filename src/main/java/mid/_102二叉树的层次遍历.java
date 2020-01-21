package mid;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _102二叉树的层次遍历 {

    public static void main(String[] args) {


    }


    // 用递归的方式
    public static List<List<Integer>> levelOrder1(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        recursionHelper(root, result, 0);
        return result;

    }

    public static void recursionHelper(TreeNode curNode, List<List<Integer>> resultList, Integer level) {

        // 如果当前层缺少subList,追加一个
        if (resultList.size() <= level) {
            resultList.add(level, new LinkedList<>());
        }

        resultList.get(level).add(curNode.val);

        if (curNode.left != null) {
            recursionHelper(curNode.left, resultList, level + 1);
        }
        if (curNode.right != null) {
            recursionHelper(curNode.right, resultList, level + 1);
        }


    }


    // 用队列的方式，
    // 一层一层的遍历
    // 依次入队 ---> 全部取出 ----> 访问+ 孩子入队
    public static List<List<Integer>> levelOrder2(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> treeNodeQueue = new LinkedBlockingQueue<>();
        treeNodeQueue.add(root);

        while (!treeNodeQueue.isEmpty()) {

            List<Integer> subList = new LinkedList<>();
            int treeSize = treeNodeQueue.size();
            // 1 取出全部，并总结本层结果， 最后把孩子们装进去
            for (int i = 0; i < treeSize; i++) {
                TreeNode remove = treeNodeQueue.remove();
                subList.add(remove.val);

                if (remove.left != null) {
                    treeNodeQueue.add(remove.left);
                }

                if (remove.right != null) {
                    treeNodeQueue.add(remove.right);
                }

            }

            // 把这一层的结果，放入返回值
            result.add(subList);
            System.out.println(subList);
        }
        return result;
    }

}

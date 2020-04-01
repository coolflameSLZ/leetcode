package basealg.binarytree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 前中后序遍历非递归 {


    // 栈深
    public static void deephtFirst(TreeNode treeNode) {

        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);

        while (!stack.isEmpty()) {

            TreeNode curNode = stack.pop();

            // 因为stack是先进后出来，所以放进去的顺序要相反
            //===dosomething
            System.out.println(curNode.val);
            //====

            if (curNode.right != null) stack.push(curNode.right);

            if (curNode.left != null) stack.push(curNode.left);
        }
    }


    // 广队
    public static void widthFirst(TreeNode treeNode) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);

        while (!queue.isEmpty()) {

            TreeNode curNode = queue.poll();

            // 因为queue是先进先出，所以顺序相同
            //===dosomething
            System.out.println(curNode.val);
            //====

            if (curNode.left != null) queue.add(curNode.left);

            if (curNode.right != null) queue.add(curNode.right);
        }


    }


}

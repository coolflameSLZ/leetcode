package common;

public class TreeNode {
    public int val;

    public TreeNode parent;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", parent=" + parent +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
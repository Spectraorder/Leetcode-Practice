package Solutions.MaximumProductofSplittedBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Daniel Atlas
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void print(TreeNode node) {
        if (this == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(this);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");

            if (current.left != null) {
                queue.offer(current.left);
            }

            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }
}

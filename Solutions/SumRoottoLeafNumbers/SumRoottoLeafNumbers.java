package Solutions.SumRoottoLeafNumbers;

/**
 * 2024/4/14
 *
 * @author Daniel Atlas
 */
public class SumRoottoLeafNumbers {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(1, left, right);
        System.out.println(sumNumbers(root));
    }

    public static int sumNumbers(TreeNode root) {
        return REC(root, 0);
    }

    public static int REC(TreeNode node, int total) {
        if (node != null) {
            total = total * 10 + node.val;

            if (node.left == null && node.right == null) {
                return total;
            }

            int leftSum = REC(node.left, total);
            int rightSum = REC(node.right, total);

            return leftSum + rightSum;
        } else {
            return 0;
        }
    }
}

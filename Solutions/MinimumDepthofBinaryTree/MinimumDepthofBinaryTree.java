package Solutions.MinimumDepthofBinaryTree;

/**
 * 2023/7/10
 *
 * @author Daniel Atlas
 */
public class MinimumDepthofBinaryTree {
    public static void main(String[] args) {
        TreeNode nine = new TreeNode(9);
        TreeNode seven = new TreeNode(7);
        TreeNode fifteen = new TreeNode(15);
        TreeNode twenty = new TreeNode(20, fifteen, seven);
        TreeNode root = new TreeNode(3, nine, twenty);
        System.out.println(minDepth(root));
    }

    public static int minDepth(TreeNode root) {
        return helper(root, 1);
    }

    public static int helper(TreeNode root, int depth){
        if(root.left==null&&root.right==null){
            return depth;
        }
        int leftDep = root.left!=null ? helper(root.left, depth+1) : Integer.MAX_VALUE;
        int rightDep = root.right!=null ? helper(root.right, depth+1) :Integer.MAX_VALUE;
        return Math.min(leftDep, rightDep);
    }
}

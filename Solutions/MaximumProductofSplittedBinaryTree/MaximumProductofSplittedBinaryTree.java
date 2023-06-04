package Solutions.MaximumProductofSplittedBinaryTree;

/**
 * @author Daniel Atlas
 */
public class MaximumProductofSplittedBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        three.left = six;
        two.left = four;
        two.right = five;
        root.left = two;
        root.right = three;
        root.print(root);
        System.out.println();
        System.out.println(maxProduct(root));
    }

    public static int maxProduct(TreeNode root) {
        int sum = allSum(root);
        int diff = minDiff(root, sum);
        long cur = sum/2;
        long a = cur - diff/2;
        long b = diff%2==0 ? cur + diff/2 : cur + diff/2 + 1;
        long k = a * b % 1000000007;
        return (int) k;
    }

    public static int allSum(TreeNode node){
        if(node==null){
            return 0;
        }
        node.val = node.val + allSum(node.left) + allSum(node.right);
        return node.val;
    }

    public static int minDiff(TreeNode node, int all){
        if(node==null){
            return Integer.MAX_VALUE;
        }
        int cur = Math.abs(node.val*2 - all);
        int right = minDiff(node.right, all);
        int left = minDiff(node.left, all);
        return Math.min(cur, Math.min(right, left));
    }
}

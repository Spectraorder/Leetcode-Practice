package Solutions.MaximumLevelSumofaBinaryTree;

import java.util.ArrayList;

/**
 * 6/15/2023
 *
 * @author Daniel Atlas
 */
public class MaximumLevelSumofaBinaryTree {
    public static void main(String[] args) {
        TreeNode seven_two = new TreeNode(7);
        TreeNode eight = new TreeNode(-8);
        TreeNode seven = new TreeNode(7, seven_two, eight);
        TreeNode zero = new TreeNode(0);
        TreeNode root = new TreeNode(1, seven, zero);
        System.out.println(maxLevelSum(root));
    }

    public static int maxLevelSum(TreeNode root) {
        ArrayList<Integer> sums = new ArrayList<>();
        dfs(root, 0, sums);
        int max_dep = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<sums.size();i++){
            if(max<sums.get(i)){
                max = sums.get(i);
                max_dep = i;
            }
        }
        return max_dep+1;
    }

    public static void dfs(TreeNode root, int depth, ArrayList<Integer> sums){
        if(root!=null){
            if(sums.size()==depth){
                sums.add(root.val);
            }
            else{
                sums.set(depth, sums.get(depth)+root.val);
            }
            dfs(root.right, depth+1, sums);
            dfs(root.left, depth+1, sums);
        }
    }
}

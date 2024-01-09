package Solutions.LeafSimilarTrees;

import java.util.ArrayList;
import java.util.List;

/**
 * 2024/1/8
 *
 * @author Daniel Atlas
 */
public class LeafSimilarTrees {
    public static void main(String[] args) {
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode four = new TreeNode(4);
        TreeNode two = new TreeNode(2, seven, four);
        TreeNode five = new TreeNode(5, six, two);
        TreeNode nine = new TreeNode(9);
        TreeNode eight = new TreeNode(8);
        TreeNode one = new TreeNode(1, nine, eight);
        TreeNode root1 = new TreeNode(3, five, one);

        TreeNode six2 = new TreeNode(6);
        TreeNode seven2 = new TreeNode(7);
        TreeNode five2 = new TreeNode(5, six2, seven2);
        TreeNode nine2 = new TreeNode(9);
        TreeNode eight2 = new TreeNode(8);
        TreeNode two2 = new TreeNode(2, nine2, eight2);
        TreeNode four2 = new TreeNode(4);
        TreeNode one2 = new TreeNode(1, four2, two2);
        TreeNode root2 = new TreeNode(3, five2, one2);
        System.out.println(leafSimilar(root1, root2));
    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = new ArrayList<>();
        List<Integer> leaf2 = new ArrayList<>();
        dfs(root1, leaf1);
        dfs(root2, leaf2);
        if(leaf1.size()!=leaf2.size()){
            return false;
        }
        for(int i=0;i<leaf1.size();i++){
            if(leaf1.get(i)!=leaf2.get(i)){
                return false;
            }
        }
        return true;
    }

    public static List<Integer> dfs(TreeNode root, List<Integer> ans){
        if(root.left==null&&root.right==null){
            ans.add(root.val);
            return ans;
        }
        if(root.left!=null){
            ans = dfs(root.left, ans);
        }
        if(root.right!=null){
            ans = dfs(root.right, ans);
        }
        return ans;
    }
}

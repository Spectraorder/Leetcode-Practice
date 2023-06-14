package Solutions.MinimumAbsoluteDifferenceinBST;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 6/13/2023
 *
 * @author Daniel Atlas
 */
public class MinimumAbsoluteDifferenceinBST {

    public static ArrayList<Integer> nodes = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        TreeNode six = new TreeNode(6);
        TreeNode two = new TreeNode(2, one, three);
        TreeNode root = new TreeNode(4, two, six);
        System.out.println(getMinimumDifference(root));
    }

    public static int getMinimumDifference(TreeNode root) {
        getAllNodes(root);
        Collections.sort(nodes);
        int min = Integer.MAX_VALUE;
        for(int i=1;i<nodes.size();i++){
            if(Math.abs(nodes.get(i)-nodes.get(i-1))<min){
                min = Math.abs(nodes.get(i)-nodes.get(i-1));
            }
        }
        return min;
    }

    public static void getAllNodes(TreeNode root){
        if(root!=null){
            nodes.add(root.val);
            getAllNodes(root.left);
            getAllNodes(root.right);
        }
    }
}

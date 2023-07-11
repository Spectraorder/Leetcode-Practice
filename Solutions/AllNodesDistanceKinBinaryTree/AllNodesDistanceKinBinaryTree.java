package Solutions.AllNodesDistanceKinBinaryTree;

import java.util.*;

/**
 * 2023/7/10
 *
 * @author Daniel Atlas
 */
public class AllNodesDistanceKinBinaryTree {

    public static HashMap<Integer, TreeNode> parentNode;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        TreeNode one = new TreeNode(1);
        TreeNode six = new TreeNode(6);
        TreeNode two = new TreeNode(2);
        TreeNode seven = new TreeNode(7);
        TreeNode four = new TreeNode(4);
        TreeNode zero = new TreeNode(0);
        TreeNode eight = new TreeNode(8);
        root.left = five;
        root.right = one;
        five.left = six;
        five.right = two;
        two.left = seven;
        two.right = four;
        one.left = zero;
        one.right = eight;
        System.out.println(distanceK(root, five, 2));
    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        fillParent(root);
        List<Integer> output = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();
        dfsFromTarget(target, 0, k, output, visited);
        return output;
    }

    public static void dfsFromTarget(TreeNode target, int step, int dist, List<Integer> cur, HashSet<Integer> visited){
        if(target==null){
            return;
        }
        if(visited.contains(target.val)){
            return;
        }
        visited.add(target.val);
        if(step==dist){
            cur.add(target.val);
            return;
        }
        dfsFromTarget(target.left, step+1, dist, cur, visited);
        dfsFromTarget(target.right, step+1, dist, cur, visited);
        dfsFromTarget(parentNode.get(target.val), step+1, dist, cur, visited);
    }

    public static void fillParent(TreeNode root){
        parentNode = new HashMap<>();
        Queue<TreeNode> cur = new LinkedList<>();
        cur.offer(root);
        while(!cur.isEmpty()){
            TreeNode curRoot = cur.poll();
            if(curRoot.left!=null){
                parentNode.put(curRoot.left.val, curRoot);
                cur.offer(curRoot.left);
            }
            if(curRoot.right!=null){
                parentNode.put(curRoot.right.val, curRoot);
                cur.offer(curRoot.right);
            }
        }
    }
}

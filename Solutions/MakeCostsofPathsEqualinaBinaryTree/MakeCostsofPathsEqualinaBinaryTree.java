package Solutions.MakeCostsofPathsEqualinaBinaryTree;

/**
 * 6/9/2023
 *
 * @author Daniel Atlas
 */
public class MakeCostsofPathsEqualinaBinaryTree {

    public static int ans = 0;

    public static void main(String[] args) {
        int n = 3;
        int[] cost = {5, 3, 3};
        System.out.println(minIncrements(n, cost));
    }

    public static int minIncrements(int n, int[] cost) {
        dfs(n, cost, 1);
        return ans;
    }

    public static int dfs(int n, int[] cost, int pos){
        if(pos>n){
            return 0;
        }
        int leftNode = dfs(n, cost, 2*pos);
        int rightNode = dfs(n, cost, 2*pos+1);
        ans += Math.abs(leftNode-rightNode);
        return Math.max(leftNode, rightNode) + cost[pos-1];
    }
}

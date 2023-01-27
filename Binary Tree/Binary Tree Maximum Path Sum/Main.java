import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class Solution {

    public static int[] solve(TreeNode root) {
        // int[]arr={maxPathSum,maxSumTilllRoot}
        if (root == null)
            return new int[] { Integer.MIN_VALUE, 0 };
        int[] left = solve(root.left);
        int[] right = solve(root.right);
        // case 1 maximum in left or right
        int case1 = Math.max(left[0], right[0]);

        int leftBranch = left[1] + root.val;
        int rightBranch = right[1] + root.val;

        int maxSumTillRoot = Math.max(root.val, Math.max(leftBranch, rightBranch));
        // case 3 path from root
        int case3 = left[1] + root.val + right[1];

        int ans[] = new int[2];
        ans[0] = Math.max(case1, Math.max(maxSumTillRoot, case3));
        ans[1] = maxSumTillRoot;

        return ans;

    }

    public static int maxPathSum(TreeNode root) {
        int[] ans = solve(root);
        return ans[0];

    }
}

class Main {
    public static TreeNode buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N')
            return null;

        String[] nodes = str.split(" ");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < nodes.length) {

            TreeNode currNode = queue.poll();

            String currVal = nodes[i];

            if (!currVal.equals("N")) {
                currNode.left = new TreeNode(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if (i >= nodes.length)
                break;
            currVal = nodes[i];

            if (!currVal.equals("N")) {
                currNode.right = new TreeNode(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        TreeNode root = buildTree(s);
        int maxPath = Solution.maxPathSum(root);
        System.out.println(maxPath);
    }
}

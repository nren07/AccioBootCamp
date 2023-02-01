import java.io.*;
import java.util.*;

static class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode() {

    }

    TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }

}

    public static TreeNode BST() {
        Scanner sc = new Scanner(System.in);
        int val = sc.nextInt();
        TreeNode root = new TreeNode(val);

        if (val < root.data) {
            root.left = BST();
        } else {
            root.right = BST();
        }
        return root;
    }

    public static void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (q.size() > 0) {
            int size = q.size();
            while (size != 0) {
                TreeNode temp = q.remove();
                System.out.print(temp.data + " ");
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
                size--;
            }
        }
    }

    public class Main {
        public static void main(String args[]) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();

            TreeNode root = BST();
            levelOrderTraversal(root);
        }
    }
}
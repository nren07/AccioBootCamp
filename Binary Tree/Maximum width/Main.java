// https://course.acciojob.com/idle?question=f74897ab-cbb8-4302-b031-f69c5d31c1ea

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Main {
    static Node buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (queue.size() > 0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if (i >= ip.length)
                break;
            currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        Node root = buildTree(s);
        Solution tree = new Solution();
        int ans = tree.solve(root);
        System.out.println(ans);

        sc.close();
    }
}

class Pair {
    Node node;
    int idx;

    Pair(Node node, int idx) {
        this.node = node;
        this.idx = idx;
    }
}

class Solution {

    public int solve(Node root) {
        // your code here
        int width = 0;
        Queue<Pair> q = new LinkedList<>();
        // add root in queue having idx=1
        q.add(new Pair(root, 1));

        while (q.size() > 0) {
            int size = q.size();

            int minWidth = Integer.MAX_VALUE;
            int maxWidth = Integer.MIN_VALUE;

            while (size > 0) {

                Pair info = q.remove();

                Node temp = info.node;
                int index = info.idx;

                minWidth = Math.min(minWidth, index);
                maxWidth = Math.max(maxWidth, index);

                if (temp.left != null)
                    q.add(new Pair(temp.left, 2 * index));

                if (temp.right != null)
                    q.add(new Pair(temp.right, 2 * index + 1));

                size--;
            }
            int currWidth = maxWidth - minWidth + 1;
            width = Math.max(width, currWidth);
        }
        return width;
    }
}

// https://course.acciojob.com/idle?question=73dc7bdc-712a-4d18-b043-4a23ff720e30

import java.util.*;
import java.io.*;

class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node root = null;
        int inorder[] = new int[n];
        int preorder[] = new int[n];
        for (int i = 0; i < n; i++)
            preorder[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            inorder[i] = sc.nextInt();
        Solution ob = new Solution();
        root = ob.buildTree(inorder, preorder, n);
        postOrdrer(root);
        System.out.println();
    }

    public static void postOrdrer(Node root) {
        if (root == null)
            return;
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}

class Solution {
    // psi-->preOrder starting idx, pei--> preorder ending idx
    // isi-->inorder starting idx,iei--> inOrder ending idx
    public static Node constructBinaryTree(int[] preOrder, int psi, int pei, int[] inOrder, int isi, int iei) {
        if (psi > pei) {
            return null;
        }
        if (isi > iei) {
            return null;
        }

        Node root = new Node(preOrder[psi]);
        int i = isi;
        int count = 0;
        while (inOrder[i] != preOrder[psi]) {
            count++;
            i++;
        }

        root.left = constructBinaryTree(preOrder, psi + 1, psi + count, inOrder, isi, i - 1);
        root.right = constructBinaryTree(preOrder, psi + count + 1, pei, inOrder, i + 1, iei);

        return root;
    }

    public static Node buildTree(int inorder[], int preorder[], int n) {
        return constructBinaryTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
}

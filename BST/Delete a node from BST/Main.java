
import java.util.*;
import java.io.*;

class Node{
    int val;
    Node left, right;
    Node(int val){
        this.val = val;
        left = null;
        right = null;
    }
}
class BST{
    Node root = null;
    BST(){
        
    }
    BST(Node root){
        root=root;
    }
    Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.val == val)
            return root;
        if(val < root.val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
    }
    void print(Node root){
        System.out.print(root.val + " ");
        if(root.left != null){
            print(root.left);
        }
        if(root.right != null){
            print(root.right);
        }
    }
}

class Solution{
	public int min(Node root){
		if(root.left==null) return root.val;
		else return min(root.left);
	}
    public Node deleteNode(Node root, int val){
        if(root==null) return root;
		// if val is less from root val then delete node from left
		if(val<root.val) root.left=deleteNode(root.left,val); 
			// if val is greater then root thenn we have to delete froom right 
		else if(val>root.val) root.right=deleteNode(root.right,val);
			// if val is equal to root val then check 
			//  case 1: delete node have not any child node (leaf Node)
			// case 2: delete node have 1 child node
			// case 3: delete node have 2 child node
		else{
			// case 1:
			if(root.left==null && root.right==null) return null;
				// case 2A
			else if(root.left==null) return root.right;
				// case 2B
			else if(root.right==null) return root.left;
				// case 3
			else {
				// if delete node have 2 child 
				root.val=min(root.right);
				root.right=deleteNode(root.right,root.val);
			}
		}
		return root;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), k = input.nextInt();
        BST t = new BST();
        for(int i = 0; i < n; i++){
            t.root = t.insert(t.root, input.nextInt());
        }
        Solution obj=new Solution();
        t.root= obj.deleteNode(t.root, k);
        t.print(t.root);
    }
}
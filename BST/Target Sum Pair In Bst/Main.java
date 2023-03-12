import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinarySearchTree {
    Node constructBST(int[] arr, int start, int end, Node root) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;

        if (root == null)
            root = new Node(arr[mid]);

        root.left = constructBST(arr, start, mid - 1, root.left);
        root.right = constructBST(arr, mid + 1, end, root.right);

        return root;

    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();

        Arrays.sort(arr);
        Node root = null;
        BinarySearchTree bst = new BinarySearchTree();
        root = bst.constructBST(arr, 0, n - 1, root);

        Accio A = new Accio();
        A.targetSum(root, target);

        sc.close();
    }
}

class Accio {
    

	int pair=0;
	public boolean find(Node root,int comp){
		if(root==null) return false;
		if(comp<root.data) return find(root.left,comp);
		else if(comp>root.data) return find(root.right,comp);
		else  return true;
	}
	public void targetSumHelper(Node root,Node node,int tar){
		if(node==null) return;
		targetSumHelper(root,node.left,tar);
		int comp=tar-node.data;
		if(comp>node.data){
			if(find(root,comp)==true){
				System.out.println(node.data+" "+comp);
				pair++;
			}	
		}
		targetSumHelper(root,node.right,tar);
	}
    public void targetSum(Node root, int tar)
    {
        targetSumHelper(root,root,tar);
		if(pair==0){
			System.out.println("-1");
		}
    }

}







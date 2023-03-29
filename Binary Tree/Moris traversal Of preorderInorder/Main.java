
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}


class Main {
    static Node buildTree(String str){
       // System.out.print(str);
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>(); 
        queue.add(root);
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if(i >= ip.length)
                break;   
            currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
    
    
	public static void main (String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    Scanner sc = new Scanner(System.in);
            
			String s = sc.nextLine();
            
            //System.out.print(s);
			Node root = buildTree(s);
			Solution tree = new Solution();
			  tree.morisTraversal(root);
            
		
	}
}
  


class Solution {

	public static void morisTraversal(Node root) {

		Node curr=root;
		
		ArrayList<Integer>pre=new ArrayList<>();
		ArrayList<Integer>in=new ArrayList<>();

		while(curr!=null){
			
			if(curr.left==null){
				pre.add(curr.data);
				in.add(curr.data);
				curr=curr.right;
			}else{
				Node rmc=curr.left;
				while(rmc.right!=null && rmc.right!=curr){
					rmc=rmc.right;
				}
				if(rmc.right==null){
					pre.add(curr.data);
					rmc.right=curr;
					curr=curr.left;
				}else{
					in.add(curr.data);
					rmc.right=null;
					curr=curr.right;
				}
			}
		}
		System.out.println(pre);
		System.out.println(in);
        
	}
}
import java.util.*;
import java.lang.*;
import java.io.*;
class Main
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine().trim();
        int N = S.length();
        Solution ob = new Solution();
        String[] element = br.readLine().trim().split("\\s+");
        int[] f = new int[N];
        for(int i = 0; i < N; i++){
            f[i] = Integer.parseInt(element[i]);
        }
        ArrayList<String> res  = ob.huffmanCodes(S,f,N);
        for(int i = 0; i < res.size(); i++)
        {
            System.out.print(res.get(i)+" ");
        }
        System.out.println();
    
	}
}

class Solution {
    public class Node{
        char c;
        int freq;
        Node left;
        Node right;
        Node(char c, int freq){
            this.c=c;
            this.freq=freq;
        }
    }
    public ArrayList<String> huffmanCodes(String S, int f[], int N){
        // Code here
        // make a minimum priority queue
        PriorityQueue<Node>pq=new PriorityQueue<>((a,b)->{
            return a.freq<b.freq ? -1 :1;
        });
        // insert all node in the priority queue 
        for(int i=0;i<N;i++){
            char c=S.charAt(i);
            int freq=f[i];
            Node nn=new Node(c,freq);
            pq.add(nn);
        }
        // extract 2 minimum node 
        while(pq.size()>1){

            Node smaller=pq.remove(); // for left 
            Node larger=pq.reove(); // next smaller for right 
            // make a new Node 
            Node nn=new Node('*',smaller.freq+larger.freq);
            nn.left=smaller;
            nn.right=larger;
            pq.add(nn);
        }
        // after whole itration priority qyueue has only huffman tree root
        Node root=pq.remove();
        // now perform dfs on it
        ArrayList<Integer>res=new ArrayList<>();
        String path="";
        dfs(root, res,path);
    }

    public static void dfs(Node root, ArrayList<Integer>res,String path){
        if(root.left==null && root.right==null){
            res.add(path);
        }
        dfs(root.left,res,path+'0');
        dfs(root.right,res,path+'1');
    }
    
}
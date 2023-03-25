import java.io.*;
import java.util.*;

class Solution {
	// public static boolean dfs(ArrayList<ArrayList<Integer>>graph, int node,int parent, boolean[]vis){
	// 	vis[node]=true;
	// 	for(int nbr : graph.get(node)){
	// 		if(!vis[node]) {
	// 			boolean isCyclic=dfs(graph,nbr,node,vis);
	// 			if(isCyclic) return true;
	// 		}else if(parent!=nbr) return true;
	// 	}
	// 	return false;
	// }
	public static boolean bfs(ArrayList<ArrayList<Integer>>graph, int s, boolean[]vis){
		Queue<Integer>q=new LinkedList<>();
		q.add(s);
		while(q.size()>0){
			// remove from q
			int curr=q.remove();
			// check if node is allready visited or not
			if(vis[curr]) return true;
			// mark curr not visited
			vis[curr]=true;
			// traverse all the neighbouring element of arraylist present in graph
			for(int nbr : graph.get(curr)){
				if(!vis[nbr]) q.add(nbr);
			}
		}
		return false;
	}
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> graph) {
       // Your code here
		boolean vis[]=new boolean[V];

		for(int i=0;i<V;i++){
			if(!vis[i] && bfs(graph,i,vis)) return true;
		}
		return false;
    }
}

public class Main{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N, E;
        N = sc.nextInt();
        E = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0; i<N; i++) adj.add(i, new ArrayList<Integer>());    
        for(int i =0; i<E; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean ans = Solution.isCycle(N,adj);
        if(ans)
            System.out.println("1");
        else
            System.out.println("0");
    }
}
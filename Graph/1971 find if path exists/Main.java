import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < M; i++) {
            ArrayList<Integer> e = new ArrayList<Integer>();
            e.add(sc.nextInt());
            e.add(sc.nextInt());
            Edges.add(e);
        }
        int U=sc.nextInt();
        int V=sc.nextInt();
        Solution ob = new Solution();
        if (ob.check(N, M, Edges,U,V)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        sc.close();
    }

}

class Solution {
    boolean dfs(ArrayList<Integer>[]graph, boolean[]vis,int src,int dest){
		if(src==dest) return true;
		vis[src]=true;
		for(int nbr : graph[src]){
			if(!vis[nbr]){
				boolean check=dfs(graph,vis, nbr, dest);
				if(check) return true;
			}
		}
		return false;
	}
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> edges,int U,int V) {
        // your code here
		boolean vis[]=new boolean[N];
		ArrayList<Integer>[]graph=new ArrayList[N];
		for(int i=0;i<N;i++){
			graph[i]=new ArrayList<Integer>();
		}
		for(ArrayList<Integer>edge : edges){
			int u=edge.get(0)-1;
			int v=edge.get(1)-1;
			graph[u].add(v);
			graph[v].add(u);
		}
		return dfs(graph,vis, U-1, V-1);
    }
}
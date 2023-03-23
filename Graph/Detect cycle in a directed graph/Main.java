import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	private boolean dfs(ArrayList<Integer>[]graph, boolean[] visited, boolean[] path, int src){
		visited[src]=true;
		path[src]=true;
		for(int nbr : graph[src]){
			if(!visited[nbr]){
				boolean check=dfs(graph,visited,path,nbr);
				if(check) return true;
			}
			else if(visited[nbr] && path[nbr]) return true;
		}
		path[src]=false;
		return false;
	}
public boolean isCyclic(int vertices, ArrayList<Integer>[] graph) {
    // Your code here
	boolean []visited=new boolean [vertices];
	boolean path[]=new boolean[vertices];
	for(int i=0;i<vertices;i++){
		if(!visited[i]){
			boolean check=dfs(graph,visited,path,i);
			if(check) return true;
		}
	}
	return false;
   }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V, E;
        V = sc.nextInt();
        E = sc.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < E; i++) {
            int u, v;
            u = sc.nextInt();
            v = sc.nextInt();
            adj[u].add(v);
        }
        Solution obj = new Solution();
        boolean ans = obj.isCyclic(V, adj);
        if (ans == true) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }
	public static void dfs(ArrayList<Edge>[]graph,int src,  int dest, String path,boolean []visited){
		if(src==dest){
			System.out.println(path);
			return;
		}
		visited[src]=true;
		for(Edge e : graph[src]){
			if(!visited[e.nbr]){
				dfs(graph,e.nbr,dest,path+e.nbr,visited);
			}
		}
		// when we reach to destination we have to back track till another path encountered
		// along with backtracking we have to keep mark as unvisited when we going back
		visited[src]=false;
	}
	public static void printAllPath(ArrayList<Edge>[]graph , int src , int dest , int n){ 
		//Your code here
		boolean[]visited=new boolean[n];
		// answer string
		String path=""+src;
		dfs(graph,src,dest,path,visited);
		return;
	}
   

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         graph[v1].add(new Edge(v1, v2));
      }

      int src = Integer.parseInt(br.readLine());
      int dest = Integer.parseInt(br.readLine());

      printAllPath(graph,src,dest,vtces);
   }


}
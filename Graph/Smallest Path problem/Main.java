import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }

   static class Pair implements Comparable<Pair> {
      int wsf;
      String psf;

      Pair(int wsf, String psf){
         this.wsf = wsf;
         this.psf = psf;
      }

      public int compareTo(Pair o){
         return this.wsf - o.wsf;
      }
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
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      int src = Integer.parseInt(br.readLine());
      int dest = Integer.parseInt(br.readLine());

      int criteria = Integer.parseInt(br.readLine());
      int k = Integer.parseInt(br.readLine());

      boolean[] visited = new boolean[vtces];
      dfs(graph, src, dest, visited, criteria, k, src + "", 0);

      System.out.println("Smallest Path = " + spath + "@" + spathwt);
      System.out.println("Just Larger Path than " + criteria + " = " + cpath + "@" + cpathwt);
      System.out.println(k + "th largest path = " + pq.peek().psf + "@" + pq.peek().wsf);
   }

   //Solution

   static String spath;
   static Integer spathwt = Integer.MAX_VALUE;
   static String cpath;
   static Integer cpathwt = Integer.MAX_VALUE;
   static PriorityQueue<Pair> pq = new PriorityQueue<>();
   public static void dfs(ArrayList<Edge>[] graph, int node, int dest, boolean[] vis, int c, int k, String currPath, int currwt ){
	    //All Variables have been initialized above the function.
	   if(node==dest){
		   // case 1: shortest path or weight
		   if(currwt<spathwt){
			   spathwt=currwt; // small path weight is equal to curr wt
			   spath=currPath; // smallest path is equal to curr path
		   }
		   // case 2:
		   if(currwt>c && cpathwt>currwt){ // this condition check current weight greater from criteria or lesser from cpath
			   cpathwt=currwt; // criteria path weight is equall to currweight 
			   cpath=currPath; // criteria path is equal to curr weight
		   }
		   //case 3:
		   // first add in queue that element when destination is achived the add currpath or weight in queue
		   pq.add(new Pair(currwt,currPath));
		   // if size of priority queue is larger then k then remove from queue
		   if(pq.size()>k) pq.remove();
		   return;
		}
		vis[node]=true;
	   for(Edge e : graph[node]){
		   if(!vis[e.nbr]){
			   dfs(graph,e.nbr,dest, vis,  c,  k,  currPath+e.nbr, currwt+e.wt);
		   }  
	   }
	   vis[node]=false;
	   
}
}
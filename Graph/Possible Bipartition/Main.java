// Possible Bipartition
/*
We want to split a group of n people (labeled from 1 to n) into two groups of any size. Each person may dislike some other people, and they should not go into the same group.

Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates that the person labeled ai does not like the person labeled bi, return true if it is possible to split everyone into two groups in this way.
*/
import java.util.*;

class Solution {

	private boolean dfs(ArrayList<Integer>[]graph,boolean[]visited,int[]colour,int src,int c){
		visited[src]=true;
		colour[src]=c;

		for(int nbr : graph[src]){
			if(!visited[nbr]){
				boolean check=dfs(graph,visited,colour,nbr,1-c);
				if(!check) return false;
			}else if(visited[src] && colour[src]==colour[nbr]) return false;
		}
		return true;
	}
	private boolean bfs(ArrayList<Integer>[]graph,boolean[]visited,int[]colour,int src){
		Queue<Integer>q=new LinkedList<>();
		q.add(src);
		visited[src]=true;
		colour[src]=0;// 0 for red

		while(q.size()>0){
			int size=q.size();
			for(int i=0;i<size;i++){
				int temp=q.remove();
				for(int nbr :graph[temp]){
					if(!visited[nbr]){
						visited[nbr]=true;
						q.add(nbr);
						// make adjustent element different color from src
						colour[nbr]=1-colour[temp];
					// if source ind neighbour colour should be different if matches then it is not a bipartition 
					}else if(visited[nbr] && colour[temp]==colour[nbr]) return false; //if node visited then check bipartition
				}
			}
		}
		return true;
	}
    public int possibleBipartition(int n, int[][] dislikes) {
        
		boolean[]visited=new boolean[n];
		int[]colour=new int[n];
		
		ArrayList<Integer>[]graph=new ArrayList[n+1];
		for(int i=0;i<n;i++) graph[i]=new ArrayList<Integer>();

		for(int []edge : dislikes){
			int u=edge[0];
			int v=edge[1];

			graph[u-1].add(v-1);
			graph[v-1].add(u-1);
		}
		for(int i=0;i<n;i++){
			if(!visited[i]){
				boolean check=bfs(graph,visited,colour,i);
				// boolean check=dfs(graph,visited,colour,i,0);
				if(!check) return 0;
			}
		}
		return 1;
		
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int M= sc.nextInt();

        int dislike[][] = new int[M][2];

        for(int i=0; i<M; i++){
            for(int j=0; j<2; j++)
                dislike[i][j]= sc.nextInt();
        }
        
        Solution Obj = new Solution();
        System.out.println(Obj.possibleBipartition(N,dislike));

    }
}
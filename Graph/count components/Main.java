import java.io.*;
import java.util.*;
class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(read.readLine());
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<N; i++)
        {
            String S[] = read.readLine().split(" ");
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j=0; j<N; j++)
                temp.add(Integer.parseInt(S[j]));
            adj.add(temp);
        }

        Solution ob = new Solution();
        System.out.println(ob.components(adj,N));
    }
}

class Solution {
	
	void dfs(ArrayList<ArrayList<Integer>>graph,boolean []visited, int src){
		visited[src]=true;
		for( int nbr=0;nbr<graph.size();nbr++){
			if(visited[nbr]==false && graph.get(src).get(nbr)==1){
				dfs(graph,visited, nbr);
			}
		}
	}
    int components(ArrayList<ArrayList<Integer>>graph, int n) {
		// given ArrayList is a graph,
		boolean visited[]=new boolean[n];
		// Make a count varibale along with itration 
		int count=0;
		for(int i=0;i<n;i++){
			if(!visited[i]){
				dfs(graph,visited, i);
				count++;
			}
		}
		return count;
    }
};
//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = new Solution().topoSort(nov, list);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        
        if(V!=res.length)
        return false;
        
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    // dfs solution
    
    // static void dfs(ArrayList<ArrayList<Integer>> adj,int src, Stack<Integer>st, boolean []visited){
    //     visited[src]=true;
        
    //     for(int nbr : adj.get(src)){
    //         if(!visited[nbr]) dfs(adj,nbr,st, visited);
    //     }
    //     // when we reach at the end of dfs then we add in stack
    //     // because lower has higher dependency
    //     st.add(src);
    // }
    // //Function to return list containing vertices in Topological order. 
    // static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    // {
    //     // add your code 
    //     Stack<Integer>st=new Stack<>();
    //     boolean []visited=new boolean [V];
    //     for(int i=0;i<V;i++){
    //         if(!visited[i]){
    //             dfs(adj,i,st,visited);
    //         }
    //     }
    //     int ans[]=new int [V];
    //     for(int i=0;i<V;i++){
    //         ans[i]=st.pop();
    //     }
    //     return ans;
    // }
    
    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj,ArrayList<Integer>list,int []indegree){
        while(q.size()!=0){
        //  remove from queue
            int temp=q.remove();
            //  add to ans list
            list.add(temp);
            //  explore nbr and reduce degree by one and if it is equal to zero then add in queue
            for(int nbr : adj.get(temp)){
                
                if(--indegree[nbr]==0) q.add(nbr);
            }
        }
    }
     static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
         
         Queue<Integer>q=new LinkedList<>();
        //  incomming edges stored in array of indegree 
         int indegree[]=new int[V];
         
         for(int i=0;i<V;i++){
             for(int nbr : adj.get(i)){
                 indegree[nbr]++;
             }
         }
        //  for answer return 
         int ans[]=new int [V];
        //  to store ans from bfs
         ArrayList<Integer>list=new ArrayList<>();
        //  first we add those element who has zero indegree 
         for(int i=0;i<V;i++){
             if(indegree[i]==0) q.add(i);
         }
        //   start bfs itration 
        bfs(adj,list,indegree);
         
        //  store ans from list
         int idx=0;
         for(int e : list){
             ans[idx++]=e;
         }
         return ans;
     }
}

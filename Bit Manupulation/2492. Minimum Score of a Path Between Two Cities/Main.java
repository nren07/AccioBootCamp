class Solution {

    public int dfs(ArrayList<int[]>[]graph, int src,boolean []vis){
        
        vis[src]=true;

        int minFound=Integer.MAX_VALUE;

        for(int [] temp : graph[src]){
            int nbr=temp[0];
            int wt=temp[1];
            minFound=Math.min(wt,minFound);
            if(!vis[nbr]) minFound=Math.min(minFound,dfs(graph,nbr,vis));
        }
        return minFound;
    }
    public int minScore(int n, int[][] roads) {
       ArrayList<int[]>[]graph=new ArrayList[n];
       boolean visited[]=new boolean [n];

       for(int i=0;i<n;i++){
           graph[i]=new ArrayList<int[]>();
       } 

       for(int [] road : roads ){
           int u=road[0];
           int v=road[1];
           int w=road[2];

           graph[u-1].add(new int[]{v-1,w});
           graph[v-1].add(new int[]{u-1,w});
       }
       return dfs(graph,0,visited);
    }
}
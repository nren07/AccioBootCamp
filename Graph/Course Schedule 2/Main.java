import java.util.*;

class Solution {
 
    @SuppressWarnings("unchecked")
	
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
        public boolean isCyclic(ArrayList<Integer>[] graph,int vertices) {
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
        private void complete(ArrayList<Integer>[]graph, ArrayList<Integer>order,int src,boolean visited[]){
        // Step 1 mark as visited for sourse node in dfs
            visited[src]=true;
            // explore nbr 

            for(int nbr : graph[src]){
                if(!visited[nbr]){
                    complete(graph,order,nbr,visited);
                }
            }
            order.add(src);
        }
        public int[] canFinish(int numCourses, int[][] prerequisites) {
            // make a graph array
            ArrayList <Integer>[] graph=new ArrayList[numCourses];

            for(int i=0;i<numCourses;i++){
                graph[i]=new ArrayList<>();
            }
            
            for(int[] edge : prerequisites){
                int u=edge[0];
                int v=edge[1];
            // given that prerequistites of a1 is b1 so we will discover nbr first then go for itself
                graph[u].add(v);
            }

            if(isCyclic(graph,numCourses)) return new int[]{};  //cycle should not be present if present then return empty

            boolean visited[]=new boolean[numCourses]; // to mark visited nodes so that we can not traverse again 

            ArrayList <Integer> order=new ArrayList<>();

            for(int i=0;i<numCourses;i++){
                if(!visited[i]){
                    complete(graph,order,i,visited);
                }
            }
            int ans[]=new int[numCourses];  //answer array

            for(int i=0;i<numCourses;i++) ans[i]=order.get(i); //convert arraylist to array

            return ans;
        }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int M= sc.nextInt();

        int prerequisites[][] = new int[M][2];

        for(int i=0; i<M; i++){
            for(int j=0; j<2; j++)
                prerequisites[i][j]= sc.nextInt();
        }
        
        Solution Obj = new Solution();
        int []ans=Obj.canFinish(N,prerequisites);
        if(ans.length==0)
            System.out.println(-1);
        else{
            for(int i=0; i<ans.length; i++){
                System.out.print(ans[i]+" ");
            }

            System.out.println("");
        }

    }
}
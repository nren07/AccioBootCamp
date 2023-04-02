class Solution {
    public class Edge{
        int nbr;
        int wt;
        Edge(int nbr, int wt){
            this.nbr=nbr;
            this.wt=wt;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        // Make graph and connect all points
        int n=points.length;
        ArrayList<Edge>[]graph=new ArrayList[n];

        // all the points considered as vertices of graph;
        // so length of array should be consider as vertices

        for(int i=0;i<n ; i++){
            graph[i]=new ArrayList<Edge>();
        }
        // we connect a point to all ather point to make graph
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                // dist is the abs different of (x1-x2)+(y1-y2);
                int dist=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                graph[i].add(new Edge(j,dist));
                graph[j].add(new Edge(i,dist));
            }
        }
        // in the priority queue we add edge or in the edge we add nbr or weight and minimum case is appled on weight
        PriorityQueue<Edge>pq=new PriorityQueue<>((a,b)->{
            return a.wt-b.wt;
        });

        boolean visited[]=new boolean [n];
        int wtOfMST=0;
        // to start itration we add o o in the priority que
        pq.add(new Edge(0,0));

        while(pq.size()>0){

            Edge curr=pq.remove();
            int node=curr.nbr;
            int wt=curr.wt;

            if(visited[node]) continue;
            visited[node]=true;
            // add weight in consucative sum or we can say MST weight
            wtOfMST+=wt;
            // explore all the unvisited nbr and put into pririty que
            for(Edge e : graph[node]){
                if(!visited[e.nbr]) pq.add(new Edge(e.nbr,e.wt));
            }
        }
        return wtOfMST;
    }
}
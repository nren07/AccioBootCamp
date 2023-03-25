class Solution {
    public int networkDelayTime(int[][] times, int vertices, int src) {
        
            PriorityQueue<int[]>pq=new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
			int dist[]=new int[vertices];
			// initially fill dist array with infinity
			Arrays.fill(dist,Integer.MAX_VALUE);

			dist[src-1]=0;
			pq.add(new int[]{dist[src-1],src-1});

			ArrayList<int[]>[]graph=new ArrayList[100];
			for(int i=0;i<vertices;i++){
				graph[i]=new ArrayList<int[]>();
			}

			for(int [] time : times ){
				int u=time[0];
				int v=time[1];
				int w=time[2];
				graph[u-1].add(new int[]{v-1,w});
			}

			while(pq.size()>0){
				// remove min dist from Queue
				int []temp=pq.remove();
				int dist_node=temp[0];
				int node= temp[1];

				// the dist in array is leser than dist_node then ignore it 
				if(dist[node]<dist_node) continue;

				// itrate over nbr
				for(int[]edge:graph[node]){
					int nbr=edge[0];
					int wt=edge[1];
					// check previously attained distance to nbr is greater then current incomming distance 
					if(dist[nbr]>dist[node]+wt){
						dist[nbr]=dist[node]+wt;
						pq.add(new int []{dist[nbr],nbr});
					}
				}
			}
			// for(int i : dist){
			// 	System.out.println(i);
			// }
			Arrays.sort(dist);
      if(dist[vertices-1]==Integer.MAX_VALUE) return -1;
      return dist[vertices-1];
    }
}
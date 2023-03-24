class Solution {
    public int jump(int[] arr) {
                int n=arr.length;
        boolean visited[]=new boolean [arr.length];
        Queue<Integer>q=new LinkedList<>(); // queue for bfs traversal

        q.add(0);
        visited[0]=true;
        int level=0;
        while(q.size()>0){

            int size=q.size();

            for(int i=0;i<size;i++){

                int idx=q.remove();

                if(idx==n-1) return level;
                for(int jump=1;jump<=arr[idx];jump++){
                    if(jump+idx>=n) break;
                    if(idx+jump<n && !visited[idx+jump]){
                        q.add(idx+jump);
                        visited[idx+jump]=true;
                    }
                }
            }
            level++;

            
        }

        return -1;
    }
}
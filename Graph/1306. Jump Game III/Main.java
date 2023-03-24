class Solution {
    public boolean canReach(int[] arr, int start) {
        int n=arr.length;
        boolean visited[]=new boolean [arr.length];
        Queue<Integer>q=new LinkedList<>(); // queue for bfs traversal

        q.add(start);
        visited[start]=true;

        while(q.size()>0){

            int size=q.size();

            for(int i=0;i<size;i++){

                int idx=q.remove();

                if(arr[idx]==0) return true;
                if(idx+arr[idx]<n && !visited[idx+arr[idx]]){
                    q.add(idx+arr[idx]);
                    visited[idx+arr[idx]]=true;
                }
                if(idx-arr[idx]>=0 && !visited[idx-arr[idx]]){
                    q.add(idx-arr[idx]);
                    visited[idx-arr[idx]]=true;
                }
            }

            
        }

        return false;
    }
}